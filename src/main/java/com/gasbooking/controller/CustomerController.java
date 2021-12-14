package com.gasbooking.controller;

import java.util.InputMismatchException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@CrossOrigin
public class CustomerController {

	@Autowired
	ICustomerService customerSer;

	@PostMapping("/addCustomer")
	public ResponseEntity<?> insertCustomer(@Valid @RequestBody Customer customer) throws CustomerNotFoundException {
		Customer addedCustomer = customerSer.insertCustomer(customer);
		return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<?> updateCustomer(@PathVariable int customerId, @Valid @RequestBody Customer customer) throws InputMismatchException, CustomerNotFoundException {
		Customer updatedCustomer = customerSer.updateCustomer(customerId, customer);
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws InputMismatchException, CustomerNotFoundException {
		Customer deletedCustomer = customerSer.deleteCustomer(customerId);
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> viewCustomers() throws InputMismatchException, CustomerNotFoundException {
		List<Customer> getAllCustomers = customerSer.viewCustomers();
		return new ResponseEntity<List<Customer>>(getAllCustomers, HttpStatus.OK);
	}
	
	@GetMapping("/getSingleCustomer/{customerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable int customerId) throws InputMismatchException, CustomerNotFoundException {
		Customer getSingleCustomer = customerSer.viewCustomer(customerId);
		return new ResponseEntity<Customer>(getSingleCustomer, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer validCustomer = customerSer.validateCustomer(customer);
		return new ResponseEntity<Customer>(validCustomer,HttpStatus.OK);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<?> logout(@RequestBody String username) throws CustomerNotFoundException{
		Customer loggedInCustomer = customerSer.logout(username);
		return new ResponseEntity<Customer>(loggedInCustomer, HttpStatus.OK);
	}
}
