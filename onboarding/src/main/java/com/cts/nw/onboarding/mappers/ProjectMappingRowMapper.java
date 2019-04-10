package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ProjectMapping;

/**
 * @author 616550
 *
 */

public class ProjectMappingRowMapper implements RowMapper<ProjectMapping> {

	@Override
	public ProjectMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectMapping projMapping = new ProjectMapping();
		projMapping.setProjectId(rs.getLong("PROJECTID"));
		projMapping.setProjectName(rs.getString("PROJECTNAME"));
		projMapping.setRequesterId(rs.getInt("REQUESTERID"));
		projMapping.setRequesterName(rs.getString("REQUESTERNAME"));
		projMapping.setProcessorId(rs.getInt("PROCESSORID"));
		projMapping.setProcessorName(rs.getString("PROCESSORNAME"));
		projMapping.setProjStatus(rs.getString("PROJSTATUS"));
		projMapping.setProjMapId(rs.getInt("PROJMAPID"));
		projMapping.setMcaProject(rs.getBoolean("MCAFLAG"));
		return projMapping;
	}

}
