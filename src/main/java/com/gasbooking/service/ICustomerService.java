package com.gasbooking.service;

import java.util.List;

import com.gasbooking.entity.Customer;

public interface ICustomerService {
	
	public Customer insertCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(int customerId);
	
	public List<Customer> viewCustomers();
	
	public Customer viewCustomer(int customerId);
}
