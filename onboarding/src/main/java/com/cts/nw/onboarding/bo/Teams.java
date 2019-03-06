package com.cts.nw.onboarding.bo;

public class Teams {

	/*
	CREATE TABLE TEAMS(
	ID INT NOT NULL AUTO_INCREMENT,
	TEAMNAME VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	
	private Integer id;
	private String teamName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "Teams [id=" + id + ", teamName=" + teamName + "]";
	}
	
	
}
