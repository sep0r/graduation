package org.restaurantapp.service;

import org.restaurantapp.model.Dish;
import org.restaurantapp.repository.DishRepository;
import org.restaurantapp.util.exception.NotFoundException;
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

    public Dish get(int id, int menuId) throws NotFoundException {
        return checkNotFoundWithId(dishRepository.get(id, menuId), id);
    }

    public void delete(int id, int menuId) {
        checkNotFoundWithId(dishRepository.delete(id, menuId), id);
    }

    public List<Dish> getAllByMenu(int menuId) {
        return dishRepository.getAllByMenu(menuId);
    }
}