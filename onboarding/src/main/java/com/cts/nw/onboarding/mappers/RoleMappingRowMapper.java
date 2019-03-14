/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.RoleMapping;

/**
 * @author 616550
 *
 */
public class RoleMappingRowMapper extends AbstractRowMapper implements RowMapper<RoleMapping> {

	@Override
	public RoleMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleMapping roleMapping = new RoleMapping();
		/*if (hasColumn(rs, "ID") == true) {
			roleMapping.setId(rs.getInt("ID"));
		}
		if (hasColumn(rs, "ROLEID") == true) {
			roleMapping.setRoleId(rs.getInt("ROLEID"));
		}
		if (hasColumn(rs, "RATEID") == true) {
			roleMapping.setRateId(rs.getInt("RATEID"));
		}
		if (hasColumn(rs, "RATE") == true) {
			roleMapping.setRate(rs.getString("RATE"));
		}
		if (hasColumn(rs, "COUNTRYID") == true) {
			roleMapping.setCountryId(rs.getInt("COUNTRYID"));
		}
		if (hasColumn(rs, "ROLENAME") == true) {
			roleMapping.setRole(rs.getString("ROLENAME"));
		}*/
		roleMapping.setId(rs.getInt("ID"));
		roleMapping.setRoleId(rs.getInt("ROLEID"));
		roleMapping.setRole(rs.getString("ROLENAME"));
		roleMapping.setRateId(rs.getInt("RATEID"));
		roleMapping.setRate(rs.getString("RATE"));
		roleMapping.setCountryId(rs.getInt("COUNTRYID"));
		return roleMapping;
	}

}
