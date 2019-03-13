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
public class ReleaseSummaryRowMapper extends AbstractRowMapper implements RowMapper<ReleaseSummary> {

	@Override
	public ReleaseSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReleaseSummary releaseSummary = new ReleaseSummary();
		if (hasColumn(rs, "ID") == true) {
			releaseSummary.setId(rs.getInt("ID"));
		}
		if (hasColumn(rs, "STATUS") == true) {
			releaseSummary.setSummary(rs.getString("STATUS"));
		}
		return releaseSummary;
	}
}
