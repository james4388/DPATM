package com.dnt.repository;

import java.util.List;

import com.dnt.model.ATM;

public interface ATMRepository {
	public List<ATM> getAllATM();
	public ATM getATMById(String id);
}
