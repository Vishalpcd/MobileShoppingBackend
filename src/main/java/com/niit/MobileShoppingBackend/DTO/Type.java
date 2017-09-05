package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type {
	//getters and setters 

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
	
	//toString method for debuuging in console 
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", description=" + description + ", active=" + active + "]";
	}
	
	
	
	
	
	//private fields
	//to make id as primary key for the table type
	@Id
	//to indicate that this id valu will increase automatically by increase with 1
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name="is_active")
	private boolean active;

}
