package com.dnt.repository;

import java.util.List;

import com.dnt.model.User;

public interface UserRepository {
	public List<User> getAllUsers();
	public User getUserById(String userId);
	public void addUser(User user);
	public void removeUser(User user);
}
