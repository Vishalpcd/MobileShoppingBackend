package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Product;

public interface ProductDAO {
	//it will return boolean value when adding the data of the product class to the data base
	//Adding the data of the products 
	boolean add(Product product);
	//it will return boolean value when deleting the data of the product
	//deleting the product data from the data base 
	boolean delete(Product product);
	//it will return boolean value when updating the data of the product
	//updating the product data of the data base 
	boolean update(Product product);
	List<Product> list();//it will return list of the product
	Product get(int id);//it will return all the product id 
	List<Product> listActiveProductsByCategory(int categoryid);//it will return all the products by the category id 
	List<Product> listAcitveProductsByBrandId(int brandid);//it will return all the products by the brand id
	List<Product> listActiveProductsByTypeId(int typeid);//it will return all the active products by the type id
	

}
