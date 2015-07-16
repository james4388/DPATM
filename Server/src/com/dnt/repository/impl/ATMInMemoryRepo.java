package com.dnt.repository.impl;

import java.util.List;

import com.dnt.model.ATM;
import com.dnt.repository.ATMRepository;

public class ATMInMemoryRepo implements ATMRepository {
	private List<ATM> atms;
	
	public ATMInMemoryRepo() {
		atms = InMemoryDatabaseBuilder.getInstance().getATMs();
	}

	@Override
	public List<ATM> getAllATM() {
		return atms;
	}

	@Override
	public ATM getATMById(String id) {
		for(ATM a : atms){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}

}
