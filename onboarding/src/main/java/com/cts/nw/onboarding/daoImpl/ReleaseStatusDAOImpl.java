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

import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.dao.ReleaseStatusDAO;
import com.cts.nw.onboarding.mappers.ReleaseStatusRowMapper;

/**
 * @author 616550
 *
 */

@Transactional
@Repository
public class ReleaseStatusDAOImpl implements ReleaseStatusDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	String allReleaseStatusInfo = "SELECT RS.ID AS RELEASESTATUSID,RS.STATUS AS RELEASESTATUSSTATUS"
			+ "  FROM RELEASESTATUS RS";
	
	@Override
	public ReleaseStatus getReleaseStatusID(String releaseStatus){
		String releaseStatbyId = allReleaseStatusInfo + " WHERE RS.STATUS= ? ";
		try {
			RowMapper<ReleaseStatus> rowMapper = new ReleaseStatusRowMapper();
			return this.jdbcTemplate.queryForObject(releaseStatbyId, rowMapper, releaseStatus);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<ReleaseStatus> getAllReleaseStatus() {
		try {
			RowMapper<ReleaseStatus> rowMapper = new ReleaseStatusRowMapper();
			return this.jdbcTemplate.query(allReleaseStatusInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
