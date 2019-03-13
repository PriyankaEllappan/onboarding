/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Service
public class ProcessorServiceImpl implements ProcessorService {

	/*@Autowired
	EmployeeProjHistDAO processorsInfoDAO;
	
	@Autowired
	MailService mailService;
	
	@Override
	public EmployeeProjHistDAO getEmployeetoProcess(String processorId,String projInfoId) {
		int processor;
		int projInfo;
		try{
			processor = Integer.parseInt(processorId);
			projInfo = Integer.parseInt(projInfoId);
			return processorsInfoDAO.getEmployeeToProcess(processor, projInfo);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeProjHistDAO processAnEmployee(EmployeeProjHistDAO employeeProjJson) {
		Integer rowsAffected = 0;
		rowsAffected = processorsInfoDAO.processAnEmployee(employeeProjJson);
		if (rowsAffected > 0) {
			if (employeeProjJson.getApprovalStatus() == 2) {
				System.out.println("Mail Serv" + employeeProjJson);
				mailService.sendInProgressEmail(employeeProjJson);
			} else if (employeeProjJson.getApprovalStatus() == 3) {
				mailService.sendCompletionEmail(employeeProjJson);
			}
			return employeeProjJson;
		}
		return null;
	}

	@Override
	public List<EmployeeProjHistDAO> getRecordsPerProcessor(int processorid) {
		return processorsInfoDAO.getRecordsPerProcessor(processorid);
	}*/

}
