package com.dnt.service;

import com.dnt.repository.ATMRepository;
import com.dnt.repository.impl.ATMInMemoryRepo;

public class ATMService {
	private static ATMService instance = new ATMService();
	private ATMRepository repo;
	
	private ATMService(){
		repo = new ATMInMemoryRepo();
	}
	
	public static ATMService getInstance(){
		return instance;
	}
	
	public ATMRepository getRepository(){
		return repo;
	}
}
