package com.cts.nw.onboarding.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeMaster;


public class EmployeeMasterRowMapper implements RowMapper<EmployeeMaster>{

	@Override
	public EmployeeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setDOB(rs.getDate("DOB"));
		employeeMaster.setFirstName(rs.getString("FIRSTNAME"));
		employeeMaster.setID(rs.getInt("ID"));
		employeeMaster.setLastName(rs.getString("LASTNAME"));
		employeeMaster.setName(rs.getString("NAME"));
		employeeMaster.setPassportNumber(rs.getString("PASSPORTNUMBER"));
		return employeeMaster;
	}
}