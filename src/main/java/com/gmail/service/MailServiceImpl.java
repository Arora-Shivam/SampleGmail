package com.gmail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.module.Mail;
import com.gmail.module.Users;
import com.gmail.repository.MailDao;
import com.gmail.repository.UsersDao;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	MailDao mailDao;
	
	@Autowired
	UsersDao usersDao;
	
	@Override
	public List<Mail> getAllMails(String mailId) {
		// TODO Auto-generated method stub
		
		Users u=usersDao.findByEmailId(mailId);		
		System.out.println(u.getEmailId());
		return u.getInbox();
	}

	@Override
	public String sendMail(Mail mail) {
		// TODO Auto-generated method stub
		
		mailDao.save(mail);
		Users sender=usersDao.findByEmailId(mail.getSender().getEmailId());
		
		//System.out.println(sender.getEmailId());
		
		List<Users> recievers=mail.getReciever();
		
		sender.getSentMails().add(mail);
		System.out.println("Before saving sender");
		usersDao.save(sender);
		System.out.println("after "+sender.getEmailId());
		for(Users r : recievers) {
			Users r1=usersDao.findByEmailId(r.getEmailId());
			r1.getInbox().add(mail);
			//System.out.println(r1.getEmailId()+" Inbox -> "+r1.getInbox());
			usersDao.save(r1);	
		}
		
//		sender.getSentMails().add(mail);
//		
//		usersDao.save(sender);
		
		
		
		return "Mail Sent";
	}

	

}
