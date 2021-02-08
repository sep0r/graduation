package org.restaurantapp.web.menu;

import org.restaurantapp.model.Menu;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuAdminRestController extends AbstractMenuController {

    public static final String REST_URL = "/rest/admin/restaurants/{restId}/menu";

    //broken
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createWithLocation(@Valid @RequestBody Menu menu,
                                                   @PathVariable("restId") int restId) {
        Menu created = super.create(menu, restId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
//    @GetMapping(value ="/{id}/restaurant/{restId}")
    @GetMapping(value ="/{id}")
    public Menu get(@PathVariable("id") int id, @PathVariable("restId") int restId) {
        return super.get(id, restId);
    }

    @Override
    @GetMapping(value ="/bydate")
    public List<Menu> getAllByDate(@RequestParam(value = "date", required = false) LocalDate date) {
        log.info("get all by date {} ",date);
        return super.getAllByDate(date);
    }

    @Override
    @GetMapping(value ="/menus/restaurant/{restId}")
    public List<Menu> getAllByRestaurantId(@PathVariable("restId") int restId) {
        log.info("get all for restaurant {} ", restId);
        return super.getAllByRestaurantId(restId);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    //update?
}
