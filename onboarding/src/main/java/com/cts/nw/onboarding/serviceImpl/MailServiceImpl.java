package com.cts.nw.onboarding.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.bo.MailDetail;
import com.cts.nw.onboarding.controllers.HomeController;
import com.cts.nw.onboarding.mailers.SendMail;
import com.cts.nw.onboarding.service.MailService;
 
@PropertySource(value = { "classpath:mail.properties" })
 
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	SendMail sendMail;
	
	@Autowired
	private Environment environment;
	
	@Override
	public void sendRequestEmail(EmployeeProjectInfo resource) {
		String emailContent = environment.getRequiredProperty("mail.request");
		System.out.println(resource.toString());
		emailContent = emailContent.replaceAll("<<EMPID>>", "616550" );
		emailContent = emailContent.replace("<<EMPNAME>>", "Priyanka" );
		emailContent = emailContent.replace("<<PROJID>>",  "132422");
		emailContent = emailContent.replace("<<PROJNAME>>",  "Projevt 1");
		emailContent = emailContent.replace("<<URL>>",  HomeController.APPURL);
		MailDetail mailDetail = new MailDetail();
		mailDetail.setReceiver("Priyanka.Ellappan@cognizant.com");
		System.out.println(emailContent);
		mailDetail.setContent(emailContent);
		mailDetail.setSubject("Request Mail.. !!!");
		sendMail.send(mailDetail);	
	}

	@Override
	public void sendInProgressEmail(EmployeeProjectInfo resource) {
		String emailContent = environment.getRequiredProperty("mail.inprogress");
		emailContent = emailContent.replaceAll("<<EMPID>>", "656579" );
		emailContent = emailContent.replace("<<EMPNAME>>", "Suresh" );
		emailContent = emailContent.replace("<<PROJID>>",  "132422");
		emailContent = emailContent.replace("<<PROJNAME>>",  "Projevt 2");
		emailContent = emailContent.replace("<<URL>>",  HomeController.APPURL);
		MailDetail mailDetail = new MailDetail();
		mailDetail.setReceiver("Priyanka.Ellappan@cognizant.com");
		mailDetail.setContent(emailContent);
		mailDetail.setSubject("Process Mail.. !!!");
		sendMail.send(mailDetail);	
	}

	@Override
	public void sendCompletionEmail(EmployeeProjectInfo resource) {
		String emailContent = environment.getRequiredProperty("mail.complete");
		emailContent = emailContent.replace("<<NWID>>", "65657239" );
		emailContent = emailContent.replace("<<URL>>",  HomeController.APPURL);
		MailDetail mailDetail = new MailDetail();
		mailDetail.setReceiver("Priyanka.Ellappan@cognizant.com");
		mailDetail.setContent(emailContent);
		mailDetail.setSubject("Complete Mail.. !!!");
		sendMail.send(mailDetail);			
	}}