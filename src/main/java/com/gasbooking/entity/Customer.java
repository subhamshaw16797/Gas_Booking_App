package com.gasbooking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer extends AbstractUser{
	
	// data members
	@Id
	@GeneratedValue
	private int customerId;
	
	@NotBlank(message = "Account number can't be empty.")
	@Size(min = 10, max = 16)
	private int accountNo;
	
//	@NotBlank(message = "IFSC No can't be empty.")
	@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.")
	private String ifscNo;
	
//	@NotBlank(message = "PAN no. can't be empty")
	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.")
	private String pan;
	
	@OneToOne(targetEntity = Cylinder.class, cascade = CascadeType.ALL)
	private Cylinder cylinder;
	
	@OneToOne(targetEntity = Bank.class, cascade = CascadeType.ALL)
	private Bank bank;
	
	// constructors
	public Customer() {
		super();
	}
	
	public Customer(int customerId,
			@NotBlank(message = "Account number can't be empty.") @Size(min = 10, max = 16) int accountNo,
			@NotBlank(message = "IFSC No can't be empty.") @Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}") String ifscNo,
			@NotBlank(message = "PAN no. can't be empty") @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Given PAN No. is not valid.") String pan,
			Cylinder cylinder, Bank bank) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
		this.cylinder = cylinder;
		this.bank = bank;
	}

	//getters and setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		return "Customer [customerId=" + customerId + ", cylinder=" + cylinder + ", bank=" + bank + ", accountNo="
				+ accountNo + ", ifscNo=" + ifscNo + ", pan=" + pan + "]";
	}
	
}
