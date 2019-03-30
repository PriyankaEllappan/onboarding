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

import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.ReleaseSummaryDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.ReleaseSummaryRowMapper;

/**
 * @author 616550
 *
 */

@Transactional
@Repository
public class ReleaseSummaryDAOImpl implements ReleaseSummaryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ReleaseSummary> getAllReleaseSummary() throws CustomException {
		try {
			String releaseSummaryInfo = QueryConstants.RELEASESUMMARY_SELECT;
			RowMapper<ReleaseSummary> rowMapper = new ReleaseSummaryRowMapper();
			return this.jdbcTemplate.query(releaseSummaryInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}

}