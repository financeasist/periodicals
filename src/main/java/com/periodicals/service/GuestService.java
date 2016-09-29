package com.periodicals.service;

import java.util.List;

import com.periodicals.models.Periodical;

public interface GuestService {

	
	
	public List<Periodical> getAllPeriodical();
	public Periodical getPeriodicalByTitle(String title);
}