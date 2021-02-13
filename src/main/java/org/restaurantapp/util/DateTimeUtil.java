package org.restaurantapp.util;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final LocalTime VOTE_DEADLINE_TIME = LocalTime.of(11,0,0);
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public DateTimeUtil() {
    }

    public static void checkVote() {
        if (LocalTime.now().isAfter(getVoteDeadlineTime())) {
            throw new DataIntegrityViolationException("Restriction vote");
        }
    }

    public static LocalTime getVoteDeadlineTime() {
        return VOTE_DEADLINE_TIME;
    }

    public static @Nullable
    LocalDate parseLocalDate(@Nullable String str) {
        return StringUtils.hasText(str) ? LocalDate.parse(str) : null;
    }

    public static String toString(LocalDate ldt) {
        return ldt == null ? "" : ldt.format(DATE_FORMATTER);
    }
}
