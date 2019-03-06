package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.Teams;

public class TeamsRowMapper implements RowMapper<Teams>{

	
	@Override
	public Teams mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teams teams = new Teams();
		teams.setId(rs.getInt("ID"));
		teams.setTeamName(rs.getString("TEAMNAME"));
		return teams;
	}

}