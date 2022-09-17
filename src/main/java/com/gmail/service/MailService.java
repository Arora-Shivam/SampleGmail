package com.gmail.service;

import java.util.List;

import com.gmail.module.Mail;
import com.gmail.module.Users;

public interface MailService {

	public List<Mail> getAllMails(Users user);
	
	public String sendMail(Mail mail);

}
