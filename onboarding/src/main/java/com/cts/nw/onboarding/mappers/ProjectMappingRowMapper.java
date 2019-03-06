package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ProjectMapping;

public class ProjectMappingRowMapper implements RowMapper<ProjectMapping>{

	
	@Override
	public ProjectMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectMapping projectMapping = new ProjectMapping();
		projectMapping.setId(rs.getInt("ID"));
		projectMapping.setProcessorID(rs.getInt("PROCESSORID"));
		projectMapping.setProjectID(rs.getInt("PROJECTID"));
		projectMapping.setRequesterID(rs.getInt("REQUESTERID"));
		projectMapping.setStatus(rs.getString("STATUS"));
		
		return projectMapping;
	}

}
