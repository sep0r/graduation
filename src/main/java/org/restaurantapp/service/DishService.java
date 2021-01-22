package org.restaurantapp.service;

import org.restaurantapp.model.Dish;
import org.restaurantapp.repository.DishRepository;

import java.util.List;

public class DishService {
    private DishRepository dishRepository;

    Dish save(Dish dish, int restaurantId) {
        return dishRepository.save(dish, restaurantId);
    }

    void delete(int id, int restaurantId) {
        dishRepository.delete(id, restaurantId);
    }

    Dish get(int id, int restaurantId) {
       return dishRepository.get(id, restaurantId);
    }

    List<Dish> getAllByRestaurant(int restaurantId) {
       return dishRepository.getAll(restaurantId);
    }
}
