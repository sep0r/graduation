package org.restaurantapp.util;

import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalTime;

public class TimeUtil {

    public TimeUtil() {
    }

    public static final LocalTime VOTE_DEADLINE_TIME = LocalTime.of(11,0,0);
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    public static void checkVote() {
        if (LocalTime.now().isAfter(getVoteDeadlineTime())) {
            throw new DataIntegrityViolationException("Restriction vote");
        }
    }

    public static LocalTime getVoteDeadlineTime() {
        return VOTE_DEADLINE_TIME;
    }
}
