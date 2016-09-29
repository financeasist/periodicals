package com.periodicals.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.periodicals.dao.BucketDao;
import com.periodicals.dao.PeriodicalDao;
import com.periodicals.dao.UserDao;
import com.periodicals.dao.impl.BucketDaoImpl;
import com.periodicals.dao.impl.PeriodicalDaoImpl;
import com.periodicals.dao.impl.UserDaoImpl;
import com.periodicals.models.Periodical;
import com.periodicals.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	PeriodicalDao periodicalDao= new PeriodicalDaoImpl();
	BucketDao buckedDao = new BucketDaoImpl();

	
	public List<Periodical> getAllPeriodicals() {
		List<Periodical> list = null;
		try {
			list = periodicalDao.getAll();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}


	public void addToBucket() {
		// TODO Auto-generated method stub
		
	}

	
	public void Paid() {
		// TODO Auto-generated method stub
		
	}

	
	public void removeFromBucket() {
		// TODO Auto-generated method stub
		
	}

	
}
