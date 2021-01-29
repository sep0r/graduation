package org.restaurantapp.service;

import org.restaurantapp.model.Menu;
import org.restaurantapp.model.Restaurant;
import org.restaurantapp.model.User;
import org.restaurantapp.repository.MenuRepository;
import org.restaurantapp.repository.UserRepository;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {

    MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu create(Menu menu, int restId, LocalDate date) {
        Assert.notNull(menu, "user must not be null");
        return menuRepository.save(menu, restId, date);
    }

    public Menu get(int id) throws NotFoundException {
        return checkNotFoundWithId(menuRepository.get(id), id);
    }

    public List<Menu> getAll() {
        return menuRepository.getAll();
    }

//    List<Menu> getAllForDate(LocalDate date) {
//        return menuRepository.getAllForDate(date);
//    }
//
//    List<Menu> getByRestaurantId(int restaurant_id) {
//        return menuRepository.getByRestaurantId(restaurant_id);
//    }
//
//    List<Menu> getByRestaurantIdAndDate(int restaurant_id, LocalDate date) {
//        return menuRepository.getByRestaurantIdAndDate(restaurant_id, date);
//    }

    public void delete(int id) {
        checkNotFoundWithId(menuRepository.delete(id), id);
    }
}
