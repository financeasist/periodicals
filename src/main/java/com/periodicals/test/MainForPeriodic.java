package com.periodicals.test;


import java.sql.SQLException;

import com.periodicals.service.AdminService;
import com.periodicals.service.GuestService;
import com.periodicals.service.impl.AdminServiceImpl;
import com.periodicals.service.impl.GuestServiceImpl;

public class MainForPeriodic {

	public static void main(String[] args) throws SQLException {
	

//	PeriodicalDaoImpl periodicalDao = new PeriodicalDaoImpl();
//	Periodical periodical = new Periodical("cosmopolitan",5.0,"poiu",true,false);
//	periodicalDao.create(periodical);
//	periodicalDao.getIdByTitle(periodical);
		AdminService adminService =new AdminServiceImpl();
		adminService.setIsBanned(true, "dfgh@hh.com");
	
	//GuestService guestService =new GuestServiceImpl();
	
	//System.out.println(guestService.getAllPeriodical());
	//System.out.println(guestService.getPeriodicalByTitle("JAVA"));
	
	}

}
