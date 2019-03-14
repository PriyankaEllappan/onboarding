/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ApprovalStatus;

/**
 * @author 616550
 *
 */

public class ApprovalStatusRowMapper extends AbstractRowMapper implements RowMapper<ApprovalStatus>{

	@Override
	public ApprovalStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApprovalStatus approvalStatus = new ApprovalStatus();
		/*if (hasColumn(rs, "ID") == true) {
			approvalStatus.setId(rs.getInt("ID"));
		}
		if (hasColumn(rs, "STATUS") == true) {
			approvalStatus.setStatus(rs.getString("STATUS"));
		}*/
		approvalStatus.setId(rs.getInt("ID"));
		approvalStatus.setStatus(rs.getString("STATUS"));
		return approvalStatus;
	}

}