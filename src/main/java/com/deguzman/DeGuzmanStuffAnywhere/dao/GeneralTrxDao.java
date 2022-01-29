package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;

public interface GeneralTrxDao {

	public List<GeneralTrxInfoDTO> findAllTransactionInformation();

	public List<GeneralTrxInfoDTO> findTransactionsByUser(@PathVariable long user_id);

	public List<GeneralTrxInfoDTO> findTransactionsByType(@PathVariable long transaction_type_id);

	public ResponseEntity<GeneralTrxInfoDTO> findTransactionInformationById(@PathVariable long transaction_id)
			throws ResourceNotFoundException;

	public long findCountOfGeneralTransaction();

	public int addTransactionInformation(@RequestBody GeneralTransaction transaction) throws ResourceNotFoundException;

	public int updateTransactionInformation(@PathVariable Long transaction_id,
			@RequestBody GeneralTransaction transactionDetails);

	public int deleteTransactionInformation(@PathVariable long transaction_id);

	public int deleteAllTransactions();

}
