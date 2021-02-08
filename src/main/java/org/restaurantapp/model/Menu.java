package org.restaurantapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.restaurantapp.util.TimeUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends AbstractBaseEntity {
    @Column(name = "date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = TimeUtil.DATE_PATTERN)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    @JsonBackReference
    @JsonIgnore
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    @JsonManagedReference
    private List<Dish> dishes;

    public Menu() {
    }

    public Menu(LocalDate date) {
        this(null, date, null);
    }

    public Menu(LocalDate date, Restaurant restaurant) {
        this(null, date, restaurant);
    }

    public Menu(Integer id, LocalDate date, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", restaurant=" + restaurant +
                ", dishes=" + dishes +
                '}';
    }
}
