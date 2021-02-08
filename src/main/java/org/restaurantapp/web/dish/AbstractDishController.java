package org.restaurantapp.web.dish;

import org.restaurantapp.model.Dish;
import org.restaurantapp.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDishController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishService service;

    public Dish create(Dish dish, int menuId) {
        log.info("create {} for {}", dish, menuId);
        return service.save(dish, menuId);
    }

    public Dish get(int id, int menuId) {
        log.info("get " + id);
        return service.get(id, menuId);
    }

    public void delete(int id, int menuId) {
        log.info("delete " + id);
        service.delete(id, menuId);
    }

    public List<Dish> getAllByMenu(int menuId) {
        log.info("getAll");
        return service.getAllByMenu(menuId);
    }
}
