package com.test.renting.rentacar.dto;

import com.test.renting.rentacar.enums.CarType;
import lombok.Data;

@Data
public class CarDto {

    private Long id;

    protected CarType carType;
    protected String model;
}
