package com.niit.MobileShoppingBackend.DTO;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@NotBlank(message="Please enter product name ")
	private String name;
	@NotBlank(message="Please enter brand name")
	private String brand;
	//to say the json to ignore this field to retriev the data from the data base 
	@JsonIgnore
	@NotBlank(message="Please enter product description")
	private  String description;
	@Column(name="unit_price")
	@Min(value=1,message="Please enter valid price ")
	private double unitPrice;
	@Min(value=1,message="Please enter valid quantity")
	private int quantity;
	@Column(name="is_active")
	private boolean active;
	@Column(name="category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierId;
	
	private int brandId;
	private int typeId;
	private int purchases;
	private int views;
	//image upload 
	//transient annotation is used for converting the file into binary file 
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Product()
	{
		this.code="MS"+UUID.randomUUID().toString().substring(26).toUpperCase();//it will generate random code for the code to the uppercase and append it with MS  
	}
	

}
