package com.test.renting.rentacar.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    private String name;

    private int loyaltyPoints;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Rental> rentals;



}
