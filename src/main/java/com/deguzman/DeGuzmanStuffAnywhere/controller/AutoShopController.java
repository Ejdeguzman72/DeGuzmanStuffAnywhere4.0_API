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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoRepairShopDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;
import com.deguzman.DeGuzmanStuffAnywhere.service.AutoRepairShopService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.ContactListResponse;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.AutoShopAddRequest;
import com.deguzman.domain_entity.AutoShopAddResponse;
import com.deguzman.domain_entity.AutoShopCountResponse;
import com.deguzman.domain_entity.AutoShopDeleteAllResponse;
import com.deguzman.domain_entity.AutoShopDeleteByIdRequest;
import com.deguzman.domain_entity.AutoShopDeleteByIdResponse;
import com.deguzman.domain_entity.AutoShopListResponse;
import com.deguzman.domain_entity.AutoShopSearchByIdRequest;
import com.deguzman.domain_entity.AutoShopSearchByNameRequest;
import com.deguzman.domain_entity.AutoShopSearchByZipRequest;
import com.deguzman.domain_entity.AutoShopSearchResponse;
import com.deguzman.domain_entity.AutoShopSearchZipResponse;
import com.deguzman.domain_entity.AutoShopUpdateRequest;
import com.deguzman.domain_entity.AutoShopUpdateResponse;

@RestController
@CrossOrigin
public class AutoShopController {

	@Autowired
	private AutoRepairShopService autoShopService;

	@GetMapping(value = UriConstants.URI_GET_AUTOSHOP_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopListResponse>> getAllAutoRepairShopInformation() {
		AutoShopListResponse response = autoShopService.findAllAutoRepairShopInfo();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTOSHOP_LIST_PAGINATION)
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllAutoShopsPagination(
			@RequestParam(required = false) String autoShopName, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return autoShopService.getAllAutoShopsPagination(autoShopName, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTOSHOP_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopSearchResponse>> getAutoRepairShopInfoById(@RequestBody AutoShopSearchByIdRequest request) {
		AutoShopSearchResponse response = autoShopService.findAutoRepairShopById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTOSHOP_BY_NAME)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopSearchResponse>> getAutoRepairShopByName(@RequestBody AutoShopSearchByNameRequest request) {
		AutoShopSearchResponse response = autoShopService.findAutoRepairShopByName(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTOSHOP_BY_ZIP)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopSearchZipResponse>> getAutoRepairShopByZip(@RequestBody AutoShopSearchByZipRequest request) {
		AutoShopSearchZipResponse response = autoShopService.findAutoRepairShopByZip(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTOSHOP_COUNT)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopCountResponse>> getCountOfAllRepairShops() {
		AutoShopCountResponse response = autoShopService.getCountOfAutoRepairShops();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PostMapping(value = UriConstants.URI_ADD_AUTOSHOP_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopAddResponse>> addAutoRepairShopInformation(@RequestBody AutoShopAddRequest request) throws DuplicateAutoShopException {
		AutoShopAddResponse response = autoShopService.addAutoRepairShopInfo(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PutMapping(value = UriConstants.URI_UPDATE_AUTOSHOP_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopUpdateResponse>> updateAutoRepairShopInformation(@RequestBody AutoShopUpdateRequest request) {
		AutoShopUpdateResponse response = autoShopService.updateAutoShopInfo(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_AUTOSHOP_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopDeleteByIdResponse>> deleteAutoShopInformationById(@RequestBody AutoShopDeleteByIdRequest request) {
		AutoShopDeleteByIdResponse response = autoShopService.deleteAutoRepairShopInfo(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_AUTOSHOP_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<AutoShopDeleteAllResponse>> deleteAllAutoRepairShopInformation() {
		AutoShopDeleteAllResponse response = autoShopService.deleteAllAutoShops();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
