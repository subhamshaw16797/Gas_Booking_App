package com.gasbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Bank;

@Repository
public interface IBankRepository extends JpaRepository<Bank, Integer>{
	
	
	public Optional<Bank> findByAccountNo(int accountNo);
	
	public Optional<Bank> findByPan(String pan);
}
