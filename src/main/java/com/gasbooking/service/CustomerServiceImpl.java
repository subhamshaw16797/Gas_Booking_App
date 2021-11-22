package com.gasbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Customer;
import com.gasbooking.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Override
	public Customer insertCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Optional<Customer> optional= customerRepository.findById(customer.getCustomerId());
		
		if(optional.isPresent()) {
			Customer gotCustomer = optional.get();
			gotCustomer.setCylinderId(customer.getCylinderId());
			gotCustomer.setBankId(customer.getBankId());
			gotCustomer.setAccountNo(customer.getAccountNo());
			gotCustomer.setIfscNo(customer.getIfscNo());
			gotCustomer.setPan(customer.getPan());
			return gotCustomer;
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		
		if(optional.isPresent()) {
			Customer gotCustomer = optional.get();
			customerRepository.delete(gotCustomer);
			return gotCustomer;
		}
		return null;
	}

	@Override
	public List<Customer> viewCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		
		if(optional.isPresent()) {
			Customer gotCustomer = optional.get();
			return gotCustomer;
		}
		return null;
	}

}
