package org.restaurantapp.web.vote;

import org.restaurantapp.model.Vote;
import org.restaurantapp.service.VoteService;
import org.restaurantapp.to.VoteTo;
import org.restaurantapp.util.exception.NotFoundException;
import org.restaurantapp.web.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractVoteController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService service;

    public VoteTo getResultByDate(LocalDate date) {
        log.info("get result by date {}", date);
        List<VoteTo> resultList = service.getResultByDate(date);
        if (resultList.size() == 0){
            throw new NotFoundException("No votes yet.");
        }
            return resultList.get(0);
    }

    public List<VoteTo> getNumberOfVotesForRestaurantsByDate(LocalDate date) {
        log.info("get all for restaurants by date {}", date);
        return service.getNumberOfVotesForRestaurantsByDate(date);
    }

    public void delete(int id, int userId) {
        log.info("delete vote {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public void createOrUpdate(int restaurantId) {
        int userId = SecurityUtil.authUserId();
        Vote vote = service.get(userId, LocalDate.now());
        if (vote == null) {
            log.info("create vote");
            service.save(userId, restaurantId);
        } else {
            log.info("update vote");
            if (!vote.isNew()) {
                service.update(vote, restaurantId);
            }
        }
    }
}
