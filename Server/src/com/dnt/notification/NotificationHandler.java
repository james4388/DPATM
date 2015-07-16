package com.dnt.notification;

import com.dnt.model.Transaction;
import com.dnt.model.User;

public abstract class NotificationHandler {
	protected NotificationHandler nextHandler;
	
	public abstract void send(User u, Transaction t);
}
