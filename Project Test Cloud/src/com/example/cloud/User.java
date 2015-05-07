package com.example.cloud;

import java.io.Serializable;
import javax.persistence.Id;

public class User implements Serializable {

	private static final long serialVersionUID = 7390103290165670089L;
	@Id
	private Long id;
	private String firstname;
	private String lastname;
	private String mail;
	private String phone;

	public User()
	{
		
	}

	public Long getId() {return id;}
	public String getMail() {return mail;}
	public String getFirstname() {return firstname;}
	public String getLastname() {return lastname;}
	public String getPhone() {return phone;}
	
	public void setId(Long id) {this.id = id;}
	public void setMail(String mail) {this.mail = mail;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public void setPhone(String phone) {this.phone = phone;}

}

