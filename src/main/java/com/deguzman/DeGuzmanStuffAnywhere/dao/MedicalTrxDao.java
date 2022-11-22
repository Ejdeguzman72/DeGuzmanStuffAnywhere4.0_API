package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.MedicalTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction;

public interface MedicalTrxDao {

	public List<MedicalTrxInfoDTO> findAllMedicalTransactionInformation();

	public List<MedicalTrxInfoDTO> findMedicalTransactionsByFacility(@PathVariable int facility_id);

	public List<MedicalTrxInfoDTO> findMedicalTransactionsByType(@PathVariable long transaction_type_id);

	public List<MedicalTrxInfoDTO> findAllMedicalTransactionbyUser(@PathVariable long user_id);

	public MedicalTrxInfoDTO findMedicalTransactionInformationDTOById(
			@PathVariable long medical_transaction_id) throws ResourceNotFoundException;
	
	public ResponseEntity<MedicalTransaction> findMedicalTransactionInformationById(
			@PathVariable long medical_transaction_id) throws ResourceNotFoundException;

	public long getCountOfMedicalTransactions();

	public int addMedicalTransactionInformation(@RequestBody MedicalTransaction medicalTransaction)
			throws ResourceNotFoundException;

	public int updateMedicalTransaction(@PathVariable long medicalTransactionId,
			@RequestBody MedicalTransaction medicalTransactionDetails);

	public int deleteMedicalTraansactionInformation(@PathVariable long medical_transaction_id);

	public int deleteAllMedicalTransactions();

}
