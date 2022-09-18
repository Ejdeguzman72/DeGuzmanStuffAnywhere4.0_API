package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.ContactDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateContactException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.PersonJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Person;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain.ContactAddRequest;
import com.deguzman.domain.ContactAddResponse;
import com.deguzman.domain.ContactCountResponse;
import com.deguzman.domain.ContactDeleteAllResponse;
import com.deguzman.domain.ContactDeleteByIdRequest;
import com.deguzman.domain.ContactDeleteResponse;
import com.deguzman.domain.ContactListResponse;
import com.deguzman.domain.ContactSearchByEmailRequest;
import com.deguzman.domain.ContactSearchByIdRequest;
import com.deguzman.domain.ContactSearchByLastnameRequest;
import com.deguzman.domain.ContactSearchByPhoneRequest;
import com.deguzman.domain.ContactSearchResponse;
import com.deguzman.domain.ContactUpdateRequest;
import com.deguzman.domain.ContactUpdateResponse;

@Service
public class ContactService {

	@Autowired
	private ContactDaoImpl contactDaoImpl;
	
	@Autowired
	private PersonJpaDao personJpaDao;

	public ContactListResponse findAllPersonInformation() throws IOException {
		ContactListResponse response = new ContactListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Person> list = new ArrayList<>();
		
		list = contactDaoImpl.findAllPersonInformation();
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_CONTACT_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_CONTACT_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllPersonsPagination(@RequestParam(required = false) String firstname,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<Person> shop = personJpaDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Person> pageBooks = null;

			if (firstname == null) {
				pageBooks = personJpaDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("persons", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ContactSearchResponse findPersonById(ContactSearchByIdRequest request) throws ResourceNotFoundException, SecurityException, IOException {
		ContactSearchResponse response = new ContactSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = contactDaoImpl.findPersonById(request.getPersonId());
		response.setPerson(person);
		response.setDescription(AppConstants.FIND_CONTACT_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_CONTACT_BY_ID_MSG);
		
		return response;
		
	}
	
	public ContactSearchResponse findPersonByLastname(ContactSearchByLastnameRequest request) {
		ContactSearchResponse response = new ContactSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = contactDaoImpl.findPersonByLastName(request.getLastname());
		response.setPerson(person);
		response.setDescription(AppConstants.FIND_CONTACT_BY_LASTNAME_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_CONTACT_BY_LASTNAME_MSG);
		
		return response;
	}
	
	public ContactSearchResponse findPersonByEmail(ContactSearchByEmailRequest request) {
		ContactSearchResponse response = new ContactSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = contactDaoImpl.findPersonByEmail(request.getEmail());
		response.setPerson(person);
		response.setDescription(AppConstants.GET_CONTACT_BY_EMAIL_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_CONTACT_BY_EMAIL_MSG);
		
		return response;
	}
	
	public ContactSearchResponse findPersonByPhone(ContactSearchByPhoneRequest request) {
		ContactSearchResponse response = new ContactSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = contactDaoImpl.findPersonByPhone(request.getPhone());
		response.setPerson(person);
		response.setDescription(AppConstants.GET_CONTACT_BY_PHONE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_CONTACT_BY_PHONE_MSG);
		
		return response;
	}
	
	public ContactCountResponse getCountofPersonInformation() {
		ContactCountResponse response = new ContactCountResponse();
		long result = contactDaoImpl.getCountOfPersonInformation();
		
		response.setCount(result);
		response.setDescription(AppConstants.GET_CONTACT_COUNT_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_CONTACT_COUNT_MSG);
		
		return response;
	}
	
	public ContactAddResponse addPersonInformation(ContactAddRequest request) throws SecurityException, IOException, DuplicateContactException {
		ContactAddResponse response = new ContactAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = new com.deguzman.DeGuzmanStuffAnywhere.model.Person();
		
		person.setFirstname(request.getFirstname());
		person.setMiddleInitial(request.getMiddleInitial());
		person.setLastname(request.getLastname());
		person.setAge(request.getAge());
		person.setAddress01(request.getAddress01());
		person.setAddress02(request.getAddress02());
		person.setCity(request.getCity());
		person.setState(request.getState());
		person.setZipcode(request.getZipcode());
		person.setPhone(request.getPhone());
		person.setEmail(request.getEmail());
		person.setBirthdate(request.getBirthdate());
		
		int result = contactDaoImpl.addPersonInformation(request);
		
		response.setPerson(person);
		response.setRecordsAdded(result);
		response.setDescription(AppConstants.ADD_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_CONTACT_INFORMATION_MSG);
		
		return response;
	}
	
	public ContactUpdateResponse updatePersonInformation(ContactUpdateRequest request) throws SecurityException, IOException, ResourceNotFoundException {
		ContactUpdateResponse response = new ContactUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = contactDaoImpl.findPersonById(request.getPersonId());
		int updatedRecords = contactDaoImpl.updatePersonInformation(request.getPersonId(), request);
		
		response.setPerson(person);
		response.setUpdatedCount(updatedRecords);
		response.setDescription(AppConstants.UPDATE_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_CONTACT_INFORMATION_MSG);
		
		return response;
		
	}
	
	public ContactDeleteResponse deletePersonInformation(ContactDeleteByIdRequest request) throws SecurityException, IOException, ResourceNotFoundException {
		ContactDeleteResponse response = new ContactDeleteResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Person person = contactDaoImpl.findPersonById(request.getPersonId());
		int deletedRecords = contactDaoImpl.deletePersonInformation(request.getPersonId());
		
		response.setPerson(person);
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_CONTACT_INFORMATION_MSG);
		
		return response;
	}
	
	public ContactDeleteAllResponse deleteAllPersonInformation() {
		ContactDeleteAllResponse response = new ContactDeleteAllResponse();
		int deletedRecords = contactDaoImpl.deleteAllPersonInformation();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_CONTACT_INFORMATION_MSG);
		
		return response;
	}
}
