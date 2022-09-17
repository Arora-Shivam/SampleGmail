package com.gmail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.module.Users;
import com.gmail.service.MailService;
import com.gmail.service.UserService;

@RestController
@RequestMapping(value = "/gmail")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@PostMapping(value = "/user")
	public ResponseEntity<Users> addUser(@RequestBody Users users){
		
		userService.saveUser(users);
		return new ResponseEntity<Users>(users, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/user")
	public ResponseEntity<List<Users>> getUsersList(){
		
		List<Users> allUsers=userService.getAllUsers();
		
		return new ResponseEntity<List<Users>>(allUsers, HttpStatus.ACCEPTED);
		
	}
}
