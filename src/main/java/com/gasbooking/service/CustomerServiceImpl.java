package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	// inserting a single object
	@Transactional
	@Override
	public Customer insertCustomer(Customer customer) {
		Customer insertedCustomer = customerRepository.save(customer);
		return insertedCustomer;
	}

	// updating a single object
	@Override
	public Customer updateCustomer(Customer customer) throws InputMismatchException, CustomerNotFoundException {
		Integer getId = Integer.valueOf(customer.getCustomerId());

		if (getId instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				gotCustomer.setAccountNo(customer.getAccountNo());
				gotCustomer.setIfscNo(customer.getIfscNo());
				gotCustomer.setPan(customer.getPan());
				gotCustomer.setBank(customer.getBank());
				gotCustomer.setCylinder(customer.getCylinder());
				Customer updateCustomer = customerRepository.save(gotCustomer);
				return updateCustomer;
			}

			else {
				throw new CustomerNotFoundException("Given customer id is not present in the database.");
			}
		} else {
			throw new InputMismatchException("The ID should be a number type");
		}

	}

	// deleting a single object by id
	@Override
	public Customer deleteCustomer(int customerId) throws InputMismatchException, CustomerNotFoundException {

		Integer id = Integer.valueOf(customerId);

		if (id instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(customerId);

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				customerRepository.delete(gotCustomer);
				return gotCustomer;
			}

			else {
				throw new CustomerNotFoundException("Given customer id is not present in the database");
			}
		} else {
			throw new InputMismatchException("Given Id should be a number");
		}
	}

	// getting list of object
	@Override
	public List<Customer> viewCustomers() throws InputMismatchException, CustomerNotFoundException {

		List<Customer> getAllCustomer = customerRepository.findAll();
		if (getAllCustomer.isEmpty()) {
			throw new CustomerNotFoundException("There are no such customer present in the database.");
		}
		return getAllCustomer;
	}

	// getting a single object
	@Override
	public Customer viewCustomer(int customerId) throws InputMismatchException, CustomerNotFoundException {
		Integer getId = Integer.valueOf(customerId);

		if (getId instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(customerId);

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				return gotCustomer;
			} else {
				throw new CustomerNotFoundException("There are no such customer is present in the database.");
			}
		} else {
			throw new InputMismatchException("ID should be a number type.");
		}
	}

}
