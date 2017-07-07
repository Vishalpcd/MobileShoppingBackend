package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DTO.Category;

public class CatDaoImpl implements CatDao {

	/*adding category in the static ArrayList for testing purpose*/
	private static List<Category> Categories=new ArrayList<Category>();
	static{
		//adding values to the category class by calling there get and set method using object 
		Category cat=new Category();
		cat.setId(1);
		cat.setName("New Arrival");
		cat.setDescription("In This Category user will find some new mobiles which are launched earlier");
		cat.setImageUrl("cat_1.png");
		//adding above values in the ArrayList 
		Categories.add(cat);
	}
	static {
		//adding second category
		//adding values to the Category class by calling there get annd set method using object  of the Category class
		Category cat=new Category();
		cat.setId(2);
		cat.setName("Old Mobiles");
		cat.setDescription("This mobiles are very rare to find at aywhere because these  are old mobiles ");
		cat.setImageUrl("cat_2.png");
		Categories.add(cat);
	
	}
	static {
		//adding Third category
		Category cat=new Category();
		cat.setId(3);
		cat.setName("Coming soon");
		cat.setDescription("This category contains all the mobiles that are going to launch in this website");
		cat.setImageUrl("cat_3.png");
		Categories.add(cat);
	}
	@Override
	public List<Category> list() {
		return Categories;//returns All the Categories in the list 
	}

}
