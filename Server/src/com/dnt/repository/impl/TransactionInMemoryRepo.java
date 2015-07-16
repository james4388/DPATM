package com.dnt.repository.impl;

import java.util.List;

import com.dnt.model.Transaction;
import com.dnt.repository.TransactionRepository;

public class TransactionInMemoryRepo implements TransactionRepository {
	private List<Transaction> trans;
	
	public TransactionInMemoryRepo() {
		trans = InMemoryDatabaseBuilder.getInstance().getTransactions();
	}

	@Override
	public void createTransaction(Transaction t) {
		trans.add(t);
	}

	@Override
	public Transaction getTransactionById(String id) {
		for (Transaction t : trans){
			if (t.getTransactionID().equals(id)){
				return t;
			}
		}
		return null;
	}

	@Override
	public void removeTransaction(Transaction t) {
		trans.remove(t);
	}

	@Override
	public List<Transaction> getAll() {
		return trans;
	}

}
