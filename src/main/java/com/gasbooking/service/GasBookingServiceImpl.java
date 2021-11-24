package com.gasbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.repository.IGasBookingRepository;

@Service
public class GasBookingServiceImpl implements IGasBookingService{
	
	@Autowired
	IGasBookingRepository gasBookingRepo;
	
	@Override
	public GasBooking insertGasBooking(GasBooking gasBooking) {
		return gasBookingRepo.save(gasBooking);
	}

	@Override
	public GasBooking updateGasBooking(GasBooking gasBooking) throws GasBookingNotFoundException {
		int gasBookingId=gasBooking.getGasBookingId();
		
		Optional<GasBooking> optional = gasBookingRepo.findById(gasBookingId);
		if(optional.isPresent()) {
			GasBooking g1=optional.get();
			g1.setLocalDate(gasBooking.getLocalDate());
			g1.setStatus(gasBooking.getStatus());
			g1.setBill(gasBooking.getBill());
			GasBooking updatedGasBooking=gasBookingRepo.save(g1);
			return updatedGasBooking;
		}
		else {
			throw new GasBookingNotFoundException("Gas Booking details not found");
		}
	}

	@Override
	public GasBooking deleteGasBooking(int gasBookingId) throws GasBookingNotFoundException {
		Optional<GasBooking> optional=gasBookingRepo.findById(gasBookingId);
		if(optional.isPresent()) {
			GasBooking deletedgasBooking=optional.get();
			gasBookingRepo.deleteById(gasBookingId);
			return deletedgasBooking;
		}
		else {
			throw new GasBookingNotFoundException("Gas Booking details not found");
		}
			
	}

	@Override
	public GasBooking getBill(int customerId) throws GasBookingNotFoundException {
		Optional<GasBooking> optional=gasBookingRepo.findBycustomerId(customerId);
		if(optional.isPresent()) {
			GasBooking details=optional.get();
			return details;
		}
		else {
			throw new GasBookingNotFoundException("Gas Booking detalis not found");
		}
	}

}
