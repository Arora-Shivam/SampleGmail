package com.gmail.service;

import java.util.List;

import com.gmail.module.Users;

public interface UserService {
	
	public String saveUser(Users user);
	
	public List<Users> getAllUsers();
}
