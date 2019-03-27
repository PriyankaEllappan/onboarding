package com.cts.nw.onboarding.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.MailDetail;
import com.cts.nw.onboarding.controllers.AbstractController;
import com.cts.nw.onboarding.mailers.SendMail;
import com.cts.nw.onboarding.service.MailService;

@PropertySource(value = { "classpath:mail.properties" })

@Service
public class MailServiceImpl implements MailService {

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
			String emailContent = environment.getRequiredProperty("mail.request");
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
			emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());

			mailDetail.setContent(emailContent);
			mailDetail.setSubject("Request Mail.. !!!");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onBoardingAcknowledged(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.inprogress");

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
			emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject("Process Mail.. !!!");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onBoardingCompleted(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.complete");

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
			emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());

			mailDetail.setContent(emailContent);
			mailDetail.setSubject("Complete Mail.. !!!");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void offBoardingInitiated(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.releaseinitiated");

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
			emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject(" Resource Release Initiated Mail.. !!!");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void offBoardingCompleted(EmployeeProjHist resource) {
		try {
			String emailContent = environment.getRequiredProperty("mail.resourceOffBoarding");

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
			emailContent = emailContent.replace("<<URL>>", AbstractController.APPINFO.getAppUrl());
			mailDetail.setContent(emailContent);
			mailDetail.setSubject(" Resource OffBoarded Mail.. !!!");
			sendMail.send(mailDetail);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}