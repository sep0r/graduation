package org.restaurantapp.web.vote;

import org.restaurantapp.model.Vote;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteAdminRestController extends AbstractVoteController {
    public static final String REST_URL = "/rest/admin/votes";

    @Override
    @GetMapping(value = "/{restId}")
    public List<Vote> getAllForRestaurantByDate(@PathVariable("restId") int restId,
                                                @RequestParam @Nullable LocalDate date) {
        return super.getAllForRestaurantByDate(restId, date);
    }

    //get подсчет голосов по дате

    @Override
    @DeleteMapping(value = "/{id}/users/{userId}")
    public void delete(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        super.delete(id, userId);
    }
}
