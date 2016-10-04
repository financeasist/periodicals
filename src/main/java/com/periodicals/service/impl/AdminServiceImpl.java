package com.periodicals.service.impl;

import java.sql.SQLException;

import com.periodicals.dao.PeriodicalDao;
import com.periodicals.dao.UserDao;
import com.periodicals.dao.impl.PeriodicalDaoImpl;
import com.periodicals.dao.impl.UserDaoImpl;
import com.periodicals.models.Periodical;
import com.periodicals.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private PeriodicalDao periodicalDao = new PeriodicalDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	
	public void addPeriodical(Periodical periodical) {
		try {
			periodicalDao.create(periodical);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	public void updatePeriodical(Periodical periodical) {
		try {
			periodicalDao.updateByOneField(periodical);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

	public void deletePeriodical(Periodical periodical) {
		try {
			periodicalDao.delete(periodical);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void setIsBanned(Boolean isBaned,String email ) {
		userDao.updateIsBannedByEmail(isBaned, email);
	}

	

	

}
