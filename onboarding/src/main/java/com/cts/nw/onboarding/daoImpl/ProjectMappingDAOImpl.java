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

import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.ProjectMappingDAO;
import com.cts.nw.onboarding.mappers.ProjectMappingRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class ProjectMappingDAOImpl implements ProjectMappingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProjectMapping> getAllActiveProjectDetails() {
		String whereClause = " WHERE PM.STATUS = 'ACTIVE' ";
		String query = QueryConstants.PROJECTHIERARCHY_SELECT + whereClause;
		try {
			RowMapper<ProjectMapping> rowMapper = new ProjectMappingRowMapper();
			return this.jdbcTemplate.query(query, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public ProjectMapping getProcesssorPerProjectId(String projectId) {
		
		String whereClause = " WHERE PM.PROJECTID = ? AND PM.STATUS = 'ACTIVE' ";
		String query = QueryConstants.PROJECTHIERARCHY_SELECT + whereClause;
		try {
			RowMapper<ProjectMapping> rowMapper = new ProjectMappingRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper,projectId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
