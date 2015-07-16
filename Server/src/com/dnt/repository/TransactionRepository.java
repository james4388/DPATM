package com.dnt.repository;

import java.util.List;

import com.dnt.model.Transaction;

public interface TransactionRepository {
	public void createTransaction(Transaction t);
	public Transaction getTransactionById(String id);
	public void removeTransaction(Transaction t);
	public List<Transaction> getAll();
}
