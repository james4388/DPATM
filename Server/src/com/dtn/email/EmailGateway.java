package com.dtn.email;

public interface EmailGateway {
	public void sendEmail(String toEmail, String subject, String body);
	public void sendHTMLEmail(String toEmail, String subject, String body, String plainbody);
}
