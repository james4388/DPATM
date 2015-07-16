package com.dnt.service;

import com.dnt.repository.BillRepository;
import com.dnt.repository.impl.BillInMemoryRepo;

public class BillService {
	private static BillService instance = new BillService();
	private static BillRepository repo;
	
	private BillService(){
		repo = new BillInMemoryRepo();
	}
	
	public static BillService getInstance(){
		return instance;
	}
	
	public BillRepository getRepository(){
		return repo;
	}
}
