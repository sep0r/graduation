package org.restaurantapp.service;

import org.restaurantapp.model.Dish;
import org.restaurantapp.repository.DishRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNotFoundWithId;


@Service
public class DishService {

    DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Transactional
    public Dish save(Dish dish, int menuId) {
        Assert.notNull(dish, "dish must not be null");
        return dishRepository.save(dish, menuId);
    }

    public void delete(int id) {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }

    public Dish get(int id, int menuId) {
        Dish dish = dishRepository.get(id);
        return checkNotFoundWithId(dish != null && dish.getMenu().getId() == menuId ? dish : null, id);
    }

    public List<Dish> getAllByMenu(int menu_id) {
        return dishRepository.getAllByMenu(menu_id);
    }
}
