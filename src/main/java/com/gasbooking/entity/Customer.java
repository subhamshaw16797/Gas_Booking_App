package com.gasbooking.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends AbstractUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 195158816166559020L;

	// data members

//	@JsonIgnore
	@JsonManagedReference(value = "2")
	@OneToOne(targetEntity = Bank.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
//	@JsonIgnore
	@JsonManagedReference(value = "1")
	@OneToOne(targetEntity = Cylinder.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cylinder_id")
	private Cylinder cylinder;
	
	@JsonManagedReference("4")
	@OneToMany(targetEntity = GasBooking.class, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<GasBooking> gasBooking = new ArrayList<>();

	// constructors
	public Customer() {
		super();
	}

	// getters and setters
	
	public Customer(Cylinder cylinder, Bank bank) {
		super();
		this.cylinder = cylinder;
		this.bank = bank;
	}

	public Cylinder getCylinder() {
		return cylinder;
	}

	public void setCylinder(Cylinder cylinder) {
		this.cylinder = cylinder;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<GasBooking> getGasBooking() {
		return gasBooking;
	}

	public void setGasBooking(List<GasBooking> gasBooking) {
		this.gasBooking = gasBooking;
	}

	// toString
	@Override
	public String toString() {
		return "Customer [bank=" + bank + ", cylinder=" + cylinder + "]";
	}
	
}

// developed by - Subham Kumar Shaw
