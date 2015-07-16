package com.dnt.notification;

import com.dnt.model.Transaction;
import com.dnt.model.User;
import com.dnt.sms.SMSFactory;
import com.dnt.sms.SMSGateway;

public class SMSNotification extends NotificationHandler {

	@Override
	public void send(User u, Transaction t) {
		SMSGateway sms = SMSFactory.getFactory().createGateway("Twilio");
		sms.send(u.getPhoneNumber(), "Your account has been changed: " + t.getType() + " $" + t.getAmount());
		if (this.nextHandler != null){
			this.nextHandler.send(u, t);
		}
	}

}
