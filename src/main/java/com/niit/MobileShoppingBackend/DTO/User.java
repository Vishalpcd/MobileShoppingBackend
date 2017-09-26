package com.niit.MobileShoppingBackend.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
@Entity
public class User {

	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	
	
	//private fields
	//to indicate that id is the primary key
	@Id
	//indicating that id should increase by 1 in every insertion of the data 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	@NotBlank(message="please enter your first name ")
	private String firstName;
	@Column(name="last_name")
	@NotBlank(message="please enter your last name ")
	private String lastName;
	private String role;
	private boolean enabled;
	@NotBlank(message="please enter your password ")
	private String password;
	@NotBlank(message="please enter your email id ")
	private String email;
	@Column(name="contact_number")
	private long contactNumber;
}
