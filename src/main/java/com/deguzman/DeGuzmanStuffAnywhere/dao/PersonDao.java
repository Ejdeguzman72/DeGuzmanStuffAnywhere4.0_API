package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidPersonException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Person;


public interface PersonDao {

	public List<Person> findAllPersonInformation() throws SecurityException, IOException;
	
	public ResponseEntity<Person> findPersonById(@PathVariable Long personid) throws SecurityException, IOException, InvalidPersonException;
	
	public Person addPersonInformation(@RequestBody Person person) throws SecurityException, IOException;
	
	public ResponseEntity<Person> updatePersonInformation(@PathVariable Long personid,@RequestBody Person personDetails) throws SecurityException, IOException;
	
	public Map<String, Boolean> deletePersonInformation(@PathVariable Long personid) throws SecurityException, IOException;
	
	public long getCountOfPersonInformation();
}
