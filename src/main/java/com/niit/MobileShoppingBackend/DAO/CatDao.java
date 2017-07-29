package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Category;

public interface CatDao {
	/* declaring that the all the variable values of the category 
	 * class will be kept in list */
	List<Category> list();
	Category get(int id);

}
