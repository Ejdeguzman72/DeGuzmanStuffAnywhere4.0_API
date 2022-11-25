package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.UtilityDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.UtilityInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Utility;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_entity.UtilityListResponse;

@Service
public class UtilityService {

	@Autowired
	private UtilityDaoImpl utilityDaoImpl;
	
	public UtilityListResponse findAllUtilityInformation() {
		UtilityListResponse response = new UtilityListResponse();
		List<UtilityInfoDTO> list = utilityDaoImpl.findAllUtilityInformation();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_UTILITY_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_UTILITY_LIST_MSG);
		
		return response;
	}
	
	public UtilityListResponse findUtilityInformationByDueDate(String dueDate) {
		UtilityListResponse response = new UtilityListResponse();
		List<UtilityInfoDTO> list = utilityDaoImpl.findUtilityInformationByDueDate(dueDate);
	}
	
	public ResponseEntity<UtilityInfoDTO> findUtilityInformationById(long utility_id) {
		return utilityDaoImpl.findUtilityInformationById(utility_id);
	}
	
	public ResponseEntity<UtilityInfoDTO> findUtilityInformationByType(int utility_type_id) {
		return utilityDaoImpl.findUtilityInformationByType(utility_type_id);
	}
	
	public long findUtilityCount() {
		return utilityDaoImpl.findUtilityCount();
	}
	
	public int addUtilityInformation(@RequestBody Utility utility) {
		return utilityDaoImpl.addUtilityInformation(utility);
	}
	
	public int updateUtilityInformation(long utility_id, Utility utilityDetails) {
		return utilityDaoImpl.updateUtilityInformation(utility_id, utilityDetails);
	}
	
	public int deleteUtilityInformation(long utility_id) {
		return utilityDaoImpl.deleteUtilityInformation(utility_id);
	}
	
	public int deleteAllUtilityInformation() {
		return utilityDaoImpl.deleteAllUtilityInformation();
	}

	public ResponseEntity<UtilityInfoDTO> findUtilityInformationByName(String name) {
		return utilityDaoImpl.findUtilityInformationByName(name);
	}
}
