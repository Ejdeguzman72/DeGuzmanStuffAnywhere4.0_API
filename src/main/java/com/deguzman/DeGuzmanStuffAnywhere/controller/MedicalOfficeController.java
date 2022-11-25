package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateOfficeException;
import com.deguzman.DeGuzmanStuffAnywhere.service.MedicalOfficeService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.MedicalOfficeAddRequest;
import com.deguzman.domain_entity.MedicalOfficeAddResponse;
import com.deguzman.domain_entity.MedicalOfficeDeleteAllResponse;
import com.deguzman.domain_entity.MedicalOfficeDeleteByIdRequest;
import com.deguzman.domain_entity.MedicalOfficeDeleteByIdResponse;
import com.deguzman.domain_entity.MedicalOfficeListResponse;
import com.deguzman.domain_entity.MedicalOfficeSearchByIdRequest;
import com.deguzman.domain_entity.MedicalOfficeSearchByZipRequest;
import com.deguzman.domain_entity.MedicalOfficeSearchResponse;
import com.deguzman.domain_entity.MedicalOfficeUpdateRequest;
import com.deguzman.domain_entity.MedicalOfficeUpdateResponse;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MedicalOfficeController {

	@Autowired
	private MedicalOfficeService medOfficeService;

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_OFFICE_LIST)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeListResponse>> getAllMedicalOfficeInformation() {
		MedicalOfficeListResponse response = medOfficeService.findAllmedicalOfficeInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_OFFICE_LIST_PAGINATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Map<String, Object>> getAllMedicalOfficesPagination(
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return medOfficeService.getAllMedicalOfficesPagination(name, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_OFFICE_BY_ZIP)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeListResponse>> getAllMedicalOfficeInformationByZipCode(@RequestBody MedicalOfficeSearchByZipRequest request) {
		MedicalOfficeListResponse response = medOfficeService.findMedicalofficesByZip(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_OFFICE_BY_ID)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeSearchResponse>> getMedicalOfficeInformationById(@RequestBody MedicalOfficeSearchByIdRequest request) {
		MedicalOfficeSearchResponse response = medOfficeService.findMedicalOfficeInformationById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_OFFICE_COUNT)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public long getMedicalOfficeCount() {
		return medOfficeService.getMedicalOfficeCount();
	}

	@PostMapping(value = UriConstants.URI_ADD_MEDICAL_OFFICE_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeAddResponse>> addMedicalOfficeInformation(@RequestBody MedicalOfficeAddRequest request) throws DuplicateOfficeException {
		MedicalOfficeAddResponse response = medOfficeService.addMedicalOfficeInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_MEDICAL_OFFICE_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeUpdateResponse>> updateMedicalOfficeInformation(@RequestBody MedicalOfficeUpdateRequest request) {
		MedicalOfficeUpdateResponse response = medOfficeService.updateMedicalOfficeInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_MEDICAL_OFFICE_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeDeleteByIdResponse>> deleteMedicalOfficeById(@RequestBody MedicalOfficeDeleteByIdRequest request) {
		MedicalOfficeDeleteByIdResponse response = medOfficeService.deleteMedicalOfficeById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_MEDICAL_OFFICE_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<MedicalOfficeDeleteAllResponse>> deleteAllMedicalOffices() {
		MedicalOfficeDeleteAllResponse response = medOfficeService.deleteAllMedicalOfficeInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
