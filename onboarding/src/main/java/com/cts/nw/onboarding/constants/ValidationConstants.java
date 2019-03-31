/**
 * 
 */
package com.cts.nw.onboarding.constants;

/**
 * @author 656579
 *
 */
public class ValidationConstants {
	
	/*Employee Master Validation Errors*/

	public static final String EMPID_ERR = "Employee ID can't be null or negative";

	public static final String FNAME_ERR = "First Name can't be null and can only contain alphabets";

	public static final String LNAME_ERR = "Last Name can't be null and can only contain alphabets";

	public static final String NAME_ERR = "Employee Name can't be null and can only contain alphabets";

	public static final String PASSPORT_ERR = "Passport or SSN Number should be numeric and 4 digits long";

	public static final String DOB_ERR = "Date of Birth can't be empty and can be past date";

	public static final String EMAIL_ERR = "Email ID format is invalid";

	/*Employee Project History Validation Errors*/
	
	public static final String TEAMNAME_ERR = "Team Name can't be null and can only contain alphabets";
	
	public static final String STRDATE_ERR = "StartDate can't be empty";
	
	public static final String EXP_ERR = "Experience can't be null and can only contain numbers";
	
	public static final String SKILL_ERR = "SkillSet can't be null and can only contain alphabets";
	
	public static final String SUMMARY_ERR = "SkillSummary can't be null and can only contain alphabets";
	
	public static final String APM_ERR = "APM can only contain alphabets";
	
	public static final String SCRUMMASTER_ERR = "ScrumMaster can only contain alphabets";
	
	public static final String PPL_ERR = "PPLManager can only contain alphabets";
	
	public static final String NWID_ERR = "NationwideId can only contains alphanumeric";
	
	public static final String COMMENTS_ERR = "Comments can contain alphanemeric and special characters(, .)";
		
	public static final String WORKFORCE_ERR = "WorkForceId can only contains alphanumeric";

	public static final String RELEASESTATUSVALIDATION = "Release Status can't be null";

	public static final String RELEASESUMMARYVALIDATION = "Release Summary can't be null";

	public static final String RELEASEDATEVALIDATION = "Release Date can't be null";

}
