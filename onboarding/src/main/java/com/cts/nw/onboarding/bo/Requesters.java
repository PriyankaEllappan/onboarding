package com.cts.nw.onboarding.bo;

public class Requesters {

	/*
	CREATE TABLE REQUESTERS(
	REQUESTERID INT NOT NULL,
	REQUESTERNAME VARCHAR(255),
	PRIMARY KEY(REQUESTERID));
	*/
	
	private Integer requesterID;
	private String requesterName;
	public Integer getRequesterID() {
		return requesterID;
	}
	public void setRequesterID(Integer requesterID) {
		this.requesterID = requesterID;
	}
	public String getRequesterName() {
		return requesterName;
	}
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
	@Override
	public String toString() {
		return "Requesters [requesterID=" + requesterID + ", requesterName=" + requesterName + "]";
	}

	
}
