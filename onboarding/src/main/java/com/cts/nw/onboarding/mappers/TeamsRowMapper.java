/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.Teams;

/**
 * @author 616550
 *
 */
public class TeamsRowMapper implements RowMapper<Teams> {

	@Override
	public Teams mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teams team = new Teams();
		team.setId(rs.getInt("ID"));
		team.setTeamName(rs.getString("TEAMNAME"));
		team.setProjMapId(rs.getInt("PROJECTMAPID"));
		team.setStatus(rs.getString("STATUS"));
		return team;
	}

}
