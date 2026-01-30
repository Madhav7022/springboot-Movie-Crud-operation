package com.A6.bikecurd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.A6.bikecurd.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
