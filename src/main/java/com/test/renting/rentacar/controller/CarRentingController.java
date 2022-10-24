package com.test.renting.rentacar.controller;

import com.test.renting.rentacar.dto.CarDto;
import com.test.renting.rentacar.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrenting")
public class CarRentingController {

    @Autowired
    private RentCarService rentCarService;

    @PostMapping("rentCar/{userId}/{days}")
    public Double rentACar(@RequestBody List<Integer> cars, @PathVariable int userId, @PathVariable int days) throws Exception {

        return rentCarService.rentACar(cars, userId, days);
    }

    @PostMapping("returnCar/{carId}/{days}")
    public Double returnCar(@PathVariable int carId, @PathVariable int days) throws Exception {
        return rentCarService.returnCar(carId, days);
    }


}
