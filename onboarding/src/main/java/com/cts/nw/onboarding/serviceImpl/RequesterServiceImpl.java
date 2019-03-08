/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.dao.EmployeeProjectInfoDAO;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Service
public class RequesterServiceImpl implements RequesterService {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;
	
	@Autowired
	EmployeeProjectInfoDAO employeeProjectInfoDAO; 
	
	@Override
	public EmployeeMaster checkEmployeeAvailability(String empid) {
		Integer employeeId;
		employeeId = Integer.parseInt(empid);
		System.out.println("Employee to be found:" + employeeId);
		return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeId);
	}

	@Override
	public EmployeeMaster addNewResource(EmployeeMaster employee) {
		Integer rowsAffected = 0;
		rowsAffected = employeeMasterDAO.addEmployeeMaster(employee);
		if (rowsAffected > 0) {
			return employee;
		}
		return null;
	}

	/*@Override
	public EmployeeCompleteProjectInfo populateRequesterForm(EmployeeMaster employee, int empid) {*/
		
		/*EmployeeMaster emp = employeeMasterDAO.getEmployeeMasterDetailsByID(empid);
		employee.setEmployeeID(emp.getID());
		employee.setName(emp.getName());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setPassportNumber(emp.getPassportNumber());
		employee.setEmail(emp.getEmail());
		employee.setDOB(emp.getDOB());*/
	
	@Override
	public EmployeeMaster populateRequesterForm(EmployeeMaster employee, int empid) {
	employee = employeeMasterDAO.getEmployeeMasterDetailsByID(empid);
		return employee;
	}

	@Override
	public EmployeeProjectInfo addNewProject(EmployeeProjectInfo employeeProjJson) {
		Integer rowsAffected = 0;
		rowsAffected = employeeProjectInfoDAO.addEmployeeProjectInfo(employeeProjJson);
		if (rowsAffected > 0) {
			return employeeProjJson;
		}
		return null;
	}

	
	/**
	 * @param employeeJson
	 * @return
	 *//*
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


	*//**
	 * @param employeeProjectInfo
	 * @param employeeCompDetails
	 *//*
	private void prepareEmpProjValues(EmployeeProjectInfo employeeProjectInfo, EmployeeCompleteProjectInfo employeeCompDetails) {
		employeeProjectInfo.setEmployeeID();
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
		employeeProjectInfo.setReasonForOffboarding();
	}*/
}
