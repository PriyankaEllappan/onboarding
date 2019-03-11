/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.ProcessorsInfo;
import com.cts.nw.onboarding.dao.ProcessorsInfoDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Service
public class ProcessorServiceImpl implements ProcessorService {

	@Autowired
	ProcessorsInfoDAO processorsInfoDAO;
	
	@Autowired
	MailService mailService;
	
	@Override
	public ProcessorsInfo getEmployeetoProcess(String processorId,String projInfoId) {
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
	public ProcessorsInfo processAnEmployee(ProcessorsInfo employeeProjJson) {
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

}
