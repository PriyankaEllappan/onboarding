/**
 * 
 */
package com.cts.nw.onboarding.constants;

/**
 * @author 656579
 *
 */
public class QueryConstants {

	 public static final String EMPLOYEEMASTER_SELECT = "SELECT ID,NAME,FIRSTNAME,LASTNAME,EMAIL,DOB,PASSPORTNUMBER FROM EMPLOYEEMASTER";
	 public static final String EMPLOYEEMASTER_INSERT = "INSERT INTO EMPLOYEEMASTER (ID, NAME, FIRSTNAME, LASTNAME, DOB, PASSPORTNUMBER,EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)";
	 public static final String EMPLOYEEMASTER_UPDATE = "UPDATE EMPLOYEEMASTER SET NAME =?, FIRSTNAME =? , LASTNAME =? , DOB =? , PASSPORTNUMBER =? ,EMAIL =?";
	 
	 public static final String EMPPROJINFO_SELECT = "";
	 public static final String EMPPROJINFO_INSERT = "";
	 public static final String EMPPROJINFO_UPDATE = "";
	 
	 public static final String RELEASESTATUS_SELECT = "";
	 public static final String RELEASESTATUS_INSERT = "";
	 public static final String RELEASESTATUS_UPDATE = "";
	 
	 public static final String RELEASESUMMARY_SELECT = "";
	 public static final String RELEASESUMMARY_INSERT = "";
	 public static final String RELEASESUMMARY_UPDATE = "";
	 
	 public static final String TEAMHIERARCHY_SELECT = "";
	 public static final String PROJHIERARCHY_SELECT = "";
	 
	
}
