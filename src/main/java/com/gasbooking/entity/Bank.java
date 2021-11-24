package com.gasbooking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "bank")
public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1794093769285039468L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bank_id")
	private int bankId;

	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]+$", message = "Given Bank name is not valid/Exist.")
	@Column(name = "bank_name")
	private String bankName;
	
	@JsonBackReference(value = "2")
	@OneToOne(targetEntity = Customer.class, mappedBy = "bank")
	private Customer customer;
	
	// constructors
	
	public Bank() {
		super();
	}
	
	// getters and setters
	
	public Bank(int bankId,
			@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]+$", message = "Given Bank name is not valid/Exist.") String bankName,
			Customer customer) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.customer = customer;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// toString
	
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", customer=" + customer + "]";
	}
}

// developer - Tracy Lewis