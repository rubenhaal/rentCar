package com.test.renting.rentacar.controller;

import com.test.renting.rentacar.dto.CarDto;
import com.test.renting.rentacar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("CarService")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("cars")
    public List<CarDto> listOfCarsAvailable(){
        return carService.getAllCars();
    }
}
