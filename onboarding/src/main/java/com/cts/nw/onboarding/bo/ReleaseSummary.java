package com.cts.nw.onboarding.bo;

public class ReleaseSummary {

	/*
	CREATE TABLE RELEASESUMMARY(
	ID INT NOT NULL AUTO_INCREMENT,
	SUMMARY VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String summary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "ReleaseSummary [id=" + id + ", summary=" + summary + "]";
	}
	
	
}
