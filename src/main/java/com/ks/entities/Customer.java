package com.ks.entities;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "customer")

public class Customer
{
	@Id
	private String emailid;  
	private String password; 
	private String userType;
	private String firstname;
	private String lastname;
	private String creditCard;
	
	/*@ManyToMany
	@Cascade({  CascadeType.REFRESH })
    @JoinTable(name="customer_fooditem", 
    		   joinColumns = @JoinColumn(name="customer_id"),
    		   inverseJoinColumns = @JoinColumn(name="fooditem_id"))
    private Set<FoodItem> foodItemSet = new HashSet<>(); */
	
	@OneToMany(mappedBy = "customer") 
 	private Set<PurchaseOrder> orders = new HashSet<>(); 
   

	public Customer() {
		super();
	}

	


	public Customer(String emailid, String password, String userType, String firstname, String lastname,
			String creditCard) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.userType = userType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.creditCard = creditCard;
		
	}




	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	
	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmailid() {
		return emailid;
	}




	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUserType() {
		return userType;
	}




	public void setUserType(String userType) {
		this.userType = userType;
	}




	public Set<PurchaseOrder> getOrders() {
		return orders;
	}

	public void addCustomerOrder(PurchaseOrder order) {
		
		this.orders.add(order);
	}




	@Override
	public String toString() {
		return "Customer [emailid=" + emailid + ", password=" + password + ", userType=" + userType + ", firstname="
				+ firstname + ", lastname=" + lastname + ", creditCard=" + creditCard + "]";
	}
	

	

    
}
