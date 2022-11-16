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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.AutoTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionTypeException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidUserException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.AutoTrxJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.AutoTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_entity.AutoShopDeleteByIdRequest;
import com.deguzman.domain_financial.AutoTransactionAddRequest;
import com.deguzman.domain_financial.AutoTransactionAddResponse;
import com.deguzman.domain_financial.AutoTransactionDeleteByIdResponse;
import com.deguzman.domain_financial.AutoTransactionUpdateRequest;
import com.deguzman.domain_financial.AutoTransactionUpdateResponse;
import com.deguzman.domain_financial.AutoTrxListResponse;
import com.deguzman.domain_financial.AutoTrxSearchResponse;
import com.deguzman.domain_financial.TransactionDeleteAllResponse;


@Service
public class AutoTrxService {
	
	@Autowired
	private AutoTrxDaoImpl autoTrxDaoImpl;
	
	@Autowired
	private AutoTrxJpaDao autoTrxDao;
	
	public AutoTrxListResponse findAllAutoTransactionInformation() {
		AutoTrxListResponse response = new AutoTrxListResponse();
		List<AutoTrxInfoDTO> list =  autoTrxDaoImpl.findAllAutoTransactionInformation();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTO_TRX_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_TRX_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<AutoTransaction> shop = autoTrxDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<AutoTransaction> pageBooks = null;

			if (paymentDate == null) {
				pageBooks = autoTrxDao.findAll(paging);
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
	
	public AutoTrxListResponse findAutoTransactionsByVehicle(long vehicle_id) {
		AutoTrxListResponse response = new AutoTrxListResponse();
		List<AutoTrxInfoDTO> list = autoTrxDaoImpl.findAutoTransactionsByVehicle(vehicle_id);
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTO_TRX_LIST_BY_VEHICLE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_TRX_LIST_BY_VEHICLE_MSG);
		
		return response;
		
	}
	
	public AutoTrxListResponse findAutoTransactionsByUser(long user_id) {
		AutoTrxListResponse response = new AutoTrxListResponse();
		List<AutoTrxInfoDTO> list = autoTrxDaoImpl.findAutoTransactionsByUser(user_id);
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTO_TRX_LIST_BY_USER_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_TRX_LIST_BY_USER_MSG);
		
		return response;
	}
	
	public AutoTrxListResponse findAutoTransactionsByType(long transaction_type_id) {
		AutoTrxListResponse response = new AutoTrxListResponse();
		List<AutoTrxInfoDTO> list = autoTrxDaoImpl.findAutoTransactionsByType(transaction_type_id);
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTO_TRX_LIST_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_TRX_LIST_BY_TYPE_MSG);
		
		return response;
	}
	
	public AutoTrxSearchResponse findAutoTransactionInformationDTOById(long auto_transaction_id) throws InvalidTransactionException {
		AutoTrxSearchResponse response = new AutoTrxSearchResponse();
		AutoTrxInfoDTO autoTrx = autoTrxDaoImpl.findAutoTranasctionInformatioDTOnById(auto_transaction_id);
		
		response.setTransaction(autoTrx);
		response.setDescription(AppConstants.FIND_AUTO_TRX_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_AUTO_TRX_BY_ID_MSG);
		
		return response;
		
	}
	
	public ResponseEntity<com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction> findAutoTransactionInformationById(@PathVariable long auto_transaction_id) throws InvalidTransactionException {
		return autoTrxDaoImpl.findAutoTranasctionInformationById(auto_transaction_id);
	}
	
	public long getCountOfAutoTransactions() {
		return autoTrxDaoImpl.getCountOfAutoTransactions();
	}
	
	public AutoTransactionAddResponse addAutoTranactionInformation(AutoTransactionAddRequest request) throws InvalidAutoShopException, InvalidUserException, InvalidTransactionTypeException, InvalidVehicleException {
		AutoTransactionAddResponse response = new AutoTransactionAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction autoTrx = new com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction();
		int recordsAdded = autoTrxDaoImpl.addAutoTransactionInformation(request);
		 
		autoTrx.setAuto_transaction_date(request.getAuto_transaction_date());
		autoTrx.setAmount(request.getAmount());
		autoTrx.setAuto_shop_id(request.getAuto_shop_id());
		autoTrx.setTransaction_type_id(request.getTransaction_type_id());
		autoTrx.setVehicle_id(request.getVehicle_id());
		autoTrx.setUser_id(request.getUser_id());
		 
		response.setTransaction(autoTrx);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_AUTO_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_AUTO_TRX_INFORMATION_MSG);
			
		return response;
		 
	}
	
	public AutoTransactionUpdateResponse updateTransactionInformation(AutoTransactionUpdateRequest request) throws InvalidAutoShopException, InvalidVehicleException, InvalidTransactionTypeException, InvalidUserException {
		AutoTransactionUpdateResponse response = new AutoTransactionUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction autoTrx = new com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction();
		int recordsUpdated = autoTrxDaoImpl.updateTransactionInformation(request.getAuto_transaction_id(), request);
		
		response.setTransaction(autoTrx);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_AUTO_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_AUTO_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public AutoTransactionDeleteByIdResponse deleteAutoTransactionInformation(AutoShopDeleteByIdRequest request) {
		AutoTransactionDeleteByIdResponse response = new AutoTransactionDeleteByIdResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction autoTrx = new com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction(); 
		int recordsDeleted = autoTrxDaoImpl.deleteAutoTransactionInformation(request.getAutoShopId());
		
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_AUTO_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_AUTO_TRX_INFORMATION_MSG);
		
		return response;
	}
	
	public TransactionDeleteAllResponse deleteAllAutoTransactions() {
		TransactionDeleteAllResponse response = new TransactionDeleteAllResponse();
		int deletedRecords = autoTrxDaoImpl.deleteAllAutoTransactions();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_AUTO_TRX_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_AUTO_TRX_INFORMATION_MSG);
		
		return response;
	}
}
