package com.gasbooking.controller;

import java.util.InputMismatchException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<?> insertCustomer(@Valid @RequestBody Customer customer) {
		Customer addedCustomer = customerService.insertCustomer(customer);
		return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws InputMismatchException, CustomerNotFoundException {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws InputMismatchException, CustomerNotFoundException {
		Customer deletedCustomer = customerService.deleteCustomer(customerId);
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> viewCustomers() throws InputMismatchException, CustomerNotFoundException {
		List<Customer> getAllCustomers = customerService.viewCustomers();
		return new ResponseEntity<List<Customer>>(getAllCustomers, HttpStatus.OK);
	}
	
	@GetMapping("/getSingleCustomer/{customerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable int customerId) throws InputMismatchException, CustomerNotFoundException {
		Customer getSingleCustomer = customerService.viewCustomer(customerId);
		return new ResponseEntity<Customer>(getSingleCustomer, HttpStatus.OK);
	}
}
