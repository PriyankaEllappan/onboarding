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
public class EmployeeMasterRowMapper extends AbstractRowMapper implements RowMapper<EmployeeMaster> {

	@Override
	public EmployeeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeMaster employeeMaster = new EmployeeMaster();
		
		/*if (hasColumn(rs, "ID") == true) {
			employeeMaster.setEmployeeId(rs.getInt("ID"));
		}
		if (hasColumn(rs, "DOB") == true) {
			employeeMaster.setDateOfBirth(rs.getDate("DOB"));
		}
		if (hasColumn(rs, "FIRSTNAME") == true) {
			employeeMaster.setFirstName(rs.getString("FIRSTNAME"));
		}
		if (hasColumn(rs, "LASTNAME") == true) {
			employeeMaster.setLastName(rs.getString("LASTNAME"));
		}
		if (hasColumn(rs, "NAME") == true) {
			employeeMaster.setName(rs.getString("NAME"));
		}
		if (hasColumn(rs, "PASSPORTNUMBER") == true) {
			employeeMaster.setPassportNumber(rs.getString("PASSPORTNUMBER"));
		}
		if (hasColumn(rs, "EMAIL") == true) {
			employeeMaster.setEmail(rs.getString("EMAIL"));
		}*/
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
