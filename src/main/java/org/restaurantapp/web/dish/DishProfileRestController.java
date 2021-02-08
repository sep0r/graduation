package org.restaurantapp.web.dish;

import org.restaurantapp.model.Dish;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = DishProfileRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishProfileRestController extends AbstractDishController {

    public static final String REST_URL = "/rest/profile/menu/{menuId}/dishes";

    @Override
    @GetMapping
    public List<Dish> getAllByMenu(@PathVariable("menuId") int menuId) {
        log.info("getAll");
        return super.getAllByMenu(menuId);
    }
}
