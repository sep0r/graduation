package org.restaurantapp.web.menu;

import org.restaurantapp.model.Menu;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuProfileRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuProfileRestController extends AbstractMenuController {

    public static final String REST_URL = "/rest/profile/restaurants/menu/";

    @Override
    @GetMapping
    public List<Menu> getAllByDate(@PathVariable("date") LocalDate date) {
        return super.getAllByDate(date);
    }

    @Override
    @GetMapping(value ="/menus/restaurant/{restId}")
    public List<Menu> getAllByRestaurantId(@PathVariable("restId") int restId) {
        return super.getAllByRestaurantId(restId);
    }

    @Override
    @GetMapping(value ="/{id}/restaurant/{restId}")
    public Menu get(@PathVariable("id") int id, @PathVariable("restId") int restId) {
        return super.get(id, restId);
    }
}
