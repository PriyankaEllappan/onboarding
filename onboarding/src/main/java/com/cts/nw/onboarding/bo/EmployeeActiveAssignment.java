/**
 * 
 */
package com.cts.nw.onboarding.bo;

import java.util.Date;

/**
 * @author 616550
 *
 */
public class EmployeeActiveAssignment {
	
	private Integer employeeID;
	private Integer projectID;
	private String projectName;
	private String projectStatus;
	private Integer requesterID;
	private String requesterName;
	private Integer processorID;
	private String processorName;
	private Date releaseDate;
	private String releaseStatus;
	/**
	 * @return the employeeID
	 */
	public Integer getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * @return the projectID
	 */
	public Integer getProjectID() {
		return projectID;
	}
	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectStatus
	 */
	public String getProjectStatus() {
		return projectStatus;
	}
	/**
	 * @param projectStatus the projectStatus to set
	 */
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	/**
	 * @return the requesterID
	 */
	public Integer getRequesterID() {
		return requesterID;
	}
	/**
	 * @param requesterID the requesterID to set
	 */
	public void setRequesterID(Integer requesterID) {
		this.requesterID = requesterID;
	}
	/**
	 * @return the requesterName
	 */
	public String getRequesterName() {
		return requesterName;
	}
	/**
	 * @param requesterName the requesterName to set
	 */
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
	/**
	 * @return the processorID
	 */
	public Integer getProcessorID() {
		return processorID;
	}
	/**
	 * @param processorID the processorID to set
	 */
	public void setProcessorID(Integer processorID) {
		this.processorID = processorID;
	}
	/**
	 * @return the processorName
	 */
	public String getProcessorName() {
		return processorName;
	}
	/**
	 * @param processorName the processorName to set
	 */
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * @return the releaseStatus
	 */
	public String getReleaseStatus() {
		return releaseStatus;
	}
	/**
	 * @param releaseStatus the releaseStatus to set
	 */
	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeRelease [employeeID=" + employeeID + ", projectID=" + projectID + ", projectName=" + projectName
				+ ", projectStatus=" + projectStatus + ", requesterID=" + requesterID + ", requesterName="
				+ requesterName + ", processorID=" + processorID + ", processorName=" + processorName + ", releaseDate="
				+ releaseDate + ", releaseStatus=" + releaseStatus + "]";
	}
	
	

}
