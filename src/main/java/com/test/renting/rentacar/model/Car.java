package com.test.renting.rentacar.model;

import com.test.renting.rentacar.enums.CarType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;



    private CarType carType;
    private String model;
    private Boolean rented;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
    private Rental rental;
}
