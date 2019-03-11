/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.CountryLocationMapping;

/**
 * @author 616550
 *
 */
public class CountryLocationRowMapper implements RowMapper<CountryLocationMapping>{
	@Override
	public CountryLocationMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		CountryLocationMapping countryLocationMapping = new CountryLocationMapping();
		countryLocationMapping.setEmployeeID(rs.getInt("EMPLOYEEID"));
		countryLocationMapping.setStartDate(rs.getDate("STARTDATE"));
		countryLocationMapping.setNatiowideID(rs.getString("NATIONWIDEID"));
		countryLocationMapping.setNationwideidCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));
		countryLocationMapping.setFgOnboardingDate(rs.getDate("FGONBOARDINGDATE"));
		countryLocationMapping.setMovementID(rs.getInt("MOVEMENTID"));
		countryLocationMapping.setWorkforceID(rs.getString("WORKFORCEID"));
		countryLocationMapping.setAttachmentID(rs.getInt("ATTACHMENTID"));
		countryLocationMapping.setComments(rs.getString("COMMENTS"));
		countryLocationMapping.setSkillSet(rs.getString("SKILLSET"));
		countryLocationMapping.setSkillSummary(rs.getString("SKILLSUMMARY"));
		countryLocationMapping.setApprovalStatus(rs.getInt("APPROVALSTATUS"));
		countryLocationMapping.setReleaseStatus(rs.getInt("RELEASESTATUS"));
		countryLocationMapping.setReleaseDate(rs.getDate("RELEASEDATE"));
		countryLocationMapping.setReasonForOffboarding(rs.getInt("REASONFOROFFBOARDING"));
		countryLocationMapping.setLocation(rs.getString("LOCATIONNAME"));			
		countryLocationMapping.setCountry(rs.getString("COUNTRYNAME"));
		return countryLocationMapping;
	}
}


