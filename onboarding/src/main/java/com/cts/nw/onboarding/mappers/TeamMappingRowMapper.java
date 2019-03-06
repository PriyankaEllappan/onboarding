package com.cts.nw.onboarding.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.TeamMapping;

public class TeamMappingRowMapper implements RowMapper<TeamMapping>{

	
	@Override
	public TeamMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeamMapping teamMapping = new TeamMapping();
		teamMapping.setId(rs.getInt("ID"));
		teamMapping.setPplMapID(rs.getInt("PPLMAPID"));
		teamMapping.setProjectMapID(rs.getInt("PROJECTMAPID"));
		teamMapping.setTeamID(rs.getInt("TEAMID"));
		
		return teamMapping;
	}

}