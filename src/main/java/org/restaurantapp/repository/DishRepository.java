package org.restaurantapp.repository;

import org.restaurantapp.model.Dish;

import java.util.Collection;
import java.util.List;

public interface DishRepository {
    // null if updated meal do not belong to userId
    Dish save(Dish dish,int restaurantId);

    // false if meal do not belong to userId
    boolean delete(int id, int restaurantId);

    // null if meal do not belong to userId
    Dish get(int id, int restaurantId);

    // ORDERED dateTime desc
    List<Dish> getAll(int restaurantId);
}
