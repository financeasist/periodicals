package com.periodicals.dao;

import java.sql.SQLException;
import java.util.List;

import com.periodicals.models.Model;


public interface ItemDao<T extends Model> {
	
	public void create(T t)throws SQLException;

	public T getById(int id) throws SQLException;

	public List<T> getAll() throws SQLException;

	public void updateByOneField(T t)throws SQLException;

	void delete(T t)throws SQLException;
	

}
