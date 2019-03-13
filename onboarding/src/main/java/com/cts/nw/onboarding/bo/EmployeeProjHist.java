/**
 * 
 */
package com.cts.nw.onboarding.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.cj.jdbc.Blob;

/**
 * @author 616550
 *
 */
public class EmployeeProjHist {

	private Integer id;
	private String nationwideId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nationwideIdCreatedDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fgOnBoardingDate;
	
	private Integer movementId;
	private String workForceId;
	private String scrumMaster;
	private String apm;
	private String pplManager;
	private Integer Experience;
	private String comments;
	private String skillSet;
	private String skillSummary;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date releaseDate;
	
	private Integer approvalStatusId;
	private String approvalStatus;
	private Integer releaseStatusId;
	private String releaseStatus;
	private Integer reasonForOffboarding;
	private Integer attachmentId;
	private Integer employeeId;
	private String name;
	private String firstName;
	private String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private String passportNumber;
	private String email;
	private Integer countryId;
	private String countryName;
	private String location;
	private Integer roleId;
	private String role;
	private String rate;
	private Integer teamId;
	private String teamName;
	private String bsaName;
	private Long projectId;
	private String projectName;
	private Integer requesterId;
	private String requesterName;
	private Integer processorId;
	private String processorName;
	
	private String movement;
	private String fileName;
	private Blob fileData;
	
