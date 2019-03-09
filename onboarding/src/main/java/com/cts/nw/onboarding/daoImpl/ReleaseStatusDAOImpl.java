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

	@Override
	public ReleaseStatus getReleaseStatusID(String releaseStatus){
		String allReleaseStatusInfo = "SELECT RS.ID AS RELEASESTATUSID,RS.STATUS AS RELEASESTATUSSTATUS"
				+ "  FROM RELEASESTATUS RS WHERE RS.STATUS= ? ";
		
		try {
			RowMapper<ReleaseStatus> rowMapper = new ReleaseStatusRowMapper();
			return this.jdbcTemplate.queryForObject(allReleaseStatusInfo, rowMapper, releaseStatus);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
