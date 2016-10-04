package com.periodicals.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.periodicals.dao.BucketDao;
import com.periodicals.dao.impl.BucketDaoImpl;
import com.periodicals.models.Bucket;

public class MainForBucket {

	public static void main(String[] args) {

		Timestamp date = new Timestamp(new Date().getTime());
		BucketDao bucketDao = new BucketDaoImpl();
		// bucketDao.create(2,10,date);
		// List<Bucket>list = null;
		// try {
		// list = bucketDao.getAll();
		//
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(list.toString());
		Bucket bucket = null;
		try {
			bucket = bucketDao.getById(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bucket.toString());
	}
}
