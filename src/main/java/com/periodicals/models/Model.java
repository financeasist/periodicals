package com.periodicals.models;

public class Model {
	private Integer id; //id is UNIQUE;

	public Model() {
	}

	public Model(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id= " + id;
	}

}
