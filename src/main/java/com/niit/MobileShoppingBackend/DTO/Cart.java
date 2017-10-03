package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//all the  data will be here in this class that means all the variable 
@Entity
public class Cart {
	//private fields 
	@Id//means that the id is primary key in the cart table 
	@GeneratedValue(strategy=GenerationType.IDENTITY)//it says that it autometically icrease by one number 
	private int id;
	@Column(name="grand_total")//column name in the data base  is for grandTotal 
	private double grandTotal;
	@OneToOne
	private User user;
	private int cartline_id;
	//getters and setters
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCartline_id() {
		return cartline_id;
	}
	public void setCartline_id(int cartline_id) {
		this.cartline_id = cartline_id;
	}
	
	//tostring 
	@Override
	public String toString() {
		return "Cart [id=" + id + ", grandTotal=" + grandTotal + ", user=" + user + ", cartline_id=" + cartline_id
				+ "]";
	}
		
	
	
}
