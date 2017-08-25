package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Category;

public interface CatDao {
	//The below  given statemennt return true or false for adding the category into the  database 
	boolean add(Category cat);
	//for deleting the category
	boolean delete(Category cat);
	//for updating the category
	boolean update(Category cat);
	/* declaring that the all the variable values of the category 
	 * class will be kept in list */
	
	List<Category> list();
	Category get(int id);

}
