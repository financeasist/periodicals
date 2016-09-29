package com.periodicals.models;

import java.sql.Timestamp;

public class Bucket extends Model {

	private Integer user_id;
	private Integer periodical_id;
	private Timestamp data;

	public Bucket() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public Bucket(Integer id,Integer user_id, Integer periodical_id,Timestamp data2) {
	super(id);
	this.user_id = user_id;
	this.periodical_id = periodical_id;
	this.data = data2;
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

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Bucket [ " + ", user_id=" + user_id + ", periodical_id=" + periodical_id + ", data=" + data + "]";
	}

}
