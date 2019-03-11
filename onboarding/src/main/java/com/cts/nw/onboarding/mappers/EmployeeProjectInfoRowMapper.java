package com.cts.nw.onboarding.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeProjectInfo;


public class EmployeeProjectInfoRowMapper implements RowMapper<EmployeeProjectInfo>{

	@Override
	public EmployeeProjectInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeProjectInfo employeeProjectInfo = new EmployeeProjectInfo();
		employeeProjectInfo.setId(rs.getInt("ID"));
		employeeProjectInfo.setEmployeeID(rs.getInt("EMPLOYEEID"));
		employeeProjectInfo.setTeam(rs.getInt("TEAM"));
		employeeProjectInfo.setRole(rs.getInt("ROLE"));
		employeeProjectInfo.setCountry(rs.getInt("COUNTRY"));
		employeeProjectInfo.setStartDate(rs.getDate("STARTDATE"));
		employeeProjectInfo.setNationwideID(rs.getString("NATIONWIDEID"));
		employeeProjectInfo.setNationwideidCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));
		employeeProjectInfo.setFgOnboardingDate(rs.getDate("FGONBOARDINGDATE"));
		employeeProjectInfo.setMovementID(rs.getInt("MOVEMENTID"));
		employeeProjectInfo.setWorkforceID(rs.getString("WORKFORCEID"));
		employeeProjectInfo.setAttachmentID(rs.getInt("ATTACHMENTID"));
		employeeProjectInfo.setComments(rs.getString("COMMENTS"));
		employeeProjectInfo.setSkillSet(rs.getString("SKILLSET"));
		employeeProjectInfo.setSkillSummary(rs.getString("SKILLSUMMARY"));
		employeeProjectInfo.setApprovalStatus(rs.getInt("APPROVALSTATUS"));
		employeeProjectInfo.setReleaseStatus(rs.getInt("RELEASESTATUS"));
		employeeProjectInfo.setReleaseDate(rs.getDate("RELEASEDATE"));
		employeeProjectInfo.setReasonForOffboarding(rs.getInt("REASONFOROFFBOARDING"));
		return employeeProjectInfo;
	}
}