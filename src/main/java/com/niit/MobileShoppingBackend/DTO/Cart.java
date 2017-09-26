package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//all the  data will be here in this class that means all the variable 
@Entity
public class Cart {
	//private fields 
	@Id//means that the id is primary key in the cart table 
	@GeneratedValue(strategy=GenerationType.IDENTITY)//it says that it autometically icrease by one number 
	private int id;
	@Column(name="grand_total")//column name in the data base  is for grandTotal 
	private double grandTotal;
	@Column(name="user_id")//userId has column name in database cart table  as user_id
	private int userId;
	
	
	//getters and the setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	//toString method for debugging 
	@Override
	public String toString() {
		return "Cart [id=" + id + ", grandTotal=" + grandTotal + ", userId=" + userId + "]";
	}
	

	
	
	

}
