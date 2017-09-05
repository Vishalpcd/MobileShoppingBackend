package com.niit.MobileShoppingBackend.DAO;

import java.util.List;

import com.niit.MobileShoppingBackend.DTO.Type;

public interface TypeDAO {
	//boolea abstract methods for CRUD operations
	boolean add(Type type);
	boolean update(Type type);
	boolean delete(Type type);
	List<Type> list();
	Type get(int id);

}
