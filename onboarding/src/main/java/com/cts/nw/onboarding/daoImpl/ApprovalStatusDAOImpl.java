/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import java.util.List;

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

	String allApprovalStatusInfo = "SELECT APS.ID AS APPROVALSTATUSID, APS.STATUS AS APPROVALSTATUSSTATUS FROM "
			+ "APPROVALSTATUS APS" ;
	
	public ApprovalStatus getApprovalStatusID(String approvalStatus) {
		String getApprovalStatusID = allApprovalStatusInfo + " WHERE APS.STATUS = ? ";
		try {
			RowMapper<ApprovalStatus> rowMapper = new ApprovalStatusRowMapper();
			return this.jdbcTemplate.queryForObject(getApprovalStatusID, rowMapper,approvalStatus);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<ApprovalStatus> getAllApprovalStatus() {
		try {
			RowMapper<ApprovalStatus> rowMapper = new ApprovalStatusRowMapper();
			return this.jdbcTemplate.query(allApprovalStatusInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}