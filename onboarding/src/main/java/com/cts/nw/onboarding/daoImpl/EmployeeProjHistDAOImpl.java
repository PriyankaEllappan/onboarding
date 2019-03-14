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

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.mappers.EmployeeProjHistRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class EmployeeProjHistDAOImpl implements EmployeeProjHistDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<EmployeeProjHist> getAllEmployeeProjectInfo() {
		try {
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(QueryConstants.EMPPROJHIST_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist) {
		try{
			return jdbcTemplate.update(QueryConstants.EMPPROJHIST_INSERT,employeeProjectHist.getId(),employeeProjectHist.getEmployeeId(),employeeProjectHist.getProjectId(),employeeProjectHist.getTeamId(),employeeProjectHist.getRoleId(),
					employeeProjectHist.getCountryId(),employeeProjectHist.getStartDate(),employeeProjectHist.getNationwideId(),employeeProjectHist.getNationwideIdCreatedDate(),
					employeeProjectHist.getFgOnBoardingDate(),employeeProjectHist.getMovementId(),employeeProjectHist.getWorkForceId(),employeeProjectHist.getScrumMaster(),employeeProjectHist.getApm(),
					employeeProjectHist.getPplManager(),employeeProjectHist.getBandId(),employeeProjectHist.getExperience(),employeeProjectHist.getAttachmentId(),employeeProjectHist.getComments(),
					employeeProjectHist.getSkillSet(),employeeProjectHist.getSkillSummary(),employeeProjectHist.getApprovalStatusId(),employeeProjectHist.getReleaseStatusId(),employeeProjectHist.getReleaseDate(),
					employeeProjectHist.getReasonForOffboarding());
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<EmployeeProjHist> getRecordsPerProcessor(int processorid) {
		try {
			String whereClause = " WHERE PR.PROCESSORID = ? AND EPH.APPROVALSTATUS IN (1,2)";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,processorid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public EmployeeProjHist getSpecificEmployeeProjectHist(int empProjHistId) {
		try {
			String whereClause = " WHERE EPH.ID = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper, empProjHistId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleased() {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2)";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Integer updateSpecificEmployeeProjectHist(EmployeeProjHist employeeProjectHist) {
		try{
			return jdbcTemplate.update(QueryConstants.EMPPROJHIST_UPDATE,employeeProjectHist.getEmployeeId(),employeeProjectHist.getProjectId(),employeeProjectHist.getTeamId(),employeeProjectHist.getRoleId(),
					employeeProjectHist.getCountryId(),employeeProjectHist.getStartDate(),employeeProjectHist.getNationwideId(),employeeProjectHist.getNationwideIdCreatedDate(),
					employeeProjectHist.getFgOnBoardingDate(),employeeProjectHist.getMovementId(),employeeProjectHist.getWorkForceId(),employeeProjectHist.getScrumMaster(),employeeProjectHist.getApm(),
					employeeProjectHist.getPplManager(),employeeProjectHist.getBandId(),employeeProjectHist.getExperience(),employeeProjectHist.getAttachmentId(),employeeProjectHist.getComments(),
					employeeProjectHist.getSkillSet(),employeeProjectHist.getSkillSummary(),employeeProjectHist.getApprovalStatusId(),employeeProjectHist.getReleaseStatusId(),employeeProjectHist.getReleaseDate(),
					employeeProjectHist.getReasonForOffboarding(),employeeProjectHist.getId());
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<EmployeeProjHist> checkActiveAssignments(String empid) {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2) AND EMPLOYEEID = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,empid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	

}
