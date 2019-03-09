/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ReleaseSummary;

/**
 * @author 616550
 *
 */

public class ReleaseSummaryRowMapper implements RowMapper<ReleaseSummary> {

	@Override
	public ReleaseSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReleaseSummary releaseSummary = new ReleaseSummary();
		releaseSummary.setId(rs.getInt("RELEASESUMMARYID"));
		releaseSummary.setSummary(rs.getString("RELEASESUMMARYSTATUS"));
		return releaseSummary;
	}
}
