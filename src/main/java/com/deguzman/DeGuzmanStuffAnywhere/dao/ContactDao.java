package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Person;

public interface ContactDao {
	
	public List<Person> findAllPersonInformation() throws SecurityException, IOException;
	
	public ResponseEntity<Person> findPersonById(@PathVariable int personid) throws ResourceNotFoundException, SecurityException, IOException;
	
	public ResponseEntity<Person> findPersonByLastName(@PathVariable String lastname);
	
	public ResponseEntity<Person> findPersonByEmail(@PathVariable String email);
	
	public ResponseEntity<Person> findPersonByPhone(@PathVariable String phone);
	
	public long getCountOfPersonInformation();
	
	public int addPersonInformation(@RequestBody Person person) throws SecurityException, IOException;
	
	public int updatePersonInformation(@PathVariable int personId, @RequestBody Person personDetails) throws SecurityException, IOException;
	
	public int deletePersonInformation(@PathVariable int personid) throws SecurityException, IOException;
	
	public int deleteAllPersonInformation();
}
