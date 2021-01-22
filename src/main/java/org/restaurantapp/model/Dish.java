package org.restaurantapp.model;

public class Dish extends AbstractNamedEntity{

    private final int price;

    public Dish(Integer id, String name, int price) {
        super(id, name);
        this.price=price;
    }

    public int getPrice() {
        return price;
    }
}
