/*package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.dao.ProjectMappingDAO;
import com.cts.nw.onboarding.mappers.ProjectMappingRowMapper;

@Transactional
@Repository
public class ProjectMappingDAOImpl implements ProjectMappingDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProjectMapping> getAllProjectMapping() {
		   String sql = "SELECT * FROM ProjectMapping";
		   RowMapper<ProjectMapping> rowMapper = new ProjectMappingRowMapper();
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public List<ProjectMapping> getAllProjectMappingByProjectID(int projectid) {
		   //String sql = "SELECT * FROM ProjectMapping";
		   String sql = "SELECT * FROM ProjectMapping where PROJECTID = ?";
		   RowMapper<ProjectMapping> rowMapper = new ProjectMappingRowMapper();
		   return this.jdbcTemplate.query(sql, rowMapper, projectid);
	}

	@Override
	public int updateProjectMapping(ProjectMapping projectMapping) {
		//String sql = "UPDATE articles SET title=?, category=? WHERE articleId=?";
		//String sql = "UPDATE ProjectMapping SET PROJECTID='1000161541', PROCESSORID='413801', REQUESTERID='151531', STATUS='INACTIVE' WHERE ID="+projectMapping.getId();
		String sql = "UPDATE ProjectMapping SET PROJECTID=?, PROCESSORID=?, REQUESTERID=?, STATUS=? WHERE ID=?";
	    return jdbcTemplate.update(sql, projectMapping.getProjectID(), projectMapping.getProcessorID(), projectMapping.getRequesterID(), projectMapping.getStatus(), projectMapping.getId());
	}

	@Override
	public ProjectMapping getAllProjectMappingByID(int id) {
		   String sql = "SELECT * FROM ProjectMapping where ID = ?";
		   RowMapper<ProjectMapping> rowMapper = new ProjectMappingRowMapper();
		   return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
*/