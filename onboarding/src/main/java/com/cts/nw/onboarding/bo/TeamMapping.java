package com.cts.nw.onboarding.bo;

public class TeamMapping {
	/*
	CREATE TABLE TEAMMAPPING (
	    ID INT NOT NULL AUTO_INCREMENT,
	    PROJECTMAPID INT NOT NULL,
	    TEAMID INT NOT NULL,
	    PPLMAPID INT NOT NULL,
	    PRIMARY KEY (ID),
	    FOREIGN KEY (TEAMID)
	        REFERENCES TEAMS (ID),
	    FOREIGN KEY (PROJECTMAPID)
	        REFERENCES PROJECTMAPPING (ID),
	    FOREIGN KEY (PPLMAPID)
	        REFERENCES PPLMAPPING (ID)
	);
	*/
	
	private Integer id;
	private Integer projectMapID ;
	private Integer teamID ;
	private Integer pplMapID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectMapID() {
		return projectMapID;
	}
	public void setProjectMapID(Integer projectMapID) {
		this.projectMapID = projectMapID;
	}
	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public Integer getPplMapID() {
		return pplMapID;
	}
	public void setPplMapID(Integer pplMapID) {
		this.pplMapID = pplMapID;
	}
	@Override
	public String toString() {
		return "TeamMapping [id=" + id + ", projectMapID=" + projectMapID + ", teamID=" + teamID + ", pplMapID="
				+ pplMapID + "]";
	}
	
	
}
