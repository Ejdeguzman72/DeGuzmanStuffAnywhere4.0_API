package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.GeneralTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;

@RestController
@RequestMapping("/app/general-transactions")
@CrossOrigin
public class GeneralTrxController {

	@Autowired
	private GeneralTrxDaoImpl generalTrxDaoImpl;

	@GetMapping("/all")
	@CrossOrigin
	public List<GeneralTrxInfoDTO> getAllGeneralTransactionInformation() {
		return generalTrxDaoImpl.findAllTransactionInformation();
	}

	@GetMapping("/all/type/{transaction_type_id}")
	@CrossOrigin
	public List<GeneralTrxInfoDTO> getTransactionsByType(@PathVariable long transaction_type_id) {
		return generalTrxDaoImpl.findTransactionsByType(transaction_type_id);
	}

	@GetMapping("/all/user/{user_id}")
	@CrossOrigin
	public List<GeneralTrxInfoDTO> getTransactionsByUser(@PathVariable long user_id) {
		return generalTrxDaoImpl.findTransactionsByUser(user_id);
	}

	@GetMapping("/transaction/{transaction_id}")
	@CrossOrigin
	public ResponseEntity<GeneralTrxInfoDTO> getTrxInformationById(@PathVariable long transaction_id)
			throws ResourceNotFoundException {
		return generalTrxDaoImpl.findTransactionInformationById(transaction_id);
	}

	@GetMapping("/get-transaction-count")
	@CrossOrigin
	public long getTransactionCcount() {
		return generalTrxDaoImpl.findCountOfGeneralTransaction();
	}

	@PostMapping("/add-general-transaction-information")
	@CrossOrigin
	public int addGeneralTrasactionInformation(@RequestBody GeneralTransaction transaction)
			throws ResourceNotFoundException {
		return generalTrxDaoImpl.addTransactionInformation(transaction);
	}

	@DeleteMapping("/transaction/{transaction_id}")
	@CrossOrigin
	public int deleteTransactionById(@PathVariable long transaction_id) {
		return generalTrxDaoImpl.deleteTransactionInformation(transaction_id);
	}

	@DeleteMapping("/delete-all-transactions")
	@CrossOrigin
	public int deleteAllTransactions() {
		return generalTrxDaoImpl.deleteAllTransactions();
	}
}
