package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.ContactDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateContactException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Person;
import com.deguzman.DeGuzmanStuffAnywhere.service.ContactService;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
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
import com.deguzman.domain.SuccessResponse;

@RestController
@CrossOrigin
public class ContactInfoController {

	@Autowired
	private ContactService contactInfoService;

	@GetMapping(value = UriConstants.URI_GET_CONTACT_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactListResponse>> getAllPersonInfo() throws SecurityException, IOException {
		ContactListResponse response = contactInfoService.findAllPersonInformation();
		
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_CONTACT_LIST_PAGINATION)
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllPersonsPagination(@RequestParam(required = false) String firstname,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return contactInfoService.getAllPersonsPagination(firstname, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_CONTACT_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactSearchResponse>> getPersonInformationById(@RequestBody ContactSearchByIdRequest request)
			throws ResourceNotFoundException, SecurityException, IOException {
		ContactSearchResponse response = contactInfoService.findPersonById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_CONTACT_BY_LASTNAME)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactSearchResponse>> getPersonInformationByLastname(@RequestBody ContactSearchByLastnameRequest request) {
		ContactSearchResponse response =  contactInfoService.findPersonByLastname(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_CONTACT_BY_EMAIL)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactSearchResponse>> getPersonInformationByEmail(@RequestBody ContactSearchByEmailRequest request) {
		ContactSearchResponse response = contactInfoService.findPersonByEmail(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_CONTACT_BY_PHONE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactSearchResponse>> getPersonInformationByPhone(@RequestBody ContactSearchByPhoneRequest request) {
		ContactSearchResponse response = contactInfoService.findPersonByPhone(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_CONTACT_COUNT)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactCountResponse>> getCountOfPersonInfo() {
		ContactCountResponse response= contactInfoService.getCountofPersonInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PostMapping(value = UriConstants.URI_ADD_CONTACT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactAddResponse>> saveContactInformation(@RequestBody ContactAddRequest request) throws SecurityException, IOException, DuplicateContactException {
		ContactAddResponse response = contactInfoService.addPersonInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_CONTACT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactUpdateResponse>> updateContactInformation(@RequestBody ContactUpdateRequest request) throws SecurityException, IOException, ResourceNotFoundException {
		ContactUpdateResponse response = contactInfoService.updatePersonInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_CONTACT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactDeleteAllResponse>> deleteAllContactInformation() {
		ContactDeleteAllResponse response = contactInfoService.deleteAllPersonInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_CONTACT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ContactDeleteResponse>> deleteContactInformation(@RequestBody ContactDeleteByIdRequest request) throws SecurityException, IOException, ResourceNotFoundException {
		ContactDeleteResponse response = contactInfoService.deletePersonInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
