package com.cts.nw.onboarding.bo;

public class ReleaseStatus {

	/*
	CREATE TABLE RELEASESTATUS(
	ID INT NOT NULL AUTO_INCREMENT,
	STATUS VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	
	private Integer id;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReleaseStatus [id=" + id + ", status=" + status + "]";
	}
	
	
	
}
