package com.cts.nw.onboarding.bo;

public class Locations {

	/*
	CREATE TABLE LOCATIONS(
	ID INT NOT NULL AUTO_INCREMENT,
	LOCATION VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	
	private Integer id;
	private String location;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Locations [id=" + id + ", location=" + location + "]";
	}
	
	
}
