package com.cts.nw.onboarding.mailers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.bo.MailDetail;
import com.cts.nw.onboarding.service.LDAPService;

@PropertySource(value = { "classpath:mail.properties" })

@Service
public class SendMail {
	Logger log = Logger.getLogger(SendMail.class) ;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	LDAPService lDAPService;
	
	public void send(MailDetail mailDetail) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", environment.getRequiredProperty("mail.auth") );
		props.put("mail.smtp.starttls.enable",environment.getRequiredProperty("mail.starttls") );
		props.put("mail.smtp.host", environment.getRequiredProperty("mail.host") );
		props.put("mail.smtp.port", environment.getRequiredProperty("mail.port") );

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(environment.getRequiredProperty("mail.from"), environment.getRequiredProperty("mail.password"));
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(environment.getRequiredProperty("mail.from")));
			for (String toId : mailDetail.getReceiver()) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(getEmailAddress(toId)));
			}
			
			if (mailDetail.getCc() != null) {
				for (String ccId : mailDetail.getCc()) {
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(getEmailAddress(ccId)));
				}
			}
			
			message.setSubject(mailDetail.getSubject());
			message.setText("Sent updated message successfully....  ");
			message.setContent(mailDetail.getContent(), "text/html");
			
			Transport transport = session.getTransport(environment.getRequiredProperty("mail.server"));
			transport.connect(environment.getRequiredProperty("mail.host"), environment.getRequiredProperty("mail.from"), environment.getRequiredProperty("mail.password"));
			
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			log.info("Sent Mail Successfully....");
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * @param empId
	 * @return
	 */
	private String getEmailAddress(String empId) {
		String emailId = null;
		EmployeeDetails resource = lDAPService.getEmployee(empId);
		if(resource != null){
			emailId = resource.getEmailId();
		}
		return emailId;
	}
}