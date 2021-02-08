package org.restaurantapp.repository.datajpa;

import org.restaurantapp.model.Restaurant;
import org.restaurantapp.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private final CrudRestaurantRepository crudRepository;

    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return crudRepository.save(restaurant);
    }

    @Override
    public Restaurant get(Integer id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant getWithMenu(int id) {
        return crudRepository.getWithMenu(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public List<Restaurant> getAllWithMenu() {
        return crudRepository.getAllWithMenu();
    }
}
