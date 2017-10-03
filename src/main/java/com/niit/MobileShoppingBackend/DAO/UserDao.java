package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Address;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.User;

public interface UserDao {
	//adding the user data to the  database 
	boolean add(User user);
	//adding the Address
	boolean add(Address address);
	//for update cart
	boolean update(Cart cart);
	//adding the cart 
	boolean add(Cart cart);
	//deleting the data from the database 
	boolean delete(User user);
	//updating the data from the database 
	boolean update(User user);
	//get the list of the User who is active
	List<User> listActiveUsers();
	//getting the user name password from the user table 
	boolean getUserDetails(String email,String password);
	//getting the email
	User getByEmail(String email);
	//getting the user id 
	List<User> getUserId(int id);
	//getting the users password 
	User getPasswd(String password);
	User getname(String email);
	
}
