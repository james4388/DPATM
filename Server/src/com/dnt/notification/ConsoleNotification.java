package com.dnt.notification;

import com.dnt.model.Transaction;
import com.dnt.model.User;

public class ConsoleNotification extends NotificationHandler {

	@Override
	public void send(User u, Transaction t) {
		System.out.println("Your account has been changed: " + t.getType() + " $" + t.getAmount());
		if (this.nextHandler != null){
			this.nextHandler.send(u, t);
		}
	}

}
