package com.niit.MobileShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileShoppingBackend.DAO.ProductDAO;
import com.niit.MobileShoppingBackend.DTO.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDao;
	private static Product product;
	@BeforeClass
	//For initialisation of the classes
	public static void init()
	{
		//Initialisation of AnnotationConfigApplicationContext class
		context=new AnnotationConfigApplicationContext();
		//Indicates from where to scan the classes for annotations 
		context.scan("com.niit.MobileShoppingBackend");
		//Refresh the context
		context.refresh();
		//Here we are indicating that this  is the class  which as annotations
		//we need to type cast it perticular class since it is returning object
		productDao=(ProductDAO)context.getBean("productDao");
	}
	/*
	@Test
	public void testAddPrducts()
	{
		product =new Product();
		product.setName("Core2");
		product.setBrand("Samsung");
		product.setDescription("This is one of the best phone available in the market");
		product.setUnitPrice(6500.00);
		product.setQuantity(2);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		product.setBrandId(1);
		product.setTypeId(2);
		assertEquals("Something went wrong while adding new product ",true,productDao.add(product));
	}
	*/
	/*
	@Test
	public void testGetProduct()
	{
		product=productDao.get(4);
		assertEquals("Something went wrong while retrieving the data by the id ","Samsung",product.getBrand());
	}
	*/
	/*
	@Test
	public void testListProduct()
	{
		assertEquals("Successfully fetched the list of  categories which are active from the DB",3,productDao.list().size());

	}
	*/
	
	/*
	@Test
	public void testListActiveProductsByCategory()
	{
		assertEquals("Successfully fetched the list of  categories which are active from the DB",1,productDao.listActiveProductsByCategory(3).size());
		assertEquals("Successfully fetched the list of  categories which are active from the DB",2,productDao.listActiveProductsByCategory(2).size());
	}
	*/
	
}
