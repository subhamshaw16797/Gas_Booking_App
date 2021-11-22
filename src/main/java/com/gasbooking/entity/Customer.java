package com.gasbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer extends AbstractUser{
	
	// data members
	@Id
	@GeneratedValue
	private int customerId;
	
	private int cylinderId;
	
	private int bankId;
	
	@NotBlank(message = "Account number can't be empty.")
	@Size(min = 10, max = 16)
	private int accountNo;
	
	@NotBlank(message = "IFSC No can't be empty.")
	@Size(min =6, max = 8)
	private String ifscNo;
	
	@NotBlank(message = "PAN no. can't be empty")
	@Size(min = 8, max = 10)
	private String pan;
	
	// constructors
	public Customer() {
		super();
	}
	
	public Customer(int customerId, int cylinderId, int bankId, int accountNo, String ifscNo, String pan) {
		super();
		this.customerId = customerId;
		this.cylinderId = cylinderId;
		this.bankId = bankId;
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
	}

	//getters and setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCylinderId() {
		return cylinderId;
	}

	public void setCylinderId(int cylinderId) {
		this.cylinderId = cylinderId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", cylinderId=" + cylinderId + ", bankId=" + bankId
				+ ", accountNo=" + accountNo + ", ifscNo=" + ifscNo + ", pan=" + pan + "]";
	}
	
}
