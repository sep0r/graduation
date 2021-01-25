package org.restaurantapp.util;

import org.restaurantapp.model.Restaurant;
import org.restaurantapp.model.Role;
import org.restaurantapp.model.User;
import org.restaurantapp.model.Vote;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class VoteUtil {
    public static void main(String[] args) {

        final int USER1_ID = 10;
        final int ADMIN_ID = 20;
        final int USER2_ID = 30;
        final int USER3_ID = 40;

        final User user1 = new User(USER1_ID, "User1", "user1@yandex.ru", "password", Role.USER);
        final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN);
        final User user2 = new User(USER2_ID, "User2", "user2@yandex.ru", "password", Role.USER);
        final User user3 = new User(USER3_ID, "User3", "user3@yandex.ru", "password", Role.USER);

        Restaurant restaurant1 = new Restaurant(11, "rest1", "description1");
        Restaurant restaurant2 = new Restaurant(12, "rest2", "description2");
        Restaurant restaurant3 = new Restaurant(13, "rest3", "description3");

        List<Vote> voteList = Arrays.asList(
                new Vote(1, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0)),
                new Vote(2, LocalDateTime.of(2020, Month.JANUARY, 30, 14, 0)),
                new Vote(3, LocalDateTime.of(2020, Month.JANUARY, 30, 12, 0)),
                new Vote(4, LocalDateTime.of(2020, Month.JANUARY, 30, 1, 0)),

                new Vote(5, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0)),
                new Vote(6, LocalDateTime.of(2020, Month.JANUARY, 31, 16, 0)),
                new Vote(7, LocalDateTime.of(2020, Month.JANUARY, 31, 8, 0)),
                new Vote(8, LocalDateTime.of(2020, Month.JANUARY, 31, 23, 0))
        );

        voteList.forEach(System.out::println);
    }
}