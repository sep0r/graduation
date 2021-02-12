package org.restaurantapp.web.restaurant;

import org.restaurantapp.model.Restaurant;
import org.restaurantapp.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.restaurantapp.util.ValidationUtil.assureIdConsistent;
import static org.restaurantapp.util.ValidationUtil.checkNew;


public abstract class AbstractRestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public List<Restaurant> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Restaurant get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public Restaurant getWithMenu(int id){
        log.info("get with menu " + id);
        return service.getWithMenu(id);
    }

    public List<Restaurant> getAllWithMenu() {
        log.info("getAll with menu");
        return service.getAllWithMenu();
    }

    public Restaurant create(Restaurant restaurant) {
        checkNew(restaurant);
        log.info("create " + restaurant);
        return service.create(restaurant);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        assureIdConsistent(restaurant, id);
        log.info("update " + restaurant);
        service.update(restaurant);
    }


}