package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;

import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;

public interface ICustomerService {

	public Customer insertCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer updateCustomer(int customerId, Customer customer) throws NumberFormatException, InputMismatchException, CustomerNotFoundException;

	public Customer deleteCustomer(int customerId) throws NumberFormatException, InputMismatchException, CustomerNotFoundException;

	public List<Customer> viewCustomers() throws NumberFormatException, InputMismatchException, CustomerNotFoundException;

	public Customer viewCustomer(int customerId) throws NumberFormatException, InputMismatchException, CustomerNotFoundException;
	
	public Customer validateCustomer(Customer customer) throws CustomerNotFoundException;
	
	public Customer logout(String username) throws CustomerNotFoundException;
}
