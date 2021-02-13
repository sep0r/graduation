package org.restaurantapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.restaurantapp.DishTestData;
import org.restaurantapp.model.Dish;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.restaurantapp.DishTestData.*;
import static org.restaurantapp.MenuTestData.MENU_ID;
import static org.restaurantapp.MenuTestData.menu2;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class DishServiceTest {

    @Autowired
    private DishService service;

    @Test
    public void save() {
        Dish created = service.save(DishTestData.getNew(), MENU_ID);
        int newId = created.id();
        Dish newDish = DishTestData.getNew();
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(service.get(newId, MENU_ID), newDish);
    }

    @Test
    public void delete() {
        service.delete(DISH_ID, MENU_ID);
        assertThrows(NotFoundException.class, () -> service.get(DISH_ID, MENU_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(DishTestData.NOT_FOUND, MENU_ID));
    }

    @Test
    public void get() {
        Dish dish = service.get(DISH_ID, MENU_ID);
        DISH_MATCHER.assertMatch(dish, dish);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(DishTestData.NOT_FOUND, MENU_ID));
    }

    @Test
    public void getAllByMenu() {
        List<Dish> all = service.getAllByMenu(menu2.getId());
        DISH_MATCHER.assertMatch(all, dishes);
    }
}
