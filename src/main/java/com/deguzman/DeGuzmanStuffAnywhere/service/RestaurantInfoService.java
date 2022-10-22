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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.RestaurantDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.RestaurantJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Restaurant;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_entity.RestaurantAddRequest;
import com.deguzman.domain_entity.RestaurantAddResponse;
import com.deguzman.domain_entity.RestaurantDeleteAllResponse;
import com.deguzman.domain_entity.RestaurantDeleteByIdRequest;
import com.deguzman.domain_entity.RestaurantDeleteByIdResponse;
import com.deguzman.domain_entity.RestaurantListResponse;
import com.deguzman.domain_entity.RestaurantSearchByIdRequest;
import com.deguzman.domain_entity.RestaurantSearchByTypeRequest;
import com.deguzman.domain_entity.RestaurantSearchByZipRequest;
import com.deguzman.domain_entity.RestaurantSearchResponse;
import com.deguzman.domain_entity.RestaurantUpdateRequest;
import com.deguzman.domain_entity.RestaurantUpdateResponse;
import com.sun.mail.iap.Response;

@Service
public class RestaurantInfoService {

	@Autowired
	private RestaurantDaoImpl restaurantDaoImpl;
	
	@Autowired
	private RestaurantJpaDao restaurantJpaDao;
	
	public RestaurantListResponse findAllRestaurants() {
		RestaurantListResponse response = new RestaurantListResponse();
		List<RestaurantInfoDTO> list = restaurantDaoImpl.findAllRestaurants();
		
		list = restaurantDaoImpl.findAllRestaurants();
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_RESTAURANT_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_RESTAURANT_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllRestaurantsPagination(
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {

			List<Restaurant> shop = restaurantJpaDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Restaurant> pageBooks = null;

			if (name == null) {
				pageBooks = restaurantJpaDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("restaurants", shop);
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
	
	public RestaurantListResponse findAllRestaurantsByType(RestaurantSearchByTypeRequest request) {
		RestaurantListResponse response = new RestaurantListResponse();
		List<RestaurantInfoDTO> list = restaurantDaoImpl.findAllRestaurantsByType(request.getType());
		
		list = restaurantDaoImpl.findAllRestaurantsByType(request.getType());
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_RESTAURANT_LIST_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_RESTAURANT_LIST_BY_TYPE_MSG);
		
		return response;
	}
	
	public RestaurantSearchResponse findRestaurantById(RestaurantSearchByIdRequest request) throws InvalidRestaurantException {
		RestaurantSearchResponse response = new RestaurantSearchResponse();
		RestaurantInfoDTO restaurant = restaurantDaoImpl.findRestaurantById(request.getRestaurantId());
		
		response.setRestaurant(restaurant);
		response.setDescription(AppConstants.GET_RESTAURANT_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_RESTAURANT_BY_ID_MSG);
		
		return response;
	}
	
	public RestaurantListResponse findRestaurantByZipCode(RestaurantSearchByZipRequest request) {
		RestaurantListResponse response = new RestaurantListResponse();
		List<RestaurantInfoDTO> list = restaurantDaoImpl.findRestaurantsByZipCode(request.getZip());
		
		list = restaurantDaoImpl.findRestaurantsByZipCode(request.getZip());
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_RESTAURANT_LIST_BY_ZIP_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_RESTAURANT_LIST_BY_ZIP_MSG);
		
		return response;
	}
	
	public List<RestaurantInfoDTO> findRestaurantsByDescr(String descr) {
		return restaurantDaoImpl.findRestaurantsByDescr(descr);
	}
	
	public RestaurantSearchResponse findRestaurantByName(String name) {
		RestaurantSearchResponse response = new RestaurantSearchResponse();
		RestaurantInfoDTO restaurant = restaurantDaoImpl.findRestaurantByName(name);
		
		response.setRestaurant(restaurant);
		response.setDescription(AppConstants.GET_RESTAURANT_LIST_BY_NAME_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_RESTAURANT_LIST_BY_NAME_MSG);
		
		return response;
	}
	
	public long getRestaurantCount() {
		return restaurantDaoImpl.getRestaurantCount();
	}
	
	public RestaurantAddResponse addRestaurantInformation(RestaurantAddRequest request) throws ResourceNotFoundException, DuplicateRestaurantException {
		RestaurantAddResponse response = new RestaurantAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant restaurant = new com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant();
		
		restaurant.setName(request.getName());
		restaurant.setAddress(request.getAddress());
		restaurant.setCity(request.getCity());
		restaurant.setState(request.getState());
		restaurant.setZip(request.getZip());
		restaurant.setRestaurant_type_id(request.getRestaurant_type_id());
		
		int result = restaurantDaoImpl.addRestaurantInformation(request);
		
		response.setRestaurant(restaurant);
		response.setRecordsAdded(result);
		response.setDescription(AppConstants.ADD_RESTAURANT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_RESTAURANT_INFORMATION_MSG);
		
		return response;
	}
	
	public RestaurantUpdateResponse updateRestaurantInformation(RestaurantUpdateRequest request) throws ResourceNotFoundException {
		RestaurantUpdateResponse response = new RestaurantUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant restaurant = restaurantDaoImpl.findRestaurantInfoById(request.getRestaurant_id());
		int recordsUpdated = restaurantDaoImpl.updateRestaurantInformation(request.getRestaurant_id(), request);
		
		response.setRestaurant(restaurant);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_UPDATE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_UPDATE_INFORMATION_MSG);
		
		return response;
	}
	
	public RestaurantDeleteByIdResponse deleteRestaurantInformation(RestaurantDeleteByIdRequest request) {
		RestaurantDeleteByIdResponse response = new RestaurantDeleteByIdResponse();
		int deletedRecords = restaurantDaoImpl.deleteRestaurantInformation(request.getRestaurantId());
		
		response.setDescription(AppConstants.DELETE_RESTAURANT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_RESTAURANT_INFORMATION_MSG);
		
		return response;
	}
	
	public RestaurantDeleteAllResponse deleteAllRestaurantInformation() {
		RestaurantDeleteAllResponse response = new RestaurantDeleteAllResponse();
		int deletedRecords = restaurantDaoImpl.deleteAllRestaurantInformation();
		
		response.setDescription(AppConstants.DELETE_ALL_RESTAURANT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_RESTAURANT_INFORMATION_MSG);
		
		return response;
	}
}
