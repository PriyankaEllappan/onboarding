package com.cts.nw.onboarding.mailers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.MailDetail;

@PropertySource(value = { "classpath:mail.properties" })

@Service
public class SendMail {
	
	@Autowired
	private Environment environment;
	
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
			for (String toAddr : mailDetail.getReceiver()) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddr));
			}
			for (String ccAddr : mailDetail.getCc()) {
				message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccAddr));
			}
			message.setSubject(mailDetail.getSubject());
			message.setText("Sent updated message successfully....  ");
			message.setContent(mailDetail.getContent(), "text/html");
			
			Transport transport = session.getTransport(environment.getRequiredProperty("mail.server"));
			transport.connect(environment.getRequiredProperty("mail.host"), environment.getRequiredProperty("mail.from"), environment.getRequiredProperty("mail.password"));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}