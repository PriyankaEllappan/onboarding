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
		ProjectMapping teamMapping = new ProjectMapping();
		teamMapping.setProjectId(rs.getLong("PROJECTID"));
		teamMapping.setProjectName(rs.getString("PROJECTNAME"));
		teamMapping.setRequesterId(rs.getInt("REQUESTERID"));
		teamMapping.setRequesterName(rs.getString("REQUESTERNAME"));
		teamMapping.setProcessorId(rs.getInt("PROCESSORID"));
		teamMapping.setProcessorName(rs.getString("PROCESSORNAME"));
		teamMapping.setBsaId(rs.getInt("BSAID"));
		teamMapping.setBsaName(rs.getString("BSANAME"));
		teamMapping.setProjStatus(rs.getString("PROJSTATUS"));
		teamMapping.setProjMapId(rs.getInt("PROJMAPID"));
		return teamMapping;
	}

}
