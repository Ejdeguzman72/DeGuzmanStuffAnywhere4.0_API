package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.dto.UtilityInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Utility;
import com.deguzman.DeGuzmanStuffAnywhere.service.UtilityService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.AutoShopListResponse;
import com.deguzman.domain_entity.UtilityAddRequest;
import com.deguzman.domain_entity.UtilityAddResponse;
import com.deguzman.domain_entity.UtilityDTOSearchResponse;
import com.deguzman.domain_entity.UtilityDeleteAllResponse;
import com.deguzman.domain_entity.UtilityDeleteByIdRequest;
import com.deguzman.domain_entity.UtilityDeleteByIdResponse;
import com.deguzman.domain_entity.UtilityListResponse;
import com.deguzman.domain_entity.UtilitySearchByDueDateRequest;
import com.deguzman.domain_entity.UtilitySearchByIdRequest;
import com.deguzman.domain_entity.UtilitySearchByNameRequest;
import com.deguzman.domain_entity.UtilitySearchByTypeRequest;
import com.deguzman.domain_entity.UtilitySearchResponse;

@RestController
@CrossOrigin
public class UtilityController {

	@Autowired
	private UtilityService utilityService;

	@GetMapping(value = UriConstants.URI_GET_UTILITY_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityListResponse>> getAllUtilityInformation() {
		UtilityListResponse response = utilityService.findAllUtilityInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_DUE_DATE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityListResponse>> getUtilityInformationByDueDate(@RequestBody UtilitySearchByDueDateRequest request) {
		UtilityListResponse response = utilityService.findUtilityInformationByDueDate(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilitySearchResponse>> getUtilityInformationById(@RequestBody UtilitySearchByIdRequest request) {
		UtilitySearchResponse response = utilityService.findUtilityInformationById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_NAME)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityDTOSearchResponse>> getUtilityInformationByName(@RequestBody UtilitySearchByNameRequest request) {
		UtilityDTOSearchResponse response = utilityService.findUtilityInformationByName(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_TYPE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityDTOSearchResponse>> getUtilityInformationByType(@RequestBody UtilitySearchByTypeRequest request) {
		UtilityDTOSearchResponse response = utilityService.findUtilityInformationByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_COUNT)
	@CrossOrigin
	public long getCountOfUtilities() {
		return utilityService.findUtilityCount();
	}

	@GetMapping(value = UriConstants.URI_ADD_UTILITY_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityAddResponse>> addUtilityInformation(@RequestBody UtilityAddRequest request) {
		UtilityAddResponse response = utilityService.addUtilityInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_UTILITY_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityDeleteByIdResponse>> deleteUtilityInformationById(@RequestBody UtilityDeleteByIdRequest request) {
		UtilityDeleteByIdResponse response = utilityService.deleteUtilityInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_UTILITY_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<UtilityDeleteAllResponse>> deleteAllUtilityInformation() {
		UtilityDeleteAllResponse response = utilityService.deleteAllUtilityInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
