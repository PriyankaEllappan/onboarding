/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
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

	@Autowired
	EmployeeProjHistDAO employeeProjHistDAO;

	@Autowired
	MailService mailService;
	
	@Override
	public EmployeeMaster getResourceByID(String employeeid) {
		try{
			return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeid);
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
	
	@Override
	public EmployeeProjHist addNewProject(EmployeeProjHist employeeProjJson) {
		try {
			Integer rowsAffected = 0;
			rowsAffected = employeeProjHistDAO.addEmployeeProjectInfo(employeeProjJson);
			if (rowsAffected > 0) {
				mailService.onBoardingInitiated(employeeProjJson);
				return employeeProjJson;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<EmployeeProjHist> checkActiveAssignments(String employeeid) {
		try {
			return employeeProjHistDAO.checkActiveAssignments(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	
}
