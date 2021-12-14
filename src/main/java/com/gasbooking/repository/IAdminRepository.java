package com.gasbooking.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Admin;
import com.gasbooking.entity.Customer;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Integer>{

	//Admin findById(int adminId);

	//Admin deleteById(int adminId);
	
	public Optional<Admin> findByUsername(String username);
	
	@Query("select c from Admin c where c.username=:user and c.password=:pass")
	public Admin findByUsernameAndPassword(@Param("user") String username, @Param("pass") String Password);
	
}
