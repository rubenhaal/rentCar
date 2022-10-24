package com.test.renting.rentacar.factory;

import com.test.renting.rentacar.dto.CarDto;
import com.test.renting.rentacar.enums.CarType;
import com.test.renting.rentacar.model.ICar;
import com.test.renting.rentacar.model.PremiumCar;

public class CarFactory {

 public static ICar createCar(CarType carType, String model) throws Exception {
     if (CarType.PREMIUM.equals(carType)){
         return new PremiumCar(model);
     }else{
         throw new Exception("Car type doesn't exist");
     }
 }
}
