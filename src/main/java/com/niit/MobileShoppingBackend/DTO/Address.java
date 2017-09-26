package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity //all the values will be assigned to the data base from this class only
public class Address {
	//private fields 
	@Id//means this the primary key in the database table
	@GeneratedValue(strategy=GenerationType.IDENTITY)//means it will automatically increase the id value with one 
	private int id;
	private String place;
	@Column(name="zip_code")//the value of zipCode will be consider as colummn name zip_code of the Address table  in the data base 
	private int zipCode;
	private String city;
	@Column(name="native_place")//database column name 
	private String nativePlace;
	private String state;
	private String road;
	@Column(name="user_id")//data base column name 
	private int userId;
	
	
	
	
	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	//toString for debugging
	@Override
	public String toString() {
		return "Address [id=" + id + ", place=" + place + ", zipCode=" + zipCode + ", city=" + city + ", nativePlace="
				+ nativePlace + ", state=" + state + ", road=" + road + ", userId=" + userId + "]";
	}
	
	
	
	

}
