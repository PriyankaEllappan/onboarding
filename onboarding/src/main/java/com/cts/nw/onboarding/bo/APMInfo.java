package com.cts.nw.onboarding.bo;

public class APMInfo {

	/*
	CREATE TABLE APMINFO(
	ID INT NOT NULL AUTO_INCREMENT,
	APM VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String APM;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAPM() {
		return APM;
	}
	public void setAPM(String aPM) {
		APM = aPM;
	}
	@Override
	public String toString() {
		return "APMInfo [id=" + id + ", APM=" + APM + "]";
	}
	
	
}
