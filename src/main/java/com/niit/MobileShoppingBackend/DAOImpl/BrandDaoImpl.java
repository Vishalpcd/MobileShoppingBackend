package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobileShoppingBackend.DAO.BrandDAO;
import com.niit.MobileShoppingBackend.DTO.Brand;
//for creating the object of the BrandDAO interface
@Repository("brandDao")
//indicating that  this will class will go to the transaction
@Transactional
public class BrandDaoImpl implements BrandDAO {

	//Autowiring the session factory that means it will create getters and setters 
	@Autowired
	//creating the object of the sessionfcatory
	private SessionFactory sessionFactory;
	@Override
	public boolean add(Brand brand) {
		try
		{
			sessionFactory.getCurrentSession().persist(brand);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Brand brand) {
		try
		{
			sessionFactory.getCurrentSession().update(brand);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean delete(Brand brand) {
		brand.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(brand);
			return true;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Brand> list() {
		String ListActiveBrand="FROM Brand WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(ListActiveBrand);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Brand get(int id) {
		//it will retrieve all the all the id value of brand class
		return sessionFactory.getCurrentSession().get(Brand.class,Integer.valueOf(id));
	}

}
