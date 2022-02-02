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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.MedicalTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.MedicalTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction;

@RestController
@RequestMapping("/app/medical-transactions")
@CrossOrigin
public class MedicalTrxController {

	@Autowired
	private MedicalTrxDaoImpl medicalTrxDaoImpl;

	@GetMapping("/all")
	@CrossOrigin
	public List<MedicalTrxInfoDTO> getAllMedicalTrxInformation() {
		return medicalTrxDaoImpl.findAllMedicalTransactionInformation();
	}

	@GetMapping("/all/facility/{facility_id}")
	@CrossOrigin
	public List<MedicalTrxInfoDTO> getAllMedicalTrxInformationByFacility(@PathVariable int facility_id) {
		return medicalTrxDaoImpl.findMedicalTransactionsByFacility(facility_id);
	}

	@GetMapping("/all/type/{transaction_type_id}")
	@CrossOrigin
	public List<MedicalTrxInfoDTO> getAllMedicalTrxInformationByType(@PathVariable long transaction_type_id) {
		return medicalTrxDaoImpl.findMedicalTransactionsByType(transaction_type_id);
	}

	@GetMapping("/all/user/{user_id}")
	@CrossOrigin
	public List<MedicalTrxInfoDTO> getAllMedicalTrxInformationByUser(@PathVariable long user_id) {
		return medicalTrxDaoImpl.findAllMedicalTransactionbyUser(user_id);
	}

	@GetMapping("/medical-transaction/{medical_transaction_id}")
	@CrossOrigin
	public ResponseEntity<MedicalTrxInfoDTO> getMedicalTrxById(@PathVariable long medical_transaction_id)
			throws ResourceNotFoundException {
		return medicalTrxDaoImpl.findMedicalTransactionInformationById(medical_transaction_id);
	}

	@GetMapping("/get-medical-trx-count")
	@CrossOrigin
	public long getMedicalTrxCount() {
		return medicalTrxDaoImpl.getCountOfMedicalTransactions();
	}

	@PostMapping("/add-medical-transaction")
	@CrossOrigin
	public int addMedicalTransaction(@RequestBody MedicalTransaction medicalTrx) throws ResourceNotFoundException {
		return medicalTrxDaoImpl.addMedicalTransactionInformation(medicalTrx);
	}

	@DeleteMapping("/medical-transaction/{medical_transaction_id}")
	@CrossOrigin
	public int deleteMedicalTrxById(@PathVariable long medical_transaction_id) {
		return medicalTrxDaoImpl.deleteMedicalTraansactionInformation(medical_transaction_id);
	}

	@DeleteMapping("/delete-all-medical-transactions")
	@CrossOrigin
	public int deleteAllMedicalTransactions() {
		return medicalTrxDaoImpl.deleteAllMedicalTransactions();
	}
}
