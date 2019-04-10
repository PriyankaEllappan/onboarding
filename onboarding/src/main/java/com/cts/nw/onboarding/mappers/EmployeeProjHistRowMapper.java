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
	public class EmployeeProjHistRowMapper implements RowMapper<EmployeeProjHist> {

		@Override
		public EmployeeProjHist mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeProjHist employeeProjHist = new EmployeeProjHist();
			employeeProjHist.setId(rs.getInt("ID"));
			employeeProjHist.setStartDate(rs.getDate("STARTDATE"));
			employeeProjHist.setNationwideId(rs.getString("NATIONWIDEID"));	
			employeeProjHist.setNationwideIdCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));
			employeeProjHist.setFgOnBoardingDate(rs.getDate("FGONBOARDINGDATE"));
			employeeProjHist.setMovementId(rs.getString("MOVEMENTID"));
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
			employeeProjHist.setBsaId(rs.getString("BSAID"));
			employeeProjHist.setProjectMappingId(rs.getInt("PROJECTMAPPINGID"));
			employeeProjHist.setProjectId(rs.getLong("PROJECTID"));
			employeeProjHist.setProjectName(rs.getString("PROJECTNAME"));
			employeeProjHist.setRequesterId(rs.getInt("REQUESTERID"));
			employeeProjHist.setRequesterName(rs.getString("REQUESTERNAME"));
			employeeProjHist.setProcessorId(rs.getInt("PROCESSORID"));
			employeeProjHist.setProcessorName(rs.getString("PROCESSORNAME"));
			employeeProjHist.setBandId(rs.getString("BAND"));
			employeeProjHist.setOnboardRequester(rs.getString("ONBOARDREQUESTER"));
			employeeProjHist.setOffboardRequester(rs.getString("OFFBOARDREQUESTER"));
			employeeProjHist.setOffboardProcessor(rs.getString("OFFBOARDPROCESSOR"));
			employeeProjHist.setOverriddenRate(rs.getString("OVERRIDDENRATE"));
			employeeProjHist.setIsRateOverride(rs.getInt("ISRATEOVERRIDE"));
			employeeProjHist.setIsMCAProject(rs.getInt("MCAFLAG"));
			return employeeProjHist;
		}

	}
