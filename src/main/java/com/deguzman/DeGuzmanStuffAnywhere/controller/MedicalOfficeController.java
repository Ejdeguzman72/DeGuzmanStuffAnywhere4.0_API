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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.MedicalOfficeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;
import com.deguzman.DeGuzmanStuffAnywhere.service.MedicalOfficePaginationService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/medical-offices")
@CrossOrigin
public class MedicalOfficeController {

	@Autowired
	private MedicalOfficeDaoImpl medicalOfficeDaoImpl;

	@Autowired
	private MedicalOfficePaginationService medOfficePageService;

	@GetMapping("/all")
	@CrossOrigin
	public List<MedicalOffice> getAllMedicalOfficeInformation() {
		return medicalOfficeDaoImpl.findAllMedicalOfficeInformation();
	}

	@GetMapping("all-medical-offices")
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllMedicalOfficesPagination(
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return medOfficePageService.getAllMedicalOfficesPagination(name, page, size);
	}

	@GetMapping("/medical-office/zip/{zip}")
	@CrossOrigin
	public List<MedicalOffice> getAllMedicalOfficeInformationByZipCode(@PathVariable String zip) {
		return medicalOfficeDaoImpl.findMedicalOfficesByZip(zip);
	}

	@GetMapping("/medical-office/{medicalOfficeId}")
	@CrossOrigin
	public ResponseEntity<MedicalOffice> getMedicalOfficeInformationById(@PathVariable long medicalOfficeId) {
		return medicalOfficeDaoImpl.findMedicalOfficeInformationById(medicalOfficeId);
	}

	@GetMapping("/medical-office-count")
	@CrossOrigin
	public long getMedicalOfficeCount() {
		return medicalOfficeDaoImpl.getMedicalOfficeCount();
	}

	@PostMapping("/add-medical-office-information")
	@CrossOrigin
	public int addMedicalOfficeInformation(@RequestBody MedicalOffice medicalOffice) {
		return medicalOfficeDaoImpl.addMedicalOfficeInformation(medicalOffice);
	}

	@DeleteMapping("/medical-office/{medicalOfficeId}")
	@CrossOrigin
	public int deleteMedicalOfficeById(@PathVariable long medicalOfficeId) {
		return medicalOfficeDaoImpl.deleteMedicalOfficeById(medicalOfficeId);
	}

	@DeleteMapping("/delete-all-medical-offices")
	@CrossOrigin
	public int deleteAllMedicalOffices() {
		return medicalOfficeDaoImpl.deleteAllMedicalOfficeInformation();
	}
}
