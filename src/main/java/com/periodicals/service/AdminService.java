package com.periodicals.service;

import com.periodicals.models.Periodical;
import com.periodicals.models.User;

public interface AdminService {
	public void addPeriodical(Periodical periodical);

	public void updatePeriodical(Periodical periodical);

	public void deletePeriodical(Periodical pperiodical);

	public void setIsBanned(User user);

}
