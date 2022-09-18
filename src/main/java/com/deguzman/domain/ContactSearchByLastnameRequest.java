package com.deguzman.domain;

public class ContactSearchByLastnameRequest {
	
	String lastname;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "ContactSearchByLastnameRequest [lastname=" + lastname + "]";
	}

}
