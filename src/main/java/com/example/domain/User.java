package com.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by djklaf on 2017/1/9.
 */
@Entity
@Table(name = "users")
public class User {

    public User(){

    }

    public User(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column(nullable = false)
    @NotNull
    private String name;

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
