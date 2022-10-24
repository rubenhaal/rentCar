package com.test.renting.rentacar.dao;

import com.test.renting.rentacar.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDao extends JpaRepository<Rental, Long> {
}
