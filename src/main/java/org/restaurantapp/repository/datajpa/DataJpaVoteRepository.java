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

    @Override
    public Vote get(int id) {
        return crudVoteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vote> getAll(int userId) {
        return crudVoteRepository.getAll(userId);
    }
}
