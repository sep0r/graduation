package org.restaurantapp.repository;


import org.restaurantapp.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish save(Dish dish,int menuId);

    boolean delete(int id);

    Dish get(int id);

    List<Dish> getAllByMenu(int menuId);
}