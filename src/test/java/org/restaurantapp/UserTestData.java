package org.restaurantapp;

import org.restaurantapp.model.Role;
import org.restaurantapp.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static TestMatcher<User> USER_MATCHER = TestMatcher.usingFieldsComparator("registered", "roles");

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int NOT_FOUND = 10;

    public static final User user = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN);

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", new Date(), Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = new User(user);
        updated.setName("UpdatedName");
        updated.setEmail("updateMail@yandex.ru");
        return updated;
    }
}
