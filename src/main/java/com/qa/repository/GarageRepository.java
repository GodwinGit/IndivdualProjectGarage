package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.model.Garage;

public interface GarageRepository extends JpaRepository<Garage, Long> {

}
