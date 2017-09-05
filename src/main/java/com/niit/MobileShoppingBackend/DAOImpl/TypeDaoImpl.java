package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobileShoppingBackend.DAO.TypeDAO;
import com.niit.MobileShoppingBackend.DTO.Type;
//for getting the object of TypeDAO
@Repository("typeDao")
//for indicating that this is the class which will go to the transaction
@Transactional
public class TypeDaoImpl implements TypeDAO {
	//autowiring the SessionFactory i.e for getting the getters and setters 
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean add(Type type) {
		try
		{
			sessionFactory.getCurrentSession().persist(type);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Type type) {
		try
		{
			sessionFactory.getCurrentSession().update(type);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Type type) {
		type.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(type);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Type> list() {
		String listActiveType="FROM Type WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(listActiveType);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Type get(int id) 
	{
		return sessionFactory.getCurrentSession().get(Type.class,Integer.valueOf(id));
	}

}
