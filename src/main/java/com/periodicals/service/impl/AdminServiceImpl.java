package com.periodicals.service.impl;

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
		periodicalDao.create(periodical);

	}

	public void updatePeriodical(Periodical periodical) {
		periodicalDao.updateByOnefield(periodical);
		

	}

	public void deletePeriodical(Periodical periodical) {
		periodicalDao.delete(periodical);

	}

	public void setIsBanned(Boolean isBaned,String email ) {
		userDao.updateIsBannedByEmail(isBaned, email);
	}

	

	

}
