package com.dnt.service;

import com.dnt.repository.AccountRepository;
import com.dnt.repository.impl.AccountInMemoryRepo;

public class AccountService {
	private static AccountService instance = new AccountService();
	private AccountRepository accountRepo;
	
	private AccountService(){
		accountRepo = new AccountInMemoryRepo();
	}
	
	public static AccountService getInstance(){
		return instance;
	}
	
	public AccountRepository getRepository(){
		return accountRepo;
	}
}
