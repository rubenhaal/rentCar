package com.test.renting.rentacar.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rental {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Users user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    private int daysRented;
}
