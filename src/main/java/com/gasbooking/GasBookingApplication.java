package com.gasbooking;

import java.util.InputMismatchException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.entity.Cylinder;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.service.IBankService;
import com.gasbooking.service.ICustomerService;

@SpringBootApplication
public class GasBookingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GasBookingApplication.class, args);

//		// Checking
//		ICustomerService customerService = context.getBean(ICustomerService.class);
//		
////		IBankService bankService = context.getBean(IBankService.class);
//		
//		Bank bank = new Bank();
//		bank.setBankName("ICICI");
//		
//		Customer customer = new Customer();
//		customer.setAccountNo(12345678);
//		customer.setIfscNo("ABCD0123456");
//		customer.setPan("IORPS5530A");
//		customer.setBank(bank);
//		
//		System.out.println(customerService.insertCustomer(customer));
//		
		
	}

}
