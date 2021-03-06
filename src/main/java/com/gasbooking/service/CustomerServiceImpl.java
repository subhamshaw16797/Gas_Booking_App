package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.entity.Cylinder;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.exception.CylinderNotFoundException;
import com.gasbooking.repository.IBankRepository;
import com.gasbooking.repository.ICustomerRepository;
import com.gasbooking.repository.ICylinderRepository;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	ICylinderRepository cylinderRepository;

	@Autowired
	ICylinderService cylinderService;
	
	@Autowired
	IBankRepository bankRepository;
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	// inserting a single object
	@Override
	public Customer insertCustomer(Customer customer) throws CustomerNotFoundException {

		logger.info("****************Inserting customer Details****************");

		String gotRole = customer.getRole();

		if (gotRole.equalsIgnoreCase("Customer")) {
			// checking existing username in database
			String userName = customer.getUsername();
			Optional<Customer> userNameOptional = customerRepository.findByUsername(userName);

			if (userNameOptional.isPresent()) {
				throw new CustomerNotFoundException(
						"Given username is already exist in database. Please give different username.");
			}
		}

		Customer insertedCustomer = customerRepository.save(customer);
		return insertedCustomer;
	}

	// updating a single object
	@Override
	public Customer updateCustomer(int customerId, Customer customer)
			throws NumberFormatException, InputMismatchException, CustomerNotFoundException {

		logger.info("****************updating Customer Details****************");

		Integer getId = Integer.valueOf(customerId);

		if (getId instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(getId);

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				gotCustomer.setUsername(customer.getUsername());
//				gotCustomer.setPassword(customer.getPassword());
				gotCustomer.setAddress(customer.getAddress());
				gotCustomer.setEmail(customer.getEmail());
				gotCustomer.setMobileNumber(customer.getMobileNumber());
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
	public Customer deleteCustomer(int customerId)
			throws NumberFormatException, InputMismatchException, CustomerNotFoundException {

		logger.info("****************Deleting Customer Details****************");

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
	public List<Customer> viewCustomers()
			throws NumberFormatException, InputMismatchException, CustomerNotFoundException {

		logger.info("****************Getting All Customers Details****************");

		List<Customer> getAllCustomer = customerRepository.findAll();
		if (getAllCustomer.isEmpty()) {
			throw new CustomerNotFoundException("There are no such customer present in the database.");
		}
		return getAllCustomer;
	}

	// getting a single object
	@Override
	public Customer viewCustomer(int customerId)
			throws NumberFormatException, InputMismatchException, CustomerNotFoundException {

		logger.info("****************Getting Single customer Details****************");

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
			throw new NumberFormatException("ID should be a number type.");
		}
	}

	@Override
	public Customer validateCustomer(Customer customer)
			throws CustomerNotFoundException {

		logger.info("****************Validating the customer username and password****************");

		Optional<Customer> optional = customerRepository.findByUsername(customer.getUsername());
		System.out.println(optional);
		if (optional.isPresent()) {
			Customer validCustomer = optional.get();
			if (customer.getUsername().equalsIgnoreCase(validCustomer.getUsername())
					&& (customer.getPassword().equalsIgnoreCase(validCustomer.getPassword()))
					&& (customer.getRole().equalsIgnoreCase(validCustomer.getRole()))) {
				validCustomer.setLoggedIn(true);
				
				// update isLoggedIn flag to true
				customerRepository.save(validCustomer);
				return validCustomer;
			}
			else {
				throw new CustomerNotFoundException("Given username or password is wrong.");
			}
		}
		 else {
			throw new CustomerNotFoundException("Given username or password not exist");
		}
	}

	@Override
	public Customer logout(String username) throws CustomerNotFoundException {
		
		Optional<Customer> optional = customerRepository.findByUsername(username);
		if(!(optional.isPresent())) {
			throw new CustomerNotFoundException("Invalid username");
		}
		
		Customer getCustomer = optional.get();
		getCustomer.setLoggedIn(false);
		customerRepository.save(getCustomer);
		return getCustomer;
	}
	
	//mapping between customer and bank
	@Override
	public Customer updateCustomerWithBank(int id, int bankId) throws CustomerNotFoundException, BankNotFoundException {
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		if(optional.isPresent()) {
			Optional<Bank> optionalBank = bankRepository.findById(bankId);
			
			if(optionalBank.isPresent()) {
				Bank getBank = optionalBank.get();
				Customer getCustomer = optional.get();
				getCustomer.setBank(getBank);
				customerRepository.save(getCustomer);
				return getCustomer;
			}
			else {
				throw new BankNotFoundException("Bank is not present.");
			}
		}
		else {
			throw new CustomerNotFoundException("Customer is not present in the database.");
		}
		
	}

	//mapping between customer and cylinder
	
	@Override
	public Customer updateCustomerWithCylinder(int id, int cylinderId) throws CustomerNotFoundException, CylinderNotFoundException {
		
		cylinderService.bookCylinder(cylinderId);
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		if(optional.isPresent()) {
			Optional<Cylinder> optionalCylinder = cylinderRepository.findById(cylinderId);
			
			if(optionalCylinder.isPresent()) {
				Cylinder getCylinder = optionalCylinder.get();
				Customer getCustomer = optional.get();
				getCustomer.setCylinder(getCylinder);
				customerRepository.save(getCustomer);
				return getCustomer;
			}
			else {
				throw new CylinderNotFoundException("Cylinder is not present.");
			}
		}
		else {
			throw new CustomerNotFoundException("Customer is not present in the database.");
		}
		
	}

}
