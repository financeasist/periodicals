package com.periodicals.service;

import java.sql.Timestamp;
import java.util.List;

import com.periodicals.models.Periodical;

public interface UserService {

	public List<Periodical> getAllPeriodicals();
	public Periodical getPeriodicalByTitle(String title);
	public void addToBucket(Integer periodicalId, Integer userId, Timestamp date);
	public void Pay(Integer bucketId);
	public void removeFromBucket(Integer bucketId);
}

