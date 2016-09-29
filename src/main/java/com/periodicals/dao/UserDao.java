package com.periodicals.dao;

import java.sql.SQLException;

import com.periodicals.models.User;

public interface UserDao extends ItemDao<User>{
	
	public Integer getIdByEmail(User u);
	public User getByEmail(String email) throws SQLException;
	public void update_AllFieldsUser_ByID(User t, Integer id);
	public void update_EmailANDPassword_ByID(User t, Integer id);
	public void update_firstName_ByEmail(User u);
	public void update_lastName_ByEmail(User u);
	public void update_Role_ByEmail(User u);
	public void update_IsBanned_ByEmail(User u); 
	
	public void deleteByEmail(User u);
	
	
	

}
