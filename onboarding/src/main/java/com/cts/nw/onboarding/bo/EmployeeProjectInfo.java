package com.cts.nw.onboarding.bo;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class EmployeeProjectInfo {

	/*
	 * CREATE TABLE employeeprojectinfo (
    ID INT NOT NULL AUTO_INCREMENT,
    EMPLOYEEID INT NOT NULL,
    TEAM INT NOT NULL,
    ROLE INT NOT NULL,
    COUNTRY INT NOT NULL,
    STARTDATE DATE,
    NATIOWIDEID VARCHAR(64),
    NATIONWIDEIDCREATEDDATE DATE,
    FGONBOARDINGDATE DATE,
    MOVEMENTID INT,
    WORKFORCEID VARCHAR(64),
	ATTACHMENTID INT,
    COMMENTS VARCHAR(255),
    SKILLSET VARCHAR(255),
    SKILLSUMMARY VARCHAR(255),
    APPROVALSTATUS INT NOT NULL,
    RELEASESTATUS INT NOT NULL,
    RELEASEDATE DATE,
    REASONFOROFFBOARDING INT,
    FOREIGN KEY (EMPLOYEEID)
        REFERENCES EMPLOYEEMASTER (ID),
    FOREIGN KEY (TEAM)
        REFERENCES TEAMMAPPING (ID),
    FOREIGN KEY (ROLE)
        REFERENCES ROLEMAPPING (ID),
    FOREIGN KEY (COUNTRY)
        REFERENCES COUNTRYMAPPING (ID),
    FOREIGN KEY (MOVEMENTID)
        REFERENCES MOVEMENTINFO (ID),
    FOREIGN KEY (APPROVALSTATUS)
        REFERENCES APPROVALSTATUS (ID),
    FOREIGN KEY (RELEASESTATUS)
        REFERENCES RELEASESTATUS (ID),
    FOREIGN KEY (ATTACHMENTID)
        REFERENCES MAILATTACHMENTS (ID),
	FOREIGN KEY (REASONFOROFFBOARDING)
        REFERENCES RELEASESUMMARY (ID),
    PRIMARY KEY (ID)
); 
*/
	/*
table employeeprojectinfo fields
	 */
	private Integer id;
	private Integer employeeID ;
	private Integer team ;
	private Integer role ;
	private Integer country;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	private String natiowideID;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nationwideidCreatedDate ;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fgOnboardingDate;
    private Integer movementID ;
    private String workforceID ;
    private Integer attachmentID ;
    private String comments ;
    private String skillSet ;
    private String skillSummary ;
    private Integer approvalStatus;
    private Integer releaseStatus ;
   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date releaseDate ;
    private Integer reasonForOffboarding ;
    
    /*Additional Params for Mail Option*/
    private String requesterId;
    private String processorId;
    
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
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
	 * @return the team
	 */
	public Integer getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(Integer team) {
		this.team = team;
	}
	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * @return the country
	 */
	public Integer getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Integer country) {
		this.country = country;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the natiowideID
	 */
	public String getNatiowideID() {
		return natiowideID;
	}
	/**
	 * @param natiowideID the natiowideID to set
	 */
	public void setNatiowideID(String natiowideID) {
		this.natiowideID = natiowideID;
	}
	/**
	 * @return the nationwideidCreatedDate
	 */
	public Date getNationwideidCreatedDate() {
		return nationwideidCreatedDate;
	}
	/**
	 * @param nationwideidCreatedDate the nationwideidCreatedDate to set
	 */
	public void setNationwideidCreatedDate(Date nationwideidCreatedDate) {
		this.nationwideidCreatedDate = nationwideidCreatedDate;
	}
	/**
	 * @return the fgOnboardingDate
	 */
	public Date getFgOnboardingDate() {
		return fgOnboardingDate;
	}
	/**
	 * @param fgOnboardingDate the fgOnboardingDate to set
	 */
	public void setFgOnboardingDate(Date fgOnboardingDate) {
		this.fgOnboardingDate = fgOnboardingDate;
	}
	/**
	 * @return the movementID
	 */
	public Integer getMovementID() {
		return movementID;
	}
	/**
	 * @param movementID the movementID to set
	 */
	public void setMovementID(Integer movementID) {
		this.movementID = movementID;
	}
	/**
	 * @return the workforceID
	 */
	public String getWorkforceID() {
		return workforceID;
	}
	/**
	 * @param workforceID the workforceID to set
	 */
	public void setWorkforceID(String workforceID) {
		this.workforceID = workforceID;
	}
	/**
	 * @return the attachmentID
	 */
	public Integer getAttachmentID() {
		return attachmentID;
	}
	/**
	 * @param attachmentID the attachmentID to set
	 */
	public void setAttachmentID(Integer attachmentID) {
		this.attachmentID = attachmentID;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the skillSet
	 */
	public String getSkillSet() {
		return skillSet;
	}
	/**
	 * @param skillSet the skillSet to set
	 */
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	/**
	 * @return the skillSummary
	 */
	public String getSkillSummary() {
		return skillSummary;
	}
	/**
	 * @param skillSummary the skillSummary to set
	 */
	public void setSkillSummary(String skillSummary) {
		this.skillSummary = skillSummary;
	}
	/**
	 * @return the approvalStatus
	 */
	public Integer getApprovalStatus() {
		return approvalStatus;
	}
	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	/**
	 * @return the releaseStatus
	 */
	public Integer getReleaseStatus() {
		return releaseStatus;
	}
	/**
	 * @param releaseStatus the releaseStatus to set
	 */
	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
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
	 * @return the reasonForOffboarding
	 */
	public Integer getReasonForOffboarding() {
		return reasonForOffboarding;
	}
	/**
	 * @param reasonForOffboarding the reasonForOffboarding to set
	 */
	public void setReasonForOffboarding(Integer reasonForOffboarding) {
		this.reasonForOffboarding = reasonForOffboarding;
	}
	
	/**
	 * @return the requesterId
	 */
	public String getRequesterId() {
		return requesterId;
	}
	/**
	 * @param requesterId the requesterId to set
	 */
	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}
	/**
	 * @return the processorId
	 */
	public String getProcessorId() {
		return processorId;
	}
	/**
	 * @param processorId the processorId to set
	 */
	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeProjectInfo [id=" + id + ", employeeID=" + employeeID + ", team=" + team + ", role=" + role
				+ ", country=" + country + ", startDate=" + startDate + ", natiowideID=" + natiowideID
				+ ", nationwideidCreatedDate=" + nationwideidCreatedDate + ", fgOnboardingDate=" + fgOnboardingDate
				+ ", movementID=" + movementID + ", workforceID=" + workforceID + ", attachmentID=" + attachmentID
				+ ", comments=" + comments + ", skillSet=" + skillSet + ", skillSummary=" + skillSummary
				+ ", approvalStatus=" + approvalStatus + ", releaseStatus=" + releaseStatus + ", releaseDate="
				+ releaseDate + ", reasonForOffboarding=" + reasonForOffboarding + ", requesterId=" + requesterId
				+ ", processorId=" + processorId + "]";
	}
	
}
