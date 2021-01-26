package org.restaurantapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.restaurantapp.VoteTestData;
import org.restaurantapp.model.Vote;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThrows;
import static org.restaurantapp.UserTestData.*;
import static org.restaurantapp.VoteTestData.*;
import static org.restaurantapp.VoteTestData.NOT_FOUND;

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
    public void delete() throws Exception {
        service.delete(VOTE1_ID, USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(VOTE1_ID, USER_ID));
    }

    @Test
    public void deleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND, USER_ID));
    }

    @Test
    public void deleteNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(VOTE1_ID, ADMIN_ID));
    }

    @Test
    public void create() throws Exception {
        Vote created = service.save(VoteTestData.getNew(), USER_ID);
        Integer newId = created.getId();
        Vote newVote = VoteTestData.getNew();
        newVote.setId(newId);
        VOTE_MATCHER.assertMatch(created, newVote);
        VOTE_MATCHER.assertMatch(service.get(newId, USER_ID), newVote);
    }

    @Test
    public void duplicateDateTimeCreate() throws Exception {
        assertThrows(DataAccessException.class, () ->
                service.save(new Vote(null, vote1.getDate()), USER_ID));
    }


    @Test
    public void get() throws Exception {
        Vote actual = service.get(ADMIN_VOTE_ID, ADMIN_ID);
        VOTE_MATCHER.assertMatch(actual, admin_meal1);
    }

    @Test
    public void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND, USER_ID));
    }

    @Test
    public void getNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(VOTE1_ID, ADMIN_ID));
    }

    @Test
    public void getAll() throws Exception {
        VOTE_MATCHER.assertMatch(service.getAll(USER_ID), votes);
    }
}
