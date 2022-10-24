package com.test.renting.rentacar.service;

import com.test.renting.rentacar.dao.CarDao;
import com.test.renting.rentacar.dao.RentalDao;
import com.test.renting.rentacar.dao.UserDao;
import com.test.renting.rentacar.dto.CarDto;
import com.test.renting.rentacar.enums.CarType;
import com.test.renting.rentacar.factory.CarFactory;
import com.test.renting.rentacar.model.Car;
import com.test.renting.rentacar.model.ICar;
import com.test.renting.rentacar.model.Rental;
import com.test.renting.rentacar.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RentCarService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RentalDao rentalDao;

    @Transactional
    public Double rentACar(List<Integer> carsToRent, int userId, int days) throws Exception {
        Integer carId= carsToRent.get(0);

        Optional<Car> carOpt = carDao.findById((long)carId);
        if (carOpt.isEmpty()){
            throw new Exception();
        }


        Optional<Users> userOpt =  userDao.findById((long)userId);
        if(userOpt.isEmpty()){
            throw new Exception();
        }
        Car car = carOpt.get();
        if(car.getRented()){
            throw new Exception();
        }

        car.setRented(true);

        ICar carToRent = CarFactory.createCar(car.getCarType(), car.getModel());

        Double cost = carToRent.calculatePrice(days);

        Rental rental = new Rental();
        rental.setCar(car);
        rental.setUser(userOpt.get());
        rental.setDaysRented(days);

        rentalDao.save(rental);

        Users user= userOpt.get();
        int points = user.getLoyaltyPoints() + addLoyaltyPoints( car.getCarType());
        user.setLoyaltyPoints(points);
        userDao.save(user);

        return cost;

    }
    @Transactional
    public Double returnCar(int carId, int totalDays) throws Exception {
        Optional<Car> carOpt = carDao.findById((long)carId);
        if (carOpt.isEmpty()){
            throw new Exception();
        }
        Car car = carOpt.get();
        if(!car.getRented()){
            throw new Exception();
        }
        car.setRented(false);
        Rental rental = car.getRental();
        Double extraCost=0d;
        if (totalDays>rental.getDaysRented()){
            ICar carToRent= CarFactory.createCar(car.getCarType(),car.getModel());
            extraCost = carToRent.calculateExtraDay(totalDays-rental.getDaysRented());
        }
        car.setRental(null);
        rental.setCar(null);
        carDao.save(car);
        rentalDao.save(rental);

        return extraCost;
    }

    private int addLoyaltyPoints(CarType carType){
        int points =0;
        if(CarType.PREMIUM.equals(carType)){
            points=5;
        }else if(CarType.SUV.equals(carType)){
            points = 3;
        }else{
            points = 1;
        }
        return points;

    }
}
