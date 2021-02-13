package org.restaurantapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.restaurantapp.MenuTestData;
import org.restaurantapp.model.Menu;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.restaurantapp.MenuTestData.*;
import static org.restaurantapp.RestaurantTestData.REST_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MenuServiceTest {

    @Autowired
    private MenuService service;

    @Test
    public void create() {
        Menu created = service.create(MenuTestData.getNew(), REST_ID);
        int newId = created.id();
        Menu newMenu = MenuTestData.getNew();
        newMenu.setId(newId);
        MENU_MATCHER.assertMatch(created, newMenu);
        MENU_MATCHER.assertMatch(service.get(newId, REST_ID), newMenu);
    }

    @Test
    public void delete() {
        service.delete(MENU_ID);
        assertThrows(NotFoundException.class, () -> service.get(MENU_ID, REST_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(MenuTestData.NOT_FOUND));
    }

    @Test
    public void get() {
        Menu menu = service.get(MENU_ID, REST_ID);
        MENU_MATCHER.assertMatch(menu, menu);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(MenuTestData.NOT_FOUND, REST_ID));
    }

    @Test
    public void getAllByDate() {
        List<Menu> allByDate = service.getAllByDate(DATE_MENU);
        MENU_MATCHER.assertMatch(allByDate, menuListByDate);
    }

    @Test
    public void getAllByRestaurantId() {
        List<Menu> allByRestaurantId = service.getAllByRestaurantId(REST_ID);
        MENU_MATCHER.assertMatch(allByRestaurantId, menuListByRestId);
    }
}