	private int bandId;
	private String band;
	
	
	/**
	 * @return the movement
	 */
	public String getMovement() {
		return movement;
	}
	/**
	 * @param movement the movement to set
	 */
	public void setMovement(String movement) {
		this.movement = movement;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileData
	 */
	public Blob getFileData() {
		return fileData;
	}
	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(Blob fileData) {
		this.fileData = fileData;
	}
	/**
	 * @return the bandId
	 */
	public int getBandId() {
		return bandId;
	}
	/**
	 * @param bandId the bandId to set
	 */
	public void setBandId(int bandId) {
		this.bandId = bandId;
	}
	/**
	 * @return the band
	 */
	public String getBand() {
		return band;
	}
	/**
	 * @param band the band to set
	 */
	public void setBand(String band) {
		this.band = band;
	}
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
	 * @return the nationwideId
	 */
	public String getNationwideId() {
		return nationwideId;
	}
	/**
	 * @param nationwideId the nationwideId to set
	 */
	public void setNationwideId(String nationwideId) {
		this.nationwideId = nationwideId;
	}
	/**
	 * @return the nationwideIdCreatedDate
	 */
	public Date getNationwideIdCreatedDate() {
		return nationwideIdCreatedDate;
	}
	/**
	 * @param nationwideIdCreatedDate the nationwideIdCreatedDate to set
	 */
	public void setNationwideIdCreatedDate(Date nationwideIdCreatedDate) {
		this.nationwideIdCreatedDate = nationwideIdCreatedDate;
	}
	/**
	 * @return the fgOnBoardingDate
	 */
	public Date getFgOnBoardingDate() {
		return fgOnBoardingDate;
	}
	/**
	 * @param fgOnBoardingDate the fgOnBoardingDate to set
	 */
	public void setFgOnBoardingDate(Date fgOnBoardingDate) {
		this.fgOnBoardingDate = fgOnBoardingDate;
	}
	/**
	 * @return the movementId
	 */
	public Integer getMovementId() {
		return movementId;
	}
	/**
	 * @param movementId the movementId to set
	 */
	public void setMovementId(Integer movementId) {
		this.movementId = movementId;
	}
	/**
	 * @return the workForceId
	 */
	public String getWorkForceId() {
		return workForceId;
	}
	/**
	 * @param workForceId the workForceId to set
	 */
	public void setWorkForceId(String workForceId) {
		this.workForceId = workForceId;
	}
	/**
	 * @return the scrumMaster
	 */
	public String getScrumMaster() {
		return scrumMaster;
	}
	/**
	 * @param scrumMaster the scrumMaster to set
	 */
	public void setScrumMaster(String scrumMaster) {
		this.scrumMaster = scrumMaster;
	}
	/**
	 * @return the apm
	 */
	public String getApm() {
		return apm;
	}
	/**
	 * @param apm the apm to set
	 */
	public void setApm(String apm) {
		this.apm = apm;
	}
	/**
	 * @return the pplManager
	 */
	public String getPplManager() {
		return pplManager;
	}
	/**
	 * @param pplManager the pplManager to set
	 */
	public void setPplManager(String pplManager) {
		this.pplManager = pplManager;
	}
	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return Experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		Experience = experience;
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
	 * @return the approvalStatusId
	 */
	public Integer getApprovalStatusId() {
		return approvalStatusId;
	}
	/**
	 * @param approvalStatusId the approvalStatusId to set
	 */
	public void setApprovalStatusId(Integer approvalStatusId) {
		this.approvalStatusId = approvalStatusId;
	}
	/**
	 * @return the approvalStatus
	 */
	public String getApprovalStatus() {
		return approvalStatus;
	}
	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	/**
	 * @return the releaseStatusId
	 */
	public Integer getReleaseStatusId() {
		return releaseStatusId;
	}
	/**
	 * @param releaseStatusId the releaseStatusId to set
	 */
	public void setReleaseStatusId(Integer releaseStatusId) {
		this.releaseStatusId = releaseStatusId;
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
	 * @return the attachmentId
	 */
	public Integer getAttachmentId() {
		return attachmentId;
	}
	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}
	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the teamId
	 */
	public Integer getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * @return the bsaName
	 */
	public String getBsaName() {
		return bsaName;
	}
	/**
	 * @param bsaName the bsaName to set
	 */
	public void setBsaName(String bsaName) {
		this.bsaName = bsaName;
	}
	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
	 * @return the requesterId
	 */
	public Integer getRequesterId() {
		return requesterId;
	}
	/**
	 * @param requesterId the requesterId to set
	 */
	public void setRequesterId(Integer requesterId) {
		this.requesterId = requesterId;
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
	 * @return the processorId
	 */
	public Integer getProcessorId() {
		return processorId;
	}
	/**
	 * @param processorId the processorId to set
	 */
	public void setProcessorId(Integer processorId) {
		this.processorId = processorId;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeProjHist [id=" + id + ", nationwideId=" + nationwideId + ", startDate=" + startDate
				+ ", nationwideIdCreatedDate=" + nationwideIdCreatedDate + ", fgOnBoardingDate=" + fgOnBoardingDate
				+ ", movementId=" + movementId + ", workForceId=" + workForceId + ", scrumMaster=" + scrumMaster
				+ ", apm=" + apm + ", pplManager=" + pplManager + ", Experience=" + Experience + ", comments="
				+ comments + ", skillSet=" + skillSet + ", skillSummary=" + skillSummary + ", releaseDate="
				+ releaseDate + ", approvalStatusId=" + approvalStatusId + ", approvalStatus=" + approvalStatus
				+ ", releaseStatusId=" + releaseStatusId + ", releaseStatus=" + releaseStatus
				+ ", reasonForOffboarding=" + reasonForOffboarding + ", attachmentId=" + attachmentId + ", employeeId="
				+ employeeId + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", passportNumber=" + passportNumber + ", email=" + email
				+ ", countryId=" + countryId + ", countryName=" + countryName + ", location=" + location + ", roleId="
				+ roleId + ", role=" + role + ", rate=" + rate + ", teamId=" + teamId + ", teamName=" + teamName
				+ ", bsaName=" + bsaName + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", requesterId=" + requesterId + ", requesterName=" + requesterName + ", processorId=" + processorId
				+ ", processorName=" + processorName + ", movement=" + movement + ", fileName=" + fileName
				+ ", fileData=" + fileData + ", bandId=" + bandId + ", band=" + band + "]";
	}
}
