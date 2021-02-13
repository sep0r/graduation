package org.restaurantapp.web.json;

import org.junit.Test;
import org.restaurantapp.UserTestData;
import org.restaurantapp.model.User;
import org.restaurantapp.model.Vote;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.restaurantapp.VoteTestData.*;

public class JsonUtilTest {

    @Test
    public void readWriteValue() throws Exception {
        String json = JsonUtil.writeValue(vote1);
        System.out.println(json);
        Vote vote = JsonUtil.readValue(json, Vote.class);
        VOTE_MATCHER.assertMatch(vote, vote1);
    }

    @Test
    public void readWriteValues() throws Exception {
        String json = JsonUtil.writeValue(votes);
        System.out.println(json);
        List<Vote> votess = JsonUtil.readValues(json, Vote.class);
        VOTE_MATCHER.assertMatch(votes, votess);
    }

    @Test
    public void writeOnlyAccess() throws Exception {
        String json = JsonUtil.writeValue(UserTestData.user1);
        System.out.println(json);
        assertThat(json, not(containsString("password")));
        String jsonWithPass = UserTestData.jsonWithPassword(UserTestData.user1, "newPass");
        System.out.println(jsonWithPass);
        User user = JsonUtil.readValue(jsonWithPass, User.class);
        assertEquals(user.getPassword(), "newPass");
    }
}
