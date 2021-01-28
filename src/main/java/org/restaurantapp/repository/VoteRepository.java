package org.restaurantapp.repository;

import org.restaurantapp.model.Vote;

import java.time.LocalDate;
import java.util.Collection;

public interface VoteRepository {
    Vote save(Vote vote, int userId);

    boolean delete(int userId, LocalDate date);

    Vote get(int id, LocalDate date);

    Collection<Vote> getAll();

}
