package org.restaurantapp.service;

import org.restaurantapp.model.Menu;
import org.restaurantapp.repository.MenuRepository;
import org.restaurantapp.util.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static org.restaurantapp.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {

    MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu create(Menu menu, int restId) {
        Assert.notNull(menu, "menu must not be null");
        if (!menu.isNew() && get(menu.getId(), restId) == null) {
            return null;
        }
        return menuRepository.save(menu, restId);
    }

    public Menu get(int id, int restId) throws NotFoundException {
        return checkNotFoundWithId(menuRepository.get(id, restId), id);
    }

    public List<Menu> getAllByDate(LocalDate date) {
        return menuRepository.getAllByDate(date);
    }

    public List<Menu> getAllByRestaurantId(int restaurantId) {
        return menuRepository.getAllByRestaurantId(restaurantId);
    }

    public void update(Menu menu, int restId) {
        Assert.notNull(menu, "menu must not be null");
        Menu updated = get(menu.getId(), restId);
        if (updated != null) {
            menuRepository.save(menu, restId);
        }
    }

    public void delete(int id) {
        checkNotFoundWithId(menuRepository.delete(id), id);
    }
}
