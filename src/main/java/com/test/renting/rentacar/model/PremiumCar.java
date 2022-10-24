package com.test.renting.rentacar.model;

import com.test.renting.rentacar.dto.CarDto;
import com.test.renting.rentacar.enums.CarType;
import com.test.renting.rentacar.factory.AbstractCar;
import lombok.Data;

@Data
public class PremiumCar  extends AbstractCar implements ICar{

    public PremiumCar (String model){
        this.carType= CarType.PREMIUM;
        this.model= model;
        this.price=300d;
        }

    @Override
    public Double calculatePrice(int days) {
        return price*days;
    }

    @Override
    public Double calculateExtraDay(int extraDays) {
        return (price + price *0.2) * extraDays;
    }
}