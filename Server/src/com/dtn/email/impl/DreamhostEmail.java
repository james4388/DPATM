package com.dtn.email.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.dtn.email.EmailGateway;

public class DreamhostEmail implements EmailGateway {
	private static final EmailGateway instance = new DreamhostEmail();
	
	// TODO get email config from external source
	private static final String host = "mail.nhutrinh.com";
	private static final int port = 587;
	private static final String fromEmail = "DPATM<dpatm@nhutrinh.com>";
	private static final String username = "dpatm@nhutrinh.com";
	private static final String password = "9uych?98";
	private Authenticator authenticator;

	private Properties properties;

	private DreamhostEmail() {
		properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.ssl.enable", false);
		properties.put("mail.smtp.starttls.enable", false);
		properties.put("mail.smtp.auth", true);
		authenticator = new Authenticator() {
			private PasswordAuthentication pa = new PasswordAuthentication(username, password);

			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return pa;
			}
		};

	}
	
	public static EmailGateway getInstance(){
		return instance;
	}

	@Override
	public void sendEmail(String toEmail, String subject, String body) {
		Session session = Session.getDefaultInstance(properties, authenticator);
		session.setDebug(true);
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void sendHTMLEmail(String toEmail, String subject, String body, String plainbody) {
		Session session = Session.getDefaultInstance(properties, authenticator);
		session.setDebug(true);
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			
			Multipart multipart = new MimeMultipart("alternative");
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(plainbody);
			
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body, "text/html");
			
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(htmlPart);
			message.setContent(multipart);
			
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
