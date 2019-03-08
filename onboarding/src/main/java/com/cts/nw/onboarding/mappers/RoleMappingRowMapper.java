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
		roleMapping.setRoleMappingID(rs.getInt("ROLEMAPPINGID"));
		roleMapping.setRateValue(rs.getString("RATEVALUE"));
		roleMapping.setRoleId(rs.getInt("ROLEID"));
		roleMapping.setCountryMappingID(rs.getInt("COUNTRYMAPPINGID"));
		return roleMapping;
	}
}
