package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.User;
import com.login.service.LoginService;

@RestController
@RequestMapping("/userinfo")
public class RestLoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return loginService.saveUser(user);
	}
	
	@GetMapping("/getusers")
	public List<User> getAllUsers(){
		return loginService.getAllUsers();
	}
	
	@GetMapping("/id/{id}")
	public User findUserById(@PathVariable("id")Long  id) {
		return loginService.findUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accnumber/{accountnumber}")
	public User findUserByAccountNumber(@PathVariable("accountnumber") int accountnumber) {
		return loginService.findUserByAccountnumber(accountnumber);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{accountnumber}")
	public void updateUser(@PathVariable int accountnumber, @RequestBody User user) {
		loginService.updateUser(accountnumber, user);
	}
}
