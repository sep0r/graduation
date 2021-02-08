package org.restaurantapp.repository;

import org.restaurantapp.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {

    Vote save(Vote vote);

    boolean delete(int id, int userId);

//    Vote getResultByDate(LocalDate date);

    Vote get(int id, int userId);

    Vote get(int userId, LocalDate date);

    List<Vote> getAllForRestaurantByDate(int restId, LocalDate date);

}
