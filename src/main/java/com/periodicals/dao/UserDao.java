package com.periodicals.dao;

import java.sql.SQLException;

import com.periodicals.models.User;

public interface UserDao extends ItemDao<User>{
	
	public Integer getIdByEmail(String mail);
	public User getByEmail(String email) throws SQLException;
	public void updateAllFieldsUserByID(User user, Integer id);
	public void updateEmailANDPasswordByID(User user, Integer id);
	public void updateFirstNameByEmail(String firstName, String email);
	public void updateLastNameByEmail(String lastName, String email);
	public void updateRoleByEmail(String role, String email);
	public void updateIsBannedByEmail(Boolean isBaned, String email); 
	
	public void deleteByEmail(String email);
	
	
	

}
