package com.deguzman.DeGuzmanStuffAnywhere.service;

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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.MedicalTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.MedicalTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.MedicalTrxJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.MedicalTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
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

@Service
public class MedicalTrxService {

	@Autowired
	private MedicalTrxDaoImpl medicalTrxDaoImpl;
	
	@Autowired
	private MedicalTrxJpaDao medicalTrxDao;
	
	public MedicalTrxListResponse findAllMedicalTransactionInformation() {
		MedicalTrxListResponse response = new MedicalTrxListResponse(); 
		List<MedicalTrxInfoDTO> list = new ArrayList<>();
		
		list = medicalTrxDaoImpl.findAllMedicalTransactionInformation();
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MEDICAL_TRX_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_TRX_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<MedicalTransaction> shop = medicalTrxDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<MedicalTransaction> pageBooks = null;

			if (paymentDate == null) {
				pageBooks = medicalTrxDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("transactions", shop);
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
	
	public MedicalTrxListResponse findAllMedicalTranactionsByFacility(MedicalTrxSearchByOfficeRequest request) {
		MedicalTrxListResponse response = new MedicalTrxListResponse(); 
		List<MedicalTrxInfoDTO> list = new ArrayList<>();
		
		list = medicalTrxDaoImpl.findMedicalTransactionsByFacility(request.getOfficeId());
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MEDICAL_TRX_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_TRX_LIST_MSG);
		
		return response;
	}
	
	public MedicalTrxListResponse findMedicalTransactionsByType(MedicalTrxSearchByTypeRequest request) {
		MedicalTrxListResponse response = new MedicalTrxListResponse(); 
		List<MedicalTrxInfoDTO> list = new ArrayList<>();
		
		list = medicalTrxDaoImpl.findMedicalTransactionsByType(request.getTranactionTypeId());
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MEDICAL_TRX_LIST_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_TRX_LIST_BY_TYPE_MSG);
		
		return response;
	}
	
	public MedicalTrxListResponse findmedicalTransactionsByUser(MedicalTrxSearchByUserRequest request) {
		MedicalTrxListResponse response = new MedicalTrxListResponse(); 
		List<MedicalTrxInfoDTO> list = new ArrayList<>();
		
		list = medicalTrxDaoImpl.findAllMedicalTransactionbyUser(request.getUserId());
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MEDICAL_TRX_LIST_BY_USER_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_TRX_LIST_BY_USER_MSG);
		
		return response;
	}
	
	public MedicallTrxSearchResponse findMedicalTransasctionInformationDTOById(MedicalTrxSearchByIdRequest request) throws ResourceNotFoundException {
		MedicallTrxSearchResponse response = new MedicallTrxSearchResponse();
		MedicalTrxInfoDTO transaction = medicalTrxDaoImpl.findMedicalTransactionInformationDTOById(request.getTranactionId());
		
		response.setTransaction(transaction);
		response.setDescription(AppConstants.FIND_MEDICAL_TRX_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_MEDICAL_TRX_BY_ID_MSG);
		
		return response;
	}
	
	public long getCountOfMedicalTransactions() {
		return medicalTrxDaoImpl.getCountOfMedicalTransactions();
	}
	
	public MedicalTransactionAddResponse addMedicalTranactionInformation(MedicalTransactionAddRequest request) throws ResourceNotFoundException {
		MedicalTransactionAddResponse response = new MedicalTransactionAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction transaction = new com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction();
		
		transaction.setAmount(request.getAmount());
		transaction.setMedical_office_id(request.getMedical_office_id());
		transaction.setMedical_transaction_date(request.getMedical_transaction_date());
		transaction.setTransaction_type_id(request.getTransaction_type_id());
		transaction.setUser_id(request.getUser_id());
		
		int result = medicalTrxDaoImpl.addMedicalTransactionInformation(request);
		
		response.setTransaction(transaction);
		response.setRecordsAdded(result);
		response.setDescription(AppConstants.ADD_MEDICAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_MEDICAL_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public MedicalTransactionUpdateResponse updateMedicalTransaction(MedicalTransactionUpdateRequest request) throws ResourceNotFoundException {
		MedicalTransactionUpdateResponse response = new MedicalTransactionUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction transaction = medicalTrxDaoImpl.findMedicalTransactionInformationById(request.getMedical_transaction_id());
		int recordsUpdated = medicalTrxDaoImpl.updateMedicalTransaction(request.getMedical_transaction_id(), request);
		
		response.setTransaction(transaction);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_MEDICAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_MEDICAL_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public MedicalTransactionDeleteByIdResponse deleteMedicalTransactionInformation(TransactionDeleteByIdRequest request) {
		MedicalTransactionDeleteByIdResponse response = new MedicalTransactionDeleteByIdResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction transaction = new com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction();
		int recordsDeleted = medicalTrxDaoImpl.deleteMedicalTraansactionInformation(request.getTransactionId());
		
		response.setDeleted(recordsDeleted);
		response.setTransaction(transaction);
		response.setDescription(AppConstants.DELETE_MEDICAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_MEDICAL_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public TransactionDeleteAllResponse deleteAllMedicalTransactions() {
		TransactionDeleteAllResponse response = new TransactionDeleteAllResponse();
		int recordsDeleted = medicalTrxDaoImpl.deleteAllMedicalTransactions();
		
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_ALL_MEDICAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_MEDICAL_TRX_INFORMATION_MSG);
		
		return response;
	}
}

