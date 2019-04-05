/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.LDAPService;
import com.cts.nw.onboarding.service.ResourceService;

/**
 * @author 656579
 *
 */
@Service
public class ResoureServiceImpl implements ResourceService{

	@Autowired
	LDAPService lDAPService;
	
	@Autowired
	EmployeeMasterDAO employeeMasterDAO;
	
	@Override
	public EmployeeDetails getEmployee(String empId) throws CustomException {
		try{
			return lDAPService.getEmployee(empId);
		}catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public List<EmployeeMaster> getAllResources() throws CustomException {
		try{
			return employeeMasterDAO.getAllEmployeeMasterDetails();
		}catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}

}
