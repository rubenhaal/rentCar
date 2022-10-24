package com.test.renting.rentacar.factory;

import com.test.renting.rentacar.enums.CarType;
import com.test.renting.rentacar.model.ICar;
import lombok.Data;

@Data
public abstract class AbstractCar implements ICar {
    private Long id;

    protected CarType carType;
    protected String model;
    protected Double price;
}
