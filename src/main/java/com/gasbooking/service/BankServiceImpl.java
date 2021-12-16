package com.gasbooking.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Bank;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.repository.IBankRepository;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	IBankRepository bankRepository;

	Logger logger=LoggerFactory.getLogger(BankServiceImpl.class);
	
	@Override
	public Bank insertBank(Bank bank) {

		logger.info("****************Inserting Bank Details****************");

		return bankRepository.save(bank);
	}

	@Override
	public Bank updateBank(int bankId, Bank bank) throws BankNotFoundException {
		
		logger.info("****************Updating Bank Details****************");

		Optional<Bank> optional = bankRepository.findById(bankId);
		
		if (optional.isPresent()) {
			Bank b1 = optional.get();
			b1.setBankName(bank.getBankName());
			b1.setAddress(bank.getAddress());
			b1.setAccountNo(bank.getAccountNo());
			b1.setIfscNo(bank.getIfscNo());
			b1.setPan(bank.getPan());
			Bank updatedBank = bankRepository.save(b1);
			return updatedBank;
		} else {
			throw new BankNotFoundException("Bank not found");
		}
	}

	@Override
	public Bank deleteBank(int bankId) throws BankNotFoundException {
		
		logger.info("****************Deleting Bank Details****************");

		Optional<Bank> optional = bankRepository.findById(bankId);
		
		if (optional.isPresent()) {
			Bank deletedBank = optional.get();
			bankRepository.deleteById(bankId);
			return deletedBank;
		} else {
			throw new BankNotFoundException("Bank not found");
		}
	}

}
