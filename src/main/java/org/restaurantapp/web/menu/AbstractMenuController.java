package org.restaurantapp.web.menu;

import org.restaurantapp.model.Menu;
import org.restaurantapp.service.MenuService;
import org.restaurantapp.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNew;

public abstract class AbstractMenuController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService service;

    @Autowired
    private RestaurantService restaurantService;

    public Menu create(Menu menu, int restId) {
        checkNew(menu);
        log.info("create {} for {}", menu, restaurantService.get(restId).getName());
        return service.create(menu, restId);
    }

    public List<Menu> getAllByDate(LocalDate date) {
        log.info("get all by date {} ",date);
        return service.getAllByDate(date);
    }

    public List<Menu> getAllByRestaurantId(int restId){
        log.info("get all for restaurant {} ",restaurantService.get(restId).getName());
        return service.getAllByRestaurantId(restId);
    }

    public Menu get(int id, int restId) {
        log.info("get menu " + id);
        return service.get(id, restId);
    }

    public void delete(int id) {
        log.info("delete menu ");
        service.delete(id);
    }

    public void update(Menu menu, int restId) {
        log.info("update menu " + menu.getId());
        service.update(menu, restId);
    }
}
