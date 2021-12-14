package com.gasbooking.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="admin_id")
public class Admin extends AbstractUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -535712062774093171L;
	
	/*
	 * @OneToMany(targetEntity = Customer.class,cascade=CascadeType.ALL,mappedBy =
	 * "admin")
	 * 
	 * @JsonManagedReference(value = "5") List<Customer> customer=new ArrayList<>();
	 */
	
	/*
	 * @OneToMany private GasBooking gasBooking;
	 */

	
	public Admin() {
		super();
	}

	public Admin(String username, String password, String address, String mobileNumber, String email, String role, boolean isLoggedIn) {
		super(username, password, address, mobileNumber, email, role, isLoggedIn);
	}

	/*
	 * public List<Customer> getCustomer() { return customer; }
	 * 
	 * public void setCustomer(List<Customer> customer) { this.customer = customer;
	 * }
	 */
}

