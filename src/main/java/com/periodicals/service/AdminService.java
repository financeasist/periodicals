package com.periodicals.service;

import com.periodicals.models.Periodical;

public interface AdminService {

	public void addPeriodical(Periodical periodical);

	public void updatePeriodical(Periodical periodical);

	public void deletePeriodical(Periodical pperiodical);

	public void setIsBanned(Boolean isBaned, String email);

}
