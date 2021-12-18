package com.gasbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Optional<Customer> findByUsername(String username);
	
//	@Query("select b from Bank b inner join Customer c on c.bankId = b.bankId where c.id=:id")
	public Optional<Customer> findBankById( int id);

}
 