/**
 * 
 */
package com.cts.nw.onboarding.constants;

/**
 * @author 656579
 *
 */
public class QueryConstants {

	 public static final String EMPLOYEEMASTER_SELECT = "SELECT EM.ID AS ID,EM.NAME AS NAME,EM.FIRSTNAME AS FIRSTNAME,EM.LASTNAME AS LASTNAME,EM.EMAIL AS EMAIL,EM.DOB AS DOB,EM.PASSPORTNUMBER AS PASSPORTNUMBER FROM EMPLOYEEMASTER EM";
	 public static final String EMPLOYEEMASTER_INSERT = "INSERT INTO EMPLOYEEMASTER (ID, NAME, FIRSTNAME, LASTNAME, DOB, PASSPORTNUMBER,EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)";
	 public static final String EMPLOYEEMASTER_UPDATE = "UPDATE EMPLOYEEMASTER SET NAME =?, FIRSTNAME =? , LASTNAME =? , DOB =? , PASSPORTNUMBER =? ,EMAIL =?";
	 public static final String COUNTRYMAPPING_SELECT = "SELECT CT.COUNTRY AS COUNTRYNAME,LI.LOCATION AS LOCATIONNAME,CTM.ID AS COUNTRYMAPPINGID FROM COUNTRYMAPPING CTM JOIN COUNTRIES CT ON CTM.COUNTRYID =CT.ID JOIN LOCATIONS LI ON CTM.LOCATIONID = LI.ID ";
	 public static final String APPROVALSTATUS_SELECT = "SELECT APS.ID AS APPROVALSTATUSID, APS.STATUS AS APPROVALSTATUSSTATUS FROM APPROVALSTATUS APS";
	 public static final String RELEASESUMMARY_SELECT = "SELECT RS.ID AS ID,RS.SUMMARY AS STATUS FROM RELEASESUMMARY RS";
	 public static final String ROLEMAPPING_SELECT = "SELECT RM.ID AS ID,RM.RATEID AS RATEID,RM.ROLEID AS ROLEID,RM.COUNTRYID AS COUNTRYID,RT.RATE AS RATE FROM ROLEMAPPING RM JOIN RATES RT ON RT.ID = RM.RATEID";
	 public static final String RELEASESTATUS_SELECT = "SELECT RS.ID AS ID,RS.STATUS AS STATUS FROM RELEASESTATUS RS";
	 public static final String PROJECTHIERARCHY_SELECT = "SELECT PI.PROJECTID AS PROJECTID,PI.PROJECTNAME AS PROJECTNAME,R.REQUESTERID AS REQUESTERID,  R.REQUESTERNAME AS REQUESTERNAME,  P.PROCESSORID AS PROCESSORID,  P.PROCESSORNAME AS PROCESSORNAME, BI.ID AS BSAID, BI.NAME AS BSANAME,PM.STATUS AS PROJSTATUS FROM PROJECTMAPPING PM  JOIN  REQUESTERS R ON R.REQUESTERID = PM.REQUESTERID JOIN  PROCESSORS P ON P.PROCESSORID = PM.PROCESSORID JOIN PROJECTINFO PI ON PI.PROJECTID = PM.PROJECTID JOIN  BSA BI ON PM.BSAID = BI.ID";
	 
