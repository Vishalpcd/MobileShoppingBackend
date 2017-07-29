package com.niit.MobileShoppingBackend.DTO;
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

	/* private fields*/
	private int id;//id of the category
	private String name;//name  of the category
	private String  description;//description of the category
	private String imageUrl;//immage url for the category
	private boolean active;//category is avilable or not

}
