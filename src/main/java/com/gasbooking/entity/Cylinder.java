 package com.gasbooking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cylinder")
public class Cylinder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1342296579429539054L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cylinder_id")
	private int cylinderId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "strap_color")
	private String strapColor;
	
	@Column(name = "price")
	private double price;
	
	private boolean isBooked = false;
	
	@JsonBackReference(value = "1")
	@OneToOne(targetEntity = Customer.class, mappedBy = "cylinder")
	private Customer customer;
	
	@JsonBackReference(value = "5")
//	@OneToOne(targetEntity = Cylinder.class, mappedBy = "surrenderCylinder")
	private SurrenderCylinder surrenderCylinder;
	
	// constructor
	
	public Cylinder(int cylinderId,String type, double weight,String strapColor, double price) {
		super();
		this.cylinderId=cylinderId;
		this.type=type;
		this.weight=weight;
		this.strapColor=strapColor;
		this.price=price;
	}
	
	public Cylinder(int cylinderId, String type, double weight, String strapColor, double price, boolean isBooked) {
		super();
		this.cylinderId = cylinderId;
		this.type = type;
		this.weight = weight;
		this.strapColor = strapColor;
		this.price = price;
		this.isBooked = isBooked;
	}


	public Cylinder() {
		super();
	}
	
	public int getCylinderId() {
		return cylinderId;
	}

	public void setCylinderId(int cylinderId) {
		this.cylinderId = cylinderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getStrapColor() {
		return strapColor;
	}

	public void setStrapColor(String strapColor) {
		this.strapColor = strapColor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SurrenderCylinder getSurrenderCylinder() {
		return surrenderCylinder;
	}

	public void setSurrenderCylinder(SurrenderCylinder surrenderCylinder) {
		this.surrenderCylinder = surrenderCylinder;
	}
	
	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	//ToString

	@Override
	public String toString() {
		return "Cylinder [cylinderId=" + cylinderId + ", type=" + type + ", weight=" + weight + ", strapColor="
				+ strapColor + ", price=" + price + ", isBooked=" + isBooked + "]";
	}
}

// developer - Chinta Goverdhan Reddy