	 public static final String EMPPROJHIST_SELECT = "SELECT  EPH.ID AS ID,  EPH.STARTDATE AS STARTDATE,  EPH.NATIONWIDEID AS NATIONWIDEID,  EPH.NATIONWIDEIDCREATEDDATE AS NATIONWIDEIDCREATEDDATE,  EPH.FGONBOARDINGDATE AS FGONBOARDINGDATE,  EPH.BAND AS BAND,  EPH.MOVEMENTID AS MOVEMENTID,  EPH.WORKFORCEID AS WORKFORCEID,  EPH.SCRUMMASTER AS SCRUMMASTER,  EPH.APM AS APM,  EPH.PPLMANAGER AS PPLMANAGER,  EPH.EXPERIENCE AS EXPERIENCE,  EPH.COMMENTS AS COMMENTS,  EPH.SKILLSET AS SKILLSET,  EPH.SKILLSUMMARY AS SKILLSUMMARY,  EPH.RELEASEDATE AS RELEASEDATE,  EPH.APPROVALSTATUS AS APPROVALSTATUSID,  APS.STATUS AS APPROVALSTATUS,  EPH.RELEASESTATUS AS RELEASESTATUSID,  RS.STATUS AS RELEASESTATUS,  EPH.REASONFOROFFBOARDING AS REASONFOROFFBOARDING,  EPH.ATTACHMENTID AS ATTACHMENTID,  EPH.EMPLOYEEID AS EMPLOYEEID,  EM.NAME AS NAME,  EM.FIRSTNAME AS FIRSTNAME,  EM.LASTNAME AS LASTNAME,  EM.DOB AS DOB,  EM.PASSPORTNUMBER AS PASSPORTNUMBER,  EM.EMAIL AS EMAIL,  EPH.COUNTRY AS COUNTRYID,  C.COUNTRY AS COUNTRYNAME,  L.LOCATION AS LOCATION,  EPH.ROLE AS ROLEID,  RO.ROLE AS ROLE,  RT.RATE AS RATE,  EPH.TEAM AS TEAMID,  T.TEAMNAME AS TEAMNAME,  B.NAME AS BSANAME,  PM.PROJECTID AS PROJECTID,  PF.PROJECTNAME AS PROJECTNAME,  RQ.REQUESTERID AS REQUESTERID,  RQ.REQUESTERNAME AS REQUESTERNAME,  PR.PROCESSORID AS PROCESSORID,  PR.PROCESSORNAME AS PROCESSORNAME FROM  EMPLOYEEPROJECTHISTORY EPH   JOIN  EMPLOYEEMASTER EM ON EM.ID = EPH.EMPLOYEEID   JOIN  PROJECTMAPPING PM ON PM.ID = EPH.PROJECT   JOIN  TEAMS T ON T.ID = EPH.TEAM   JOIN  BSA B ON B.ID = PM.BSAID   JOIN  PROJECTINFO PF ON PF.PROJECTID = PM.PROJECTID   JOIN  REQUESTERS RQ ON RQ.REQUESTERID = PM.REQUESTERID   JOIN  PROCESSORS PR ON PR.PROCESSORID = PM.PROCESSORID   JOIN  ROLEMAPPING RM ON RM.ID = EPH.ROLE   JOIN  ROLES RO ON RO.ID = RM.ROLEID   JOIN  RATES RT ON RT.ID = RM.RATEID   JOIN  COUNTRYMAPPING CM ON CM.ID = EPH.COUNTRY   JOIN  COUNTRIES C ON C.ID = CM.COUNTRYID   JOIN  LOCATIONS L ON L.ID = CM.LOCATIONID   JOIN  APPROVALSTATUS APS ON APS.ID = EPH.APPROVALSTATUS   JOIN  RELEASESTATUS RS ON RS.ID = EPH.RELEASESTATUS";
	 public static final String EMPPROJHIST_INSERT = "INSERT INTO EMPLOYEEPROJECTHISTORY(ID, EMPLOYEEID, PROJECT, TEAM, ROLE, COUNTRY, STARTDATE, NATIONWIDEID, NATIONWIDEIDCREATEDDATE, FGONBOARDINGDATE, MOVEMENTID, WORKFORCEID, SCRUMMASTER, APM, PPLMANAGER, BAND, EXPERIENCE, ATTACHMENTID, COMMENTS, SKILLSET, SKILLSUMMARY, APPROVALSTATUS, RELEASESTATUS, RELEASEDATE, REASONFOROFFBOARDING) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 public static final String EMPPROJHIST_UPDATE = "UPDATE EMPLOYEEPROJECTHISTORY SET EMPLOYEEID = ?, PROJECT = ?, TEAM = ?, ROLE = ?, COUNTRY = ?, STARTDATE = ?, NATIONWIDEID = ?, NATIONWIDEIDCREATEDDATE = ?, FGONBOARDINGDATE = ?, MOVEMENTID = ?, WORKFORCEID = ?, SCRUMMASTER = ?, APM = ?, PPLMANAGER = ?, BAND = ?, EXPERIENCE = ?, ATTACHMENTID = ?, COMMENTS = ?, SKILLSET = ?, SKILLSUMMARY = ?, APPROVALSTATUS = ?, RELEASESTATUS = ?, RELEASEDATE = ?, REASONFOROFFBOARDING = ? WHERE  ID = ? ";
	 
	 public static final String TEAMS_SELECT = "SELECT T.ID AS ID, T.TEAMNAME AS TEAMNAME, T.PROJECTMAPID AS PROJECTMAPID , T.STATUS AS STATUS FROM TEAMS T";
	 public static final String TEAMS_INSERT = "INSERT INTO TEAMS(ID,TEAMNAME,PROJECTMAPID,STATUS) VALUES(?,?,?,?)";
	 
	 
	 
	 
	 public static final String RELEASESTATUS_UPDATE = "";
	 public static final String RELEASESUMMARY_INSERT = "";
	 public static final String RELEASESUMMARY_UPDATE = "";
	
}
