/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeProjHist;

/**
 * @author 616550
 *
 */
	public class EmployeeProjHistRowMapper extends AbstractRowMapper implements RowMapper<EmployeeProjHist> {

		@Override
		public EmployeeProjHist mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeProjHist employeeProjHist = new EmployeeProjHist();
			
			employeeProjHist.setId(rs.getInt("ID"));
			employeeProjHist.setStartDate(rs.getDate("STARTDATE"));
			employeeProjHist.setNationwideId(rs.getString("NATIONWIDEID"));	
			employeeProjHist.setNationwideIdCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));
			employeeProjHist.setFgOnBoardingDate(rs.getDate("FGONBOARDINGDATE"));
			employeeProjHist.setMovementId(rs.getInt("MOVEMENTID"));
			employeeProjHist.setWorkForceId(rs.getString("WORKFORCEID"));
			employeeProjHist.setScrumMaster(rs.getString("SCRUMMASTER"));
			employeeProjHist.setApm(rs.getString("APM"));
			employeeProjHist.setPplManager(rs.getString("PPLMANAGER"));
			employeeProjHist.setExperience(rs.getInt("EXPERIENCE"));
			employeeProjHist.setComments(rs.getString("COMMENTS"));
			employeeProjHist.setSkillSet(rs.getString("SKILLSET"));
			employeeProjHist.setSkillSummary(rs.getString("SKILLSUMMARY"));
			employeeProjHist.setReleaseDate(rs.getDate("RELEASEDATE"));
			employeeProjHist.setApprovalStatusId(rs.getInt("APPROVALSTATUSID"));
			employeeProjHist.setApprovalStatus(rs.getString("APPROVALSTATUS"));
			employeeProjHist.setReleaseStatusId(rs.getInt("RELEASESTATUSID"));
			employeeProjHist.setReleaseStatus(rs.getString("RELEASESTATUS"));
			employeeProjHist.setReasonForOffboarding(rs.getInt("REASONFOROFFBOARDING"));
			employeeProjHist.setAttachmentId(rs.getInt("ATTACHMENTID"));
			employeeProjHist.setEmployeeId(rs.getInt("EMPLOYEEID"));
			employeeProjHist.setName(rs.getString("NAME"));
			employeeProjHist.setFirstName(rs.getString("FIRSTNAME"));
			employeeProjHist.setLastName(rs.getString("LASTNAME"));
			employeeProjHist.setDateOfBirth(rs.getDate("DOB"));
			employeeProjHist.setPassportNumber(rs.getString("PASSPORTNUMBER"));
			employeeProjHist.setEmail(rs.getString("EMAIL"));
			employeeProjHist.setCountryId(rs.getInt("COUNTRYID"));
			employeeProjHist.setCountryName(rs.getString("COUNTRYNAME"));
			employeeProjHist.setLocation(rs.getString("LOCATION"));
			employeeProjHist.setRoleId(rs.getInt("ROLEID"));
			employeeProjHist.setRole(rs.getString("ROLE"));
			employeeProjHist.setRate(rs.getString("RATE"));
			employeeProjHist.setTeamId(rs.getInt("TEAMID"));
			employeeProjHist.setTeamName(rs.getString("TEAMNAME"));
			employeeProjHist.setBsaName(rs.getString("BSANAME"));
			employeeProjHist.setProjectId(rs.getLong("PROJECTID"));
			employeeProjHist.setProjectName(rs.getString("PROJECTNAME"));
			employeeProjHist.setRequesterId(rs.getInt("REQUESTERID"));
			employeeProjHist.setRequesterName(rs.getString("REQUESTERNAME"));
			employeeProjHist.setProcessorId(rs.getInt("PROCESSORID"));
			employeeProjHist.setProcessorName(rs.getString("PROCESSORNAME"));
			employeeProjHist.setBandId(rs.getInt("BAND"));
			
			/*if (hasColumn(rs, "ID") == true) {
				employeeProjHist.setId(rs.getInt("ID"));
			}
			if (hasColumn(rs, "STARTDATE") == true) {
				employeeProjHist.setStartDate(rs.getDate("STARTDATE"));
			}
			if (hasColumn(rs, "NATIONWIDEID") == true) {
				employeeProjHist.setNationwideId(rs.getString("NATIONWIDEID"));				
			}
			if (hasColumn(rs, "NATIONWIDEIDCREATEDDATE") == true) {
				employeeProjHist.setNationwideIdCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));
			}
			if (hasColumn(rs, "FGONBOARDINGDATE") == true) {
				employeeProjHist.setFgOnBoardingDate(rs.getDate("FGONBOARDINGDATE"));
			}			
			if (hasColumn(rs, "MOVEMENTID") == true) {
				employeeProjHist.setMovementId(rs.getInt("MOVEMENTID"));
			}
			if (hasColumn(rs, "WORKFORCEID") == true) {
				employeeProjHist.setWorkForceId(rs.getString("WORKFORCEID"));
			}
			if (hasColumn(rs, "SCRUMMASTER") == true) {
				employeeProjHist.setScrumMaster(rs.getString("SCRUMMASTER"));
			}
			if (hasColumn(rs, "APM") == true) {
				employeeProjHist.setApm(rs.getString("APM"));
			}
			if (hasColumn(rs, "PPLMANAGER") == true) {
				employeeProjHist.setPplManager(rs.getString("PPLMANAGER"));
			}
			if (hasColumn(rs, "EXPERIENCE") == true) {
				employeeProjHist.setExperience(rs.getInt("EXPERIENCE"));
			}
			if (hasColumn(rs, "COMMENTS") == true) {
				employeeProjHist.setComments(rs.getString("COMMENTS"));
			}
			if (hasColumn(rs, "SKILLSET") == true) {
				employeeProjHist.setSkillSet(rs.getString("SKILLSET"));
			}
			if (hasColumn(rs, "SKILLSUMMARY") == true) {
				employeeProjHist.setSkillSummary(rs.getString("SKILLSUMMARY"));
			}
			if (hasColumn(rs, "RELEASEDATE") == true) {
				employeeProjHist.setReleaseDate(rs.getDate("RELEASEDATE"));
			}
			if (hasColumn(rs, "APPROVALSTATUSID") == true) {
				employeeProjHist.setApprovalStatusId(rs.getInt("APPROVALSTATUSID"));
			}
			if (hasColumn(rs, "APPROVALSTATUS") == true) {
				employeeProjHist.setApprovalStatus(rs.getString("APPROVALSTATUS"));
			}
			if (hasColumn(rs, "RELEASESTATUSID") == true) {
				employeeProjHist.setReleaseStatusId(rs.getInt("RELEASESTATUSID"));
			}
			if (hasColumn(rs, "RELEASESTATUS") == true) {
				employeeProjHist.setReleaseStatus(rs.getString("RELEASESTATUS"));
			}
			if (hasColumn(rs, "REASONFOROFFBOARDING") == true) {
				employeeProjHist.setReasonForOffboarding(rs.getInt("REASONFOROFFBOARDING"));
			}
			if (hasColumn(rs, "ATTACHMENTID") == true) {
				employeeProjHist.setAttachmentId(rs.getInt("ATTACHMENTID"));
			}
			if (hasColumn(rs, "EMPLOYEEID") == true) {
				employeeProjHist.setEmployeeId(rs.getInt("EMPLOYEEID"));
			}
			if (hasColumn(rs, "NAME") == true) {
				employeeProjHist.setName(rs.getString("NAME"));
			}
			if (hasColumn(rs, "FIRSTNAME") == true) {
				employeeProjHist.setFirstName(rs.getString("FIRSTNAME"));
			}
			if (hasColumn(rs, "LASTNAME") == true) {
				employeeProjHist.setLastName(rs.getString("LASTNAME"));
			}
			if (hasColumn(rs, "DOB") == true) {
				employeeProjHist.setDateOfBirth(rs.getDate("DOB"));
			}
			if (hasColumn(rs, "PASSPORTNUMBER") == true) {
				employeeProjHist.setPassportNumber(rs.getString("PASSPORTNUMBER"));
			}
			if (hasColumn(rs, "EMAIL") == true) {
				employeeProjHist.setEmail(rs.getString("EMAIL"));
			}
			if (hasColumn(rs, "COUNTRYID") == true) {
				employeeProjHist.setCountryId(rs.getInt("COUNTRYID"));
			}
			if (hasColumn(rs, "COUNTRYNAME") == true) {
				employeeProjHist.setCountryName(rs.getString("COUNTRYNAME"));
			}
			if (hasColumn(rs, "LOCATION") == true) {
				employeeProjHist.setLocation(rs.getString("LOCATION"));
			}
			if (hasColumn(rs, "ROLEID") == true) {
				employeeProjHist.setRoleId(rs.getInt("ROLEID"));
			}
			if (hasColumn(rs, "ROLE") == true) {
				employeeProjHist.setRole(rs.getString("ROLE"));
			}
			if (hasColumn(rs, "RATE") == true) {
				employeeProjHist.setRate(rs.getString("RATE"));
			}
			if (hasColumn(rs, "TEAMID") == true) {
				employeeProjHist.setTeamId(rs.getInt("TEAMID"));
			}
			if (hasColumn(rs, "TEAMNAME") == true) {
				employeeProjHist.setTeamName(rs.getString("TEAMNAME"));
			}
			if (hasColumn(rs, "BSANAME") == true) {
				employeeProjHist.setBsaName(rs.getString("BSANAME"));
			}
			if (hasColumn(rs, "PROJECTID") == true) {
				employeeProjHist.setProjectId(rs.getLong("PROJECTID"));
			}
			if (hasColumn(rs, "PROJECTNAME") == true) {
				employeeProjHist.setProjectName(rs.getString("PROJECTNAME"));
			}
			if (hasColumn(rs, "REQUESTERID") == true) {
				employeeProjHist.setRequesterId(rs.getInt("REQUESTERID"));
			}
			if (hasColumn(rs, "REQUESTERNAME") == true) {
				employeeProjHist.setRequesterName(rs.getString("REQUESTERNAME"));
			}
			if (hasColumn(rs, "PROCESSORID") == true) {
				employeeProjHist.setProcessorId(rs.getInt("PROCESSORID"));
			}
			if (hasColumn(rs, "PROCESSORNAME") == true) {
				employeeProjHist.setProcessorName(rs.getString("PROCESSORNAME"));
			}	
			if (hasColumn(rs, "BAND") == true) {
				employeeProjHist.setBandId(rs.getInt("BAND")); 
			}	*/
			return employeeProjHist;
		}

	}
