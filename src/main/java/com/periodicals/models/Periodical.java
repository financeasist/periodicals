package com.periodicals.models;

public class Periodical extends Model {

	private String title;
	private Double price;
	private String discription;
	private Boolean isAdded;
	private Boolean isPaided;

	// public Periodical() {
	// super();
	// }
	// public Periodical(Integer id) {
	// super(id);
	// }
	//
	//
	//
	//
	// public Periodical(String title, Double price, String discription, Boolean
	// isAdded, Boolean isPaided) {
	// super();
	// this.title = title;
	// this.price = price;
	// this.discription = discription;
	// this.isAdded = isAdded;
	// this.isPaided = isPaided;
	// }
	public Boolean getIsAdded() {
		return isAdded;
	}

	public void setIsAdded(Boolean isAdded) {
		this.isAdded = isAdded;
	}

	public Boolean getIsPaided() {
		return isPaided;
	}

	public void setIsPaided(Boolean isPaided) {
		this.isPaided = isPaided;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Periodical [title=" + title + ", price=" + price + ", discription=" + discription + ", isAdded="
				+ isAdded + ", isPaided=" + isPaided + "]";
	}

}
