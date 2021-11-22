package com.gasbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.gasbooking.entity.Customer;
//import com.gasbooking.service.ICustomerService;

@SpringBootApplication
public class GasBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasBookingApplication.class, args);

		// Checking
//		ICustomerService customerService = context.getBean(ICustomerService.class);
//		Customer customer = new Customer();
//		
//		customer.setAccountNo(12345);
//		customer.setIfscNo("ABCD1234");
//		customer.setPan("IORPS5530A");
//		
//		Customer addedCustomer = customerService.insertCustomer(customer);
//		System.out.println(addedCustomer);

	}

}
