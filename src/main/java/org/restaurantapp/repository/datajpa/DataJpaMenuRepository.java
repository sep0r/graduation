package org.restaurantapp.repository.datajpa;

import org.restaurantapp.model.Menu;
import org.restaurantapp.repository.MenuRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaMenuRepository implements MenuRepository {
    private static final Sort SORT_DATE = Sort.by(Sort.Direction.ASC, "date");


    private final CrudMenuRepository crudRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DataJpaMenuRepository(CrudMenuRepository crudRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRepository = crudRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    @Transactional
    public Menu save(Menu menu, int restId, LocalDate date) {
        if (!menu.isNew()) {
            return null;
        }
        menu.setRestaurant(crudRestaurantRepository.getOne(restId));
        menu.setDate(date);
        return crudRepository.save(menu);
    }

    @Override
    public Menu get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> getAll() {
        return crudRepository.findAll(SORT_DATE);
    }
//
//    @Override
//    public List<Menu> getAllForDate(LocalDate date) {
//        return crudRepository.getAllForDate(date);
//    }
//
//    @Override
//    public List<Menu> getByRestaurantId(int restaurantId) {
//        return crudRepository.getByRestaurantId(restaurantId);
//    }
//
//    @Override
//    public List<Menu> getByRestaurantIdAndDate(int restaurantId, LocalDate date) {
//        return crudRepository.getByRestaurantIdAndDate(restaurantId, date);
//    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }
}
