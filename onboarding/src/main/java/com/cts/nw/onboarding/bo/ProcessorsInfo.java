package com.cts.nw.onboarding.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProcessorsInfo {

	/*
	 * table employeemaster fields
	 */
	private Integer employeeMasterID;
	/*
	 * private String employeeMasterName; private String
	 * employeeMasterFirstName; private String employeeMasterLastName; private
	 * String employeeMasterPassportNumber; private String employeeMasterEmail;
	 */

	private String name;
	private String firstName;
	private String lastName;
	private String passportNumber;
	private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date DOB;

	private String bsaInfo;
	private String pplInfo;

	/*
	 * table employeeprojectinfo fields
	 */
	private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	private String natiowideID;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nationwideidCreatedDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fgOnboardingDate;
	private String comments;
	private String skillSet;
	private String skillSummary;
	private Integer approvalStatus;
	private Integer releaseStatus;
	private String roleName;
	private String rateValue;
	private String teamName;
	private String locationName;
	private String countryName;

	/*
	 * table projectinfo fields
	 */

	private String projectName;
	private String projectId;

	/*
	 * table requesters fields
	 */

	private Integer requesterID;
	private String requesterName;

	/*
	 * table processors fields
	 */
	private Integer processorID;
	private String processorName;

	private Integer releaseSummary;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date releaseDate;
	
	public Integer getReleaseSummary() {
		return releaseSummary;
	}

	public void setReleaseSummary(Integer releaseSummary) {
		this.releaseSummary = releaseSummary;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the employeeMasterID
	 */
	public Integer getEmployeeMasterID() {
		return employeeMasterID;
	}

	/**
	 * @param employeeMasterID
	 *            the employeeMasterID to set
	 */
	public void setEmployeeMasterID(Integer employeeMasterID) {
		this.employeeMasterID = employeeMasterID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}

	/**
	 * @param passportNumber
	 *            the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dOB
	 */
	public Date getDOB() {
		return DOB;
	}

	/**
	 * @param dOB
	 *            the dOB to set
	 */
	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
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
	 * @param natiowideID
	 *            the natiowideID to set
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
	 * @param nationwideidCreatedDate
	 *            the nationwideidCreatedDate to set
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
	 * @param fgOnboardingDate
	 *            the fgOnboardingDate to set
	 */
	public void setFgOnboardingDate(Date fgOnboardingDate) {
		this.fgOnboardingDate = fgOnboardingDate;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
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
	 * @param skillSet
	 *            the skillSet to set
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
	 * @param skillSummary
	 *            the skillSummary to set
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
	 * @param approvalStatus
	 *            the approvalStatus to set
	 */
	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName
	 *            the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName
	 *            the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the releaseStatus
	 */
	public int getReleaseStatus() {
		return releaseStatus;
	}

	/**
	 * @param releaseStatus
	 *            the releaseStatus to set
	 */
	public void setReleaseStatus(int releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	/**
	 * @param releaseStatus
	 *            the releaseStatus to set
	 */
	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	/**
	 * @return the bsaInfo
	 */
	public String getBsaInfo() {
		return bsaInfo;
	}

	/**
	 * @param bsaInfo the bsaInfo to set
	 */
	public void setBsaInfo(String bsaInfo) {
		this.bsaInfo = bsaInfo;
	}

	/**
	 * @return the pplInfo
	 */
	public String getPplInfo() {
		return pplInfo;
	}

	/**
	 * @param pplInfo the pplInfo to set
	 */
	public void setPplInfo(String pplInfo) {
		this.pplInfo = pplInfo;
	}

	/**
	 * @return the rateValue
	 */
	public String getRateValue() {
		return rateValue;
	}

	/**
	 * @param rateValue the rateValue to set
	 */
	public void setRateValue(String rateValue) {
		this.rateValue = rateValue;
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
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ProcessorsInfo [employeeMasterID=" + employeeMasterID + ", name=" + name + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", passportNumber=" + passportNumber + ", email=" + email + ", DOB=" + DOB
				+ ", bsaInfo=" + bsaInfo + ", pplInfo=" + pplInfo + ", id=" + id + ", startDate=" + startDate
				+ ", natiowideID=" + natiowideID + ", nationwideidCreatedDate=" + nationwideidCreatedDate
				+ ", fgOnboardingDate=" + fgOnboardingDate + ", comments=" + comments + ", skillSet=" + skillSet
				+ ", skillSummary=" + skillSummary + ", approvalStatus=" + approvalStatus + ", releaseStatus="
				+ releaseStatus + ", roleName=" + roleName + ", rateValue=" + rateValue + ", teamName=" + teamName
				+ ", locationName=" + locationName + ", countryName=" + countryName + ", projectName=" + projectName
				+ ", projectId=" + projectId + ", requesterID=" + requesterID + ", requesterName=" + requesterName
				+ ", processorID=" + processorID + ", processorName=" + processorName + ", releaseSummary="
				+ releaseSummary + ", releaseDate=" + releaseDate + "]";
	}

}
