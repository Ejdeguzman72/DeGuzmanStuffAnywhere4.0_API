package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.UtilityDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.UtilityInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Utility;

@RestController
@RequestMapping("/app/utility-information")
@CrossOrigin
public class UtilityController {

	@Autowired
	private UtilityDaoImpl utilityDaoImpl;
	
	@GetMapping("/all")
	public List<UtilityInfoDTO> getAllUtilityInformation() {
		return utilityDaoImpl.findAllUtilityInformation();
	}
	
	@GetMapping("/dueDate")
	public List<UtilityInfoDTO> getUtilityInformationByDueDate(@PathVariable String dueDate) {
		return utilityDaoImpl.findUtilityInformationByDueDate(dueDate);
	}
	
	@GetMapping("/utility/{utility_id}")
	public ResponseEntity<UtilityInfoDTO> getUtilityInformationById(@PathVariable long utility_id) {
		return utilityDaoImpl.findUtilityInformationById(utility_id);
	}
	
	@GetMapping("/utility/name/{name}")
	public ResponseEntity<UtilityInfoDTO> getUtilityInformationByName(@PathVariable String name) {
		return utilityDaoImpl.findUtilityInformationByName(name);
	}
	
	@GetMapping("/utility/utility-type/{utility_type_id}")
	public ResponseEntity<UtilityInfoDTO> getUtilityInformationByType(@PathVariable int utility_type_id) {
		return utilityDaoImpl.findUtilityInformationByType(utility_type_id);
	}
	
	@GetMapping("/get-utility-count")
	public long getCountOfUtilities() {
		return utilityDaoImpl.findUtilityCount();
	}
	
	@GetMapping("/add-utility-information")
	public int addUtilityInformation(@RequestBody Utility utility) {
		return utilityDaoImpl.addUtilityInformation(utility);
	}
	
	@DeleteMapping("/utility/{utility_id}")
	public int deleteUtilityInformationById(@PathVariable long utility_id) {
		return utilityDaoImpl.deleteUtilityInformation(utility_id);
	}
	
	@DeleteMapping("/delete-all-utilties")
	public int deleteAllUtilityInformation() {
		return utilityDaoImpl.deleteAllUtilityInformation();
	}
}
