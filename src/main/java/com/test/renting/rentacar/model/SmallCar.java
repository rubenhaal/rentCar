package com.test.renting.rentacar.model;

import com.test.renting.rentacar.enums.CarType;
import com.test.renting.rentacar.factory.AbstractCar;

public class SmallCar extends AbstractCar {

    public SmallCar(String model){
        this.carType= CarType.SMALL;
        this.model=model;
        this.price=50d;
    }

    @Override
    public Double calculatePrice(int days) {

        if(days<=7){
            return this.price*days;
        }else {
            return this.price*7 + this.price*0.6*(days -7);
        }
    }

    @Override
    public Double calculateExtraDay(int extraDays) {
        return (this.price + this.price*0.30) * extraDays;
    }
}