package com.deguzman.DeGuzmanStuffAnywhere.service;

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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.GeneralTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.GeneralTrxJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.GeneralTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
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

@Service
public class GeneralTrxService {

	@Autowired
	private GeneralTrxDaoImpl generalTrxDaoImpl;
	
	@Autowired
	private GeneralTrxJpaDao generalTrxDao;
	
	public GeneralTrxListResponse findAllTransactionInformation() {
		GeneralTrxListResponse response = new GeneralTrxListResponse();
		List<GeneralTrxInfoDTO> list = generalTrxDaoImpl.findAllTransactionInformation();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_GENERAL_TRX_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_GENERAL_TRX_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<GeneralTransaction> shop = generalTrxDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<GeneralTransaction> pageBooks = null;

			if (paymentDate == null) {
				pageBooks = generalTrxDao.findAll(paging);
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
	
	public GeneralTrxListResponse findTransactionsByUser(GeneralTrxSearchByUserRequest request) {
		GeneralTrxListResponse response = new GeneralTrxListResponse();
		List<GeneralTrxInfoDTO> list = generalTrxDaoImpl.findTransactionsByUser(request.getUserId());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_GENERAL_TRX_LIST_BY_USER_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_GENERAL_TRX_LIST_BY_USER_MSG);
		
		return response;
	}
	
	public GeneralTrxListResponse findTransactionsByType(GeneralTrxSearchByTypeRequest request) {
		GeneralTrxListResponse response = new GeneralTrxListResponse();
		List<GeneralTrxInfoDTO> list = generalTrxDaoImpl.findTransactionsByType(request.getTranactionTypeId());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_GENERAL_TRX_LIST_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_GENERAL_TRX_LIST_BY_TYPE_MSG);
		
		return response;
	}
	
	public GeneratlTrxDTOSearchResponse findTranactionInformationDTOById(GeneralTrxSearchByIdRequest request) throws ResourceNotFoundException {
		GeneratlTrxDTOSearchResponse response = new GeneratlTrxDTOSearchResponse();
		GeneralTrxInfoDTO transaction = generalTrxDaoImpl.findTransactionInformationDTOById(request.getTranactionId());
		
		response.setTransaction(transaction);
		response.setDescription(AppConstants.FIND_GENERAL_TRX_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_GENERAL_TRX_BY_ID_MSG);
		
		return response;
	}
	
	public long findCountOfGeneralTransacion() {
		return generalTrxDaoImpl.findCountOfGeneralTransaction();
	}
	
	public GeneralTransactionAddResponse addTransactionInformation(GeneralTransactionAddRequest request) throws ResourceNotFoundException {
		GeneralTransactionAddResponse response = new GeneralTransactionAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction transaction = new com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction();
		
		transaction.setAmount(request.getAmount());
		transaction.setEntity(request.getEntity());
		transaction.setPayment_date(request.getPayment_date());
		transaction.setTransaction_type_id(request.getTransaction_type_id());
		transaction.setUser_id(request.getUser_id());
		
		int recordsAdded = generalTrxDaoImpl.addTransactionInformation(request);
		
		response.setTransaction(transaction);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_GENERAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_GENERAL_TRX_INFORMATION_MSG);
			
		return response;
		
	}
	
	public GeneralTransactionUpdateResponse updateTransactionInformation(GeneralTransactionUpdateRequest request) throws ResourceNotFoundException {
		GeneralTransactionUpdateResponse response = new GeneralTransactionUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction transaction = generalTrxDaoImpl.findTransactionInformationById(request.getTransaction_id());
		int updatedRecords = generalTrxDaoImpl.updateTransactionInformation(request.getTransaction_id(), request);
		
		response.setTransaction(transaction);
		response.setUpdatedCount(updatedRecords);
		response.setDescription(AppConstants.UPDATE_GENERAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_GENERAL_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public GeneralTransactionDeleteByIdResponse deleteTransactioninformation(TransactionDeleteByIdRequest request) {
		GeneralTransactionDeleteByIdResponse response = new GeneralTransactionDeleteByIdResponse();
		int deletedRecords = generalTrxDaoImpl.deleteTransactionInformation(request.getTransactionId());
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_GENERAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_GENERAL_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public TransactionDeleteAllResponse deleteAllTransactions() {
		TransactionDeleteAllResponse response = new TransactionDeleteAllResponse();
		int deletedRecords = generalTrxDaoImpl.deleteAllTransactions();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_GENERAL_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_GENERAL_TRX_INFORMATION_MSG);
		
		return response;
	}

	public com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction findTransactionInformationById(
			long transaction_id) throws ResourceNotFoundException {
		return generalTrxDaoImpl.findTransactionInformationById(transaction_id);
	}
}
