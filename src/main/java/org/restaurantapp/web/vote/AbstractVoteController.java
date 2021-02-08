package org.restaurantapp.web.vote;

import org.restaurantapp.model.Vote;
import org.restaurantapp.service.VoteService;
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

    //нужно настроить даты
    public List<Vote> getAllForRestaurantByDate(int restId, LocalDate date) {
        log.info("get all for restaurant {} by date {}", restId, date);
        int userId = SecurityUtil.authUserId();
        return service.getAllForRestaurantByDate(userId, date);
    }

    public void delete(int id, int userId) {
        log.info("delete vote {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public void createOrUpdate(int restaurantId) {
        int userId = SecurityUtil.authUserId();
        Vote vote = service.get(userId, LocalDate.now());
        if (vote == null) {
//            log.info("create vote for User {} and Restaurant {}", AuthorizedUser.get(), restaurantId);
            service.save(userId, restaurantId);
        } else {
//            log.info("update vote for User {} and Restaurant {}", AuthorizedUser.get(), restaurantId);
            if (!vote.isNew()) {
                service.update(vote, restaurantId);
            }
        }
    }
}
