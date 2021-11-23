package com.gasbooking.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class GasBooking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -48597437543156221L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gasBookingId;
	
	private LocalDate localDate=LocalDate.now();
	
	private boolean status;
	
	private float bill;
	
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	//constructors
	public GasBooking() {
		super();
	}
	
	public GasBooking(int gasBookingId, LocalDate localDate, boolean status, float bill, Customer customer) {
		super();
		this.gasBookingId = gasBookingId;
		this.localDate = localDate;
		this.status = status;
		this.bill = bill;
		this.customer = customer;
	}


	//setters and getters
	public int getGasBookingId() {
		return gasBookingId;
	}
	
	public void setGasBookingId(int gasBookingId) {
		this.gasBookingId = gasBookingId;
	}
	
	public LocalDate getLocalDate() {
		return localDate;
	}
	
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public float getBill() {
		return bill;
	}
	
	public void setBill(float bill) {
		this.bill = bill;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "GasBooking [gasBookingId=" + gasBookingId + ", localDate=" + localDate + ", status=" + status
				+ ", bill=" + bill + ", customer=" + customer + "]";
	}
	
}

// developer - Gangireddy Geetha
