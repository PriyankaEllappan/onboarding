package com.cts.nw.onboarding.bo;

public class ProjectInfo {

	/*
	CREATE TABLE PROJECTINFO(
	PROJECTID INT NOT NULL,
	PROJECTNAME VARCHAR(255),
	PRIMARY KEY(PROJECTID));
	*/
	private Integer projectID;
	private String projectName;
	public Integer getProjectID() {
		return projectID;
	}
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "ProjectInfo [projectID=" + projectID + ", projectName=" + projectName + "]";
	}

	
	
	
}
