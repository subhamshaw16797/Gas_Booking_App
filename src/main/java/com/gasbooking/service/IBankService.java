package com.gasbooking.service;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;

public interface IBankService {
	
	public Customer insertBank(int id, Bank bank) throws CustomerNotFoundException, BankNotFoundException;
	
	public Bank updateBank(int bankId, Bank bank) throws BankNotFoundException;
	
	public Bank deleteBank(int bankId) throws BankNotFoundException;

}
