package com.example.demogit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_x_car",
            joinColumns = {
                    @JoinColumn(name = "car_id")
            }, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

    public Car(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Car() {
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
