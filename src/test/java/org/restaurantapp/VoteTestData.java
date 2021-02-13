package org.restaurantapp;

import org.restaurantapp.model.Vote;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {
    public static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Vote.class,"date", "restaurant", "user");

    public static final int NOT_FOUND = 100;
    public static final int VOTE1_ID = START_SEQ + 24;
    public static final LocalDate DATE_VOTE= LocalDate.of(2020, Month.MAY, 20);

    public static final Vote vote1 = new Vote(VOTE1_ID,DATE_VOTE);
    public static final Vote vote6 = new Vote(VOTE1_ID + 5, LocalDate.of(2020, Month.MAY, 2));


    public static final List<Vote> votes = Arrays.asList(vote6,vote1);

    public static Vote getNew() {
        return new Vote(null, LocalDate.of(2020, Month.FEBRUARY, 1));
    }
}
