package com.deguzman.DeGuzmanStuffAnywhere.jpa_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "hapi_users")
@CrossOrigin
public class HapiUsers {
	
	public int hapi_user_id;
	public String username;
	public String password;
	public String firstname;
	public String lastname;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "hapi_user_id")
	public int getHapi_user_id() {
		return hapi_user_id;
	}
	public void setHapi_user_id(int hapi_user_id) {
		this.hapi_user_id = hapi_user_id;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "HapiUsers [hapi_user_id=" + hapi_user_id + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	public HapiUsers(int hapi_user_id, String username, String password, String firstname, String lastname) {
		super();
		this.hapi_user_id = hapi_user_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public HapiUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

}
