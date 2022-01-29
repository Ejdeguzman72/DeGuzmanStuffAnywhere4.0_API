package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.UtilityTypeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.UtilityType;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/utility-types")
@CrossOrigin
public class UtilityTypeController {

	@Autowired
	private UtilityTypeDaoImpl utilityTypeDaoImpl;

	@GetMapping("/all")
	public List<UtilityType> getAllUtilityTypes() {
		return utilityTypeDaoImpl.findAllUtilityTypes();
	}

	@GetMapping("/utility-type/{utility_type_id}")
	public ResponseEntity<UtilityType> getUtilityTypeInformationById(@PathVariable int utility_type_id) {
		return utilityTypeDaoImpl.findUtilityInformationById(utility_type_id);
	}

	@GetMapping("/utility-type/descr/{utility_type_descr}")
	public ResponseEntity<UtilityType> getUtilityInformationByDescr(@PathVariable String utility_type_descr) {
		return utilityTypeDaoImpl.findUtilityInformationByDescr(utility_type_descr);
	}
}
