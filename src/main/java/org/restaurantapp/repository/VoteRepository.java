package org.restaurantapp.repository;

import org.restaurantapp.model.Vote;
import org.restaurantapp.to.VoteTo;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {

    Vote save(Vote vote);

    boolean delete(int id, int userId);

    Vote get(int id, int userId);

    Vote get(int userId, LocalDate date);

    List<VoteTo> getResultByDate(LocalDate date);

    List<VoteTo> getNumberOfVotesForRestaurantsByDate(LocalDate date);
}
