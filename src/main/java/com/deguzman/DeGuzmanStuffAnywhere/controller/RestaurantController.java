package com.deguzman.DeGuzmanStuffAnywhere.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.service.RestaurantInfoService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.RestaurantAddRequest;
import com.deguzman.domain_entity.RestaurantAddResponse;
import com.deguzman.domain_entity.RestaurantDeleteAllResponse;
import com.deguzman.domain_entity.RestaurantDeleteByIdRequest;
import com.deguzman.domain_entity.RestaurantDeleteByIdResponse;
import com.deguzman.domain_entity.RestaurantListResponse;
import com.deguzman.domain_entity.RestaurantSearchByIdRequest;
import com.deguzman.domain_entity.RestaurantSearchByNameRequest;
import com.deguzman.domain_entity.RestaurantSearchByTypeRequest;
import com.deguzman.domain_entity.RestaurantSearchByZipRequest;
import com.deguzman.domain_entity.RestaurantSearchResponse;
import com.deguzman.domain_entity.RestaurantUpdateRequest;
import com.deguzman.domain_entity.RestaurantUpdateResponse;

@RestController
@CrossOrigin
public class RestaurantController {
	
	@Autowired
	private RestaurantInfoService restaurantInfoService;

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantListResponse>> getAllRestaurantInformation() {
		RestaurantListResponse response = restaurantInfoService.findAllRestaurants();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_LIST_PAGINATION)
	public ResponseEntity<Map<String, Object>> getAllRestaurantsPagination(@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return restaurantInfoService.getAllRestaurantsPagination(name, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_BY_TYPE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantListResponse>> getAllRestaurantInformationByType(@RequestBody RestaurantSearchByTypeRequest request) {
		RestaurantListResponse response = restaurantInfoService.findAllRestaurantsByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_BY_ZIP)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantListResponse>> getAllRestaurantInformationByZip(@RequestBody RestaurantSearchByZipRequest request) {
		RestaurantListResponse response = restaurantInfoService.findRestaurantByZipCode(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_BY_DESCR)
	@CrossOrigin
	public List<RestaurantInfoDTO> getAllRestaurantInformationByDescr(@PathVariable String descr) {
		return restaurantInfoService.findRestaurantsByDescr(descr);
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_INFO_DTO_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantSearchResponse>> getRestaurantDTOInfoById(@RequestBody RestaurantSearchByIdRequest request)
			throws InvalidRestaurantException {
		RestaurantSearchResponse response = restaurantInfoService.findRestaurantById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_BY_ID)
	public ResponseEntity<SuccessResponse<RestaurantSearchResponse>> getRestaurantInfoById(@RequestBody RestaurantSearchByIdRequest request) throws InvalidRestaurantException {
		RestaurantSearchResponse response = restaurantInfoService.findRestaurantById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_BY_NAME)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantSearchResponse>> getRestaurantInformationByName(@RequestBody RestaurantSearchByNameRequest request) {
		RestaurantSearchResponse response = restaurantInfoService.findRestaurantByName(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_COUNT)
	@CrossOrigin
	public long getRestaurantCount() {
		return restaurantInfoService.getRestaurantCount();
	}

	@PostMapping(value = UriConstants.URI_ADD_RESTAURANT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantAddResponse>> addRestaurantInformation(@RequestBody RestaurantAddRequest request) throws ResourceNotFoundException, DuplicateRestaurantException {
		RestaurantAddResponse response = restaurantInfoService.addRestaurantInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PutMapping(value = UriConstants.URI_UPDATE_RESTAURANT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantUpdateResponse>> updateRestaurantInformation(@RequestBody RestaurantUpdateRequest request) throws ResourceNotFoundException {
		RestaurantUpdateResponse response = restaurantInfoService.updateRestaurantInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_RESTAURANT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantDeleteByIdResponse>> deleteRestaurantInformationById(@RequestBody RestaurantDeleteByIdRequest request) {
		RestaurantDeleteByIdResponse response = restaurantInfoService.deleteRestaurantInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_RESTAURANT_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<RestaurantDeleteAllResponse>> deleteAllRestaurantInformation() {
		RestaurantDeleteAllResponse response = restaurantInfoService.deleteAllRestaurantInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
