package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.TransactionTypeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.TransactionType;

@RestController
@RequestMapping("/app/transaction-types")
@CrossOrigin
public class TransactionTypeDaoController {

	@Autowired
	private TransactionTypeDaoImpl trxTypeDaoImpl;

	@GetMapping("/all")
	public List<TransactionType> getAllTransactionTypes() {
		return trxTypeDaoImpl.retrieveAllTransactionTypes();
	}

	@GetMapping("/transaction-type/{transaction_type_id}")
	public ResponseEntity<TransactionType> getTransactionTypeById(@PathVariable int transaction_type_id) {
		return trxTypeDaoImpl.retrieveTransactionTypeById(transaction_type_id);
	}

	@GetMapping("/transaction-type/name/{transaction_type_descr}")
	public ResponseEntity<TransactionType> getTransactionTypeByDescr(@PathVariable String transaction_type_descr) {
		return trxTypeDaoImpl.retrieveTransactionTypeByName(transaction_type_descr);
	}
}
