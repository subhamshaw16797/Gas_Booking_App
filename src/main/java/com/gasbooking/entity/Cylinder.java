package com.gasbooking.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JsonBackReference(value = "1")
	@OneToOne(targetEntity = Customer.class, mappedBy = "cylinder")
	private Customer customer;
	
	@JsonManagedReference(value = "5")
	@OneToOne(targetEntity = SurrenderCylinder.class, cascade = CascadeType.ALL)
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
	
	public Cylinder() {
		super();
	}
	
	// getters and setters
	
	public int getcylinderId() {
		return cylinderId;
	}
	
	public String getType() {
		return type;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getStrapColor() {
		return strapColor;
	}
	
	public double getPrice() {
		return price;
	}
	
	//setters
	public void setCylinderId(int cylinderId) {
		this.cylinderId=cylinderId;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setStrapColor(String strapColor) {
		this.strapColor = strapColor;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
    //ToString
	
	@Override
	public String toString() {
		return "Cylinder [cylinderId=" + cylinderId + ", type=" + type + ", weight=" + weight + ", strapColor="
				+ strapColor + ", price=" + price + "]";
	}
}

// developer - Chinta Goverdhan Reddy