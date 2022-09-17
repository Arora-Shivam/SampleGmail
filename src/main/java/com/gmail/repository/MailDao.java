package com.gmail.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.module.Mail;
import com.gmail.module.Users;

@Repository
public interface MailDao extends JpaRepository<Mail, Integer>{

	public List<Mail> findBySender(Users user); 
}
