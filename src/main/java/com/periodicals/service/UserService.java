package com.periodicals.service;

import java.util.List;

import com.periodicals.models.Periodical;

public interface UserService {

	public List<Periodical> getAllPeriodicals();
	public void addToBucket();
	public void Pay();
	public void removeFromBucket();
}

