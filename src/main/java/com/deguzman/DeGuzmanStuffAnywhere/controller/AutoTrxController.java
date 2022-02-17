package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.AutoTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionTypeException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidUserException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.service.AutoTrxPaginationService;

@RestController
@RequestMapping("/app/auto-transactions")
@CrossOrigin
public class AutoTrxController {

	@Autowired
	private AutoTrxDaoImpl autoTrxDaoImpl;
	
	@Autowired
	private AutoTrxPaginationService autoTrxPageService;

	@GetMapping("/all")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<AutoTrxInfoDTO> getAllAutoTransactionInformation() {
		return autoTrxDaoImpl.findAllAutoTransactionInformation();
	}
	
	@GetMapping("/all-transactions")
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return autoTrxPageService.getAllTransactionsPagination(paymentDate, page, size);
	}

	@GetMapping("/all/vehicle/{vehicle_id}")
	@CrossOrigin
	public List<AutoTrxInfoDTO> getAutoTransactionsByVehicle(@PathVariable long vehicle_id) {
		return autoTrxDaoImpl.findAutoTransactionsByVehicle(vehicle_id);
	}

	@GetMapping("/all/users/{user_id}")
	@CrossOrigin
	public List<AutoTrxInfoDTO> getAutoTransactionsByUser(@PathVariable long user_id) {
		return autoTrxDaoImpl.findAutoTransactionsByUser(user_id);
	}

	@GetMapping("/all/type/{transaction_type_id}")
	@CrossOrigin
	public List<AutoTrxInfoDTO> getAutoTransactionsByType(@PathVariable long transaction_type_id) {
		return autoTrxDaoImpl.findAutoTransactionsByType(transaction_type_id);
	}

	@GetMapping("/auto-transaction/{auto_transaction_id}")
	@CrossOrigin
	public ResponseEntity<AutoTrxInfoDTO> getAutoTransactionById(@PathVariable long auto_transaction_id)
			throws InvalidTransactionException {
		return autoTrxDaoImpl.findAutoTranasctionInformationById(auto_transaction_id);
	}

	@GetMapping("/auto-transaction-count")
	@CrossOrigin
	public long getAutoTransactionCount() {
		return autoTrxDaoImpl.getCountOfAutoTransactions();
	}

	@PostMapping("/add-auto-transaction-information")
	@CrossOrigin
	public int addAutoTransactionInformation(@RequestBody AutoTransaction autoTransaction)
			throws InvalidAutoShopException, InvalidUserException, InvalidTransactionTypeException,
			InvalidVehicleException {
		return autoTrxDaoImpl.addAutoTransactionInformation(autoTransaction);
	}
	
	@PutMapping("/auto-transaction/{auto_transaction_id}")
	@CrossOrigin
	public int updateAutoTransactionInformation(@PathVariable long auto_transaction_id, @RequestBody AutoTransaction autoTransactionDetails) throws InvalidAutoShopException, InvalidVehicleException, InvalidTransactionTypeException, InvalidUserException {
		return autoTrxDaoImpl.updateTransactionInformation(auto_transaction_id, autoTransactionDetails);
	}

	@DeleteMapping("/auto-transaction/{auto_transaction_id}")
	@CrossOrigin
	public int deleteAutoTransactionById(@PathVariable long auto_transaction_id) {
		return autoTrxDaoImpl.deleteAutoTransactionInformation(auto_transaction_id);
	}

	@DeleteMapping("/delete-all-transactions")
	@CrossOrigin
	public int deleteAllAutoTransactions() {
		return autoTrxDaoImpl.deleteAllAutoTransactions();
	}
}
