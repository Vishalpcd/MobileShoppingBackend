package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.CartLine;

public interface CartLineDao {
	//for adding the cartLine into the databse 
	public boolean add(CartLine cartLine);
	//for updating the cartLine 
	public boolean update(CartLine cartLine);
	//for deleting the cartLine
	public boolean delete(CartLine cartLine);
	//get the cartLine by its id for displaying the carLine 
	public CartLine get(int id);
	//getting the list of  carline by the users cartid 
	public List<CartLine> list(int cart_id);
	//getting the list of the available cartLine by the cartId
	public List<CartLine> availableCartLineList(int cart_id);
	//get the cartLine by the productid and cart id 
	public CartLine getByProductIdAndCartId(int cart_id,int product_id);
	
	
	//updating the cart
	public boolean update(Cart cart);
	
	

}
