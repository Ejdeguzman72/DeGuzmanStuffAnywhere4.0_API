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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.MedicalTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.MedicalTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.service.MedicalTrxService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.AutoShopListResponse;
import com.deguzman.domain_financial.MedicalTransactionAddRequest;
import com.deguzman.domain_financial.MedicalTransactionAddResponse;
import com.deguzman.domain_financial.MedicalTransactionDeleteByIdResponse;
import com.deguzman.domain_financial.MedicalTransactionUpdateRequest;
import com.deguzman.domain_financial.MedicalTransactionUpdateResponse;
import com.deguzman.domain_financial.MedicalTrxListResponse;
import com.deguzman.domain_financial.MedicalTrxSearchByIdRequest;
import com.deguzman.domain_financial.MedicalTrxSearchByOfficeRequest;
import com.deguzman.domain_financial.MedicalTrxSearchByTypeRequest;
import com.deguzman.domain_financial.MedicalTrxSearchByUserRequest;
import com.deguzman.domain_financial.MedicallTrxSearchResponse;
import com.deguzman.domain_financial.TransactionDeleteAllResponse;
import com.deguzman.domain_financial.TransactionDeleteByIdRequest;

@RestController
@CrossOrigin
public class MedicalTrxController {

	@Autowired
	private MedicalTrxService medicalTrxService;
	
	@Autowired
	private MedicalTrxService medicalTrxPageService;

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTrxListResponse>> getAllMedicalTrxInformation() {
		MedicalTrxListResponse response = medicalTrxService.findAllMedicalTransactionInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_LIST_PAGINATION)
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return medicalTrxPageService.getAllTransactionsPagination(paymentDate, page, size);
	}


	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_BY_FACILITY)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTrxListResponse>> getAllMedicalTrxInformationByFacility(@RequestBody MedicalTrxSearchByOfficeRequest request) {
		MedicalTrxListResponse response = medicalTrxService.findAllMedicalTranactionsByFacility(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_BY_TYPE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTrxListResponse>> getAllMedicalTrxInformationByType(@RequestBody MedicalTrxSearchByTypeRequest request) {
		MedicalTrxListResponse response = medicalTrxService.findMedicalTransactionsByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_DTO_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTrxListResponse>> getAllMedicalTrxInformationByUser(@RequestBody MedicalTrxSearchByUserRequest request) {
		MedicalTrxListResponse response = medicalTrxService.findmedicalTransactionsByUser(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

//	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_BY_ID)
//	@CrossOrigin
//	public ResponseEntity<SuccessResponse<MedicalTransaction>> getMedicalTrxById(@RequestBody MedicalTrxSearchByIdRequest request)
//			throws ResourceNotFoundException {
//		MedicalTransaction transaction = medicalTrxService.find
//	}
	
	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_DTO_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicallTrxSearchResponse>> getMedicalTrxDTOById(@RequestBody MedicalTrxSearchByIdRequest request)
			throws ResourceNotFoundException {
		MedicallTrxSearchResponse response = medicalTrxService.findMedicalTransasctionInformationDTOById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_MEDICAL_TRX_COUNT)
	@CrossOrigin
	public long getMedicalTrxCount() {
		return medicalTrxService.getCountOfMedicalTransactions();
	}

	@PostMapping(value = UriConstants.URI_ADD_MEDICAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTransactionAddResponse>> addMedicalTransaction(@RequestBody MedicalTransactionAddRequest request) throws ResourceNotFoundException {
		MedicalTransactionAddResponse response = medicalTrxService.addMedicalTranactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_MEDICAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTransactionUpdateResponse>> updateMedicalTransactionInformation(@RequestBody MedicalTransactionUpdateRequest request) throws ResourceNotFoundException {
		MedicalTransactionUpdateResponse response = medicalTrxService.updateMedicalTransaction(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_MEDICAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MedicalTransactionDeleteByIdResponse>> deleteMedicalTrxById(@RequestBody TransactionDeleteByIdRequest request) {
		MedicalTransactionDeleteByIdResponse response = medicalTrxService.deleteMedicalTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_MEDICAL_TRX_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<TransactionDeleteAllResponse>> deleteAllMedicalTransactions() {
		TransactionDeleteAllResponse response = medicalTrxService.deleteAllMedicalTransactions();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
