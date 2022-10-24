package com.test.renting.rentacar.dao;

import com.test.renting.rentacar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, Long> {
}
