package com.periodicals.dao;

import com.periodicals.models.Periodical;

public interface PeriodicalDao extends ItemDao<Periodical> {
	
	public void deleteByTitle(String title);
	public Integer getIdByTitle(String title);
	public Periodical getPeriodicalByTitle(String title);
}
