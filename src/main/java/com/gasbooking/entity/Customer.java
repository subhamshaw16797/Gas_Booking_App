package com.gasbooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import javax.validation.constraints.Size;

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 195158816166559020L;

	// data members
	@Id
	@GeneratedValue
	private int customerId;

	@NotNull
	private int accountNo;

	@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.")
	private String ifscNo;

	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.")
	private String pan;

	@JsonBackReference
	@OneToOne(targetEntity = Cylinder.class, cascade = CascadeType.ALL)
	private Cylinder cylinder;

	@JsonBackReference
	@OneToOne(targetEntity = Bank.class, cascade = CascadeType.ALL)
	private Bank bank;

	@JsonBackReference
	@OneToOne(targetEntity = SurrenderCylinder.class, cascade = CascadeType.ALL)
	private SurrenderCylinder surrenderCylinder;

	@OneToMany(targetEntity = GasBooking.class, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<GasBooking> gasBooking;

	// constructors
	public Customer() {
		super();
	}

	public Customer(int customerId, @NotNull int accountNo,
			@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.") String ifscNo,
			@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.") String pan,
			Cylinder cylinder, Bank bank) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
//		this.cylinder = cylinder;
//		this.bank = bank;
	}

	// getters and setters
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

	// toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", accountNo=" + accountNo + ", ifscNo=" + ifscNo + ", pan=" + pan
				+ ", bank=" + bank + "]";
	}

}

// developed by - Subham Kumar Shaw
