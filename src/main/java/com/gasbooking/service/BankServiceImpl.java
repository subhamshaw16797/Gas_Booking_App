package com.gasbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Bank;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.repository.IBankRepository;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	IBankRepository bankRepository;

	@Override
	public Bank insertBank(Bank bank) {

		return bankRepository.save(bank);
	}

	@Override
	public Bank updateBank(Bank bank) throws BankNotFoundException {
		
		int bankId = bank.getBankId();
		
		Optional<Bank> optional = bankRepository.findById(bankId);
		
		if (optional.isPresent()) {
			Bank b1 = optional.get();
			b1.setBankName(bank.getBankName());
			Bank updatedBank = bankRepository.save(b1);
			return updatedBank;
		} else {
			throw new BankNotFoundException("Bank not found");
		}
	}

	@Override
	public Bank deleteBank(int bankId) throws BankNotFoundException {
		
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
