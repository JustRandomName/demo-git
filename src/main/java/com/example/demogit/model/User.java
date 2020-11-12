package com.example.demogit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_x_car",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            }, inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> cars;

    public User(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
