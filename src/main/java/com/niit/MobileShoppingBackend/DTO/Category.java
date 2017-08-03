package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category { 
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", active=" + active + "]";
	}



	/* private fields*/
	@Id//every entity that is every row must have id as an identity
	//to increment the id autometically we need add 
	@GeneratedValue(strategy=GenerationType.IDENTITY)//since we have given id as an IDENTITY thats why we have used just above the id
	private int id;//id of the category
	private String name;//name  of the category
	private String  description;//description of the category
	@Column(name="image_url")
	private String imageUrl;//immage url for the category
	@Column(name="is_active")
	private boolean active;//category is avilable or not

}
