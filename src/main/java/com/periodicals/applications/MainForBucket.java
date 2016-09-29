package com.periodicals.applications;

import java.sql.Timestamp;
import java.util.Date;

import com.periodicals.dao.BucketDao;
import com.periodicals.dao.impl.BucketDaoImpl;
import com.periodicals.models.Bucket;

public class MainForBucket {

	public static void main(String[] args) {
		
		Timestamp data = new Timestamp(new Date().getTime());
		BucketDao bucketDao = new BucketDaoImpl();
		Bucket bucket = new Bucket(3,2,2 ,data);
		bucketDao.create(bucket);
	}
}
