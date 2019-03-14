/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Service
public class RequesterServiceImpl implements RequesterService {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;

	@Override
	public EmployeeMaster getResourceByID(String employeeid) {
		int empId; 
		try{
			empId = Integer.parseInt(employeeid);
			return employeeMasterDAO.getEmployeeMasterDetailsByID(empId);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeMaster> getAllEmployees() {
		try{
			return employeeMasterDAO.getAllEmployeeMasterDetails();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeMaster addNewResource(EmployeeMaster employee) {
		try{
			Integer rowsAffected = 0;
			rowsAffected = employeeMasterDAO.addNewResource(employee);
			if (rowsAffected > 0) {
				return employee;
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		return null;
	}
	
	 
	

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#addNewProject(com.cts.nw.onboarding.bo.EmployeeProjectInfo)
	 
	@Override
	public EmployeeProjectInfo addNewProject(EmployeeProjectInfo employeeProjJson) {
		Integer rowsAffected = 0;
		rowsAffected = employeeProjectInfoDAO.addEmployeeProjectInfo(employeeProjJson);
		if (rowsAffected > 0) {
			mailService.sendRequestEmail(employeeProjJson);
			return employeeProjJson;
		}
		return null;
	}

	 (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#checkforActiveAssignment(java.lang.String)
	 
	@Override
	public List<EmployeeActiveAssignment> checkforActiveAssignment(String empid) {
		Integer employeeId;
		employeeId = Integer.parseInt(empid);
		return employeeActiveAssignmentDAO.getActiveAssignmentDetails(employeeId);
	}

	@Override
	public List<EmployeeMaster> getAllEmployees() {
		return employeeMasterDAO.getAllEmployeeMasterDetails();
	}*/

	
	
}
