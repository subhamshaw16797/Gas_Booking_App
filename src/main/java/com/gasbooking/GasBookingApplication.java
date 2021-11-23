package com.gasbooking;

import java.util.InputMismatchException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.entity.Cylinder;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.service.ICustomerService;

@SpringBootApplication
public class GasBookingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GasBookingApplication.class, args);

		// Checking
		ICustomerService customerService = context.getBean(ICustomerService.class);
		
		Bank bank = new Bank();
		
		bank.setBankName("ICICI");
		bank.setAddress("BBSR");
		
		Cylinder cylinder = new Cylinder();
		
		cylinder.setPrice(1000.50f);
		cylinder.setStrapColor("Red");
		cylinder.setType("LPG");
		cylinder.setWeight(20.50f);
		
		Customer customer = new Customer();
		
		customer.setCustomerId(9);
		customer.setAccountNo(1234567890);
		customer.setIfscNo("ABCD0123456");
		customer.setPan("IORPS5530A");
		customer.setBank(bank);
		customer.setCylinder(cylinder);
		
		try {
			System.out.println(customerService.deleteCustomer(9));
		} catch (InputMismatchException e) {
			
			e.printStackTrace();
		} catch (CustomerNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
