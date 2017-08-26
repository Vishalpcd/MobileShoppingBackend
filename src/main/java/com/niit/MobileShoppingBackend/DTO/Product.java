package com.niit.MobileShoppingBackend.DTO;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
//To indicate that this is the class that is going give the  data for our product table thats why  @Entity is used below
@Entity
public class Product {
	//public getters and setters method of private fields 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	//for the console i.e it will return all the  value to the console while running the application
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", brand=" + brand + ", description=" + description
				+ ", unit_price=" + unit_price + ", quantity=" + quantity + ", is_active=" + is_active
				+ ", category_id=" + category_id + ", supplier_id=" + supplier_id + ", purchases=" + purchases
				+ ", views=" + views + "]";
	}






	//private fields
	//@Id indicates that the below given variable will be considered as the primary key in the data base  
	@Id
	//now id will inrease autometically by one every time when product is inserted in the database 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String brand;
	private  String description;
	private float unit_price;
	private int quantity;
	private boolean is_active;
	private int category_id;
	private int supplier_id;
	private int purchases;
	private int views;
	
	public Product()
	{
		this.code="MS"+UUID.randomUUID().toString().substring(26).toUpperCase();//it will generate random code for the code to the uppercase and append it with MS  
	}
	

}
