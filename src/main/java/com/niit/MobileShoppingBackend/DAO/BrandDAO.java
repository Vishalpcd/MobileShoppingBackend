package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Brand;

public interface BrandDAO {
	//boolean abstract methods for CRUD operation
	boolean add(Brand brand);
	boolean update(Brand brand);
	boolean delete(Brand brand);
	//for getting the list of the Brand which is active 
	List<Brand> list();
	//for getting the id of the brands
	Brand get(int id);
	

}
