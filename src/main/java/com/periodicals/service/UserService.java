package com.periodicals.service;

import java.sql.Timestamp;
import java.util.List;

import com.periodicals.models.Periodical;

public interface UserService {

	public List<Periodical> getAllPeriodicals();
	public void addToBucket(Integer periodicalId, Integer UserID, Timestamp date);
	public void Pay(Integer bucketID);
	public void removeFromBucket(Integer bucketID,Integer periodicalID);
}

