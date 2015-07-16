package com.dnt.service.transaction;

import com.dnt.model.Transaction;
import com.dnt.notification.Notification;

public class WithdrawTransaction implements TransactionCommand {

	@Override
	public void execute(Transaction t) {
		t.getAccount().withdraw(t.getAmount());
		Notification.getInstance().getHandler().send(t.getAccount().getOwner(), t);
	}

	@Override
	public void reverse(Transaction t) {
		t.getAccount().deposit(t.getAmount());	
		Notification.getInstance().getHandler().send(t.getAccount().getOwner(), t);
	}

}
