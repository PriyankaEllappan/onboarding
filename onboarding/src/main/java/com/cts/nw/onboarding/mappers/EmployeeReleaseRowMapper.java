/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeRelease;

/**
 * @author 616550
 *
 */
public class EmployeeReleaseRowMapper implements RowMapper<EmployeeRelease> {

	@Override
	public EmployeeRelease mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeRelease employeeReleaseInfo = new EmployeeRelease();
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
