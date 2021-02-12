package org.restaurantapp.web.menu;

import org.restaurantapp.model.Menu;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuAdminRestController extends AbstractMenuController {

    public static final String REST_URL = "/rest/admin/restaurants/menu";

    @PostMapping(value = "/{restId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createWithLocation(@RequestBody Menu menu,
                                                   @PathVariable("restId") int restId) {
        Menu created = super.create(menu, restId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @GetMapping(value = "/{id}/for/{restId}")
    public Menu get(@PathVariable("id") int id, @PathVariable("restId") int restId) {
        return super.get(id, restId);
    }

    @Override
    @GetMapping(value = "/bydate")
    public List<Menu> getAllByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return super.getAllByDate(date);
    }

    @Override
    @GetMapping(value = "/{restId}")
    public List<Menu> getAllByRestaurantId(@PathVariable("restId") int restId) {
        return super.getAllByRestaurantId(restId);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @PutMapping(value = "/{restId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Menu menu, @PathVariable("restId") int restId) {
        super.update(menu, restId);
    }
}
