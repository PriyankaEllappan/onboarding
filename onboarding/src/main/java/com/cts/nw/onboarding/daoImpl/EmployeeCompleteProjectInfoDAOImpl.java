package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.dao.EmployeeCompleteProjectInfoDAO;
import com.cts.nw.onboarding.mappers.EmployeeCompleteProjectInfoRowMapper;
import com.cts.nw.onboarding.mappers.EmployeeMasterRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class EmployeeCompleteProjectInfoDAOImpl implements EmployeeCompleteProjectInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	String sql = "SELECT EM.ID AS EMPLOYEEID, PI.PROJECTID AS PROJECTID, "
			+ " EM.NAME AS NAME,     EM.FIRSTNAME AS FIRSTNAME,     EM.LASTNAME AS LASTNAME,     EM.DOB AS DOB,     EM.PASSPORTNUMBER AS PASSPORTNUMBER,     EM.EMAIL AS EMAIL,"
			+ " PI.PROJECTNAME AS PROJECTNAME, R.REQUESTERID AS REQUESTERID, R.REQUESTERNAME AS REQUESTERNAME, "
			+ "P.PROCESSORID AS PROCESSORID, P.PROCESSORNAME AS PROCESSORNAME, T.TEAMNAME AS TEAMNAME, "
			+ "T.ID AS TEAMID, BI.ID AS BSAID, BI.BSA AS BSANAME, PPLI.ID AS PPLID, PPLI.PPLNAME AS PPLNAME, "
			+ "PM.STATUS AS PROJECTMAPPINGSTATUS, PM.ID AS PROJECTMAPPINGID, TM.ID AS TEAMMAPID, TM.STATUS AS TEAMSTATUS, "
			+ "EMPPI.STARTDATE AS STARTDATE, EMPPI.NATIOWIDEID AS NATIOWIDEID, EMPPI.NATIONWIDEIDCREATEDDATE AS NATIONWIDEIDCREATEDDATE,"
			+ " EMPPI.FGONBOARDINGDATE AS FGONBOARDINGDATE, CT.ID AS COUNTRYID, CT.COUNTRY AS COUNTRYNAME, LO.ID AS LOCATIONID,"
			+ " LO.LOCATION AS LOCATIONNAME, CTM.ID AS COUNTRYMAPPINGID, EMPPI.COMMENTS AS COMMENTS, EMPPI.SKILLSET AS SKILLSET,"
			+ " EMPPI.SKILLSUMMARY AS SKILLSUMMARY, EMPPI.RELEASEDATE AS RELEASEDATE, EMPPI.WORKFORCEID AS WORKFORCEID, "
			+ "RO.ID AS ROLEID, RO.ROLE AS ROLENAME, RT.ID AS RATEID, RT.RATE AS RATENAME, RM.ID AS ROLEMAPPINGID,"
			+ " EMPPI.APPROVALSTATUS AS APPROVALSTATUS, APS.ID AS APPROVALSTATUSID, APS.STATUS AS APPROVALSTATUSMESSAGE, "
			+ "EMPPI.ATTACHMENTID AS ATTACHMENTID, ML.ID AS MAILATTACHMENTID, ML.FILENAME AS MAILATTACHMENTFILENAME, "
			+ "ML.FILEDATA AS MAILATTACHMENTFILEDATA, EMPPI.RELEASESTATUS AS RELEASESTATUS,     "
			+ "EMPPI.REASONFOROFFBOARDING AS REASONFOROFFBOARDING, RES.ID AS RELEASESUMMARYID, "
			+ "RES.SUMMARY AS RELEASESUMMARY, RS.ID AS RELEASESTATUSID, RS.STATUS AS RELEASESTATUSSTATUS, "
			+ "EMPPI.MOVEMENTID AS MOVEMENTMAPPINGID FROM REQUESTERS R     "
			+ "JOIN PROJECTMAPPING PM ON R.REQUESTERID = PM.REQUESTERID    "
			+ " JOIN PROCESSORS P ON P.PROCESSORID = PM.PROCESSORID  "
			+ "   JOIN PROJECTINFO PI ON PI.PROJECTID = PM.PROJECTID   "
			+ "  JOIN TEAMMAPPING TM ON TM.PROJECTMAPID = PM.ID     JOIN PPLMAPPING PPLM ON PPLM.ID = TM.PPLMAPID  "
			+ "   JOIN BSAINFO BI ON PPLM.BSAID = BI.ID     JOIN PPLINFO PPLI ON PPLI.ID = PPLM.PPLID   "
			+ "  JOIN TEAMS T ON T.ID = TM.TEAMID "
			+ "  JOIN EMPLOYEEPROJECTINFO EMPPI ON EMPPI.TEAM = TM.ID " 
			+ "  JOIN EMPLOYEEMASTER EM ON EM.ID = EMPPI.EMPLOYEEID     JOIN COUNTRYMAPPING CTM ON CTM.ID = EMPPI.COUNTRY   "
			+ "  JOIN COUNTRIES CT ON CT.ID = CTM.COUNTRYID     JOIN LOCATIONS LO ON LO.ID = CTM.LOCATIONID"
			+ " JOIN ROLEMAPPING RM ON EMPPI.ROLE= RM.ID JOIN ROLES RO ON RO.ID =RM.ROLEID JOIN"
			+ " RATES RT ON RT.ID =RM.RATEID JOIN APPROVALSTATUS APS ON APS.ID =EMPPI.APPROVALSTATUS "
			+ "JOIN MAILATTACHMENTS ML ON ML.ID =EMPPI.ATTACHMENTID JOIN  RELEASESTATUS RS ON RS.ID = EMPPI.RELEASESTATUS "
			+ "JOIN MOVEMENTINFO MI ON MI.ID =EMPPI.MOVEMENTID JOIN RELEASESUMMARY RES ON RES.ID = EMPPI.REASONFOROFFBOARDING ";
	
	
	
	@Override
	public List<EmployeeCompleteProjectInfo> getAllEmployeeCompleteProjectInfoDetails() {
		try {
			RowMapper<EmployeeCompleteProjectInfo> rowMapper = new EmployeeCompleteProjectInfoRowMapper();
			return this.jdbcTemplate.query(sql, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	
	@Override
	public EmployeeCompleteProjectInfo getAllEmployeeCompleteProjectInfoDetailsByID(int employeeid) {


				String sqlWithWhereClause = sql + " where EMPPI.EMPLOYEEID = ?";

		try {
			RowMapper<EmployeeCompleteProjectInfo> rowMapper = new EmployeeCompleteProjectInfoRowMapper();
			//return this.jdbcTemplate.query(sql, rowMapper);
			return this.jdbcTemplate.queryForObject(sqlWithWhereClause, rowMapper, employeeid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
