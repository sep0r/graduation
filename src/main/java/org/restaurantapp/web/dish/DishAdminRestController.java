package org.restaurantapp.web.dish;

import org.restaurantapp.model.Dish;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = DishAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishAdminRestController extends AbstractDishController {

    public static final String REST_URL = "/rest/admin/menu/{menuId}/dishes";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@Valid @RequestBody Dish dish,
                                                   @PathVariable("menuId") int menuId) {
        Dish created = super.create(dish, menuId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(menuId, created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @GetMapping("/{id}")
    public Dish get(@PathVariable("id") int id, @PathVariable("menuId") int menuId) {
        return super.get(id, menuId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id, @PathVariable("menuId") int menuId) {
        super.delete(id, menuId);
    }
}

