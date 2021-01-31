package org.restaurantapp.service;

import org.restaurantapp.model.Vote;
import org.restaurantapp.repository.VoteRepository;
import org.restaurantapp.repository.datajpa.CrudRestaurantRepository;
import org.restaurantapp.repository.datajpa.CrudUserRepository;
import org.restaurantapp.repository.datajpa.CrudVoteRepository;
import org.restaurantapp.util.TimeUtil;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private CrudUserRepository crudUserRepository;
    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Transactional
    public Vote save(int userId, int restId) {
        Vote vote = new Vote(LocalDateTime.now());
        vote.setRestaurant(crudRestaurantRepository.getOne(restId));
        vote.setUser(crudUserRepository.getOne(userId));
        return checkNotFoundWithId(voteRepository.save(vote), vote.getId());
    }

    void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }

    Vote get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(voteRepository.get(id), id);
    }

    List<Vote> getAll(int userId) {
        return voteRepository.getAll(userId);
    }


    Vote update(Vote vote, int restId) throws NotFoundException {
        Assert.notNull(vote, "vote must not be null");
        TimeUtil.checkVote();
        vote.setRestaurant(crudRestaurantRepository.getOne(restId));
        return checkNotFoundWithId(voteRepository.save(vote), vote.getId());
    }
}