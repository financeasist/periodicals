package com.periodicals.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
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
	PeriodicalDao periodicalDao = new PeriodicalDaoImpl();
	BucketDao bucketDao = new BucketDaoImpl();

	public List<Periodical> getAllPeriodicals() {
		List<Periodical> list = null;

		try {
			list = periodicalDao.getAll();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public void addToBucket(Integer periodicalId, Integer UserID, Timestamp date) {

		bucketDao.create(periodicalId, UserID, date); // createBucket()
	}

	public void Pay(Integer bucketID) {
		bucketDao.setIsPaiedTrue(bucketID); // setISPaid='true'

	}

	public void removeFromBucket(Integer bucketId) {

		bucketDao.delete(bucketId);

	}

	public Periodical getPeriodicalByTitle(String title) {
		Periodical periodical = null;

		periodical = periodicalDao.getPeriodicalByTitle(title);

		return periodical;
	}

}
