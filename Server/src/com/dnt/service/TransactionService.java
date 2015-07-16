package com.dnt.service;

import com.dnt.repository.TransactionRepository;
import com.dnt.repository.impl.TransactionInMemoryRepo;

public class TransactionService {
	private static TransactionService instance = new TransactionService();
	private static TransactionRepository transRepo;
	
	private TransactionService(){
		transRepo = new TransactionInMemoryRepo();
	}
	
	public static TransactionService getInstance(){
		return instance;
	}
	
	public TransactionRepository getRepository(){
		return transRepo;
	}
	
}
