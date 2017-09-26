package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
//entity annotaion for giving the hibernate sql query
@Entity
public class Brand {
	//getter and setter methods 
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
	//private fields
	//indicating that id is a primary key in the brand table 
	@Id
	//indicating that id should be generate there value automatically by increase id value with 1
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Please enter brand name ")
	private String name;
	@NotBlank(message="Please enter description")
	private String description;
	@Column(name="is_active")
	private boolean active;
	

}
