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

public class RoleRowMapper implements RowMapper<Roles> {

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles role = new Roles();
		role.setId(rs.getInt("ID"));
		role.setRoleName(rs.getString("ROLENAME"));
		return role;
	}

}