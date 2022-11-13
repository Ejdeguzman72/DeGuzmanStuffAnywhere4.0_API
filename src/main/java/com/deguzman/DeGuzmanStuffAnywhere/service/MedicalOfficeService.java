package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.MedicalOfficeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateOfficeException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.MedicalOfficeJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.MedicalOffice;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_entity.MedicalOfficeAddRequest;
import com.deguzman.domain_entity.MedicalOfficeAddResponse;
import com.deguzman.domain_entity.MedicalOfficeDeleteAllResponse;
import com.deguzman.domain_entity.MedicalOfficeDeleteByIdRequest;
import com.deguzman.domain_entity.MedicalOfficeDeleteByIdResponse;
import com.deguzman.domain_entity.MedicalOfficeListResponse;
import com.deguzman.domain_entity.MedicalOfficeSearchByIdRequest;
import com.deguzman.domain_entity.MedicalOfficeSearchByZipRequest;
import com.deguzman.domain_entity.MedicalOfficeSearchResponse;
import com.deguzman.domain_entity.MedicalOfficeUpdateRequest;
import com.deguzman.domain_entity.MedicalOfficeUpdateResponse;

@Service
public class MedicalOfficeService {

	@Autowired
	private static MedicalOfficeDaoImpl medicalOfficeDaoImpl;
	
	@Autowired
	private MedicalOfficeJpaDao medOfficeJpaDao;
	
	public MedicalOfficeListResponse findAllmedicalOfficeInformation() {
		MedicalOfficeListResponse response = new MedicalOfficeListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice> list = medicalOfficeDaoImpl.findAllMedicalOfficeInformation();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MEDICAL_OFFICE_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_OFFICE_LIST_MSG);
		
		return response;
	}

	public ResponseEntity<Map<String, Object>> getAllMedicalOfficesPagination(
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {

			List<MedicalOffice> shop = medOfficeJpaDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<MedicalOffice> pageBooks = null;

			if (name == null) {
				pageBooks = medOfficeJpaDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("medicalOffices", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public MedicalOfficeListResponse findMedicalofficesByZip(MedicalOfficeSearchByZipRequest request) {
		MedicalOfficeListResponse response = new MedicalOfficeListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice> list = medicalOfficeDaoImpl.findMedicalOfficesByZip(request.getZip());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MEDICAL_OFFICE_BY_ZIP_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_OFFICE_BY_ZIP_MSG);
		
		return response;
	}
	
	public long getMedicalOfficeCount() {
		return medicalOfficeDaoImpl.getMedicalOfficeCount();
	}
	
	public MedicalOfficeAddResponse addMedicalOfficeInformation(MedicalOfficeAddRequest request) throws DuplicateOfficeException {
		MedicalOfficeAddResponse response = new MedicalOfficeAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice medicalOffice = new com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice();
		
		medicalOffice.setName(request.getName());
		medicalOffice.setAddress(request.getAddress());
		medicalOffice.setCity(request.getCity());
		medicalOffice.setState(request.getState());
		medicalOffice.setZip(request.getZip());
		
		int recordsAdded = medicalOfficeDaoImpl.addMedicalOfficeInformation(request);
		
		response.setMedicalOffice(medicalOffice);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_MEDICAL_OFFICE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_MEDICAL_OFFICE_INFORMATION_MSG);
			
		return response;
		
	}
	
	public MedicalOfficeUpdateResponse updateMedicalOfficeInformation(MedicalOfficeUpdateRequest request) {
		MedicalOfficeUpdateResponse response = new MedicalOfficeUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice medicalOffice = medicalOfficeDaoImpl.findMedicalOfficeInformationById(request.getMedicalOfficeId());
		int recordsUpdated = medicalOfficeDaoImpl.updateMedicalOfficeInformation(request.getMedicalOfficeId(), request);
		
		response.setMedicalOffice(medicalOffice);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_MEDICAL_OFFICE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_MEDICAL_OFFICE_INFORMATION_MSG);
		
		return response;
	}
	
	public MedicalOfficeDeleteByIdResponse deleteMedicalOfficeById(MedicalOfficeDeleteByIdRequest request) {
		MedicalOfficeDeleteByIdResponse response = new MedicalOfficeDeleteByIdResponse();
		int recordsDeleted = medicalOfficeDaoImpl.deleteMedicalOfficeById(request.getMedicalOfficeId());
		
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_MEDICAL_OFFICE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_MEDICAL_OFFICE_INFORMATION_MSG);
		
		return response;
	}
	
	public MedicalOfficeDeleteAllResponse deleteAllMedicalOfficeInformation() {
		MedicalOfficeDeleteAllResponse response = new MedicalOfficeDeleteAllResponse();
		int recordsDeleted = medicalOfficeDaoImpl.deleteAllMedicalOfficeInformation();
		
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_ALL_MEDICAL_OFFICE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_MEDICAL_OFFICE_INFORMATION_MSG);
		
		return response;
	}

	public MedicalOfficeSearchResponse findMedicalOfficeInformationById(MedicalOfficeSearchByIdRequest request) {
		MedicalOfficeSearchResponse response = new MedicalOfficeSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice medicalOffice = medicalOfficeDaoImpl.findMedicalOfficeInformationById(request.getOfficeId());
		
		response.setMedicalOffice(medicalOffice);
		response.setDescription(AppConstants.GET_MEDICAL_OFFICE_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_OFFICE_BY_ID_MSG);
		
		return response;
	}
}
