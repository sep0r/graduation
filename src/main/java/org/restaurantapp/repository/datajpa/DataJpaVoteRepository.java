package org.restaurantapp.repository.datajpa;


import org.restaurantapp.model.Vote;
import org.restaurantapp.repository.VoteRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Repository
public class DataJpaVoteRepository implements VoteRepository {
    private final CrudVoteRepository crudVoteRepository;


    public DataJpaVoteRepository(CrudVoteRepository crudVoteRepository) {
        this.crudVoteRepository = crudVoteRepository;
    }

    @Override
    @Transactional
    public Vote save(Vote vote) {
        return crudVoteRepository.save(vote);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudVoteRepository.delete(id, userId) != 0;
    }

//    @Override
//    public Vote getResultByDate(LocalDate date) {
//        return crudVoteRepository.getResultByDate(date);
//    }

    @Override
    public Vote get(int userId, LocalDate date) {
        return crudVoteRepository.get(userId, date);
    }

    @Override
    public Vote get(int id, int userId) {
        return crudVoteRepository.findById(id)
                .filter(vote-> vote.getUser().getId() == userId)
                .orElse(null);
    }

    @Override
    public List<Vote> getAllForRestaurantByDate(int restId, LocalDate date) {
        return crudVoteRepository.getAllForRestaurantByDate(restId, date);
    }
}
