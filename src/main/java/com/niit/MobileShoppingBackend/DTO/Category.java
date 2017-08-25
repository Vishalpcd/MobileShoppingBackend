package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//To indicate that this is the class that is going give the  data for our category table @Entity is used below
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
	//we need to add toString method to see in console that it is taking all data correctly it will  print the all the data has been traveled to data base 
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", active=" + active + "]";
	}
	
	
	

	/* private fields*/
	//To add below as the primary key @Id is used below
	@Id
	//To indicate that increment id autometically @GeneratedValue() is used 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//id of the category
	private String name;//name  of the category
	private String  description;//description of the category
	//Below @Column annotation is used to say  that the data is used to assign the value for image_url column since it is not same as that of column name of the table 
	@Column(name="image_url")
	private String imageUrl;//immage url for the category
	@Column(name="is_active")
	private boolean active=true;//category is avilable or not

}