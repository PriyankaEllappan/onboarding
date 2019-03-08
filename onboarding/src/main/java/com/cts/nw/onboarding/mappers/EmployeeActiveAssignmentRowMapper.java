/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeActiveAssignment;

/**
 * @author 616550
 *
 */
public class EmployeeActiveAssignmentRowMapper implements RowMapper<EmployeeActiveAssignment> {

	@Override
	public EmployeeActiveAssignment mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeActiveAssignment employeeReleaseInfo = new EmployeeActiveAssignment();
		employeeReleaseInfo.setEmployeeID(rs.getInt("EMPLOYEEID"));
		employeeReleaseInfo.setProjectID(rs.getInt("PROJECTID"));
		employeeReleaseInfo.setProjectName(rs.getString("PROJECTNAME"));
		employeeReleaseInfo.setProjectStatus(rs.getString("PROJECTSTATUS"));
		employeeReleaseInfo.setRequesterID(rs.getInt("REQUESTERID"));
		employeeReleaseInfo.setRequesterName(rs.getString("REQUESTERNAME"));
		employeeReleaseInfo.setProcessorID(rs.getInt("PROCESSORID"));
		employeeReleaseInfo.setProcessorName(rs.getString("PROCESSORNAME"));
		employeeReleaseInfo.setReleaseDate(rs.getDate("RELEASEDATE"));
		employeeReleaseInfo.setReleaseStatus(rs.getString("RELEASESTATUS"));
		return employeeReleaseInfo;
	}
}
