package com.gmail.service;

import java.util.List;

import com.gmail.module.Mail;
import com.gmail.module.Users;

public interface MailService {

	
	
	public String sendMail(Mail mail);

	List<Mail> getAllMails(String mailId);

}
