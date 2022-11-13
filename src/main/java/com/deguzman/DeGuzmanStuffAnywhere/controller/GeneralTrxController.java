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

import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.service.GeneralTrxService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_financial.GeneralTransactionAddRequest;
import com.deguzman.domain_financial.GeneralTransactionAddResponse;
import com.deguzman.domain_financial.GeneralTransactionDeleteByIdResponse;
import com.deguzman.domain_financial.GeneralTransactionUpdateRequest;
import com.deguzman.domain_financial.GeneralTransactionUpdateResponse;
import com.deguzman.domain_financial.GeneralTrxListResponse;
import com.deguzman.domain_financial.GeneralTrxSearchByIdRequest;
import com.deguzman.domain_financial.GeneralTrxSearchByTypeRequest;
import com.deguzman.domain_financial.GeneralTrxSearchByUserRequest;
import com.deguzman.domain_financial.GeneratlTrxDTOSearchResponse;
import com.deguzman.domain_financial.TransactionDeleteAllResponse;
import com.deguzman.domain_financial.TransactionDeleteByIdRequest;

@RestController
@CrossOrigin
public class GeneralTrxController {

	@Autowired
	private GeneralTrxService generalTrxService;

	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneralTrxListResponse>> getAllGeneralTransactionInformation() {
		GeneralTrxListResponse response = generalTrxService.findAllTransactionInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_LIST_PAGINATION)
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return generalTrxService.getAllTransactionsPagination(paymentDate, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_BY_TYPE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneralTrxListResponse>> getTransactionsByType(@RequestBody GeneralTrxSearchByTypeRequest request) {
		GeneralTrxListResponse response = generalTrxService.findTransactionsByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_BY_USER)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneralTrxListResponse>> getTransactionsByUser(@RequestBody GeneralTrxSearchByUserRequest request) {
		GeneralTrxListResponse response = generalTrxService.findTransactionsByUser(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_DTO_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneratlTrxDTOSearchResponse>> getTrxInformationDTOById(@RequestBody GeneralTrxSearchByIdRequest request)
			throws ResourceNotFoundException {
		GeneratlTrxDTOSearchResponse response = generalTrxService.findTranactionInformationDTOById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_BY_ID)
	@CrossOrigin
	public GeneralTransaction getTrxInformationById(@PathVariable long transaction_id)
			throws ResourceNotFoundException {
		return generalTrxService.findTransactionInformationById(transaction_id);
	}

	@GetMapping(value = UriConstants.URI_GET_GENERAL_TRX_COUNT)
	@CrossOrigin
	public long getTransactionCcount() {
		return generalTrxService.findCountOfGeneralTransacion();
	}

	@PostMapping(value = UriConstants.URI_ADD_GENERAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneralTransactionAddResponse>> addGeneralTrasactionInformation(@RequestBody GeneralTransactionAddRequest request)
			throws ResourceNotFoundException {
		GeneralTransactionAddResponse response = generalTrxService.addTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_GENERAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneralTransactionUpdateResponse>> updateTransactionInformation(@RequestBody GeneralTransactionUpdateRequest request) throws ResourceNotFoundException {
		GeneralTransactionUpdateResponse response = generalTrxService.updateTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_GENERAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<GeneralTransactionDeleteByIdResponse>> deleteTransactionById(@RequestBody TransactionDeleteByIdRequest request) {
		GeneralTransactionDeleteByIdResponse response = generalTrxService.deleteTransactioninformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_GENERAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<TransactionDeleteAllResponse>> deleteAllTransactions() {
		TransactionDeleteAllResponse response = generalTrxService.deleteAllTransactions();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
