package org.restaurantapp.repository;

import org.restaurantapp.model.Dish;

import java.util.Collection;

public interface DishRepository {
    // null if updated meal do not belong to userId
    Dish save(Dish dish);

    // false if meal do not belong to userId
    boolean delete(int id);

    // null if meal do not belong to userId
    Dish get(int id);

    // ORDERED dateTime desc
    Collection<Dish> getAll();
}
