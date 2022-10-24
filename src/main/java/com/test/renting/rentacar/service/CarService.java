package com.test.renting.rentacar.service;

import com.test.renting.rentacar.dao.CarDao;
import com.test.renting.rentacar.dto.CarDto;
import com.test.renting.rentacar.model.Car;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private CarDao carDao;

    private ModelMapper modelMapper;

    public List<CarDto> getAllCars(){
        List<Car> cars = carDao.findAll();
        return cars.stream().map( car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

}
