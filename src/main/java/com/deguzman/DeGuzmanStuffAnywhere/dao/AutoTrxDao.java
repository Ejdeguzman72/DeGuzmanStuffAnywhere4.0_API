package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.AutoTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionTypeException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidUserException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction;

public interface AutoTrxDao {

	public List<AutoTrxInfoDTO> findAllAutoTransactionInformation();

	public List<AutoTrxInfoDTO> findAutoTransactionsByVehicle(long vehicle_id);

	public List<AutoTrxInfoDTO> findAutoTransactionsByUser(long user_id);

	public List<AutoTrxInfoDTO> findAutoTransactionsByType(long transaction_type_id);

	public ResponseEntity<AutoTransaction> findAutoTranasctionInformationById(long auto_transaction_id)
			throws InvalidTransactionException;

	public long getCountOfAutoTransactions();

	public int addAutoTransactionInformation(@RequestBody AutoTransaction autoTransaction)
			throws InvalidAutoShopException, InvalidUserException, InvalidTransactionTypeException,
			InvalidVehicleException;

	public int updateTransactionInformation(@PathVariable long auto_transaction_id,
			@RequestBody AutoTransaction autoTransactionDetails) throws InvalidAutoShopException,
			InvalidVehicleException, InvalidTransactionTypeException, InvalidUserException;

	public int deleteAutoTransactionInformation(@PathVariable long auto_transaction_id);

	public int deleteAllAutoTransactions();

	public AutoTrxInfoDTO findAutoTranasctionInformatioDTOnById(long auto_transaction_id)
			throws InvalidTransactionException;

}
