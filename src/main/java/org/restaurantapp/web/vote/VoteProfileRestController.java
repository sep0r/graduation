package org.restaurantapp.web.vote;

import org.restaurantapp.to.VoteTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = VoteProfileRestController.REST_URL)
public class VoteProfileRestController extends AbstractVoteController {
    public static final String REST_URL = "/rest/profile/votes/";

    @PostMapping(value = "/{restId}")
    public void createOrUpdate(@PathVariable("restId") int restId) {
        super.createOrUpdate(restId);
    }

    @GetMapping(value = "/result")
    public VoteTo getResultByDate() {
        return super.getResultByDate(LocalDate.now());
    }
}
