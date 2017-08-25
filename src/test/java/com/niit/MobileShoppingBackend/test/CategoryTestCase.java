package com.niit.MobileShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DTO.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CatDao catDao;
	private static Category cat;
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
		catDao=(CatDao)context.getBean("catDao");
	}
	//to test  the add category data to the database 
	/*
	@Test
	public void testAddCategory()
	{
		cat=new Category();

		cat.setName("Comingsoon");
		cat.setDescription("This category contains all the mobiles that are going to launch in this website");
		cat.setImageUrl("cat_3.png");
		//it will check in the CatDaoimpl class in which it return if the category data is persisted in the database
		assertEquals("Successfully added category ",true,catDao.add(cat));
		
		
	}
	*/
	//to test the getcategory
	/*
	@Test
	public void testGetCategory()
	{
		cat=catDao.get(4);
		//the meaning of the below line is 
		//shows the message successful if the id mathces with Comingsoon categoryname from the Category class 
		assertEquals("Successfully fetched the category id from the DB","Comingsoon",cat.getName());
	}
	*/
	/*
	@Test
	public void testUpdateCategory()
	{
		cat=catDao.get(4);
		cat.setName("TV");
		//the meaning of the below line is 
		//shows the message successful if the id mathces with Comingsoon categoryname from the Category class 
		assertEquals("Successfully updated the category name in the DB",true,catDao.update(cat));
	}
	*/
	/*
	@Test
	public void testDeleteCategory()
	{
		cat=catDao.get(4);
		
		//the meaning of the below line is 
		//shows the message successful if the id mathces with Comingsoon categoryname from the Category class 
		assertEquals("Successfully set the category active false in the DB",true,catDao.delete(cat));
	}
	*/
	
	/*
	@Test
	public void testListCategory()
	{
		//it will return all the  three list  of the category where whose active value is true 3 referred
		assertEquals("Successfully fetched the list of  categories which are active from the DB",3,catDao.list().size());
	}
	*/
	//to merge all the crud operation at one method
	@Test
	public void crudOperationOfCategory()
	{
		//adding the  category
		cat=new Category();

		cat.setName("Comingsoon");
		cat.setDescription("This category contains all the mobiles that are going to launch in this website");
		cat.setImageUrl("cat_1.png");
		//it will check in the CatDaoimpl class in which it return if the category data is persisted in the database
		assertEquals("Successfully added category ",true,catDao.add(cat));
		
		
		cat=new Category();

		cat.setName("Newarrival");
		cat.setDescription("This category contains all the mobiles that are newly launched on our website");
		cat.setImageUrl("cat_2.png");
		//it will check in the CatDaoimpl class in which it return if the category data is persisted in the database
		assertEquals("Successfully added category ",true,catDao.add(cat));
		
		
		cat=new Category();

		cat.setName("Exclusive");
		cat.setDescription("This category contains all the mobiles that are not available to any other websites");
		cat.setImageUrl("cat_3.png");
		//it will check in the CatDaoimpl class in which it return if the category data is persisted in the database
		assertEquals("Successfully added category ",true,catDao.add(cat));
		
		
		
		//updating the category
		cat=catDao.get(2);
		cat.setName("newarrival");
		//the meaning of the below line is 
		//shows the message successful if the id mathces with Comingsoon categoryname from the Category class 
		assertEquals("Successfully updated the category name in the DB",true,catDao.update(cat));
		
		//deleting the  category
		cat=catDao.get(2);
		//the meaning of the below line is 
		//shows the message successful if the id mathces with Comingsoon categoryname from the Category class 
		assertEquals("Successfully set the category active false in the DB",true,catDao.delete(cat));

		//getting all the list of the  category from the table 

		//it will return all the  three list  of the category where whose active value is true 3 referred
		assertEquals("Successfully fetched the list of  categories which are active from the DB",2,catDao.list().size());
	

	}
}
