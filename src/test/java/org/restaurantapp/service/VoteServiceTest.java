package org.restaurantapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.restaurantapp.VoteTestData;
import org.restaurantapp.model.Vote;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThrows;
import static org.restaurantapp.RestaurantTestData.rest3;
import static org.restaurantapp.UserTestData.ADMIN_ID;
import static org.restaurantapp.UserTestData.USER1_ID;
import static org.restaurantapp.VoteTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class VoteServiceTest {

    @Autowired
    private VoteService service;

    @Test
    public void delete() {
        service.delete(VOTE1_ID, USER1_ID);
        assertThrows(NotFoundException.class, () -> service.get(VOTE1_ID, USER1_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND, USER1_ID));
    }

    @Test
    public void deleteNotOwn() {
        assertThrows(NotFoundException.class, () -> service.delete(VOTE1_ID, ADMIN_ID));
    }

    @Test
    public void save() {
        Vote created = service.save(USER1_ID, rest3.getId());
        Integer newId = created.getId();
        Vote newVote = VoteTestData.getNew();
        newVote.setId(newId);
        VOTE_MATCHER.assertMatch(created, newVote);
        VOTE_MATCHER.assertMatch(service.get(newId,USER1_ID), newVote);
    }

    @Test
    public void get() {
        Vote actual = service.get(VOTE1_ID,USER1_ID);
        VOTE_MATCHER.assertMatch(actual, vote1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND,USER1_ID));
    }
}
