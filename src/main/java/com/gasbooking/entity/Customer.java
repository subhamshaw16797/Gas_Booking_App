package com.gasbooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 195158816166559020L;

	// data members
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int customerId;

	@NotNull
	@Column(name = "account_no")
	private int accountNo;

	@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.")
	@Column(name = "ifsc_no")
	private String ifscNo;

	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.")
	@Column(name = "pan")
	private String pan;

	@JsonBackReference
	@OneToOne(targetEntity = Cylinder.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cylinder_id")
	private Cylinder cylinder;

	@JsonBackReference
	@OneToOne(targetEntity = Bank.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@JsonManagedReference
	@OneToOne(targetEntity = SurrenderCylinder.class, mappedBy = "customer", cascade = CascadeType.ALL)
	private SurrenderCylinder surrenderCylinder;

	@JsonManagedReference
	@OneToMany(targetEntity = GasBooking.class, cascade = CascadeType.ALL, mappedBy = "customerId")
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
		this.cylinder = cylinder;
		this.bank = bank;
	}

	// getters and setters
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public SurrenderCylinder getSurrenderCylinder() {
		return surrenderCylinder;
	}

	public void setSurrenderCylinder(SurrenderCylinder surrenderCylinder) {
		this.surrenderCylinder = surrenderCylinder;
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
		return "Customer [customerId=" + customerId + ", accountNo=" + accountNo + ", ifscNo=" + ifscNo + ", pan=" + pan
				+ ", cylinder=" + cylinder + ", bank=" + bank + ", surrenderCylinder=" + surrenderCylinder
				+ ", gasBooking=" + gasBooking + "]";
	}
	
}

// developed by - Subham Kumar Shaw
