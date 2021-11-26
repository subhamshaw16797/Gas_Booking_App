package com.gasbooking.service;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Customer;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.repository.IGasBookingRepository;

@SpringBootTest
public class GasBookingServiceImplTest {
	
	@Autowired
	IGasBookingService gasBookingService;
	@MockBean
	IGasBookingRepository gasBookingRepository;
	@Test
	void testInsertGasBooking() {
		GasBooking g1=new GasBooking();
		Customer c=new Customer();
		g1.setGasBookingId(33);
		g1.setCustomer(c);
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(true);
		g1.setBill(1200);
		Mockito.when(gasBookingRepository.save(g1)).thenReturn(g1);
		assertThat(gasBookingService.insertGasBooking(g1)).isEqualTo(g1);
	}
	@Test
	void testUpdateGasBooking() throws GasBookingNotFoundException {
		GasBooking g1=new GasBooking();
		Customer c=new Customer();
		g1.setGasBookingId(33);
		g1.setCustomer(c);
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(true);
		g1.setBill(1200);
		Optional<GasBooking> g2=Optional.of(g1);
		 Mockito.when(gasBookingRepository.findById(33)).thenReturn(g2);
		 Mockito.when(gasBookingRepository.save(g1)).thenReturn(g1);
		 g1.setCustomer(c);
		 g1.setLocalDate(LocalDate.now());
		 g1.setStatus(true);
		 g1.setBill(1150);
		 assertThat(gasBookingService.updateGasBooking(33,g1)).isEqualTo(g1);
		 
	}
	@Test
	void testDeleteGasBooking() throws GasBookingNotFoundException {
		GasBooking g1=new GasBooking();
		Customer c=new Customer();
		g1.setGasBookingId(33);
		g1.setCustomer(c);
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(true);
		g1.setBill(1200);
		Optional<GasBooking> g2=Optional.of(g1);
		 Mockito.when(gasBookingRepository.findById(33)).thenReturn(g2);
		 assertThat(gasBookingService.deleteGasBooking(33)).isEqualTo(g1);
	}
}