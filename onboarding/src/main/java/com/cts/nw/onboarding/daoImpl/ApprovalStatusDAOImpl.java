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
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.ApprovalStatusDAO;
import com.cts.nw.onboarding.exception.CustomException;
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
	
	@Override
	public ApprovalStatus getApprovalStatusbyID(String id) throws CustomException {
		String whereClause=" WHERE APS.ID = ?";
		String query = QueryConstants.APPROVALSTATUS_SELECT + whereClause;
		try {
			RowMapper<ApprovalStatus> rowMapper = new ApprovalStatusRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper,id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e);
		}
	}

	@Override
	public ApprovalStatus getApprovalStatus(String status) throws CustomException {
		String whereClause=" WHERE APS.STATUS = ?";
		String query = QueryConstants.APPROVALSTATUS_SELECT + whereClause;
		try {
			RowMapper<ApprovalStatus> rowMapper = new ApprovalStatusRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper,status);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}catch(Exception e){
			throw new CustomException(e);
		}
	}

	@Override
	public List<ApprovalStatus> getAllApprovalStatus() throws CustomException {
		try {
			RowMapper<ApprovalStatus> rowMapper = new ApprovalStatusRowMapper();
			return this.jdbcTemplate.query(QueryConstants.APPROVALSTATUS_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}catch(Exception e){
			throw new CustomException(e);
		}
	}
}
