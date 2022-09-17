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

import com.gmail.module.Mail;
import com.gmail.module.Users;
import com.gmail.service.MailService;
import com.gmail.service.UserService;


@RestController
@RequestMapping(value = "/gmail")
public class MailController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@PostMapping(value = "/compose")
	public ResponseEntity<String> compose(@RequestBody Mail mail){
		
		mailService.sendMail(mail);
		
		return new ResponseEntity<String>("Mail Sent", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/inbox")
	public ResponseEntity<List<Mail>> inbox(Users users){
		List<Mail> mails=mailService.getAllMails(users);
		
		return new ResponseEntity<List<Mail>>(mails, HttpStatus.OK);
		
	}
}
