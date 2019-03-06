/*package com.cts.nw.onboarding.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.PPLMapping;
import com.cts.nw.onboarding.dao.PPLMappingDAO;
import com.cts.nw.onboarding.mappers.PPLMappingRowMapper;

@Transactional
@Repository
public class PPLMappingDAOImpl implements PPLMappingDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public PPLMapping getAllPPLMappingByID(int id) {
		   String sql = "SELECT * FROM PPLMapping where ID = ?";
		   RowMapper<PPLMapping> rowMapper = new PPLMappingRowMapper();
		   return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
*/