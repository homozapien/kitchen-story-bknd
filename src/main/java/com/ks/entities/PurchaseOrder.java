package com.ks.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "foodorders")

public class PurchaseOrder {
	@Id
	private String orderid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "orderedby", referencedColumnName = "emailid")
	private Customer customer;

	
	@ManyToMany (cascade = CascadeType.REFRESH )
    @JoinTable(name="orders_fooditems", 
    		   joinColumns = @JoinColumn(name="orderid"),
    		   inverseJoinColumns = @JoinColumn(name="fooditem_id"))
    private Set<FoodItem> foodItems = new HashSet<>();
	
	@Transient
    private String orderBy;

	@Basic
	private java.sql.Date orderDate;

	private double orderTotalPrice;

	private String paymentStatus;

	public PurchaseOrder() {
		super();
	}
	

	public PurchaseOrder(String orderid, String orderBy, FoodItem[] foodItems,  double orderTotalPrice)
	{
			
		super();
		this.orderid = orderid;
		this.orderTotalPrice = orderTotalPrice;
		this.orderBy = orderBy;
		
		this.setOrderDate(java.sql.Date.valueOf(LocalDate.now()));
		
		Arrays.asList(foodItems)
		    .forEach(item -> { 
		    	this.addFoodItem(item);		    
		    });
		
	}

	
	public PurchaseOrder(String orderid, Customer customer, Date orderDate,
			double orderTotalPrice, String paymentStatus) {
		super();
		this.orderid = orderid;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderTotalPrice = orderTotalPrice;
		this.paymentStatus = paymentStatus;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void addFoodItem(FoodItem foodItem) {
		this.foodItems.add(foodItem);
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


	@Override
	public String toString() {
		return "PurchaseOrder [orderid=" + orderid + ", customer=" + customer + ", foodItems=" + foodItems
				+ ", orderBy=" + orderBy + ", orderDate=" + orderDate + ", orderTotalPrice=" + orderTotalPrice
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	

}
