package org.restaurantapp;

import org.restaurantapp.model.Role;
import org.restaurantapp.model.User;
import org.restaurantapp.web.json.JsonUtil;

import java.util.Collections;
import java.util.Date;

import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static TestMatcher<User> USER_MATCHER = TestMatcher.usingIgnoringFieldsComparator(User.class,"registered","roles","votes", "password");

    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int USER1_ID = START_SEQ;
    public static final int USER2_ID = START_SEQ + 2;
    public static final int USER3_ID = START_SEQ + 3;
    public static final int NOT_FOUND = 10;

    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN);
    public static final User user1 = new User(USER1_ID, "User1", "user1@yandex.ru", "password1", Role.USER);
    public static final User user2 = new User(USER2_ID, "User2", "user2@yandex.ru", "password2",Role.USER);
    public static final User user3 = new User(USER3_ID, "User3", "user3@yandex.ru", "password3",Role.USER);


    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", new Date(), Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = new User(user1);
        updated.setName("UpdatedName");
        updated.setPassword("newPass");
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }

    public static String jsonWithPassword(User user, String passw) {
        return JsonUtil.writeAdditionProps(user, "password", passw);
    }
}
