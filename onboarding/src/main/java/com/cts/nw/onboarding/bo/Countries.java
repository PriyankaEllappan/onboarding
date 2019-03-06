package com.cts.nw.onboarding.bo;

public class Countries {

	/*
	CREATE TABLE COUNTRIES(
	ID INT NOT NULL AUTO_INCREMENT,
	COUNTRY VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String  country;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Countries [id=" + id + ", country=" + country + "]";
	}
	
	
}
