package com.dnt.notification;

import com.dnt.model.Transaction;
import com.dnt.model.User;
import com.dtn.email.EmailGateway;
import com.dtn.email.impl.DreamhostEmail;

public class EmailNotification extends NotificationHandler {

	@Override
	public void send(User u, Transaction t) {
		EmailGateway email = DreamhostEmail.getInstance();
		email.sendHTMLEmail(u.getEmail(), "Account alert", "Dear <b>"+u+"</b>,<br/>"+""
				+ "Your account has been changed.<br/>"+
				t.getType() + " amount: " + t.getAmount()+ "<br/>"+
				t.getDescription(), "");
		if (this.nextHandler != null){
			this.nextHandler.send(u, t);
		}
	}

}
