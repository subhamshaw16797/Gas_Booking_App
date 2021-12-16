package com.gasbooking.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "surrender_cylinder")
public class SurrenderCylinder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1819839579413933404L;

	@Id
	@GeneratedValue
	@Column(name = "surrender_id")
	private int surrenderId;
	
	@Column(name = "surrender_date")
	private LocalDate surrenderDate;
	
	@JsonManagedReference(value = "5")
	@OneToOne(targetEntity = Cylinder.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cylinder_id")
	private Cylinder cylinder;
	
	@JsonManagedReference(value = "6")
	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	// constructor
	public SurrenderCylinder() {
		super();
	}

	public SurrenderCylinder(int surrenderId, LocalDate surrenderDate, Cylinder cylinder) {
		super();
		this.surrenderId = surrenderId;
		this.surrenderDate = surrenderDate;
		this.cylinder = cylinder;
	}

	// setters and getters
	
	public int getSurrenderId() {
		return surrenderId;
	}

	public void setSurrenderId(int surrenderId) {
		this.surrenderId = surrenderId;
	}

	public LocalDate getSurrenderDate() {
		return surrenderDate;
	}

	public void setSurrenderDate(LocalDate surrenderDate) {
		this.surrenderDate = surrenderDate;
	}

	public Cylinder getCylinder() {
		return cylinder;
	}

	public void setCylinder(Cylinder cylinder) {
		this.cylinder = cylinder;
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
		return "SurrenderCylinder [surrenderId=" + surrenderId + ", surrenderDate=" + surrenderDate + ", cylinder=" + cylinder + "]";
	}
	
}

// developer - Jangam Mohan Kalyan