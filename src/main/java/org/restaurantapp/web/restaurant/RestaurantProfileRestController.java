package org.restaurantapp.web.restaurant;

import org.restaurantapp.model.Restaurant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantProfileRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantProfileRestController extends AbstractRestaurantController {
    public static final String REST_URL = "/rest/profile/restaurants";

    @GetMapping(value = "/with-menu")
    public List<Restaurant> getAllWithMenu() {
        return super.getAllWithMenu();
    }

    @GetMapping("/{id}/with-menu")
    public Restaurant getWithVotes(@PathVariable int id) {
        return super.getWithMenu(id);
    }

    @Override
    @GetMapping
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable("id") int id) {
        return super.get(id);
    }
}
