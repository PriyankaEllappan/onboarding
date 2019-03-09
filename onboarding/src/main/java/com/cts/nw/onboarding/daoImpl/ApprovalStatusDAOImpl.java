/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.dao.ApprovalStatusDAO;
import com.cts.nw.onboarding.mappers.ApprovalStatusRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository

public class ApprovalStatusDAOImpl implements ApprovalStatusDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ApprovalStatus getApprovalStatusID(String approvalStatus) {
		String allApprovalStatusInfo = "SELECT APS.ID AS APPROVALSTATUSID, APS.STATUS AS APPROVALSTATUSSTATUS FROM "
				+ "APPROVALSTATUS APS WHERE APS.STATUS = ?";
		try {
			RowMapper<ApprovalStatus> rowMapper = new ApprovalStatusRowMapper();
			return this.jdbcTemplate.queryForObject(allApprovalStatusInfo, rowMapper,approvalStatus);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}