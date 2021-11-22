package com.gasbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cylinder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cylinderId;
	
	private String type;
	
	private float weight;
	
	private String strapColor;
	
	private float price;
	
	public Cylinder(int cylinderId,String type,float weight,String strapColor,float price) {
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
	
	//getters
	public int getcylinderId() {
		return cylinderId;
	}
	
	public String getType() {
		return type;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public String getStrapColor() {
		return strapColor;
	}
	
	public float getPrice() {
		return price;
	}
	
	//setters
	public void setCylinderId(int cylinderId) {
		this.cylinderId=cylinderId;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public void setStrapColor(String strapColor) {
		this.strapColor = strapColor;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
    //ToString	
	@Override
	public String toString() {
		return "Cylinder [cylinderId=" + cylinderId + ", type=" + type + ", weight=" + weight + ", strapColor="
				+ strapColor + ", price=" + price + "]";
	}
}
