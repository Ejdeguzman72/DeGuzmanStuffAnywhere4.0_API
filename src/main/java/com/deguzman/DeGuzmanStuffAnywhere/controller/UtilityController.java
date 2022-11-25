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

import com.deguzman.DeGuzmanStuffAnywhere.dto.UtilityInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Utility;
import com.deguzman.DeGuzmanStuffAnywhere.service.UtilityService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;

@RestController
@CrossOrigin
public class UtilityController {

	@Autowired
	private UtilityService utilityService;

	@GetMapping(value = UriConstants.URI_GET_UTILITY_LIST)
	@CrossOrigin
	public List<UtilityInfoDTO> getAllUtilityInformation() {
		return utilityService.findAllUtilityInformation();
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_DUE_DATE)
	@CrossOrigin
	public List<UtilityInfoDTO> getUtilityInformationByDueDate(@PathVariable String dueDate) {
		return utilityService.findUtilityInformationByDueDate(dueDate);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_ID)
	@CrossOrigin
	public ResponseEntity<UtilityInfoDTO> getUtilityInformationById(@PathVariable long utility_id) {
		return utilityService.findUtilityInformationById(utility_id);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_NAME)
	@CrossOrigin
	public ResponseEntity<UtilityInfoDTO> getUtilityInformationByName(@PathVariable String name) {
		return utilityService.findUtilityInformationByName(name);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_BY_TYPE)
	@CrossOrigin
	public ResponseEntity<UtilityInfoDTO> getUtilityInformationByType(@PathVariable int utility_type_id) {
		return utilityService.findUtilityInformationByType(utility_type_id);
	}

	@GetMapping(value = UriConstants.URI_GET_UTILITY_COUNT)
	@CrossOrigin
	public long getCountOfUtilities() {
		return utilityService.findUtilityCount();
	}

	@GetMapping(value = UriConstants.URI_ADD_UTILITY_INFORMATION)
	@CrossOrigin
	public int addUtilityInformation(@RequestBody Utility utility) {
		return utilityService.addUtilityInformation(utility);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_UTILITY_INFORMATION)
	@CrossOrigin
	public int deleteUtilityInformationById(@PathVariable long utility_id) {
		return utilityService.deleteUtilityInformation(utility_id);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_UTILITY_INFORMATION)
	@CrossOrigin
	public int deleteAllUtilityInformation() {
		return utilityService.deleteAllUtilityInformation();
	}
}
