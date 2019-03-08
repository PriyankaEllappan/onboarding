/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.dao.EmployeeProjectInfoDAO;
import com.cts.nw.onboarding.responses.JsonEmployeeMasterResponse;
import com.cts.nw.onboarding.util.DateConversionUtil;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;
	
	@Autowired
	EmployeeProjectInfoDAO employeeProjectInfoDAO; 
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check", method = RequestMethod.GET)
	public String index() {
		return "request/checkResourceAvailability";
	}
	
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public @ResponseBody EmployeeMaster employeeAvailability(Model model,@PathVariable String empid) {
		Integer employeeId;
		EmployeeMaster employee = null;
		try {
			employeeId = Integer.parseInt(empid);
			System.out.println("Employee to be found:" + employeeId);
			return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/addResource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody JsonEmployeeMasterResponse createUser(@RequestBody EmployeeMaster employeeJson) {
		JsonEmployeeMasterResponse jsonResponse = null;
		try{
			Integer rowsAffected;
			rowsAffected = employeeMasterDAO.addEmployeeMaster(employeeJson);
			rowsAffected = 0;
			if( rowsAffected > 0){
				jsonResponse = new JsonEmployeeMasterResponse();
				jsonResponse.setEmployeeMaster(employeeJson);
				jsonResponse.setStatus(true);
				jsonResponse.setStatusMessage("Employee details saved successfully");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonResponse;
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/mapProject", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String addProject(@RequestBody EmployeeCompleteProjectInfo employeeCompDetails) {
		String message = "";
		try {
			EmployeeProjectInfo employeeProjectInfo = new EmployeeProjectInfo();
			Integer rowsAffected;
			//prepareEmpProjValues(employeeProjectInfo,employeeCompDetails);
			
			employeeProjectInfo.setId(3);
			employeeProjectInfo.setEmployeeID(616550);
			employeeProjectInfo.setTeam(1);
			employeeProjectInfo.setRole(1);
			employeeProjectInfo.setCountry(1);
			employeeProjectInfo.setStartDate(DateConversionUtil.convertStringToDate("yyyy-MM-dd", "1991-10-06"));

			employeeProjectInfo.setNatiowideID(null);
			employeeProjectInfo.setNationwideidCreatedDate(null);
			employeeProjectInfo.setFgOnboardingDate(null);
			employeeProjectInfo.setMovementID(null);
			employeeProjectInfo.setWorkforceID(null);

			employeeProjectInfo.setAttachmentID(1);
			employeeProjectInfo.setComments("616550 comments");
			employeeProjectInfo.setSkillSet("full stack dev");
			employeeProjectInfo.setSkillSummary("java & web");
			employeeProjectInfo.setApprovalStatus(1);
			employeeProjectInfo.setReleaseStatus(1);

			employeeProjectInfo.setReleaseDate(null);
			employeeProjectInfo.setReasonForOffboarding(null);

			rowsAffected = employeeProjectInfoDAO.addEmployeeProjectInfo(employeeProjectInfo);
			if (rowsAffected > 0) {
				message = "Project details saved successfully";
			}
			return message;
		}catch(Exception e){
			message = "Error in iserting Project Details";
			return message;
		}
	}


	/**
	 * @param employeeProjectInfo
	 * @param employeeCompDetails
	 */
	private void prepareEmpProjValues(EmployeeProjectInfo employeeProjectInfo, EmployeeCompleteProjectInfo employeeCompDetails) {
		/*employeeProjectInfo.setEmployeeID();
		employeeProjectInfo.setId();
		employeeProjectInfo.setEmployeeID();
		employeeProjectInfo.setTeam();
		employeeProjectInfo.setRole();
		employeeProjectInfo.setCountry();
		employeeProjectInfo.setStartDate();
		employeeProjectInfo.setNatiowideID();
		employeeProjectInfo.setNationwideidCreatedDate();
		employeeProjectInfo.setFgOnboardingDate();
		employeeProjectInfo.setMovementID();
		employeeProjectInfo.setWorkforceID();
		employeeProjectInfo.setAttachmentID();
		employeeProjectInfo.setComments();
		employeeProjectInfo.setSkillSet();
		employeeProjectInfo.setSkillSummary();
		employeeProjectInfo.setApprovalStatus();
		employeeProjectInfo.setReleaseStatus();
		employeeProjectInfo.setReleaseDate();
		employeeProjectInfo.setReasonForOffboarding();*/
	}
	
	
}
