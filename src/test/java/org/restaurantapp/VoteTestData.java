package org.restaurantapp;

import org.restaurantapp.model.Vote;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.restaurantapp.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {
    public static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingFieldsComparator();

    public static final int NOT_FOUND = 10;
    public static final int VOTE1_ID = START_SEQ + 2;
    public static final int ADMIN_VOTE_ID = START_SEQ + 9;

    public static final Vote vote1 = new Vote(VOTE1_ID, of(2020, Month.JANUARY, 30, 10, 0));
    public static final Vote vote2 = new Vote(VOTE1_ID + 1, of(2020, Month.JANUARY, 30, 13, 0));
    public static final Vote vote3 = new Vote(VOTE1_ID + 2, of(2020, Month.JANUARY, 30, 20, 0));
    public static final Vote vote4 = new Vote(VOTE1_ID + 3, of(2020, Month.JANUARY, 31, 0, 0));
    public static final Vote vote5 = new Vote(VOTE1_ID + 4, of(2020, Month.JANUARY, 31, 10, 0));
    public static final Vote vote6 = new Vote(VOTE1_ID + 5, of(2020, Month.JANUARY, 31, 13, 0));
    public static final Vote vote7 = new Vote(VOTE1_ID + 6, of(2020, Month.JANUARY, 31, 20, 0));
    public static final Vote admin_meal1 = new Vote(ADMIN_VOTE_ID, of(2020, Month.JANUARY, 31, 14, 0));
    public static final Vote admin_meal2 = new Vote(ADMIN_VOTE_ID + 1, of(2020, Month.JANUARY, 31, 21, 0));

    public static final List<Vote> votes = Arrays.asList(vote7, vote6, vote5, vote4, vote3, vote2, vote1);

    public static Vote getNew() {
        return new Vote(null, of(2020, Month.FEBRUARY, 1, 18, 0));
    }
}
