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
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;

@RestController
@CrossOrigin
public class TransactionTypeDaoController {

	@Autowired
	private TransactionTypeDaoImpl trxTypeDaoImpl;

	@GetMapping(value = UriConstants.URI_GET_TRANSACTION_TYPE_LIST)
	@CrossOrigin
	public List<TransactionType> getAllTransactionTypes() {
		return trxTypeDaoImpl.retrieveAllTransactionTypes();
	}

	@GetMapping(value = UriConstants.URI_GET_TRANSACTION_TYPE_BY_ID)
	@CrossOrigin
	public ResponseEntity<TransactionType> getTransactionTypeById(@PathVariable int transaction_type_id) {
		return trxTypeDaoImpl.retrieveTransactionTypeById(transaction_type_id);
	}

	@GetMapping(value = UriConstants.URI_GET_TRANSACTION_TYPE_BY_DESCR)
	@CrossOrigin
	public ResponseEntity<TransactionType> getTransactionTypeByDescr(@PathVariable String transaction_type_descr) {
		return trxTypeDaoImpl.retrieveTransactionTypeByName(transaction_type_descr);
	}
}
