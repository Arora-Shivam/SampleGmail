package com.gmail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.module.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, String>{

	public Users findByEmailId(String emailId);
}
