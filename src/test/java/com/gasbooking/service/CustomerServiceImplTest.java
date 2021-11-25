package com.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Customer;
import com.gasbooking.repository.ICustomerRepository;

class CustomerServiceImplTest {

	@Autowired
	ICustomerService customerService;
	
	@MockBean
	ICustomerRepository customerRepository;
	
	@Test
	void testInsertCustomer() {
		Customer c1 = new Customer();
		c1.setUsername("subham");
		c1.setPassword("subham@16");
		c1.setAddress("Kumrashol-");
		c1.setEmail("subhamshaw@gmail.com");
		c1.setMobileNumber("9576979049");
		c1.setIfscNo("ABCD0122344");
		c1.setPan("IORPS5530A");
		
		Mockito.when(customerRepository.save(c1)).thenReturn(c1);
		
		assertThat(customerService.insertCustomer(c1)).isEqualTo(c1);
	}

}
