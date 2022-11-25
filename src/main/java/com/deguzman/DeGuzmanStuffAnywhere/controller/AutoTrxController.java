package com.deguzman.DeGuzmanStuffAnywhere.controller;

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

import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionTypeException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidUserException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.service.AutoTrxService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.AutoShopDeleteByIdRequest;
import com.deguzman.domain_financial.AutoTransactionAddRequest;
import com.deguzman.domain_financial.AutoTransactionAddResponse;
import com.deguzman.domain_financial.AutoTransactionDeleteByIdResponse;
import com.deguzman.domain_financial.AutoTransactionUpdateRequest;
import com.deguzman.domain_financial.AutoTransactionUpdateResponse;
import com.deguzman.domain_financial.AutoTrxListResponse;
import com.deguzman.domain_financial.AutoTrxSearchByIdRequest;
import com.deguzman.domain_financial.AutoTrxSearchByTypeRequest;
import com.deguzman.domain_financial.AutoTrxSearchByUserRequest;
import com.deguzman.domain_financial.AutoTrxSearchByVehicleRequest;
import com.deguzman.domain_financial.AutoTrxSearchResponse;
import com.deguzman.domain_financial.TransactionDeleteAllResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AutoTrxController {
	
	@Autowired
	private AutoTrxService autoTrxService;

	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_LIST)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTrxListResponse>> getAllAutoTransactionInformation() {
		AutoTrxListResponse response = autoTrxService.findAllAutoTransactionInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_LIST_PAGINATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return autoTrxService.getAllTransactionsPagination(paymentDate, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_BY_VEHICLE)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTrxListResponse>> getAutoTransactionsByVehicle(@RequestBody AutoTrxSearchByVehicleRequest request) {
		AutoTrxListResponse response = autoTrxService.findAutoTransactionsByVehicle(request.getVehicleId());
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_BY_USER)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTrxListResponse>> getAutoTransactionsByUser(@RequestBody AutoTrxSearchByUserRequest request) {
		AutoTrxListResponse response = autoTrxService.findAutoTransactionsByUser(request.getUserId());
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_BY_TYPE)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTrxListResponse>> getAutoTransactionsByType(@RequestBody AutoTrxSearchByTypeRequest request) {
		AutoTrxListResponse response = autoTrxService.findAutoTransactionsByType(request.getTranactionTypeId());
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_DTO_BY_ID)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTrxSearchResponse>> getAutoTransactionDTOById(@RequestBody AutoTrxSearchByIdRequest request)
			throws InvalidTransactionException {
		AutoTrxSearchResponse response = autoTrxService.findAutoTransactionInformationDTOById(request.getTranactionId());
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_BY_ID)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<AutoTransaction> getAutoTransactionById(@PathVariable long auto_transaction_id)
			throws InvalidTransactionException {
		ResponseEntity<AutoTransaction> response = autoTrxService.findAutoTransactionInformationById(auto_transaction_id);
		return response;
	}

	@GetMapping(value = UriConstants.URI_GET_AUTO_TRX_COUNT)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public long getAutoTransactionCount() {
		return autoTrxService.getCountOfAutoTransactions();
	}

	@PostMapping(value = UriConstants.URI_ADD_AUTO_TRX_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTransactionAddResponse>> addAutoTransactionInformation(@RequestBody AutoTransactionAddRequest request)
			throws InvalidAutoShopException, InvalidUserException, InvalidTransactionTypeException,
			InvalidVehicleException {
		AutoTransactionAddResponse response = autoTrxService.addAutoTranactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_AUTO_TRX_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTransactionUpdateResponse>> updateAutoTransactionInformation(@RequestBody AutoTransactionUpdateRequest request) throws InvalidAutoShopException, InvalidVehicleException, InvalidTransactionTypeException, InvalidUserException {
		AutoTransactionUpdateResponse response = autoTrxService.updateTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_AUTO_TRX_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<AutoTransactionDeleteByIdResponse>> deleteAutoTransactionById(@RequestBody AutoShopDeleteByIdRequest request) {
		AutoTransactionDeleteByIdResponse response =  autoTrxService.deleteAutoTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_AUTO_TRX_INFORMATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<TransactionDeleteAllResponse>> deleteAllAutoTransactions() {
		TransactionDeleteAllResponse response = autoTrxService.deleteAllAutoTransactions();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
