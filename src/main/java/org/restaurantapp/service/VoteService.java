package org.restaurantapp.service;

import org.restaurantapp.model.Vote;
import org.restaurantapp.repository.VoteRepository;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Transactional
    public Vote save(Vote vote, int userId, int restId) {
        Assert.notNull(vote, "vote must not be null");
        return voteRepository.save(vote, userId, restId);
    }

    void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }

    Vote get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(voteRepository.get(id, userId), id);
    }

    List<Vote> getAll(int userId) {
        return voteRepository.getAll(userId);
    }

    void update(Vote vote, int userId, int restId) throws NotFoundException {
        Assert.notNull(vote, "vote must not be null");
        voteRepository.save(vote, userId, restId);
    }
}