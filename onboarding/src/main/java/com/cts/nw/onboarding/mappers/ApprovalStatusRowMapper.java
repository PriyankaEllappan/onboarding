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

public class ApprovalStatusRowMapper implements RowMapper<ApprovalStatus>{

	
	@Override
	public ApprovalStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApprovalStatus approvalStatus = new ApprovalStatus();
		approvalStatus.setId(rs.getInt("APPROVALSTATUSID"));
		approvalStatus.setStatus(rs.getString("APPROVALSTATUSSTATUS"));
		return approvalStatus;
	}

}