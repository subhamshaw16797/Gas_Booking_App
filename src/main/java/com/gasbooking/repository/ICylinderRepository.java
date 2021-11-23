package com.gasbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gasbooking.entity.Cylinder;

public interface ICylinderRepository extends JpaRepository<Cylinder, Integer> {
	
    public Optional<Cylinder> findByType(String type);
    
}
