/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 616550
 *
 */
public class EmployeeMasterRowMapper implements RowMapper<EmployeeMaster> {

	@Override
	public EmployeeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setEmployeeId(rs.getInt("ID"));
		employeeMaster.setName(rs.getString("NAME"));
		employeeMaster.setFirstName(rs.getString("FIRSTNAME"));
		employeeMaster.setLastName(rs.getString("LASTNAME"));
		employeeMaster.setEmail(rs.getString("EMAIL"));
		employeeMaster.setDateOfBirth(rs.getDate("DOB"));
		employeeMaster.setPassportNumber(rs.getString("PASSPORTNUMBER"));
		
		return employeeMaster;
	}

}
