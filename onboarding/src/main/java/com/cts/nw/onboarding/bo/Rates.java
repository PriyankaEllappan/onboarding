package com.cts.nw.onboarding.bo;

public class Rates {

	/*
	CREATE TABLE RATES(
	ID INT NOT NULL AUTO_INCREMENT,
	RATE VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String rate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Rates [id=" + id + ", rate=" + rate + "]";
	}
	
	
}
