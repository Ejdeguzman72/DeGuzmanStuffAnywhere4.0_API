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
import com.deguzman.domain_entity.UtilityAddRequest;
import com.deguzman.domain_entity.UtilityAddResponse;
import com.deguzman.domain_entity.UtilityDTOSearchResponse;
import com.deguzman.domain_entity.UtilityDeleteAllResponse;
import com.deguzman.domain_entity.UtilityDeleteByIdRequest;
import com.deguzman.domain_entity.UtilityDeleteByIdResponse;
import com.deguzman.domain_entity.UtilityListResponse;
import com.deguzman.domain_entity.UtilitySearchByDueDateRequest;
import com.deguzman.domain_entity.UtilitySearchByIdRequest;
import com.deguzman.domain_entity.UtilitySearchByNameRequest;
import com.deguzman.domain_entity.UtilitySearchByTypeRequest;
import com.deguzman.domain_entity.UtilitySearchResponse;
import com.deguzman.domain_entity.UtilityUpdateRequest;
import com.deguzman.domain_entity.UtilityUpdateResponse;

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
	
	public UtilityListResponse findUtilityInformationByDueDate(UtilitySearchByDueDateRequest request) {
		UtilityListResponse response = new UtilityListResponse();
		List<UtilityInfoDTO> list = utilityDaoImpl.findUtilityInformationByDueDate(request.getDueDate());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_UTILITY_BY_DUE_DATE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_UTILITY_BY_DUE_DATE_MSG);
		
		return response;
	}
	
	public UtilitySearchResponse findUtilityInformationById(UtilitySearchByIdRequest request) {
		UtilitySearchResponse response = new UtilitySearchResponse();
		Utility utility = utilityDaoImpl.findUtilityInformationById(request.getUtilityId());
		
		response.setUtility(utility);
		response.setDescription(AppConstants.GET_UTILITY_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_UTILITY_BY_ID_MSG);
		
		return response;
	}
	
	public UtilityDTOSearchResponse findUtilityInformationByType(UtilitySearchByTypeRequest request) {
		UtilityDTOSearchResponse response = new UtilityDTOSearchResponse();
		UtilityInfoDTO utility = utilityDaoImpl.findUtilityInformationByType(request.getTypeId());
		
		response.setUtility(utility);
		response.setDescription(AppConstants.GET_UTILITY_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_UTILITY_BY_ID_MSG);
		
		return response;
	}
	
	public long findUtilityCount() {
		return utilityDaoImpl.findUtilityCount();
	}
	
	public UtilityAddResponse addUtilityInformation(UtilityAddRequest request) {
		UtilityAddResponse response = new UtilityAddResponse();
		Utility utility = new Utility();
		
		utility.setDueDate(request.getDueDate());
		utility.setName(request.getName());
		utility.setPhone(request.getPhone());
		utility.setUrl(request.getUrl());
		utility.setUtility_type_id(request.getUtility_type_id());
		
		int recordsAdded = utilityDaoImpl.addUtilityInformation(request);
		
		response.setUtility(utility);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_UTILITY_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_UTILITY_INFORMATION_MSG);
		
		return response;
	}
	
	public UtilityUpdateResponse updateUtilityInformation(UtilityUpdateRequest request) {
		UtilityUpdateResponse response = new UtilityUpdateResponse();
		Utility utility = utilityDaoImpl.findUtilityInformationById(request.getUtility_id());
		int recordsUpdated = utilityDaoImpl.updateUtilityInformation(request.getUtility_id(), request);
		
		response.setUtility(utility);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_UTILITY_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_UTILITY_INFORMATION_MSG);
		
		return response;
	}
	
	public UtilityDeleteByIdResponse deleteUtilityInformation(UtilityDeleteByIdRequest request) {
		UtilityDeleteByIdResponse response = new UtilityDeleteByIdResponse();
		Utility utility = utilityDaoImpl.findUtilityInformationById(request.getUtilityId());
		int recordsDeleted = utilityDaoImpl.deleteUtilityInformation(request.getUtilityId());
		
		response.setDeleted(recordsDeleted);
		response.setUtility(utility);
		response.setDescription(AppConstants.DELETE_UTILITY_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_UTILITY_INFORMATION_MSG);
		
		return response;
	}
	
	public UtilityDeleteAllResponse deleteAllUtilityInformation() {
		UtilityDeleteAllResponse response = new UtilityDeleteAllResponse();
		int recordsDeleted = utilityDaoImpl.deleteAllUtilityInformation();
		
		response.setSize(recordsDeleted);
		response.setDescription(AppConstants.DELETE_ALL_UTILITY_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_UTILITY_INFORMATION_MSG);
		
		return response;
	}

	public UtilityDTOSearchResponse findUtilityInformationByName(UtilitySearchByNameRequest request) {
		UtilityDTOSearchResponse response = new UtilityDTOSearchResponse();
		UtilityInfoDTO utility = utilityDaoImpl.findUtilityInformationByName(request.getName());
		
		response.setUtility(utility);
		response.setDescription(AppConstants.GET_UTILITY_LIST_BY_NAME_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_UTILITY_LIST_BY_NAME_MSG);
		
		return response;
	}
}
