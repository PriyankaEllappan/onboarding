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

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getAllEmployeeProjectInfo()
	 */
	@Override
	public List<EmployeeProjHist> getAllEmployeeProjectInfo() {
		try {
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(QueryConstants.EMPPROJHIST_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#addEmployeeProjectInfo(com.cts.nw.onboarding.bo.EmployeeProjHist)
	 */
	@Override
	public Integer addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist) {
		try{
			return jdbcTemplate.update(QueryConstants.EMPPROJHIST_INSERT,employeeProjectHist.getId(),employeeProjectHist.getEmployeeId(),employeeProjectHist.getProjectMappingId(),employeeProjectHist.getTeamId(),employeeProjectHist.getRoleId(),
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

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getRecordsPerProcessortoOnboard(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid) {
		try {
			String whereClause = " WHERE PR.PROCESSORID = ? AND EPH.APPROVALSTATUS IN (1,2)";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,processorid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getRecordsPerProcessortoOffboard(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid) {
		try {
			String whereClause = " WHERE PR.PROCESSORID = ? AND EPH.RELEASESTATUS = 2";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,processorid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getSpecificEmployeeProjectHist(java.lang.String)
	 */
	@Override
	public EmployeeProjHist getSpecificEmployeeProjectHist(String empProjHistId) {
		try {
			String whereClause = " WHERE EPH.ID = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper, empProjHistId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getEmployeestobeReleased()
	 */
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

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getEmployeestobeReleasedbyTeam(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2) AND EPH.TEAM = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,teamId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getEmployeestobeReleasedbyProj(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyProj(String projectId) {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2) AND PM.PROJECTID = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,projectId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public Integer offboardEmployee(EmployeeProjHist employeeProjectHist,Integer Id) {
		try{
			System.out.println(employeeProjectHist.toString());
			return jdbcTemplate.update(QueryConstants.OFFBOARDDPROCESS_UPDATE,employeeProjectHist.getReleaseStatusId(),employeeProjectHist.getReleaseDate(),
					employeeProjectHist.getReasonForOffboarding(),Id);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#updateSpecificEmployeeProjectHist(com.cts.nw.onboarding.bo.EmployeeProjHist)
	 */
	@Override
	public Integer updateSpecificEmployeeProjectHist(EmployeeProjHist employeeProjectHist) {
		try{
			return jdbcTemplate.update(QueryConstants.EMPPROJHIST_UPDATE,employeeProjectHist.getEmployeeId(),employeeProjectHist.getProjectMappingId(),employeeProjectHist.getTeamId(),employeeProjectHist.getRoleId(),
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

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#updateSpecificEmployeeProjectHist(com.cts.nw.onboarding.bo.EmployeeProjHist)
	 */
	@Override
	public Integer onBoardEmployee(EmployeeProjHist employeeProjectHist) {
		try{
			return jdbcTemplate.update(QueryConstants.ONBOARDPROCESS_UPDATE,employeeProjectHist.getNationwideId(),employeeProjectHist.getNationwideIdCreatedDate(),
					employeeProjectHist.getFgOnBoardingDate(),employeeProjectHist.getWorkForceId(),employeeProjectHist.getScrumMaster(),employeeProjectHist.getApm(),
					employeeProjectHist.getPplManager(),employeeProjectHist.getBandId(),employeeProjectHist.getAttachmentId(),employeeProjectHist.getComments(),
					employeeProjectHist.getApprovalStatusId(),employeeProjectHist.getId());
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#checkActiveAssignments(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getEmployeesPerRequester(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getEmployeesPerRequester(String requesterId) {
		try {
			String whereClause = " WHERE RQ.REQUESTERID = ? ";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper,requesterId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
