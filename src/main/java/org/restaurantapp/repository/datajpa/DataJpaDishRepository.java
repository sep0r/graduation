package org.restaurantapp.repository.datajpa;

import org.restaurantapp.model.Dish;
import org.restaurantapp.repository.DishRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaDishRepository implements DishRepository {

    private final CrudDishRepository crudDishRepository;
    private final CrudMenuRepository crudMenuRepository;

    public DataJpaDishRepository(CrudDishRepository crudDishRepository, CrudMenuRepository crudMenuRepository) {
        this.crudDishRepository = crudDishRepository;
        this.crudMenuRepository = crudMenuRepository;
    }

    @Override
    @Transactional
    public Dish save(Dish dish, int menuId) {
        if (!dish.isNew()) {
            return null;
        }
        dish.setMenu(crudMenuRepository.getOne(menuId));
        return crudDishRepository.save(dish);
    }

    @Override
    public Dish get(int id, int menuId) {
        return crudDishRepository.findById(id)
                .filter(dish -> dish.getMenu().getId() == menuId)
                .orElse(null);
    }

    @Override
    public boolean delete(int id, int menuId) {
        return crudDishRepository.delete(id, menuId) != 0;
    }

    @Override
    public List<Dish> getAllByMenu(int menuId) {
        return crudDishRepository.getAllByMenu(menuId);
    }
}
