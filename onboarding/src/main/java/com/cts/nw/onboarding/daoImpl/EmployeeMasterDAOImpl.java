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

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.EmployeeMasterRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class EmployeeMasterDAOImpl implements EmployeeMasterDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EmployeeMaster> getAllEmployeeMasterDetails() throws CustomException {
		try {
			RowMapper<EmployeeMaster> rowMapper = new EmployeeMasterRowMapper();
			return this.jdbcTemplate.query(QueryConstants.EMPLOYEEMASTER_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e);
		}
	}

	@Override
	public EmployeeMaster getEmployeeMasterDetailsByID(String id) throws CustomException {
		String whereClause = " WHERE ID = ? ";
		String query = QueryConstants.EMPLOYEEMASTER_SELECT + whereClause;
		try {
			RowMapper<EmployeeMaster> rowMapper = new EmployeeMasterRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper,id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e);
		}
	}

	@Override
	public Integer addNewResource(EmployeeMaster employeeMaster) throws CustomException{
		try{
			return jdbcTemplate.update(QueryConstants.EMPLOYEEMASTER_INSERT, employeeMaster.getEmployeeId(), employeeMaster.getName(), employeeMaster.getFirstName(),
					employeeMaster.getLastName(), employeeMaster.getDateOfBirth(), employeeMaster.getPassportNumber(), employeeMaster.getEmail());
		} catch(Exception e){
			throw new CustomException(e);
		}
	}
}
