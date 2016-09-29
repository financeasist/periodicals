package com.periodicals.dao;

import java.sql.SQLException;
import java.util.List;

import com.periodicals.models.Model;


public interface ItemDao<T extends Model> {
	
	public void create(T t);

	public T getByID(int id) throws SQLException;

	public List<T> getAll() throws SQLException;

	public void updateByOnefield(T t);

	void delete(T t);
	

}
