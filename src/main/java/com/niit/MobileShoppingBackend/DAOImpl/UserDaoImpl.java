package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobileShoppingBackend.DAO.UserDao;
import com.niit.MobileShoppingBackend.DTO.Address;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.User;
@Repository("userDao")
@Transactional//this will go under transactional context 
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	public boolean add(User user) {
		
		try
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(User user) {
		user.setEnabled(false);
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	public boolean update(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public List<User> listActiveUsers() {
		String listactiveUsers="FROM User where enabled=:enabled";
		Query query=sessionFactory.getCurrentSession().createQuery(listactiveUsers);
		query.setParameter("enabled",true );
		return query.getResultList();
	}

	@Override
	public User getByEmail(String email) {
		//get all the value of the by the email 
		String selectQuery = "FROM User WHERE email = :email";		
		try {
			
			return sessionFactory.getCurrentSession()
						.createQuery(selectQuery,User.class)
							.setParameter("email", email)
								.getSingleResult();
			
		}
		catch(Exception ex) {
			//ex.printStackTrace();
			return null;
}
}

	@Override
	public boolean add(Address address) {
		try
		{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean add(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	
	}
//update cart we need to update cart by user id 
	@Override
	public boolean update(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
//getting thr user id 
	@Override
	public List<User> getUserId(int id) {
		String getUserIdQuery="FROM User WHERE id=:id";
		return sessionFactory.getCurrentSession().createQuery(getUserIdQuery,User.class).setParameter("id", id).getResultList();
	}

	@Override
	public User getPasswd(String password) {
		String getps="SELECT FROM User WHERE password=:password";
		return sessionFactory.getCurrentSession().createQuery(getps,User.class).setParameter("password",password).getSingleResult();
		
	}

	@Override
	public User getname(String email) {
		String getnameQuery="SELECT firstName FROM User WHERE email=:email";
		return sessionFactory.getCurrentSession().createQuery(getnameQuery,User.class).setParameter("email", email).getSingleResult();
	}

	@Override
	public boolean getUserDetails(String email, String password) {
		
			String details="FROM User WHERE email=:email AND password=:password";
			Query query=sessionFactory.getCurrentSession().createQuery(details);
					query.setParameter("email", email).setParameter("password", password);
					List list=query.getResultList();
					if((list!=null)&&(list.size()>0))
					{
						return true;
					}
		
					return false;
		
	}

	

	
	
}
