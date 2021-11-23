package com.gasbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.GasBooking;
@Repository
public interface IGasBookingRepository extends JpaRepository<GasBooking, Integer> {

	public Optional<GasBooking> findBycustomerId(int customerId);

}
