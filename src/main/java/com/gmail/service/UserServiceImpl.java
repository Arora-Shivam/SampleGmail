package com.gmail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.module.Users;
import com.gmail.repository.UsersDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UsersDao userDao;
	
	@Override
	public String saveUser(Users user) {
		userDao.save(user);
		return "User Saved to DB";
	}
	
	public List<Users> getAllUsers(){
		List<Users> allUsers=userDao.findAll();
		
		return allUsers;
	}

}
