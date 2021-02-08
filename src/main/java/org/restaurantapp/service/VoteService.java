package org.restaurantapp.service;

import org.restaurantapp.model.Vote;
import org.restaurantapp.repository.VoteRepository;
import org.restaurantapp.repository.datajpa.CrudRestaurantRepository;
import org.restaurantapp.repository.datajpa.CrudUserRepository;
import org.restaurantapp.util.TimeUtil;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
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
        Vote vote = new Vote(LocalDate.now());
        vote.setRestaurant(crudRestaurantRepository.getOne(restId));
        vote.setUser(crudUserRepository.getOne(userId));
        return checkNotFoundWithId(voteRepository.save(vote), vote.getId());
    }

    public void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }

//    public Vote getResultByDate(LocalDate date) {
//        return voteRepository.getResultByDate(date);
//    }

    public Vote get(int userId, LocalDate date) throws NotFoundException {
        return voteRepository.get(userId, date);
    }

    public Vote get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(voteRepository.get(id, userId), id);
    }

    public List<Vote> getAllForRestaurantByDate(int restId, LocalDate date) {
        return voteRepository.getAllForRestaurantByDate(restId, date);
    }

    public Vote update(Vote vote, int restId) throws NotFoundException {
        Assert.notNull(vote, "vote must not be null");
        TimeUtil.checkVote();
        vote.setRestaurant(crudRestaurantRepository.getOne(restId));
        return checkNotFoundWithId(voteRepository.save(vote), vote.getId());
    }
}