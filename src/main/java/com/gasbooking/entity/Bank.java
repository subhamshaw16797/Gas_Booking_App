package com.gasbooking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
	
	@NotNull
	@Column(name = "account_no")
	private int accountNo;

	@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.")
	@Column(name = "ifsc_no")
	private String ifscNo;

	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.")
	@Column(name = "pan")
	private String pan;
	
	private String address;
	
	@JsonBackReference(value = "2")
//	@OneToOne(targetEntity = Customer.class, mappedBy = "bank")
	private Customer customer;
	
	// constructors
	
	public Bank() {
		super();
	}
	
	public Bank(int bankId,
			@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]+$", message = "Given Bank name is not valid/Exist.") String bankName,
			@NotNull int accountNo,
			@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.") String ifscNo,
			@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.") String pan,
			String address) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
		this.address = address;
	}

	// getters and setters
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	// toString
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", accountNo=" + accountNo + ", ifscNo=" + ifscNo
				+ ", pan=" + pan + ", address=" + address + "]";
	}
	
}

// developer - Tracy Lewis