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
public class TeamsRowMapper extends AbstractRowMapper implements RowMapper<Teams>{

	@Override
	public Teams mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teams team = new Teams();
		if (hasColumn(rs, "ID") == true) {
			team.setId(rs.getInt("ID"));
		}
		if (hasColumn(rs, "TEAMNAME") == true) {
			team.setTeamName(rs.getString("TEAMNAME"));
		}
		if (hasColumn(rs, "PROJECTMAPID") == true) {
			team.setProjMapId(rs.getInt("PROJECTMAPID"));
		}
		if (hasColumn(rs, "STATUS") == true) {
			team.setStatus(rs.getString("STATUS"));
		}
		return team;
	}
	
}
