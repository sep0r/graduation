package org.restaurantapp.repository;

import org.restaurantapp.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository {

    Menu save(Menu menu, int restId);

    Menu get(int id, int restId);

    Menu get(LocalDate date, int restId);

    List<Menu> getAllByDate(LocalDate date);

    List<Menu> getAllByRestaurantId(int restaurantId);

    boolean delete(int id);
}
