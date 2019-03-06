package com.cts.nw.onboarding.bo;

public class MovementInfo {
	/*
	CREATE TABLE MOVEMENTINFO(
	ID INT NOT NULL AUTO_INCREMENT,
	VALUE VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	
	private Integer id;
	private String value;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MovementInfo [id=" + id + ", value=" + value + "]";
	}
	
	
}
