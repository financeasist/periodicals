package com.periodicals.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.periodicals.dao.PeriodicalDao;
import com.periodicals.dao.impl.PeriodicalDaoImpl;
import com.periodicals.models.Periodical;
import com.periodicals.service.GuestService;

public class GuestServiceImpl implements GuestService {

	private PeriodicalDao periodicalDao = new PeriodicalDaoImpl();

	
	public List<Periodical> getAllPeriodical() {
		List<Periodical> periodicalsList = new ArrayList<Periodical>();
		try {
			periodicalsList = periodicalDao.getAll();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return periodicalsList;

	}

	
	public Periodical getPeriodicalByTitle(String title) {
		return periodicalDao.getPeriodicalByTitle(title);
		
	}

}
