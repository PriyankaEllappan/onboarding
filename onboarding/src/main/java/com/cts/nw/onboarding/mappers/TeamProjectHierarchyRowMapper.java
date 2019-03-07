package com.cts.nw.onboarding.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.TeamProjectHierarchy;


public class TeamProjectHierarchyRowMapper implements RowMapper<TeamProjectHierarchy>{

	@Override
	public TeamProjectHierarchy mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeamProjectHierarchy teamSelect = new TeamProjectHierarchy();
		
		teamSelect.setProjectID(rs.getInt("PROJECTID"));
		teamSelect.setProjectName(rs.getString("PROJECTNAME"));
		teamSelect.setRequesterID(rs.getInt("REQUESTERID"));
		teamSelect.setRequesterName(rs.getString("REQUESTERNAME"));
		teamSelect.setProcessorID(rs.getInt("PROCESSORID"));
		teamSelect.setProcessorName(rs.getString("PROCESSORNAME"));
		teamSelect.setBsaID(rs.getInt("ID"));
		teamSelect.setBsa(rs.getString("BSA"));
		teamSelect.setPplID(rs.getInt("ID"));
		teamSelect.setPplName(rs.getString("PPLNAME"));
		teamSelect.setStatus(rs.getString("STATUS"));
		teamSelect.setTeamName(rs.getString("TEAMNAME"));
		return teamSelect;
	}
}