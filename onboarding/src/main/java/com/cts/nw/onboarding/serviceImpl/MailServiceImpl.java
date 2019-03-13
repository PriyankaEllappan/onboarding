package com.cts.nw.onboarding.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.MailDetail;
import com.cts.nw.onboarding.controllers.HomeController;
import com.cts.nw.onboarding.mailers.SendMail;
import com.cts.nw.onboarding.service.LDAPService;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.vo.EmployeeDetails;

@PropertySource(value = { "classpath:mail.properties" })

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	SendMail sendMail;

	@Autowired
	private Environment environment;

	@Autowired
	LDAPService lDAPService;

	List<String> toList;
	List<String> ccList;
	EmployeeDetails employeeDetail;
	MailDetail mailDetail;

	@Override
	public void sendRequestEmail(EmployeeProjHist resource) {
		String emailContent = environment.getRequiredProperty("mail.request");
		employeeDetail = new EmployeeDetails();
		mailDetail = new MailDetail();
		toList = new ArrayList<>();
		ccList = new ArrayList<>();

		toList.add("Priyanka.Ellappan@cognizant.com");
		toList.add("Suresh.Baskar2@cognizant.com");
		mailDetail.setReceiver(toList);
		ccList.add("Priyanka.Ellappan@cognizant.com");
		mailDetail.setCc(ccList);

		emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
		emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
		emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
		emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
		emailContent = emailContent.replace("<<URL>>", HomeController.APPURL);
		employeeDetail = lDAPService.getEmployee(String.valueOf(resource.getProcessorId()));
		System.out.println("-------" + employeeDetail.getEmailId());

		System.out.println(emailContent);
		mailDetail.setContent(emailContent);
		mailDetail.setSubject("Request Mail.. !!!");
		sendMail.send(mailDetail);
	}

	@Override
	public void sendInProgressEmail(EmployeeProjHist resource) {
		String emailContent = environment.getRequiredProperty("mail.inprogress");

		employeeDetail = new EmployeeDetails();
		mailDetail = new MailDetail();
		toList = new ArrayList<>();
		ccList = new ArrayList<>();

		toList.add("Priyanka.Ellappan@cognizant.com");
		toList.add("Suresh.Baskar2@cognizant.com");
		mailDetail.setReceiver(toList);
		ccList.add("Priyanka.Ellappan@cognizant.com");
		mailDetail.setCc(ccList);

		emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
		emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
		emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
		emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
		emailContent = emailContent.replace("<<URL>>", HomeController.APPURL);
		mailDetail.setContent(emailContent);
		mailDetail.setSubject("Process Mail.. !!!");
		sendMail.send(mailDetail);
	}

	@Override
	public void sendCompletionEmail(EmployeeProjHist resource) {
		String emailContent = environment.getRequiredProperty("mail.complete");

		employeeDetail = new EmployeeDetails();
		mailDetail = new MailDetail();
		toList = new ArrayList<>();
		ccList = new ArrayList<>();

		toList.add("Priyanka.Ellappan@cognizant.com");
		toList.add("Suresh.Baskar2@cognizant.com");
		mailDetail.setReceiver(toList);
		ccList.add("Priyanka.Ellappan@cognizant.com");
		mailDetail.setCc(ccList);

		emailContent = emailContent.replace("<<NWID>>", resource.getNationwideId());
		emailContent = emailContent.replace("<<URL>>", HomeController.APPURL);

		mailDetail.setContent(emailContent);
		mailDetail.setSubject("Complete Mail.. !!!");
		sendMail.send(mailDetail);
	}
	
	@Override
	public void releaseInitiatedEmail(EmployeeProjHist resource) {
		String emailContent = environment.getRequiredProperty("mail.releaseinitiated");

		employeeDetail = new EmployeeDetails();
		mailDetail = new MailDetail();
		toList = new ArrayList<>();
		ccList = new ArrayList<>();

		// toList.add("Priyanka.Ellappan@cognizant.com");
		toList.add("Suresh.Baskar2@cognizant.com");
		mailDetail.setReceiver(toList);
		ccList.add("Priyanka.Ellappan@cognizant.com");
		ccList.add("Jambulingam.S@cognizant.com");
		mailDetail.setCc(ccList);

		emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
		emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
		emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
		emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
		emailContent = emailContent.replace("<<URL>>", HomeController.APPURL);
		mailDetail.setContent(emailContent);
		mailDetail.setSubject(" Resource ReleaseInitiated Mail.. !!!");
		sendMail.send(mailDetail);

	}

	@Override
	public void resourceOffBoardingEmail(EmployeeProjHist resource) {
		String emailContent = environment.getRequiredProperty("mail.released");

		employeeDetail = new EmployeeDetails();
		mailDetail = new MailDetail();
		toList = new ArrayList<>();
		ccList = new ArrayList<>();

		// toList.add("Priyanka.Ellappan@cognizant.com");
		toList.add("Suresh.Baskar2@cognizant.com");
		mailDetail.setReceiver(toList);
		ccList.add("Priyanka.Ellappan@cognizant.com");
		ccList.add("Jambulingam.S@cognizant.com");
		mailDetail.setCc(ccList);

		emailContent = emailContent.replaceAll("<<EMPID>>", String.valueOf(resource.getEmployeeId()));
		emailContent = emailContent.replace("<<EMPNAME>>", resource.getName());
		emailContent = emailContent.replace("<<PROJID>>", String.valueOf(resource.getProjectId()));
		emailContent = emailContent.replace("<<PROJNAME>>", resource.getProjectName());
		emailContent = emailContent.replace("<<URL>>", HomeController.APPURL);
		mailDetail.setContent(emailContent);
		mailDetail.setSubject(" Resource OffBoarding Mail.. !!!");
		sendMail.send(mailDetail);

	}
}