package com.periodicals.dao;

import java.sql.Timestamp;

import com.periodicals.models.Bucket;

public interface BucketDao extends ItemDao<Bucket> {
	public void create(Integer userId, Integer periodicalId, Timestamp date);
	public void setIsPaiedTrue(Integer bucketId);
	public void delete(Integer bucketId);
}
