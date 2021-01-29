package org.restaurantapp.repository;

import org.restaurantapp.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    Vote save(Vote vote, int userId,int restId);

    boolean delete(int id, int userId);

    boolean delete(int userId, LocalDate date);

    Vote get(int id, int userId);

    List<Vote> getAll(int userId);

}
