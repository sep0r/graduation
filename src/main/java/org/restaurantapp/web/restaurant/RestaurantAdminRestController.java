package org.restaurantapp.web.restaurant;

import org.restaurantapp.model.Restaurant;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = RestaurantAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantAdminRestController extends AbstractRestaurantController {

    public static final String REST_URL = "/rest/admin/restaurants";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        Restaurant created = super.create(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        super.update(restaurant, id);
    }
}