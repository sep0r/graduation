package org.restaurantapp;

import org.restaurantapp.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static TestMatcher<Restaurant> REST_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Restaurant.class, "votes", "menu");

    public static final int NOT_FOUND = 200;
    public static final int REST_ID = START_SEQ + 4;

    public static final Restaurant rest1 = new Restaurant(REST_ID, "ЧEBUREK", "description 1");
    public static final Restaurant rest2 = new Restaurant(REST_ID + 1, "Пельменная №2", "description 2");
    public static final Restaurant rest3 = new Restaurant(REST_ID + 2, "Хуторок", "description 3");
    public static final Restaurant rest4 = new Restaurant(REST_ID + 3, "Златибор", "description 4");
    public static final Restaurant rest5 = new Restaurant(REST_ID + 4, "Four", "description 5");
    public static final List<Restaurant> restaurantList = Arrays.asList(rest1, rest2, rest3, rest4, rest5);

    public static Restaurant getNew() {
        return new Restaurant(null, "nameRest", "desc");
    }
}
