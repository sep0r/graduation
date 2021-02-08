package org.restaurantapp.repository.datajpa;

import org.restaurantapp.model.Menu;
import org.restaurantapp.repository.MenuRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaMenuRepository implements MenuRepository {

    private final CrudMenuRepository crudRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DataJpaMenuRepository(CrudMenuRepository crudRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRepository = crudRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    @Transactional
    public Menu save(Menu menu, int restId) {
        menu.setRestaurant(crudRestaurantRepository.getOne(restId));
//        menu.setDate(date);
        return crudRepository.save(menu);
    }

    @Override
    public Menu get(int id, int restId) {
        return crudRepository.findById(id)
                .filter(menu -> menu.getRestaurant().getId() == restId)
                .orElse(null);
    }

    @Override
    public List<Menu> getAllByDate(LocalDate date) {
        return crudRepository.getAllByDate(date);
    }

    @Override
    public List<Menu> getAllByRestaurantId(int restaurantId){
        return crudRepository.getAllByRestaurantId(restaurantId);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }
}
