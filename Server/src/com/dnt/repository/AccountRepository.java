package com.dnt.repository;

import java.util.List;

import com.dnt.model.Account;
import com.dnt.model.User;

public interface AccountRepository {
	public Account getAccountById(String accountId);
	public List<Account> getAccountByUser(User u);
	
}
