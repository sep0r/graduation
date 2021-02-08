package org.restaurantapp.service;


import org.restaurantapp.model.Restaurant;
import org.restaurantapp.repository.RestaurantRepository;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNotFoundWithId;

@Service("restaurantService")
public class RestaurantService {

    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository=restaurantRepository;
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }

    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(restaurantRepository.get(id), id);
    }

    public Restaurant getWithMenu(int id) throws NotFoundException {
        return checkNotFoundWithId(restaurantRepository.getWithMenu(id), id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllWithMenu() {
        return restaurantRepository.getAllWithMenu();
    }
}
