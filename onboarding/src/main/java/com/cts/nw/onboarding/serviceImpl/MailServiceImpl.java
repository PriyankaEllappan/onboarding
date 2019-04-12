package com.cts.nw.onboarding.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.MailDetail;
import com.cts.nw.onboarding.controllers.ProcessController;
import com.cts.nw.onboarding.mailers.SendMail;
import com.cts.nw.onboarding.service.MailService;

@PropertySource(value = { "classpath:mail.properties" })

@Service
public class MailServiceImpl implements MailService {

	Logger log = Logger.getLogger(ProcessController.class);
	
	@Autowired
	SendMail sendMail;

	@Autowired
	private Environment environment;

	

	List<String> toList;
	List<String> ccList;
	EmployeeDetails employeeDetail;
	MailDetail mailDetail;

	@Override
	public void onBoardingInitiated(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.onboardinginit");
			employeeDetail = new EmployeeDetails();
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			ccList = new ArrayList<>();
			
			toList.add(String.valueOf(resource.getProcessorId()));
			mailDetail.setReceiver(toList);
			ccList.add(resource.getOnboardRequester());
			ccList.add(String.valueOf(resource.getRequesterId()));
			mailDetail.setCc(ccList);

			emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
			emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
			emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
			emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());

			mailDetail.setContent(emailContent);
			mailDetail.setSubject("New Nationwide ID Creation Request");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}
	}

	@Override
	public void onBoardingAcknowledged(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.onboardingack");

			employeeDetail = new EmployeeDetails();
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			ccList = new ArrayList<>();

			toList.add(String.valueOf(resource.getRequesterId()));
			toList.add(String.valueOf(resource.getOnboardRequester()));
			mailDetail.setReceiver(toList);
			ccList.add(String.valueOf(resource.getProcessorId()));
			mailDetail.setCc(ccList);

			emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
			emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
			emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
			emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject("NationWide Onboarding - In Progress");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}
	}

	@Override
	public void onBoardingCompleted(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.onboardingcomp");

			employeeDetail = new EmployeeDetails();
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			ccList = new ArrayList<>();

			toList.add(String.valueOf(resource.getRequesterId()));
			toList.add(String.valueOf(resource.getOnboardRequester()));
			toList.add(String.valueOf(resource.getEmployeeId()));
			mailDetail.setReceiver(toList);
			ccList.add(String.valueOf(resource.getProcessorId()));
			mailDetail.setCc(ccList);

			emailContent = emailContent.replace("<<NWID>>", resource.getNationwideId());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());

			mailDetail.setContent(emailContent);
			mailDetail.setSubject("Welcome Aboard !!");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}
	}
	
	@Override
	public void offBoardingInitiated(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.offboardinginit");

			employeeDetail = new EmployeeDetails();
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			ccList = new ArrayList<>();

			toList.add(String.valueOf(resource.getOffboardProcessor()));
			mailDetail.setReceiver(toList);
			ccList.add(String.valueOf(resource.getOffboardRequester()));
			mailDetail.setCc(ccList);

			emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
			emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
			emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
			emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject("NationWide Offboarding - Initiated");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}

	}

	@Override
	public void offBoardingCompleted(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.offboardingcomp");

			employeeDetail = new EmployeeDetails();
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			ccList = new ArrayList<>();

			toList.add(String.valueOf(resource.getOffboardRequester()));
			mailDetail.setReceiver(toList);
			ccList.add(String.valueOf(resource.getOffboardProcessor()));
			mailDetail.setCc(ccList);

			emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
			emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
			emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
			emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject("NationWide Offboarding - Completed");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}

	}

	@Override
	public void onBoardingRejected(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.onboardingreject");

			employeeDetail = new EmployeeDetails();
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			ccList = new ArrayList<>();

			toList.add(String.valueOf(resource.getRequesterId()));
			toList.add(String.valueOf(resource.getOnboardRequester()));
			mailDetail.setReceiver(toList);
			ccList.add(String.valueOf(resource.getProcessorId()));
			mailDetail.setCc(ccList);

			emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
			emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
			emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
			emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
			emailContent = emailContent.replace("<<REJECTCOMMENTS>>", resource.getComments());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject("NationWide Onboarding - Rejected");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}
	}

	@Override
	public void sendMailPin(AuthenticationInfo authenticationInfo) {
		try {
			String emailContent = environment.getRequiredProperty("mail.passwordreset");
			mailDetail = new MailDetail();
			toList = new ArrayList<>();
			toList.add(String.valueOf(authenticationInfo.getUserName()));
			mailDetail.setReceiver(toList);
			emailContent = emailContent.replaceAll("<<MAILPIN>>", authenticationInfo.getMailPin());
			//emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject("NationWide Onboarding - One Time Password");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			log.error(e);
		}
		
	}
}