package com.dnt.repository.impl;

import java.util.List;

import com.dnt.model.Account;
import com.dnt.model.User;
import com.dnt.repository.AccountRepository;

public class AccountInMemoryRepo implements AccountRepository {
	private List<Account> accounts;
	
	public AccountInMemoryRepo(){
		accounts = InMemoryDatabaseBuilder.getInstance().getAccounts();
	}

	@Override
	public Account getAccountById(String accountId) {
		for(Account a : accounts){
			if (a.getAccountId().equals(accountId)){
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Account> getAccountByUser(User u) {
		return u.getAccounts();
	}

}
