package com.ks.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fooditems")

public class FoodItem 
{
	@Id
    private String id;
	private String name;
	private String type; //e.g CARBS, PROTEN
	private String imagepath;
	private double price;

	
	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FoodItem(String id, String name, String type, String imagepath, double price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imagepath = imagepath;
		this.price = price;
	}

	
	@ManyToMany(mappedBy = "foodItems")
	private Set<PurchaseOrder> setOfOrders = new HashSet<>(); 


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", type=" + type + ", imagepath=" + imagepath + ", price="
				+ price + "]";
	}
	
	
}
