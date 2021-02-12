package org.restaurantapp.web.vote;

import org.restaurantapp.to.VoteTo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteAdminRestController extends AbstractVoteController {
    public static final String REST_URL = "/rest/admin/votes";

    @Override
    @GetMapping(value = "/")
    public List<VoteTo> getNumberOfVotesForRestaurantsByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return super.getNumberOfVotesForRestaurantsByDate( date);
    }

    @Override
    @GetMapping(value = "/result")
    public VoteTo getResultByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return super.getResultByDate(date);
    }

    @Override
    @DeleteMapping(value = "/{id}/users/{userId}")
    public void delete(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        super.delete(id, userId);
    }
}
