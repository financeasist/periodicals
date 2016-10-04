package com.periodicals.models;

import java.sql.Timestamp;

public class Bucket extends Model {

	private Integer user_id;
	private Integer periodical_id;
	boolean IsPaid = false;
	private Timestamp date;

	public Bucket() {

	}
	// public Bucket(Integer id, Integer user_id, Integer periodical_id,
	// Timestamp date) {
	// super(id);
	// this.user_id = user_id;
	// this.periodical_id = periodical_id;
	// this.date = date;
	//
	// }

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Bucket(Integer id) {
		super(id);
	}

	public Integer getPeriodical_id() {
		return periodical_id;
	}

	public void setPeriodical_id(Integer periodical_id) {
		this.periodical_id = periodical_id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public boolean getIsIsPaid() {
		return IsPaid;
	}

	public void setIsPaid(boolean isPaid) {
		IsPaid = isPaid;
	}

	@Override
	public String toString() {
		return "Bucket [user_id=" + user_id + ", periodical_id=" + periodical_id + ", IsPaid=" + IsPaid + ", date="
				+ date + "]+\n";
	}

}
