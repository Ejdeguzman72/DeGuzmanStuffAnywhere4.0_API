package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dao.ContactDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Person;

@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Logger LOGGER = LoggerFactory.getLogger(ContactDaoImpl.class);
	
	String GET_ALL_CONTACT_INFO = "SELECT * FROM PERSON ORDER BY FIRSTNAME, LASTNAME";
	String GET_CONTACT_INFO_BY_ID = "SELECT * FROM PERSON WHERE PERSON_ID = ?";
	String GET_CONTACT_INFO_BY_LASTNAME = "SELECT * FROM PERSON WHERE LASTNAME = ?";
	String GET_CONTACT_INFO_BY_EMAIL = "SELECT * FROM PERSON WHERE EMAIL = ?";
	String GET_CONTACT_INFO_BY_PHONE = "SELECT * FROM PERSON WHERE PHONE = ?";
	String GET_COUNT_OF_PERSON_INFO = "SELECT COUNT(*) FROM PERSON";
	String INSERT_NEW_CONTACT_INFO = "INSERT INTO PERSON " + 
			"(FIRSTNAME, MIDDLE_INITIAL, LASTNAME, ADDRESS01, ADDRESS02, CITY, STATE, ZIPCODE, AGE, BIRTHDATE, EMAIL, PHONE) " + 
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String UPDATE_CONTACT_INFO = "UPDATE PERSON SET FIRSTNAME = ?, MIDDLE_INITIAL = ?, LASTNAME = ?, ADDRESS01 = ?, ADDRESS02 = ?, CITY = ?, STATE = ?, ZIPCODE = ?, AGE = ?. BIRTHDATE = ?, PHONE = ?, EMAIL = ?";
	String DELETE_CONTACT_INFO_BY_ID = "DELETE FROM PERSON WHERE PERSON_ID = ?";
	String DELETE_ALL_CONTACT_INFO = "DELETE FROM PERSON";
	
	
	@Override
	public List<Person> findAllPersonInformation() throws SecurityException, IOException {
		List<Person> personList =  jdbcTemplate.query(GET_ALL_CONTACT_INFO, BeanPropertyRowMapper.newInstance(Person.class));
		
		LOGGER.info("Retrieved all persons...");
		
		return personList;
	}

	@Override
	public ResponseEntity<Person> findPersonById(@PathVariable int personId)
			throws ResourceNotFoundException, SecurityException, IOException {
		
		Person personInfo = jdbcTemplate.queryForObject(GET_CONTACT_INFO_BY_ID,BeanPropertyRowMapper.newInstance(Person.class), personId);
		
		LOGGER.info("Retrieved Person Info: " + personInfo.getFirstname() + " " + personInfo.getLastname());
		
		return ResponseEntity.ok().body(personInfo);
	}

	@Override
	public ResponseEntity<Person> findPersonByLastName(@PathVariable String lastname) {
		
		Person person = jdbcTemplate.queryForObject(GET_CONTACT_INFO_BY_LASTNAME,BeanPropertyRowMapper.newInstance(Person.class), lastname);
		
		LOGGER.info("Retrieved Person with Last Name: " + lastname);
		
		return ResponseEntity.ok().body(person);
	}

	@Override
	public ResponseEntity<Person> findPersonByEmail(String email) {
		
		Person person = jdbcTemplate.queryForObject(GET_CONTACT_INFO_BY_EMAIL, BeanPropertyRowMapper.newInstance(Person.class), email);
		
		LOGGER.info("Retrieved person with email: " + email);
		
		return ResponseEntity.ok().body(person);
	}

	@Override
	public ResponseEntity<Person> findPersonByPhone(String phone) {
		
		Person person = jdbcTemplate.queryForObject(GET_CONTACT_INFO_BY_PHONE, BeanPropertyRowMapper.newInstance(Person.class), phone);
		
		LOGGER.info("Retrived person with phone: " + phone);
		
		return ResponseEntity.ok().body(person);
	}
	
	@Override
	public int addPersonInformation(@RequestBody Person person) throws SecurityException, IOException {
		
		String firstname = person.getFirstname();
		String middleInitial = person.getMiddleInitial();
		String lastname = person.getLastname();
		String address01 = person.getAddress01();
		String address02 = person.getAddress02();
		String city = person.getCity();
		String state = person.getState();
		String zip = person.getZipcode();
		int age = person.getAge();
		String birthdate = person.getBirthdate();
		String phone = person.getPhone();
		String email = person.getEmail();
		
		LOGGER.info("Adding Person Information for " + firstname + " " + lastname);
		
		return jdbcTemplate.update(INSERT_NEW_CONTACT_INFO, new Object[] {
				firstname,
				middleInitial,
				lastname,
				address01,
				address02,
				city,
				state,
				zip,
				age,
				birthdate,
				phone,
				email
				});
		}

	@Override
	public int updatePersonInformation(@PathVariable int personId, @RequestBody Person person)
			throws SecurityException, IOException {
		
		person = jdbcTemplate.queryForObject(GET_CONTACT_INFO_BY_ID,BeanPropertyRowMapper.newInstance(Person.class), personId);
			
		return jdbcTemplate.update(UPDATE_CONTACT_INFO, new Object[] {
				person.getFirstname(), 
				person.getMiddleInitial(), 
				person.getLastname(), 
				person.getAddress01(), 
				person.getAddress02(), 
				person.getCity(), 
				person.getState(), 
				person.getZipcode(),
				person.getAge(), 
				person.getBirthdate(), 
				person.getPhone(), 
				person.getEmail()} );
	}

	@Override
	public int deletePersonInformation(@PathVariable int personId) throws SecurityException, IOException {
		int count = jdbcTemplate.update(DELETE_CONTACT_INFO_BY_ID, personId);
		
		LOGGER.info("Deleting Person Information By ID: " + personId);
		
		return count;
	}

	@Override
	public long getCountOfPersonInformation() {
		long count = jdbcTemplate.queryForObject(GET_COUNT_OF_PERSON_INFO, Integer.class);
		
		LOGGER.info("Getting person count...");
		
		return count;
	}

	@Override
	public int deleteAllPersonInformation() {
		int count = jdbcTemplate.update(DELETE_ALL_CONTACT_INFO);
		
		LOGGER.info("Deleting All Person Information...");
		
		return count;
	}

}
