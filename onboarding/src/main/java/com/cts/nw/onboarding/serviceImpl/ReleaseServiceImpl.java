/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.dao.ReleaseSummaryDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ReleaseService;

/**
 * @author 656579
 *
 */
@Service
public class ReleaseServiceImpl implements ReleaseService{

	@Autowired
	EmployeeProjHistDAO employeeProjHistDAO;

	@Autowired
	ReleaseSummaryDAO releaseSummaryDAO;
	
	@Autowired
	MailService mailService;
	
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleased(){
		return employeeProjHistDAO.getEmployeestobeReleased();
	}
	
	@Override
	public EmployeeProjHist getEmployeetoRelease(int empProjHistId) {
		return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
	}
	
	@Override
	public EmployeeProjHist releaseAnEmployee(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		rowsAffected = employeeProjHistDAO.updateSpecificEmployeeProjectHist(employeeProjHist);
		if(rowsAffected > 0){
			if (employeeProjHist.getReleaseStatusId() == 2) {
				mailService.offBoardingInitiated(employeeProjHist);
			} else if (employeeProjHist.getReleaseStatusId() == 3) {
				mailService.offBoardingCompleted(employeeProjHist);
			}
			return employeeProjHist;
		}
		return null;

	}
	
	@Override
	public List<ReleaseSummary> getAllReleaseSummary() {
		return releaseSummaryDAO.getAllReleaseSummary();
	}
	
}
