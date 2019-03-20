/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.dao.MailAttachmentDAO;
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
	
	@Autowired
	MailAttachmentDAO mailAttachmentDAO;
	
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid) {
		return employeeProjHistDAO.getRecordsPerProcessortoOnboard(processorid);
	}
	
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid) {
		return employeeProjHistDAO.getRecordsPerProcessortoOffboard(processorid);
	}
	
	@Override
	public EmployeeProjHist getEmployeetoProcess(String empProjHistId) {
		return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
	}
	
	@Override
	public EmployeeProjHist onboardAnEmployee(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		MailAttachment fileUploadObj;
		Integer mailId = null;
		
		fileUploadObj = getFileUploadObject(employeeProjHist.getAttachment());
		if(fileUploadObj != null){
			mailId = mailAttachmentDAO.uploadAttachmentViaCallable(fileUploadObj);
			employeeProjHist.setAttachmentId(mailId);
		}
		
		rowsAffected = employeeProjHistDAO.onBoardEmployee(employeeProjHist);
		if(rowsAffected > 0){
			if (employeeProjHist.getApprovalStatusId() == 2) {
				//mailService.onBoardingAcknowledged(employeeProjHist);
			} else if (employeeProjHist.getApprovalStatusId() == 3) {
				//mailService.onBoardingCompleted(employeeProjHist);
			}
			return employeeProjHist;
		}
		return null;
	}
	
	@Override
	public EmployeeProjHist offboardAnEmployee(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		rowsAffected = employeeProjHistDAO.offboardEmployee(employeeProjHist, employeeProjHist.getId());
		if(rowsAffected > 0){
			return employeeProjHist;
		}
		return null;
	}
	
	public MailAttachment getFileUploadObject(CommonsMultipartFile[] attachFileObj) {
		MailAttachment fileUploadObj = null;
		try {
			if ((attachFileObj != null) && (attachFileObj.length > 0) && (!attachFileObj.equals(""))) {
				for (CommonsMultipartFile aFile : attachFileObj) {
					if(aFile.isEmpty()) {
						continue;
					} else {
						if (!aFile.getOriginalFilename().equals("")) {
							fileUploadObj = new MailAttachment();
							fileUploadObj.setFileName(aFile.getOriginalFilename());
							fileUploadObj.setData(aFile.getBytes());
						}
					}
					System.out.println("File Is Successfully Uploaded & Saved In The Database.... Hurrey!\n");
				}
			} else {
				System.out.println("Error in file Upload");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUploadObj;
	}
}
