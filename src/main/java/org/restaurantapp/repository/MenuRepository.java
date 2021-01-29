package org.restaurantapp.repository;

import org.restaurantapp.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository {

    Menu save(Menu menu, int restId, LocalDate date);

    Menu get(int id);

    List<Menu> getAll();

//    List<Menu> getAllForDate(LocalDate date);
//
//    List<Menu> getByRestaurantId(int restaurant_id);
//
//    List<Menu> getByRestaurantIdAndDate(int restaurant_id, LocalDate date);

    boolean delete(int id);
}
