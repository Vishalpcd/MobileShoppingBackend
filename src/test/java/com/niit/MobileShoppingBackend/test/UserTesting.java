package com.niit.MobileShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileShoppingBackend.DAO.UserDao;
import com.niit.MobileShoppingBackend.DTO.Address;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.User;

public class UserTesting {
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private static User user;
	private static Address address;
	private static Cart cart;
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
		userDao=(UserDao)context.getBean("userDao");
	}
	
	
	//testing 
	@Test
	public void testAddingUser()
	{
		//for the user 
		user=new User();
		user.setFirstName("Vishal");
		user.setLastName("Pathak");
		user.setRole("ADMIN");
		user.setEnabled(true);
		user.setPassword("123@cosine");
		user.setEmail("vpathak154@gmail.com");
		user.setContactNumber(998754469);
		assertEquals("Successfully added user ",true,userDao.add(user));
		
		//for address
		
		address=new Address();
		address.setUserId(user.getId());
		address.setPlace("Ek siddhi society kolbad road");
		address.setCity("Thane");
		address.setNativePlace("Khopat");
		address.setRoad("Kolbad");
		address.setState("Maharashtra");
		address.setZipCode(400601);
		assertEquals("successfully added address ",true,userDao.add(address));
		
		//for cart
		if(user.getRole().equals("USER"))
		{	
			cart=new Cart();
			cart.setUserId(user.getId());
			assertEquals("successfully added cart",true,userDao.add(cart));
		}
		
		
	}

}
