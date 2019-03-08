package com.cts.nw.onboarding.bo;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class EmployeeCompleteProjectInfo {

	
	/*
	 * table employeemaster fields 
	 */
	private Integer employeeMasterID;
	/*
	 * private String employeeMasterName; private String employeeMasterFirstName;
	 * private String employeeMasterLastName; private String
	 * employeeMasterPassportNumber; private String employeeMasterEmail;
	 */
	
	private String name;
	private String firstName;
	private String lastName;
	private String passportNumber;
	private String email;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date DOB;
	
	/*
	 * table projectinfo fields 
	 */
	
	private Integer projectInfoProjectID;
	private String projectInfoProjectName;
	
	/*
	 * table requesters fields 
	 */	
	
	private Integer requestersRequesterID;
	private String requestersRequesterName;
	
	/*
	 * table processors fields 
	 */	
	private Integer processorsProcessorID;
	private String processorsProcessorName;
	
	/*
	 * table BSAInfo fields 
	 */	
	
	private Integer BSAInfoID;
	private String BSAInfoName;
	
	/*
	 * table PPLInfo fields 
	 */	
	private Integer PPLInfoID;
	private String PPLInfoName;
	
	/*
	 * table teamMapping fields 
	 */	
	private Integer teamMappingID;
	private Integer teamMappingProjectMapID ;
	private Integer teamMappingTeamID ;
	private Integer teamMappingPPLMapID;
	private String teamMappingStatus;
	
	/*
	 * table roleMapping fields 
	 */	
	
	private Integer roleMappingID ;
	private Integer roleMappingRoleID;
	private Integer roleMappingRateID;
    
    
	/*
	 * table countryMapping fields 
	 */	
	
	private Integer  countryMappingID;
	private Integer countryMappingCountryID;
	private Integer countryMappingLocationID;
	
	/*
	 * table employeeprojectinfo fields 
	 */
	private Integer id;
	private Integer employeeID;
	private Integer team;
	private Integer role;
	private Integer country;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	private String natiowideID;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nationwideidCreatedDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fgOnboardingDate;
	private Integer movementID;
	private String workforceID;
	private Integer attachmentID;
	private String comments;
	private String skillSet;
	private String skillSummary;
	private Integer approvalStatus;
	private Integer releaseStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date releaseDate;
	private Integer reasonForOffboarding;

	/*
	 * table APPROVALSTATUS fields
	 */

	private Integer approvalStatusID;
	private String approvalStatusMessage;

	/*
	 * table RELEASESTATUS fields
	 */
	private Integer releaseStatusID;
	private String releaseStatusStatus;

	/*
	 * table releaseSummary fields
	 */
	private Integer releaseSummaryID;
	private String releaseSummaryName;

	/*
	 * table roles fields
	 */
	private Integer roleID;
	private String roleName;

	/*
	 * table rates fields
	 */
	private Integer rateID;
	private String rateName;

	/*
	 * table MAILATTACHMENTS fields
	 */
	private Integer mailAttachmentid;
	private String mailAttachmentFilename;
	private byte[] mailAttachmentFiledata;

	/*
	 * table PROJECTMAPPING fields
	 */
	private Integer projectMappingID;
	private Integer projectMappingProjectID;
	private Integer projectMappingProcessorID;
	private Integer projectMappingRequesterID;
	private String projectMappingStatus;

	/*
	 * table LOCATIONS fields
	 */
	private Integer locationID;
	private String locationName;

	/*
	 * table TEAMS fields
	 */

	private Integer teamid;
	private String teamName;

	/*
	 * table COUNTRIES fields
	 */

	private Integer countryID;
	private String countryName;
	
	
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
	 * @return the employeeID
	 */
	public Integer getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID
	 *            the employeeID to set
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
	 * @param team
	 *            the team to set
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
	 * @param role
	 *            the role to set
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
	 * @param country
	 *            the country to set
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
	 * @param fgOnboardingDate
	 *            the fgOnboardingDate to set
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
	 * @param movementID
	 *            the movementID to set
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
	 * @param workforceID
	 *            the workforceID to set
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
	 * @param attachmentID
	 *            the attachmentID to set
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
	 * @return the releaseStatus
	 */
	public Integer getReleaseStatus() {
		return releaseStatus;
	}

	/**
	 * @param releaseStatus
	 *            the releaseStatus to set
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
	 * @param releaseDate
	 *            the releaseDate to set
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
	 * @param reasonForOffboarding
	 *            the reasonForOffboarding to set
	 */
	public void setReasonForOffboarding(Integer reasonForOffboarding) {
		this.reasonForOffboarding = reasonForOffboarding;
	}

	/**
	 * @return the approvalStatusID
	 */
	public Integer getApprovalStatusID() {
		return approvalStatusID;
	}

	/**
	 * @param approvalStatusID
	 *            the approvalStatusID to set
	 */
	public void setApprovalStatusID(Integer approvalStatusID) {
		this.approvalStatusID = approvalStatusID;
	}

	/**
	 * @return the approvalStatusMessage
	 */
	public String getApprovalStatusMessage() {
		return approvalStatusMessage;
	}

	/**
	 * @param approvalStatusMessage
	 *            the approvalStatusMessage to set
	 */
	public void setApprovalStatusMessage(String approvalStatusMessage) {
		this.approvalStatusMessage = approvalStatusMessage;
	}

	/**
	 * @return the releaseStatusID
	 */
	public Integer getReleaseStatusID() {
		return releaseStatusID;
	}

	/**
	 * @param releaseStatusID
	 *            the releaseStatusID to set
	 */
	public void setReleaseStatusID(Integer releaseStatusID) {
		this.releaseStatusID = releaseStatusID;
	}

	/**
	 * @return the releaseStatusStatus
	 */
	public String getReleaseStatusStatus() {
		return releaseStatusStatus;
	}

	/**
	 * @param releaseStatusStatus
	 *            the releaseStatusStatus to set
	 */
	public void setReleaseStatusStatus(String releaseStatusStatus) {
		this.releaseStatusStatus = releaseStatusStatus;
	}

	/**
	 * @return the releaseSummaryID
	 */
	public Integer getReleaseSummaryID() {
		return releaseSummaryID;
	}

	/**
	 * @param releaseSummaryID
	 *            the releaseSummaryID to set
	 */
	public void setReleaseSummaryID(Integer releaseSummaryID) {
		this.releaseSummaryID = releaseSummaryID;
	}



	/**
	 * @return the roleID
	 */
	public Integer getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID
	 *            the roleID to set
	 */
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
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
	 * @return the rateID
	 */
	public Integer getRateID() {
		return rateID;
	}

	/**
	 * @param rateID
	 *            the rateID to set
	 */
	public void setRateID(Integer rateID) {
		this.rateID = rateID;
	}

	/**
	 * @return the rateName
	 */
	public String getRateName() {
		return rateName;
	}

	/**
	 * @param rateName
	 *            the rateName to set
	 */
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	/**
	 * @return the mailAttachmentid
	 */
	public Integer getMailAttachmentid() {
		return mailAttachmentid;
	}

	/**
	 * @param mailAttachmentid
	 *            the mailAttachmentid to set
	 */
	public void setMailAttachmentid(Integer mailAttachmentid) {
		this.mailAttachmentid = mailAttachmentid;
	}

	/**
	 * @return the mailAttachmentFilename
	 */
	public String getMailAttachmentFilename() {
		return mailAttachmentFilename;
	}

	/**
	 * @param mailAttachmentFilename
	 *            the mailAttachmentFilename to set
	 */
	public void setMailAttachmentFilename(String mailAttachmentFilename) {
		this.mailAttachmentFilename = mailAttachmentFilename;
	}

	/**
	 * @return the mailAttachmentFiledata
	 */
	public byte[] getMailAttachmentFiledata() {
		return mailAttachmentFiledata;
	}

	/**
	 * @param mailAttachmentFiledata
	 *            the mailAttachmentFiledata to set
	 */
	public void setMailAttachmentFiledata(byte[] mailAttachmentFiledata) {
		this.mailAttachmentFiledata = mailAttachmentFiledata;
	}

	/**
	 * @return the projectMappingID
	 */
	public Integer getProjectMappingID() {
		return projectMappingID;
	}

	/**
	 * @param projectMappingID
	 *            the projectMappingID to set
	 */
	public void setProjectMappingID(Integer projectMappingID) {
		this.projectMappingID = projectMappingID;
	}

	/**
	 * @return the projectMappingProjectID
	 */
	public Integer getProjectMappingProjectID() {
		return projectMappingProjectID;
	}

	/**
	 * @param projectMappingProjectID
	 *            the projectMappingProjectID to set
	 */
	public void setProjectMappingProjectID(Integer projectMappingProjectID) {
		this.projectMappingProjectID = projectMappingProjectID;
	}

	/**
	 * @return the projectMappingProcessorID
	 */
	public Integer getProjectMappingProcessorID() {
		return projectMappingProcessorID;
	}

	/**
	 * @param projectMappingProcessorID
	 *            the projectMappingProcessorID to set
	 */
	public void setProjectMappingProcessorID(Integer projectMappingProcessorID) {
		this.projectMappingProcessorID = projectMappingProcessorID;
	}

	/**
	 * @return the projectMappingRequesterID
	 */
	public Integer getProjectMappingRequesterID() {
		return projectMappingRequesterID;
	}

	/**
	 * @param projectMappingRequesterID
	 *            the projectMappingRequesterID to set
	 */
	public void setProjectMappingRequesterID(Integer projectMappingRequesterID) {
		this.projectMappingRequesterID = projectMappingRequesterID;
	}

	/**
	 * @return the projectMappingStatus
	 */
	public String getProjectMappingStatus() {
		return projectMappingStatus;
	}

	/**
	 * @param projectMappingStatus
	 *            the projectMappingStatus to set
	 */
	public void setProjectMappingStatus(String projectMappingStatus) {
		this.projectMappingStatus = projectMappingStatus;
	}

	/**
	 * @return the locationID
	 */
	public Integer getLocationID() {
		return locationID;
	}

	/**
	 * @param locationID
	 *            the locationID to set
	 */
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
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
	 * @return the teamid
	 */
	public Integer getTeamid() {
		return teamid;
	}

	/**
	 * @param teamid
	 *            the teamid to set
	 */
	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
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
	 * @return the countryID
	 */
	public Integer getCountryID() {
		return countryID;
	}

	/**
	 * @param countryID
	 *            the countryID to set
	 */
	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
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
	 * @return the employeeMasterID
	 */
	public Integer getEmployeeMasterID() {
		return employeeMasterID;
	}

	/**
	 * @param employeeMasterID the employeeMasterID to set
	 */
	public void setEmployeeMasterID(Integer employeeMasterID) {
		this.employeeMasterID = employeeMasterID;
	}




	/**
	 * @return the projectInfoProjectID
	 */
	public Integer getProjectInfoProjectID() {
		return projectInfoProjectID;
	}

	/**
	 * @param projectInfoProjectID the projectInfoProjectID to set
	 */
	public void setProjectInfoProjectID(Integer projectInfoProjectID) {
		this.projectInfoProjectID = projectInfoProjectID;
	}

	/**
	 * @return the projectInfoProjectName
	 */
	public String getProjectInfoProjectName() {
		return projectInfoProjectName;
	}

	/**
	 * @param projectInfoProjectName the projectInfoProjectName to set
	 */
	public void setProjectInfoProjectName(String projectInfoProjectName) {
		this.projectInfoProjectName = projectInfoProjectName;
	}

	/**
	 * @return the requestersRequesterID
	 */
	public Integer getRequestersRequesterID() {
		return requestersRequesterID;
	}

	/**
	 * @param requestersRequesterID the requestersRequesterID to set
	 */
	public void setRequestersRequesterID(Integer requestersRequesterID) {
		this.requestersRequesterID = requestersRequesterID;
	}

	/**
	 * @return the requestersRequesterName
	 */
	public String getRequestersRequesterName() {
		return requestersRequesterName;
	}

	/**
	 * @param requestersRequesterName the requestersRequesterName to set
	 */
	public void setRequestersRequesterName(String requestersRequesterName) {
		this.requestersRequesterName = requestersRequesterName;
	}

	/**
	 * @return the processorsProcessorID
	 */
	public Integer getProcessorsProcessorID() {
		return processorsProcessorID;
	}

	/**
	 * @param processorsProcessorID the processorsProcessorID to set
	 */
	public void setProcessorsProcessorID(Integer processorsProcessorID) {
		this.processorsProcessorID = processorsProcessorID;
	}

	/**
	 * @return the processorsProcessorName
	 */
	public String getProcessorsProcessorName() {
		return processorsProcessorName;
	}

	/**
	 * @param processorsProcessorName the processorsProcessorName to set
	 */
	public void setProcessorsProcessorName(String processorsProcessorName) {
		this.processorsProcessorName = processorsProcessorName;
	}

	/**
	 * @return the bSAInfoID
	 */
	public Integer getBSAInfoID() {
		return BSAInfoID;
	}

	/**
	 * @param bSAInfoID the bSAInfoID to set
	 */
	public void setBSAInfoID(Integer bSAInfoID) {
		BSAInfoID = bSAInfoID;
	}

	/**
	 * @return the bSAInfoName
	 */
	public String getBSAInfoName() {
		return BSAInfoName;
	}

	/**
	 * @param bSAInfoName the bSAInfoName to set
	 */
	public void setBSAInfoName(String bSAInfoName) {
		BSAInfoName = bSAInfoName;
	}

	/**
	 * @return the pPLInfoID
	 */
	public Integer getPPLInfoID() {
		return PPLInfoID;
	}

	/**
	 * @param pPLInfoID the pPLInfoID to set
	 */
	public void setPPLInfoID(Integer pPLInfoID) {
		PPLInfoID = pPLInfoID;
	}

	/**
	 * @return the pPLInfoName
	 */
	public String getPPLInfoName() {
		return PPLInfoName;
	}

	/**
	 * @param pPLInfoName the pPLInfoName to set
	 */
	public void setPPLInfoName(String pPLInfoName) {
		PPLInfoName = pPLInfoName;
	}

	/**
	 * @return the teamMappingID
	 */
	public Integer getTeamMappingID() {
		return teamMappingID;
	}

	/**
	 * @param teamMappingID the teamMappingID to set
	 */
	public void setTeamMappingID(Integer teamMappingID) {
		this.teamMappingID = teamMappingID;
	}

	/**
	 * @return the teamMappingProjectMapID
	 */
	public Integer getTeamMappingProjectMapID() {
		return teamMappingProjectMapID;
	}

	/**
	 * @param teamMappingProjectMapID the teamMappingProjectMapID to set
	 */
	public void setTeamMappingProjectMapID(Integer teamMappingProjectMapID) {
		this.teamMappingProjectMapID = teamMappingProjectMapID;
	}

	/**
	 * @return the teamMappingTeamID
	 */
	public Integer getTeamMappingTeamID() {
		return teamMappingTeamID;
	}

	/**
	 * @param teamMappingTeamID the teamMappingTeamID to set
	 */
	public void setTeamMappingTeamID(Integer teamMappingTeamID) {
		this.teamMappingTeamID = teamMappingTeamID;
	}

	/**
	 * @return the teamMappingPPLMapID
	 */
	public Integer getTeamMappingPPLMapID() {
		return teamMappingPPLMapID;
	}

	/**
	 * @param teamMappingPPLMapID the teamMappingPPLMapID to set
	 */
	public void setTeamMappingPPLMapID(Integer teamMappingPPLMapID) {
		this.teamMappingPPLMapID = teamMappingPPLMapID;
	}

	/**
	 * @return the teamMappingStatus
	 */
	public String getTeamMappingStatus() {
		return teamMappingStatus;
	}

	/**
	 * @param teamMappingStatus the teamMappingStatus to set
	 */
	public void setTeamMappingStatus(String teamMappingStatus) {
		this.teamMappingStatus = teamMappingStatus;
	}

	/**
	 * @return the countryMappingID
	 */
	public Integer getCountryMappingID() {
		return countryMappingID;
	}

	/**
	 * @param countryMappingID the countryMappingID to set
	 */
	public void setCountryMappingID(Integer countryMappingID) {
		this.countryMappingID = countryMappingID;
	}

	/**
	 * @return the countryMappingCountryID
	 */
	public Integer getCountryMappingCountryID() {
		return countryMappingCountryID;
	}

	/**
	 * @param countryMappingCountryID the countryMappingCountryID to set
	 */
	public void setCountryMappingCountryID(Integer countryMappingCountryID) {
		this.countryMappingCountryID = countryMappingCountryID;
	}

	/**
	 * @return the countryMappingLocationID
	 */
	public Integer getCountryMappingLocationID() {
		return countryMappingLocationID;
	}

	/**
	 * @param countryMappingLocationID the countryMappingLocationID to set
	 */
	public void setCountryMappingLocationID(Integer countryMappingLocationID) {
		this.countryMappingLocationID = countryMappingLocationID;
	}

	/**
	 * @return the roleMappingID
	 */
	public Integer getRoleMappingID() {
		return roleMappingID;
	}

	/**
	 * @param roleMappingID the roleMappingID to set
	 */
	public void setRoleMappingID(Integer roleMappingID) {
		this.roleMappingID = roleMappingID;
	}

	/**
	 * @return the roleMappingRoleID
	 */
	public Integer getRoleMappingRoleID() {
		return roleMappingRoleID;
	}

	/**
	 * @param roleMappingRoleID the roleMappingRoleID to set
	 */
	public void setRoleMappingRoleID(Integer roleMappingRoleID) {
		this.roleMappingRoleID = roleMappingRoleID;
	}

	/**
	 * @return the roleMappingRateID
	 */
	public Integer getRoleMappingRateID() {
		return roleMappingRateID;
	}

	/**
	 * @param roleMappingRateID the roleMappingRateID to set
	 */
	public void setRoleMappingRateID(Integer roleMappingRateID) {
		this.roleMappingRateID = roleMappingRateID;
	}

	/**
	 * @return the releaseSummaryName
	 */
	public String getReleaseSummaryName() {
		return releaseSummaryName;
	}

	/**
	 * @param releaseSummaryName the releaseSummaryName to set
	 */
	public void setReleaseSummaryName(String releaseSummaryName) {
		this.releaseSummaryName = releaseSummaryName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
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
	 * @param passportNumber the passportNumber to set
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
	 * @param email the email to set
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
	 * @param dOB the dOB to set
	 */
	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	
	


	
	

}
