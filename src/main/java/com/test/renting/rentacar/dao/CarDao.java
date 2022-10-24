package com.test.renting.rentacar.dao;

import com.test.renting.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car, Long> {
}
