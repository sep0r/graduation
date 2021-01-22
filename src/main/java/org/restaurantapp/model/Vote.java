package org.restaurantapp.model;

import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity {
    private LocalDateTime voting_date;


    protected Vote(Integer id, LocalDateTime voting_date) {
        super(id);
        this.voting_date = voting_date;
    }

    public LocalDateTime getVoting_date() {
        return voting_date;
    }
}
