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
public class RoleMappingRowMapper implements RowMapper<RoleMapping> {

	@Override
	public RoleMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleMapping roleMapping = new RoleMapping();
		roleMapping.setId(rs.getInt("ID"));
		roleMapping.setRoleId(rs.getInt("ROLEID"));
		roleMapping.setRole(rs.getString("ROLENAME"));
		roleMapping.setRateId(rs.getInt("RATEID"));
		roleMapping.setRate(rs.getString("RATE"));
		roleMapping.setCountryId(rs.getInt("COUNTRYID"));
		return roleMapping;
	}

}
