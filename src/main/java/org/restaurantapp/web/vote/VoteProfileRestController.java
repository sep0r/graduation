package org.restaurantapp.web.vote;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = VoteProfileRestController.REST_URL)
public class VoteProfileRestController extends AbstractVoteController {
    public static final String REST_URL = "/rest/profile/votes/restaurants";

    @PostMapping(value = "/{restId}")
    public void createOrUpdate(@PathVariable("restId") int restId) {
        super.createOrUpdate(restId);
    }
}
