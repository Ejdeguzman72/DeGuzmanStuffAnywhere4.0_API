package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Vehicle;

@Repository
public interface VehicleJpaDao extends JpaRepository<Vehicle, Integer> {

	Page<Vehicle> findAll(Pageable pageable);

}
