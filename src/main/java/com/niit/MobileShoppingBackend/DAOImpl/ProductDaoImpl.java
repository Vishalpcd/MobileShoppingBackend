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
	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> list() {
		String listProduct="FROM Product WHERE is_active=:active";
		Query  query=sessionFactory.getCurrentSession().createQuery(listProduct);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

		@Override
	public List<Product> listActiveProductsByCategory(int categoryid) {
		String listactiveProductsByCategory="FROM Product WHERE category_id=:categoryid AND is_active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(listactiveProductsByCategory);
		query.setParameter(categoryid,categoryid );
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listAcitveProductsByBrandId(int brandid) {
		String listactiveProductByBrandId="FROM Product WHERE brandid=:brandid AND is_active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(listactiveProductByBrandId);
		query.setParameter(brandid, brandid);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByTypeId(int typeid) {
	
		String listactiveProductByTypeId="FROM Product WHERE typeid=:typeid AND is_active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(listactiveProductByTypeId);
		query.setParameter(typeid, typeid);
		query.setParameter("active", true);
		return query.getResultList();
	}

}
