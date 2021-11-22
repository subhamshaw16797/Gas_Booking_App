package com.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
}
