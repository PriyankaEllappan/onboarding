package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;

public class EmployeeCompleteProjectInfoRowMapper implements RowMapper<EmployeeCompleteProjectInfo> {
	
	@Override
		public EmployeeCompleteProjectInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeCompleteProjectInfo employeeCompleteprojectInfo = new EmployeeCompleteProjectInfo();
			employeeCompleteprojectInfo.setName(rs.getString("NAME")); //EM.NAME AS NAME,
			employeeCompleteprojectInfo.setFirstName(rs.getString("FIRSTNAME"));//EM.FIRSTNAME AS FIRSTNAME,
			employeeCompleteprojectInfo.setLastName(rs.getString("LASTNAME"));//EM.LASTNAME AS LASTNAME,
			employeeCompleteprojectInfo.setDOB(rs.getDate("DOB"));//EM.DOB AS DOB,
			employeeCompleteprojectInfo.setPassportNumber(rs.getString("PASSPORTNUMBER"));//EM.PASSPORTNUMBER AS PASSPORTNUMBER, 
			employeeCompleteprojectInfo.setEmail(rs.getString("EMAIL"));//EM.EMAIL AS EMAIL, 
			employeeCompleteprojectInfo.setEmployeeMasterID(rs.getInt("EMPLOYEEID")); //EM.ID AS EMPLOYEEID, 
			
			employeeCompleteprojectInfo.setProjectInfoProjectID(rs.getInt("PROJECTID"));//PI.PROJECTID AS PROJECTID,
			employeeCompleteprojectInfo.setProjectInfoProjectName(rs.getString("PROJECTNAME"));//PI.PROJECTNAME AS PROJECTNAME,
			
			employeeCompleteprojectInfo.setRequestersRequesterID(rs.getInt("REQUESTERID"));//R.REQUESTERID AS REQUESTERID,
			employeeCompleteprojectInfo.setRequestersRequesterName(rs.getString("REQUESTERNAME"));//R.REQUESTERNAME AS REQUESTERNAME,
			
			employeeCompleteprojectInfo.setProcessorsProcessorID(rs.getInt("PROCESSORID"));//P.PROCESSORID AS PROCESSORID,
			employeeCompleteprojectInfo.setProcessorsProcessorName(rs.getString("PROCESSORNAME"));//P.PROCESSORNAME AS PROCESSORNAME,
			
			
			employeeCompleteprojectInfo.setTeamid(rs.getInt("TEAMID"));//T.ID AS TEAMID,
			employeeCompleteprojectInfo.setTeamName(rs.getString("TEAMNAME"));//T.TEAMNAME AS TEAMNAME,
			
			
			employeeCompleteprojectInfo.setBSAInfoID(rs.getInt("BSAID"));//BI.ID AS BSAID,
			employeeCompleteprojectInfo.setBSAInfoName(rs.getString("BSANAME"));//BI.BSA AS BSANAME,
			
			employeeCompleteprojectInfo.setPPLInfoID(rs.getInt("PPLID"));//PPLI.ID AS PPLID,
			employeeCompleteprojectInfo.setPPLInfoName(rs.getString("PPLNAME"));//PPLI.PPLNAME AS PPLNAME,
			
			employeeCompleteprojectInfo.setProjectMappingID(rs.getInt("PROJECTMAPPINGID"));//PM.ID AS PROJECTMAPPINGID,
			employeeCompleteprojectInfo.setProjectMappingStatus(rs.getString("PROJECTMAPPINGSTATUS"));//PM.STATUS AS PROJECTMAPPINGSTATUS,
			
			
			employeeCompleteprojectInfo.setTeamMappingID(rs.getInt("TEAMMAPID"));//TM.ID AS TEAMMAPID,
			employeeCompleteprojectInfo.setTeamMappingStatus(rs.getString("TEAMSTATUS"));//TM.STATUS AS TEAMSTATUS,
		    
