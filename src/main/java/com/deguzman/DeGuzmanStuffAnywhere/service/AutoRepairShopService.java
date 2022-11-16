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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoRepairShopDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.AutoRepairShopJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.AutoRepairShop;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_entity.AutoShopAddRequest;
import com.deguzman.domain_entity.AutoShopAddResponse;
import com.deguzman.domain_entity.AutoShopCountResponse;
import com.deguzman.domain_entity.AutoShopDeleteAllResponse;
import com.deguzman.domain_entity.AutoShopDeleteByIdRequest;
import com.deguzman.domain_entity.AutoShopDeleteByIdResponse;
import com.deguzman.domain_entity.AutoShopListResponse;
import com.deguzman.domain_entity.AutoShopSearchByIdRequest;
import com.deguzman.domain_entity.AutoShopSearchByNameRequest;
import com.deguzman.domain_entity.AutoShopSearchByZipRequest;
import com.deguzman.domain_entity.AutoShopSearchResponse;
import com.deguzman.domain_entity.AutoShopSearchZipResponse;
import com.deguzman.domain_entity.AutoShopUpdateRequest;
import com.deguzman.domain_entity.AutoShopUpdateResponse;

@Service
public class AutoRepairShopService {

	@Autowired
	private AutoRepairShopDaoImpl autoRepairShopDaoImpl;
	
	@Autowired
	private AutoRepairShopJpaDao autoShopDao;

	public AutoShopListResponse findAllAutoRepairShopInfo() {
		AutoShopListResponse response = new AutoShopListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop> list = autoRepairShopDaoImpl.findAllAutoRepairShopInfo();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTOSHOP_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTOSHOP_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllAutoShopsPagination(
			@RequestParam(required = false) String autoShopname, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {

			List<AutoRepairShop> shop = autoShopDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<AutoRepairShop> pageBooks = null;

			if (autoShopname == null) {
				pageBooks = autoShopDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("autoShops", shop);
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
	
	public AutoShopSearchResponse findAutoRepairShopById(AutoShopSearchByIdRequest request) {
		AutoShopSearchResponse response = new AutoShopSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop autoShop = autoRepairShopDaoImpl.findAutoRepairShopById(request.getAutoShopId());
		
		response.setAutoShop(autoShop);
		response.setDescription(AppConstants.GET_AUTO_SHOP_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_SHOP_BY_ID_MSG);
		
		return response;
	}
	
	public AutoShopSearchResponse findAutoRepairShopByName(AutoShopSearchByNameRequest request) {
		AutoShopSearchResponse response = new AutoShopSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop autoShop = autoRepairShopDaoImpl.findAutoRepairShopByName(request.getName());
		
		response.setAutoShop(autoShop);
		response.setDescription(AppConstants.GET_AUTO_SHOP_BY_NAME_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_SHOP_BY_NAME_MSG);
		
		return response;
	}
	
	public AutoShopSearchZipResponse findAutoRepairShopByZip(AutoShopSearchByZipRequest request) {
		AutoShopSearchZipResponse response = new AutoShopSearchZipResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop> list = autoRepairShopDaoImpl.findAutoRepairShopByZip(request.getZip());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTO_SHOP_BY_ZIP_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_SHOP_BY_ZIP_MSG);
		
		return response;
	}
	
	public AutoShopCountResponse getCountOfAutoRepairShops() {
		AutoShopCountResponse response = new AutoShopCountResponse();
		long count = autoRepairShopDaoImpl.getCountOfAutoRepairShops();
		
		response.setCount(count);
		response.setDescription(AppConstants.GET_AUTO_SHOP_COUNT_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTO_SHOP_COUNT_MSG);
		
		return response;
	}
	
	public AutoShopAddResponse addAutoRepairShopInfo(AutoShopAddRequest request) throws DuplicateAutoShopException {
		AutoShopAddResponse response = new AutoShopAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop autoShop = new com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop();
		int recordsAdded = autoRepairShopDaoImpl.addAutoRepairShopInfo(request);
		
		autoShop.setAutoShopName(request.getAutoShopName());
		autoShop.setAddress(request.getAddress());
		autoShop.setCity(request.getCity());
		autoShop.setState(request.getState());
		autoShop.setZip(request.getZip());
		
		response.setAutoShop(autoShop);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_AUTOSHOP_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_AUTOSHOP_INFORMATION_MSG);
		
		return response;
	}
	
	public AutoShopUpdateResponse updateAutoShopInfo(AutoShopUpdateRequest request) {
		AutoShopUpdateResponse response = new AutoShopUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop autoShop = autoRepairShopDaoImpl.findAutoRepairShopById(request.getAuto_shop_id());
		int recordsUpdated = autoRepairShopDaoImpl.updateAutoShopInfo(request.getAuto_shop_id(), request);
		
		response.setAutoShop(autoShop);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_AUTOSHOP_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_AUTOSHOP_INFORMATION_MSG);
		
		return response;
	}
	
	public AutoShopDeleteByIdResponse deleteAutoRepairShopInfo(AutoShopDeleteByIdRequest request) {
		AutoShopDeleteByIdResponse response = new AutoShopDeleteByIdResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop autoShop = autoRepairShopDaoImpl.findAutoRepairShopById(request.getAutoShopId());
		int recordsDeleted = autoRepairShopDaoImpl.deleteAutoRepairShopInfo(request.getAutoShopId());
		
		response.setAutoShop(autoShop);
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_AUTOSHOP_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_AUTSHOP_INFORMATION_MSG);
		
		return response;
	}
	
	public AutoShopDeleteAllResponse deleteAllAutoShops() {
		AutoShopDeleteAllResponse response = new AutoShopDeleteAllResponse();
		int deletedRecords = autoRepairShopDaoImpl.deleteAllAutoShop();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_AUTOSHOP_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_AUTOSHOP_INFORMATION_MSG);
		
		return response;
	}

}
