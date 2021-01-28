package org.restaurantapp.service;

import org.restaurantapp.model.Vote;
import org.restaurantapp.repository.UserRepository;
import org.restaurantapp.repository.VoteRepository;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Vote save(Vote userId, int restaurantId) {
        return null;
    }

    void delete(int id, int userId) throws NotFoundException {
    }

    Vote get(int id, int userId) throws NotFoundException {
        return null;
    }

    List<Vote> getAll(int userId) {
        return null;
    }

    Vote getVote(int userId, LocalDate date) {
        return null;
    }

    Vote update(Vote vote, int restaurantId) throws NotFoundException {
        return null;
    }
}