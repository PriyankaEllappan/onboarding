/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Service
public class ProcessorServiceImpl implements ProcessorService {

	@Autowired
	EmployeeProjHistDAO employeeProjHistDAO;

	@Autowired
	MailService mailService;
	
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessor(String processorid) {
		return employeeProjHistDAO.getRecordsPerProcessor(processorid);
	}
	
	@Override
	public EmployeeProjHist getEmployeetoProcess(String empProjHistId) {
		return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
	}
	
	@Override
	public EmployeeProjHist processAnEmployee(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		rowsAffected = employeeProjHistDAO.updateSpecificEmployeeProjectHist(employeeProjHist);
		if(rowsAffected > 0){
			if (employeeProjHist.getApprovalStatusId() == 2) {
				mailService.onBoardingAcknowledged(employeeProjHist);
			} else if (employeeProjHist.getApprovalStatusId() == 3) {
				mailService.onBoardingCompleted(employeeProjHist);
			}
			return employeeProjHist;
		}
		return null;

	}
}
