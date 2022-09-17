package com.gmail.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
	private String emailId;
	
	
	private String name;
	
	@OneToMany( mappedBy = "sender")
	@JsonIgnore
	List<Mail> sentMails=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL )
	@JoinTable(
	        name = "Users_recievedMail", 
	        joinColumns = { @JoinColumn(name = "users_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "recieved_mail_id") }
	    )
	List<Mail> inbox=new ArrayList<>();
}
