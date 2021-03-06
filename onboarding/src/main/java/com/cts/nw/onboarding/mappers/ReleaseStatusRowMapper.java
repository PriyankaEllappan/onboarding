/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ReleaseStatus;

/**
 * @author 616550
 *
 */
public class ReleaseStatusRowMapper implements RowMapper<ReleaseStatus> {

	@Override
	public ReleaseStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReleaseStatus releaseStatus = new ReleaseStatus();
		releaseStatus.setId(rs.getInt("ID"));
		releaseStatus.setStatus(rs.getString("STATUS"));
		return releaseStatus;
	}
}
