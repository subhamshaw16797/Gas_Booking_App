package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;

import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;

public interface ICustomerService {

	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException, InputMismatchException;

	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException, InputMismatchException;

	public List<Customer> viewCustomers() throws CustomerNotFoundException, InputMismatchException;

	public Customer viewCustomer(int customerId) throws CustomerNotFoundException, InputMismatchException;
}
