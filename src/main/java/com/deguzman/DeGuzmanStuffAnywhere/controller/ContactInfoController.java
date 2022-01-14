package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.ContactDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Person;

@RestController
@RequestMapping("/app/person-info")
@CrossOrigin
public class ContactInfoController {

	@Autowired
	private ContactDaoImpl contactDaoImpl;
	
	@GetMapping("/all")
	public List<Person> getAllPersonInfo() throws SecurityException, IOException {
		return contactDaoImpl.findAllPersonInformation();
	}
	
	@GetMapping("/person/{personId}")
	public ResponseEntity<Person> getPersonInformationById(@PathVariable int personId) throws ResourceNotFoundException, SecurityException, IOException {
		return contactDaoImpl.findPersonById(personId);
	}
	
	@GetMapping("/person/lastname/{lastname}")
	public ResponseEntity<Person> getPersonInformationByLastname(@PathVariable String lastname) {
		return contactDaoImpl.findPersonByLastName(lastname);
	}
	
	@GetMapping("/person/email/{email}")
	public ResponseEntity<Person> getPersonInformationByEmail(@PathVariable String email) {
		return contactDaoImpl.findPersonByEmail(email);
	}
	
	@GetMapping("/person/phone/{phone}")
	public ResponseEntity<Person> getPersonInformationByPhone(@PathVariable String phone) {
		return contactDaoImpl.findPersonByPhone(phone);
	}
	
	@GetMapping("/count")
	public long getCountOfPersonInfo() {
		return contactDaoImpl.getCountOfPersonInformation();
	}
	
	@PostMapping("/add-person-information")
	public int saveContactInformation(@RequestBody Person personInfo) throws SecurityException, IOException {
		return contactDaoImpl.addPersonInformation(personInfo);
	}
	
	@DeleteMapping("/delete-all")
	public int deleteAllContactInformation() {
		return contactDaoImpl.deleteAllPersonInformation();
	}
	
	@DeleteMapping("/person/{personId}")
	public int deleteContactInformation(@PathVariable int personId) throws SecurityException, IOException {
		return contactDaoImpl.deletePersonInformation(personId);
	}
}
