package com.niit.MobileShoppingBackend.DTO;

public class Category {
	/* private fields*/
	private int id;//id of the category
	private String Name;//name  of the category
	private String  Description;//description of the category
	private String ImageUrl;//immage url for the category
	private boolean Active;//category is avilable or not 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}

}
