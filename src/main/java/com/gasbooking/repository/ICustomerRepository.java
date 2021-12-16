package com.gasbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
//	@Query("select c from Customer c where c.username=:user and c.password=:pass")
//	public Optional<Customer> findByUsernameAndPassword(@Param("user") String username, @Param("pass") String Password);
	
//	@Query(value="select * from user_details where username=:name", nativeQuery=true )
	
	
	public Optional<Customer> findByUsername(String username);

}
 