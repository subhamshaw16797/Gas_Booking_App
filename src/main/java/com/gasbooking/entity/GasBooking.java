package com.gasbooking.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "gas_booking")
public class GasBooking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -48597437543156221L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "gas_booking_id")
	private int gasBookingId;
	
	@Column(name = "local_date")
	private LocalDate localDate=LocalDate.now();
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "bill")
	private float bill;
	
	@JsonBackReference
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customer_id")
	private int customerId;
	
	//constructors
	
	public GasBooking() {
		super();
	}
	
	public GasBooking(int gasBookingId, LocalDate localDate, boolean status, float bill) {
		super();
		this.gasBookingId = gasBookingId;
		this.localDate = localDate;
		this.status = status;
		this.bill = bill;
	}
	
	// setters and getters
	
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
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// toString
	
	@Override
	public String toString() {
		return "GasBooking [gasBookingId=" + gasBookingId + ", localDate=" + localDate + ", status=" + status
				+ ", bill=" + bill + ", customerId=" + customerId + "]";
	}
	
}

// developer - Gangireddy Geetha
