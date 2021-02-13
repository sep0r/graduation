package org.restaurantapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.restaurantapp.RestaurantTestData;
import org.restaurantapp.model.Restaurant;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThrows;
import static org.restaurantapp.RestaurantTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void delete() {
        service.delete(REST_ID);
        assertThrows(NotFoundException.class, () -> service.get(REST_ID));
    }

    @Test
    public void create() {
        Restaurant created = service.create(RestaurantTestData.getNew());
        Integer newId = created.getId();
        Restaurant newRest = RestaurantTestData.getNew();
        newRest.setId(newId);
        REST_MATCHER.assertMatch(created, newRest);
        REST_MATCHER.assertMatch(service.get(newId), newRest);
    }

    @Test
    public void get() {
        Restaurant actual = service.get(REST_ID);
        REST_MATCHER.assertMatch(actual, rest1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        REST_MATCHER.assertMatch(service.getAll(), restaurantList);
    }

    @Test
    public void getWithMenu() {
        Restaurant restaurant = service.getWithMenu(REST_ID);
        REST_MATCHER.assertMatch(restaurant, rest1);
    }
}
