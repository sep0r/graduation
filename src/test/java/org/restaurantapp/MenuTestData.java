package org.restaurantapp;

import org.restaurantapp.model.Menu;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.restaurantapp.RestaurantTestData.*;
import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class MenuTestData {
    public static TestMatcher<Menu> MENU_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Menu.class, "restaurant", "dishes");

    public static final int NOT_FOUND = 300;
    public static final int MENU_ID = START_SEQ + 9;
    public static final LocalDate DATE_MENU = LocalDate.of(2020, Month.MAY, 20);

    public static final Menu menu1 = new Menu(MENU_ID, DATE_MENU, rest1);
    public static final Menu menu2 = new Menu(MENU_ID + 1, DATE_MENU, rest2);
    public static final Menu menu3 = new Menu(MENU_ID + 2, DATE_MENU, rest3);
    public static final Menu menu4 = new Menu(MENU_ID + 3, LocalDate.of(2020, Month.MAY, 21), rest4);
    public static final Menu menu5 = new Menu(MENU_ID + 4, LocalDate.of(2020, Month.MAY, 21), rest5);

    public static final List<Menu> menuListByDate = Arrays.asList(menu1, menu2, menu3);
    public static final List<Menu> menuListByRestId = Arrays.asList(menu1);

    public static Menu getNew() {
        return new Menu(null, LocalDate.now(), RestaurantTestData.getNew());
    }
}
