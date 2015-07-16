package com.dnt.service.transaction;

import com.dnt.model.Transaction;

public interface TransactionCommand {
	public void execute(Transaction t);
	public void reverse(Transaction t);
}
