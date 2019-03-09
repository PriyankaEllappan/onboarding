/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeActiveAssignment;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.dao.EmployeeActiveAssignmentDAO;
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
	
	@Autowired
    EmployeeActiveAssignmentDAO employeeActiveAssignmentDAO;
	
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#checkEmployeeAvailability(java.lang.String)
	 */
	@Override
	public EmployeeMaster checkEmployeeAvailability(String empid) {
		Integer employeeId;
		employeeId = Integer.parseInt(empid);
		System.out.println("Employee to be found:" + employeeId);
		return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeId);
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#addNewResource(com.cts.nw.onboarding.bo.EmployeeMaster)
	 */
	@Override
	public EmployeeMaster addNewResource(EmployeeMaster employee) {
		Integer rowsAffected = 0;
		rowsAffected = employeeMasterDAO.addEmployeeMaster(employee);
		if (rowsAffected > 0) {
			return employee;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#populateRequesterForm(int)
	 */
	@Override
	public EmployeeMaster populateRequesterForm(int empid) {
		return employeeMasterDAO.getEmployeeMasterDetailsByID(empid);
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#addNewProject(com.cts.nw.onboarding.bo.EmployeeProjectInfo)
	 */
	@Override
	public EmployeeProjectInfo addNewProject(EmployeeProjectInfo employeeProjJson) {
		Integer rowsAffected = 0;
		rowsAffected = employeeProjectInfoDAO.addEmployeeProjectInfo(employeeProjJson);
		if (rowsAffected > 0) {
			return employeeProjJson;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.RequesterService#checkforActiveAssignment(java.lang.String)
	 */
	@Override
	public List<EmployeeActiveAssignment> checkforActiveAssignment(String empid) {
		Integer employeeId;
		employeeId = Integer.parseInt(empid);
		return employeeActiveAssignmentDAO.getActiveAssignmentDetails(employeeId);
	}

	
	
}
