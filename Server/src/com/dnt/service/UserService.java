package com.dnt.service;

import com.dnt.repository.UserRepository;
import com.dnt.repository.impl.UserInMemoryRepo;

public class UserService {
	private static UserService instance = new UserService();
	private UserRepository userRepo;
	
	private UserService(){
		userRepo = new UserInMemoryRepo();
	}
	
	public static UserService getInstance(){
		return instance;
	}
	
	public UserRepository getRepository(){
		return userRepo;
	}
}
