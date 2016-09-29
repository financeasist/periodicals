package com.periodicals.applications;

import java.sql.SQLException;

import com.periodicals.dao.impl.UserDaoImpl;
import com.periodicals.models.User;
import com.periodicals.models.enums.Roles;

public class MainForUser {

	public static void main(String[] args) throws SQLException {
	
	UserDaoImpl userDao = new UserDaoImpl();
	User user = new User("sadhfj@vcb.kom","hgfdfgh","Roman","null",Roles.GUEST,false);
	userDao.create(user);
//	userDao.deleteByEmail("sadhfj@vbcb.kom");
	
//	System.out.println(userDao.getByID(2));
//	userDao.update_EmailANDPassword_ByID(user,2);
	
//	userDao.update_IsBanned_ByEmail(true, "sadhfj@vbcb.kom");
//	userDao.update_Role_ByEmail(user);
//	userDao.update_firstName_ByEmail(user);
//	userDao.updateByOnefield(user);
	}
}
