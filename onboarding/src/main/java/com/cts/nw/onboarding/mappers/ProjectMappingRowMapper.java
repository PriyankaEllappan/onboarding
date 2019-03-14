package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ProjectMapping;

/**
 * @author 616550
 *
 */

public class ProjectMappingRowMapper extends AbstractRowMapper implements RowMapper<ProjectMapping> {

	@Override
	public ProjectMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectMapping teamMapping = new ProjectMapping();
		
		/*if (hasColumn(rs, "PROJECTID") == true) {
			teamMapping.setProjectId(rs.getLong("PROJECTID"));
		}
		if (hasColumn(rs, "PROJECTNAME") == true) {
			teamMapping.setProjectName(rs.getString("PROJECTNAME"));
		}
		if (hasColumn(rs, "REQUESTERID") == true) {
			teamMapping.setRequesterId(rs.getInt("REQUESTERID"));
		}
		if (hasColumn(rs, "REQUESTERNAME") == true) {
			teamMapping.setRequesterName(rs.getString("REQUESTERNAME"));
		}
		if (hasColumn(rs, "PROCESSORID") == true) {
			teamMapping.setProcessorId(rs.getInt("PROCESSORID"));
		}
		if (hasColumn(rs, "PROCESSORNAME") == true) {
			teamMapping.setProcessorName(rs.getString("PROCESSORNAME"));
		}
		if (hasColumn(rs, "BSAID") == true) {
			teamMapping.setBsaId(rs.getInt("BSAID"));
		}
		if (hasColumn(rs, "BSANAME") == true) {
			teamMapping.setBsaName(rs.getString("BSANAME"));
		}
		if (hasColumn(rs, "PROJSTATUS") == true) {
			teamMapping.setProjStatus(rs.getString("PROJSTATUS"));
		}*/
		
		teamMapping.setProjectId(rs.getLong("PROJECTID"));
		teamMapping.setProjectName(rs.getString("PROJECTNAME"));
		teamMapping.setRequesterId(rs.getInt("REQUESTERID"));
		teamMapping.setRequesterName(rs.getString("REQUESTERNAME"));
		teamMapping.setProcessorId(rs.getInt("PROCESSORID"));
		teamMapping.setProcessorName(rs.getString("PROCESSORNAME"));
		teamMapping.setBsaId(rs.getInt("BSAID"));
		teamMapping.setBsaName(rs.getString("BSANAME"));
		teamMapping.setProjStatus(rs.getString("PROJSTATUS"));
		
		return teamMapping;
	}

}
