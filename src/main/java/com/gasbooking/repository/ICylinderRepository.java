package com.gasbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gasbooking.entity.Cylinder;

public interface ICylinderRepository extends JpaRepository<Cylinder, Integer> {

//	@Query("select c from Cylinder c where c.type=:type")
	public Optional<List<Cylinder>> findByType(String type);

}
