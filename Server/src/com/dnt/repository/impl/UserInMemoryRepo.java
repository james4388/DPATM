package com.dnt.repository.impl;

import java.util.LinkedList;
import java.util.List;

import com.dnt.model.User;
import com.dnt.repository.UserRepository;

public class UserInMemoryRepo implements UserRepository {
	private static List<User> users = new LinkedList<User>();
	
	public UserInMemoryRepo(){
		users = InMemoryDatabaseBuilder.getInstance().getUsers();
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public User getUserById(String userId) {
		for(User u : users){
			if (u.getUserId().equals(userId)){
				return u;
			}
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void removeUser(User user) {
		users.remove(user);
	}

}
