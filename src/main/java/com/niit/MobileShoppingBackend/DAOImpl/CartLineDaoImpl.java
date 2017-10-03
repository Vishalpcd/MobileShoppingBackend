package com.niit.MobileShoppingBackend.DAOImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.MobileShoppingBackend.DAO.CartLineDao;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.CartLine;
@Repository("cartLineDao")
@Transactional
public class CartLineDaoImpl implements CartLineDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean add(CartLine cartLine) {
		try
		{
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try
		{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartLine) {
		cartLine.setAvailable(false);
		try
		{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession().get(CartLine.class,id);
	}
	@Override
	public List<CartLine> list(int cart_id) {
		String query="FROM CartLine WHERE cart_id=:cart_id";
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class).setParameter("cart_id", cart_id).getResultList();
	}
	@Override
	public List<CartLine> availableCartLineList(int cart_id) {
		String query="FROM CartLine WHERE cart_id=:cart_id AND available=:available";
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class).setParameter("cart_id",cart_id).setParameter("available", true).getResultList();
	}
	@Override
	public boolean update(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public CartLine getByProductIdAndCartId(int cart_id, int product_id) {
		try
		{
		String query="FROM CartLine WHERE cart_id=:cart_id AND product.id=:product_id AND available=:available";
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class).setParameter("cart_id",cart_id).setParameter("product_id",product_id).setParameter("available", true).getSingleResult();
		}
		catch(Exception ex)
		{
			
			return null;
		}
	}
}
