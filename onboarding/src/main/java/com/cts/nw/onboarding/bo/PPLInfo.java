package com.cts.nw.onboarding.bo;

public class PPLInfo {

	/*
	CREATE TABLE PPLINFO(
	ID INT NOT NULL AUTO_INCREMENT,
	PPLNAME VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String pplName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPplName() {
		return pplName;
	}
	public void setPplName(String pplName) {
		this.pplName = pplName;
	}
	@Override
	public String toString() {
		return "PPLInfo [id=" + id + ", pplName=" + pplName + "]";
	}
	
	
}
