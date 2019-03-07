package com.cts.nw.onboarding.bo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeCompleteProjectInfo {

	/*
	 * table employeeprojectinfo fields 
	 */
	private Integer id;
	private Integer employeeID;
	private Integer team;
	private Integer role;
	private Integer country;
	private Date startDate;
	private String natiowideID;
	private Date nationwideidCreatedDate;
	private Date fgOnboardingDate;
	private Integer movementID;
	private String workforceID;
	private Integer attachmentID;
	private String comments;
	private String skillSet;
	private String skillSummary;
	private Integer approvalStatus;
	private Integer releaseStatus;
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
	private String releaseSummary;

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
	 * @return the releaseSummary
	 */
	public String getReleaseSummary() {
		return releaseSummary;
	}

	/**
	 * @param releaseSummary
	 *            the releaseSummary to set
	 */
	public void setReleaseSummary(String releaseSummary) {
		this.releaseSummary = releaseSummary;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeCompleteProjectInfo [id=" + id + ", employeeID=" + employeeID + ", team=" + team + ", role="
				+ role + ", country=" + country + ", startDate=" + startDate + ", natiowideID=" + natiowideID
				+ ", nationwideidCreatedDate=" + nationwideidCreatedDate + ", fgOnboardingDate=" + fgOnboardingDate
				+ ", movementID=" + movementID + ", workforceID=" + workforceID + ", attachmentID=" + attachmentID
				+ ", comments=" + comments + ", skillSet=" + skillSet + ", skillSummary=" + skillSummary
				+ ", approvalStatus=" + approvalStatus + ", releaseStatus=" + releaseStatus + ", releaseDate="
				+ releaseDate + ", reasonForOffboarding=" + reasonForOffboarding + ", approvalStatusID="
				+ approvalStatusID + ", approvalStatusMessage=" + approvalStatusMessage + ", releaseStatusID="
				+ releaseStatusID + ", releaseStatusStatus=" + releaseStatusStatus + ", releaseSummaryID="
				+ releaseSummaryID + ", releaseSummary=" + releaseSummary + ", roleID=" + roleID + ", roleName="
				+ roleName + ", rateID=" + rateID + ", rateName=" + rateName + ", mailAttachmentid=" + mailAttachmentid
				+ ", mailAttachmentFilename=" + mailAttachmentFilename + ", mailAttachmentFiledata="
				+ Arrays.toString(mailAttachmentFiledata) + ", projectMappingID=" + projectMappingID
				+ ", projectMappingProjectID=" + projectMappingProjectID + ", projectMappingProcessorID="
				+ projectMappingProcessorID + ", projectMappingRequesterID=" + projectMappingRequesterID
				+ ", projectMappingStatus=" + projectMappingStatus + ", locationID=" + locationID + ", locationName="
				+ locationName + ", teamid=" + teamid + ", teamName=" + teamName + ", countryID=" + countryID
				+ ", countryName=" + countryName + "]";
	}

}
