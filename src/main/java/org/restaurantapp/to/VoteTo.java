package org.restaurantapp.to;

public class VoteTo {
    private Integer id;
    private String name;
    private Long count;

    public VoteTo() {
    }

    public VoteTo(Integer id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "restaurantId=" + id +
                ", name='" + name + '\'' +
                ", votes=" + count +
                '}';
    }
}