			employeeCompleteprojectInfo.setStartDate(rs.getDate("STARTDATE"));//EMPPI.STARTDATE AS STARTDATE,
			employeeCompleteprojectInfo.setNatiowideID(rs.getString("NATIOWIDEID"));;//EMPPI.NATIOWIDEID AS NATIOWIDEID,
			employeeCompleteprojectInfo.setNationwideidCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));;//EMPPI.NATIONWIDEIDCREATEDDATE AS NATIONWIDEIDCREATEDDATE,
			employeeCompleteprojectInfo.setFgOnboardingDate(rs.getDate("FGONBOARDINGDATE"));//EMPPI.FGONBOARDINGDATE AS FGONBOARDINGDATE,
			
			employeeCompleteprojectInfo.setComments(rs.getString("COMMENTS"));//EMPPI.COMMENTS AS COMMENTS,
			employeeCompleteprojectInfo.setSkillSet(rs.getString("SKILLSET"));//EMPPI.SKILLSET AS SKILLSET,
			employeeCompleteprojectInfo.setSkillSummary(rs.getString("SKILLSUMMARY"));//EMPPI.SKILLSUMMARY AS SKILLSUMMARY,
			employeeCompleteprojectInfo.setApprovalStatus(rs.getInt("APPROVALSTATUS"));//EMPPI.APPROVALSTATUS AS APPROVALSTATUS, private Integer approvalStatus;
			employeeCompleteprojectInfo.setReleaseStatus(rs.getInt("RELEASESTATUS"));//EMPPI.RELEASESTATUS AS RELEASESTATUS, private Integer releaseStatus;
			employeeCompleteprojectInfo.setReleaseDate(rs.getDate("RELEASEDATE"));//EMPPI.RELEASEDATE AS RELEASEDATE, private Date releaseDate;
			employeeCompleteprojectInfo.setReasonForOffboarding(rs.getInt("REASONFOROFFBOARDING"));//EMPPI.REASONFOROFFBOARDING AS REASONFOROFFBOARDING, private Integer reasonForOffboarding;
			employeeCompleteprojectInfo.setMovementID(rs.getInt("MOVEMENTMAPPINGID"));//EMPPI.MOVEMENTID AS MOVEMENTMAPPINGID private Integer movementID;
			employeeCompleteprojectInfo.setWorkforceID(rs.getString("WORKFORCEID"));//EMPPI.WORKFORCEID AS WORKFORCEID, private String workforceID;
			employeeCompleteprojectInfo.setAttachmentID(rs.getInt("ATTACHMENTID"));//EMPPI.ATTACHMENTID AS ATTACHMENTID,private Integer attachmentID;
		    
			employeeCompleteprojectInfo.setCountryID(rs.getInt("COUNTRYID"));//CT.ID AS COUNTRYID, private Integer countryID;
			employeeCompleteprojectInfo.setCountryName(rs.getString("COUNTRYNAME"));//CT.COUNTRY AS COUNTRYNAME, private String countryName;
		    
			employeeCompleteprojectInfo.setLocationID(rs.getInt("LOCATIONID"));//LO.ID AS LOCATIONID, private Integer locationID;
			employeeCompleteprojectInfo.setLocationName(rs.getString("LOCATIONNAME"));//LO.LOCATION AS LOCATIONNAME, private String locationName;
			
			employeeCompleteprojectInfo.setCountryMappingCountryID(rs.getInt("COUNTRYMAPPINGID"));//CTM.ID AS COUNTRYMAPPINGID,
			
			employeeCompleteprojectInfo.setRoleID(rs.getInt("ROLEID"));//RO.ID AS ROLEID,  private Integer roleID;
			employeeCompleteprojectInfo.setRoleName(rs.getString("ROLENAME"));//RO.ROLE AS ROLENAME,  private String roleName;
			
			employeeCompleteprojectInfo.setRateID(rs.getInt("RATEID"));//RT.ID AS RATEID,
			employeeCompleteprojectInfo.setRateName(rs.getString("RATENAME"));//RT.RATE AS RATENAME,
			
			employeeCompleteprojectInfo.setRoleMappingID(rs.getInt("ROLEMAPPINGID"));//RM.ID AS ROLEMAPPINGID,
			
			employeeCompleteprojectInfo.setApprovalStatusID(rs.getInt("APPROVALSTATUSID"));//APS.ID AS APPROVALSTATUSID,
			employeeCompleteprojectInfo.setApprovalStatusMessage(rs.getString("APPROVALSTATUSMESSAGE"));		    //APS.STATUS AS APPROVALSTATUSMESSAGE,
		  
			
			employeeCompleteprojectInfo.setMailAttachmentid(rs.getInt("MAILATTACHMENTID"));
			employeeCompleteprojectInfo.setMailAttachmentFilename(rs.getString("MAILATTACHMENTFILENAME"));
			//employeeCompleteprojectInfo.setMailAttachmentFiledata(rs.getBytes("MAILATTACHMENTFILEDATA"));
			
			
			employeeCompleteprojectInfo.setReleaseSummaryID(rs.getInt("RELEASESUMMARYID"));
			employeeCompleteprojectInfo.setReleaseSummaryName(rs.getString("RELEASESUMMARY"));
			
			employeeCompleteprojectInfo.setReleaseStatusID(rs.getInt("RELEASESTATUSID"));
			employeeCompleteprojectInfo.setReleaseStatusStatus(rs.getString("RELEASESTATUSSTATUS"));
			
	
			return employeeCompleteprojectInfo;
		}
	}
