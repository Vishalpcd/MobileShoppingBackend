package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobileShoppingBackend.DAO.ProductDAO;
import com.niit.MobileShoppingBackend.DTO.Product;
//indicates that it will import all the data of productDao to the ProductDaoImpl
@Repository("productDao")
//indicates that this is the class which is going to transaction
@Transactional
public class ProductDaoImpl implements ProductDAO {
	//it indicates the this is the class which is going to autowire
	@Autowired
private SessionFactory sessionFactory;
	//for adding the data 
	@Override
	public boolean add(Product product) {
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Product product) {
	product.setActive(false);
	try
	{
		sessionFactory.getCurrentSession().update(product);
		return true;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	}

	@Override
	public boolean update(Product product) {
	
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
				}

	@Override
	public Product get(int id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

		@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String listactiveProductsByCategory="FROM Product WHERE active=:active And categoryId=:categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(listactiveProductsByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId",categoryId )
				.getResultList();
	}

	@Override
	public List<Product> listAcitveProductsByBrandId(int brandId) {
		String listactiveProductsByBrand="FROM Product WHERE active=:active And brandId=:brandId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(listactiveProductsByBrand,Product.class)
				.setParameter("active", true)
				.setParameter("brandId",brandId )
				.getResultList();

	}

	@Override
	public List<Product> listActiveProductsByTypeId(int typeId) {
		String listactiveProductByTypeId="FROM Product WHERE active=:active AND typeId=:typeId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(listactiveProductByTypeId,Product.class)
				.setParameter("active", true)
				.setParameter("typeId",typeId )
				.getResultList();

	}

	@Override
	public List<Product> listActiveProduct() {
		String listActiveProducts="FROM Product WHERE active=:active";
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(listActiveProducts,Product.class)
				.setParameter("active",true)
				.getResultList();
	}

}
