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


@Service
public class AutoTrxService {
	
	@Autowired
	private AutoTrxDaoImpl autoTrxDaoImpl;
	
	@Autowired
	private AutoTrxJpaDao autoTrxDao;
	
	public List<AutoTrxInfoDTO> findAllAutoTransactionInformation() {
		return autoTrxDaoImpl.findAllAutoTransactionInformation();
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
	
	public List<AutoTrxInfoDTO> findAutoTransactionsByVehicle(long vehicle_id) {
		return autoTrxDaoImpl.findAutoTransactionsByVehicle(vehicle_id);
	}
	
	public List<AutoTrxInfoDTO> findAutoTransactionsByUser(long user_id) {
		return autoTrxDaoImpl.findAutoTransactionsByUser(user_id);
	}
	
	public List<AutoTrxInfoDTO> findAutoTransactionsByType(long transaction_type_id) {
		return autoTrxDaoImpl.findAutoTransactionsByType(transaction_type_id);
	}
	
	public ResponseEntity<AutoTrxInfoDTO> findAutoTransactionInformationDTOById(@PathVariable long auto_shop_id) throws InvalidTransactionException {
		return autoTrxDaoImpl.findAutoTranasctionInformatioDTOnById(auto_shop_id);
	}
	
	public ResponseEntity<com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction> findAutoTransactionInformationById(@PathVariable long auto_transaction_id) throws InvalidTransactionException {
		return autoTrxDaoImpl.findAutoTranasctionInformationById(auto_transaction_id);
	}
	
	public long getCountOfAutoTransactions() {
		return autoTrxDaoImpl.getCountOfAutoTransactions();
	}
	
	public int addAutoTranactionInformation(com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction autoTransaction) throws InvalidAutoShopException, InvalidUserException, InvalidTransactionTypeException, InvalidVehicleException {
		return autoTrxDaoImpl.addAutoTransactionInformation(autoTransaction);
	}
	
	public int updateTransactionInformation(long auto_transaction_id, com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction autoTransactionDetails) throws InvalidAutoShopException, InvalidVehicleException, InvalidTransactionTypeException, InvalidUserException {
		return autoTrxDaoImpl.updateTransactionInformation(auto_transaction_id, autoTransactionDetails);
	}
	
	public int deleteAutoTransactionInformation(long auto_transaction_id) {
		return autoTrxDaoImpl.deleteAutoTransactionInformation(auto_transaction_id);
	}
	
	public int deleteAllAutoTransactions() {
		return autoTrxDaoImpl.deleteAllAutoTransactions();
	}
}
