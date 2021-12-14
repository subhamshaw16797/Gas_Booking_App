package com.gasbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Admin;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.AdminNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.repository.IAdminRepository;
import com.gasbooking.repository.IGasBookingRepository;

@SpringBootTest
public class AdminServiceImplTest {

	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	IGasBookingService gasBookingService;
	
	@MockBean
	IGasBookingRepository gasBookingDao;
	
	@MockBean
	IAdminRepository adminRepository;
	
	@Test
	public void insertAdminTest(){
		Admin admin=new Admin();
		admin.setAddress("14-176,Andhra Pradesh");
		admin.setEmail("Mola@gmail.com");
		admin.setMobileNumber("9898987653");
		admin.setPassword("Mola123456");
		admin.setUsername("MolaMola123");
		admin.setRole("Admin");
		when(adminRepository.save(admin)).thenReturn(admin);
		try {
			assertEquals(admin,adminService.insertAdmin(admin) );
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void updateAdminTest() throws AdminNotFoundException, Exception{
		int id=4;
		Admin admin=new Admin();
		admin.setAddress("14-176,Andhra Pradesh");
		admin.setEmail("Mola@gmail.com");
		admin.setMobileNumber("9898987653");
		admin.setPassword("Mola123456");
		admin.setUsername("MolaMola123");	
		Optional<Admin> adminDao=Optional.of(admin);
		
		when(adminRepository.findById(id)).thenReturn(adminDao);
		admin.setAddress("14-176,Andhra Pradesh");
		admin.setEmail("Ashraf@gmail.com");
		admin.setMobileNumber("9564387653");
		admin.setPassword("Ashraf123456");
		admin.setUsername("AshrafAshraf123");	
		when(adminRepository.save(admin)).thenReturn(admin);
	    assertEquals(admin, adminService.updateAdmin(id, admin));
		
	}
	
	@Test
	public void deleteAdminTest() throws AdminNotFoundException, Exception {
		int id=4;
		Admin deletedAdmin=new Admin();
		deletedAdmin.setAddress("14-186,Bengaluru");
		deletedAdmin.setEmail("Babjan@gmail.com");
		deletedAdmin.setMobileNumber("1234567653");
		deletedAdmin.setPassword("Mola123456");
		deletedAdmin.setUsername("MolaMola123");
		Optional<Admin> optionalAdmin=Optional.of(deletedAdmin);
		when(adminRepository.findById(id)).thenReturn(optionalAdmin);
		assertEquals(deletedAdmin, adminService.deleteAdmin(id));
		
		
	}
	
	@Test
	public void  getAllBookings() {
		int customerId=2;
		List<GasBooking> list=new ArrayList<>();
		GasBooking g=new GasBooking();
		g.setBill(14.45);
        g.setGasBookingId(1);
        g.setLocalDate(LocalDate.now());
        g.setStatus(false);
      
		GasBooking g1=new GasBooking();
		g1.setBill(34.56);
        g1.setGasBookingId(2);
        g1.setLocalDate(LocalDate.now());
        g1.setStatus(false);
       when(gasBookingDao.findAllByCustomerId(customerId)).thenReturn((list));
		try {
			assertEquals(list.size(), adminService.getAllBookings(customerId).size());
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAllBookingsForDays() throws GasBookingNotFoundException {
		int customerId=3;
		LocalDate fromDate=LocalDate.now();
		LocalDate toDate=LocalDate.now();
		
		List<GasBooking> list=new ArrayList<>();
		GasBooking g=new GasBooking();
		g.setBill(123.76);
        g.setGasBookingId(5);
        g.setLocalDate(LocalDate.now());
        g.setStatus(true);
      
		GasBooking g1=new GasBooking();
		g1.setBill(34.56);
        g1.setGasBookingId(2);
        g1.setLocalDate(LocalDate.now());
        g1.setStatus(true);
		
		
		when(gasBookingDao.getAllBookingsForDays(customerId, fromDate, toDate)).thenReturn(list);
		assertEquals(list.size(), adminService.getAllBookingsForDays(customerId, fromDate, toDate).size());
	}
	
	
	
}