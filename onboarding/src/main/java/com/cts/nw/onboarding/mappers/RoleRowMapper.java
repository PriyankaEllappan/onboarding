/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.Roles;

/**
 * @author 616550
 *
 */
public class RoleRowMapper implements RowMapper<Roles>{

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles roles = new Roles();
		roles.setId(rs.getInt("ID"));
		roles.setRole(rs.getString("ROLE"));
		return roles;
	}
}


