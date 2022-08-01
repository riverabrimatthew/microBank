package com.login.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.entity.User;
import com.login.repo.UserRepository;

@Service
public class LoginService {

	@Autowired	
	private UserRepository repo;

	public List<User> getAllUsers() {
		return repo.findAll();
		
	}
	public User login(String username, String password) {
		User user = repo.findByUsernameAndPassword(username,password);
		return user;
	}

	public User findUserById(Long id) {
		 return repo.findUserById(id);
	}

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUserByAccountnumber(int accountnumber) {
		User user = repo.findUserByAccountnumber(accountnumber);
		return user;
	}

	public void updateUser(int accountnumber, User user) {
		repo.save(user);
	}
	
}
