package org.restaurantapp.repository;

import org.restaurantapp.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    Restaurant get(Integer id);

    Restaurant getWithMenu(int id);

    List<Restaurant> getAll();

    boolean delete(int id);

    List<Restaurant> getAllWithMenu();
}
