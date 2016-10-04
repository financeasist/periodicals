package com.periodicals.dao;

import java.sql.Timestamp;

import com.periodicals.models.Bucket;

public interface BucketDao extends ItemDao<Bucket> {
	public void create(Integer userID, Integer periodicalID, Timestamp date);
	public void setIsPaiedTrue(Integer bucketID);
}
