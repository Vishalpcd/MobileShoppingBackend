package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.id.IncrementGenerator;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DTO.Category;
@Repository("catDao")
@Transactional//beacuse now everythisng in the class is going to persist in db thats why it used at the class level
public class CatDaoImpl implements CatDao {
	//@Autowired annotation will generate getters and setters
	@Autowired
	//SessionFactory will do all task that would be given to the application
	private SessionFactory sessionFactory;
	/*adding category in the static ArrayList for testing purpose*/
	
	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active=:active";//hibernate query language for listing data whose value is active
		//to define the query language and passsing the query string value to the hibernate 
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		//to set the value of active 
		query.setParameter("active", true);
		return query.getResultList();//returns All the Categories in the list 
	}
	@Override
	public Category get(int id) {
		//it will return id of integer type from the Category class
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	@Override
	public boolean add(Category cat) {
		try
		{
			//it  will return current session 
			sessionFactory.getCurrentSession().persist(cat);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Category cat) {
		cat.setActive(false);//now it will not delete the item from the table simply it update set active as false and then it will do just check if it is returning true if yes then test is pass 
		try
		{
			//it  will return current session i.e. it will return DeleteCategory
			//it will update the cat object of the category class to the data base 
			sessionFactory.getCurrentSession().update(cat);//now update the category table  if we write delete here then it will delete that row 
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	//test case for updating product
	@Override
	public boolean update(Category cat) {
		try
		{
			//it  will return current session i.e. it will return UpdateCategory
			//it will update the cat object of the category class to the data base 
			sessionFactory.getCurrentSession().update(cat);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}