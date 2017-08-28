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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", brandId=" + brandId + ", typeId="
				+ typeId + ", purchases=" + purchases + ", views=" + views + "]";
	}







	//private fields
	//@Id indicates that the below given variable will be considered as the primary key in the data base  
	@Id
	//now id will inrease autometically by one every time when product is inserted in the database 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String brand;
	private  String description;
	@Column(name="unit_price")
	private double unitPrice;
	private int quantity;
	@Column(name="is_active")
	private boolean active;
	@Column(name="category_id")
	private int categoryId;
	@Column(name="supplier_id")
	private int supplierId;
	private int brandId;
	private int typeId;
	private int purchases;
	private int views;
	
	public Product()
	{
		this.code="MS"+UUID.randomUUID().toString().substring(26).toUpperCase();//it will generate random code for the code to the uppercase and append it with MS  
	}
	

}
