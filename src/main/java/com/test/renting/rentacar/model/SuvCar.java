package com.test.renting.rentacar.model;

import com.test.renting.rentacar.enums.CarType;
import com.test.renting.rentacar.factory.AbstractCar;

public class SuvCar  extends AbstractCar {

    public SuvCar(String model){
        this.carType= CarType.SUV;
        this.model= model;
        this.price= 150d;
    }

    @Override
    public Double calculatePrice(int days) {
        if(days<=7){
            return this.price*days;
        }else if(days <=30){
            return this.price*7 + this.price*0.8*(days -7);
        }else {
            return this.price*7 + this.price*0.8*23 + this.price*0.6*(days-30);
        }
    }

    @Override
    public Double calculateExtraDay(int extraDays) {
        return (this.price + 50*0.6)*extraDays;
    }
}
