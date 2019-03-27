/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.Calendar;
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
import com.cts.nw.onboarding.service.ReleaseService;
import com.cts.nw.onboarding.validators.OnboardingRequestValidator;

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
	
	@Autowired
	ReleaseService releaseService;
	
	@Autowired
	OnboardingRequestValidator onboardingRequestValidator;
	
	/*1. Resource Onboarding Operations*/
	
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid) {
		try {
			return employeeProjHistDAO.getRecordsPerProcessortoOnboard(processorid);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EmployeeProjHist onboardAnEmployee(EmployeeProjHist employeeProjHist) {

		Integer rowsAffected = 0;
		MailAttachment fileUploadObj;
		Integer mailId = null;
		try {
			if (onboardingRequestValidator.validate(employeeProjHist)) {
				fileUploadObj = getFileUploadObject(employeeProjHist.getAttachment());
				if (fileUploadObj != null) {
					mailId = mailAttachmentDAO.uploadAttachmentViaCallable(fileUploadObj);
					employeeProjHist.setAttachmentId(mailId);
				}

				rowsAffected = employeeProjHistDAO.onBoardEmployee(employeeProjHist);
				if (rowsAffected > 0) {
					if (employeeProjHist.getApprovalStatusId() == 2) {
						mailService.onBoardingAcknowledged(employeeProjHist);
					} else if (employeeProjHist.getApprovalStatusId() == 3) {
						mailService.onBoardingCompleted(employeeProjHist);
						checkForAnyPrevAssignmentandRelease(employeeProjHist);
					}
					return employeeProjHist;
				}
				return null;
			} else {
				System.out.println("Validation errors");
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private void checkForAnyPrevAssignmentandRelease(EmployeeProjHist employeeProjHist) {
		try {
			List<EmployeeProjHist> activeAssignmentList = employeeProjHistDAO.checkActiveAssignments(String.valueOf(employeeProjHist.getEmployeeId()));
			if(activeAssignmentList != null && activeAssignmentList.size() > 1){
				EmployeeProjHist activeAssignment = activeAssignmentList.get(0);
				activeAssignment.setReleaseStatusId(2);
				activeAssignment.setReasonForOffboarding(6);
				activeAssignment.setReleaseDate(Calendar.getInstance().getTime());
				releaseService.releaseAnEmployee(activeAssignment);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*2. Resource Off boarding Operations*/
	
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid) {
		try {
			return employeeProjHistDAO.getRecordsPerProcessortoOffboard(processorid);	
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EmployeeProjHist offboardAnEmployee(EmployeeProjHist employeeProjHist) {
		try {
			Integer rowsAffected = 0;
			rowsAffected = employeeProjHistDAO.processOffboardEmployee(employeeProjHist, employeeProjHist.getId());
			if(rowsAffected > 0){
				return employeeProjHist;
			}
			return null;	
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*3. Display Resource details*/
	@Override
	public EmployeeProjHist getEmployeeDetails(String empProjHistId) {
		try {
			return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);	
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public MailAttachment getFileUploadObject(CommonsMultipartFile[] attachFileObj) {
		try {
			MailAttachment fileUploadObj = null;
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
				}
			}
			return fileUploadObj;	
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
