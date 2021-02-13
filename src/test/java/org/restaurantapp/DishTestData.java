package org.restaurantapp;

import org.restaurantapp.model.Dish;

import java.util.Arrays;
import java.util.List;

import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static TestMatcher<Dish> DISH_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Dish.class, "menu");

    public static final int NOT_FOUND = 400;
    public static final int DISH_ID = START_SEQ + 14;

    public static final Dish dish1 = new Dish(DISH_ID, "Лапша удон", 1200);
    public static final Dish dish2 = new Dish(DISH_ID + 1, "Отбивные из фарша", 300);
    public static final Dish dish3 = new Dish(DISH_ID + 2, "Куриные рулеты с грибами", 150);
    public static final Dish dish4 = new Dish(DISH_ID + 3, "Жульен из курицы", 200);
    public static final Dish dish5 = new Dish(DISH_ID + 4, "Тушеный картофель с мясом", 280);
    public static final Dish dish6 = new Dish(DISH_ID + 5, "Котлеты из овощей", 100);
    public static final Dish dish7 = new Dish(DISH_ID + 6, "Курица в томатном соусе", 300);
    public static final Dish dish8 = new Dish(DISH_ID + 7, "Паста с помидорами", 150);
    public static final Dish dish9 = new Dish(DISH_ID + 8, "Гуляш из печени говяжьей", 700);
    public static final Dish dish10 = new Dish(DISH_ID + 9, "Сибирские пельмени", 550);


    public static final List<Dish> dishes = Arrays.asList(dish9, dish2);

    public static Dish getNew() {
        return new Dish(null, "nameDish", 2000);
    }
}
