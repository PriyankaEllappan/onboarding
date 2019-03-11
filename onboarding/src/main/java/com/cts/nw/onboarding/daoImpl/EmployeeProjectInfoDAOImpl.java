package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.dao.EmployeeProjectInfoDAO;
import com.cts.nw.onboarding.mappers.EmployeeProjectInfoRowMapper;

@Transactional
@Repository
public class EmployeeProjectInfoDAOImpl implements EmployeeProjectInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EmployeeProjectInfo> getAllEmployeeProjectInfo() {
		   String sql = "SELECT * FROM EmployeeProjectInfo";
		   RowMapper<EmployeeProjectInfo> rowMapper = new EmployeeProjectInfoRowMapper();
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public int addEmployeeProjectInfo(EmployeeProjectInfo employeeProjectInfo) {
		String sql = "INSERT INTO EMPLOYEEPROJECTINFO (ID, EMPLOYEEID, TEAM, ROLE, COUNTRY, STARTDATE, NATIONWIDEID, NATIONWIDEIDCREATEDDATE, FGONBOARDINGDATE,MOVEMENTID, WORKFORCEID, ATTACHMENTID, COMMENTS, SKILLSET, SKILLSUMMARY, APPROVALSTATUS, RELEASESTATUS, RELEASEDATE, REASONFOROFFBOARDING) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    return jdbcTemplate.update(sql, employeeProjectInfo.getId(), employeeProjectInfo.getEmployeeID(), employeeProjectInfo.getTeam(), employeeProjectInfo.getRole(), employeeProjectInfo.getCountry(), employeeProjectInfo.getStartDate(), employeeProjectInfo.getNationwideID(), employeeProjectInfo.getNationwideidCreatedDate(), employeeProjectInfo.getFgOnboardingDate(), employeeProjectInfo.getMovementID(), employeeProjectInfo.getWorkforceID(), employeeProjectInfo.getAttachmentID(), employeeProjectInfo.getComments(), employeeProjectInfo.getSkillSet(), employeeProjectInfo.getSkillSummary(), employeeProjectInfo.getApprovalStatus(), employeeProjectInfo.getReleaseStatus(), employeeProjectInfo.getReleaseDate(), employeeProjectInfo.getReasonForOffboarding());
	}
}
