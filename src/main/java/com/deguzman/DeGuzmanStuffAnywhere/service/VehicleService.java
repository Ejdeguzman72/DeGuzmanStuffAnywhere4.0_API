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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.VehicleDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.VehicleJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Vehicle;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_entity.VehicleAddRequest;
import com.deguzman.domain_entity.VehicleAddResponse;
import com.deguzman.domain_entity.VehicleDeleteAllResponse;
import com.deguzman.domain_entity.VehicleDeleteByIdRequest;
import com.deguzman.domain_entity.VehicleDeleteByIdResponse;
import com.deguzman.domain_entity.VehicleListResponse;
import com.deguzman.domain_entity.VehicleListSearchResponse;
import com.deguzman.domain_entity.VehicleSearchByIdRequest;
import com.deguzman.domain_entity.VehicleSearchByMakeRequest;
import com.deguzman.domain_entity.VehicleSearchByModelRequest;
import com.deguzman.domain_entity.VehicleSearchByTransmissionRequest;
import com.deguzman.domain_entity.VehicleSearchByYearRequest;
import com.deguzman.domain_entity.VehicleSearchResponse;
import com.deguzman.domain_entity.VehicleUpdateRequest;
import com.deguzman.domain_entity.VehicleUpdateResponse;

@Service
public class VehicleService {

	@Autowired
	private VehicleDaoImpl vehicleDaoImpl;
	
	@Autowired
	private VehicleJpaDao vehicleJpaDao;
	
	public VehicleListResponse findAllVehicleInformation() {
		VehicleListResponse response = new VehicleListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> list = vehicleDaoImpl.findAllCarInformation();
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_VEHICLE_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_VEHICLE_LIST_MSG);
		
		return response;
		
	}

	public ResponseEntity<Map<String, Object>> getAllVehiclesPagination(@RequestParam(required = false) String model,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<Vehicle> shop = vehicleJpaDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Vehicle> pageBooks = null;

			if (model == null) {
				pageBooks = vehicleJpaDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("vehicles", shop);
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
	
	public VehicleSearchResponse findVehicleInformationById(VehicleSearchByIdRequest request) throws InvalidVehicleException {
		VehicleSearchResponse response = new VehicleSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle vehicle = vehicleDaoImpl.findVehicleInformationById(request.getVehicleId());
		response.setVehicle(vehicle);
		response.setDescription(AppConstants.GET_VEHICLE_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_VEHICLE_BY_ID_MSG);
		
		return response;
	}
	
	public VehicleListSearchResponse findVehicleInformationByMake(VehicleSearchByMakeRequest request) {
		VehicleListSearchResponse response = new VehicleListSearchResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> list = vehicleDaoImpl.findVehicleInformatioByMake(request.getMake());
		response.setVehicle(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_VEHICLE_LIST_BY_MAKE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_VEHICLE_LIST_BY_MAKE_MSG);
		
		return response;
	}
	
	public VehicleListSearchResponse findVehicleInformationbyModel(VehicleSearchByModelRequest request) {
		VehicleListSearchResponse response = new VehicleListSearchResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> list = vehicleDaoImpl.findVehicleInformationByModel(request.getModel());
		response.setVehicle(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_VEHICLE_LIST_BY_MODEL_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_VEHICLE_LIST_BY_MODEL_MSG);
		
		return response;
	}
	
	public VehicleListSearchResponse findVehicleInformationByYear(VehicleSearchByYearRequest request) {
		VehicleListSearchResponse response = new VehicleListSearchResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> list = vehicleDaoImpl.findVehicleInformationByYear(request.getYear());
		response.setVehicle(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_VEHICLE_LIST_BY_YEAR_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_VEHICLE_LIST_BY_YEAR_MSG);
		
		return response;
	}
	 
	public VehicleListSearchResponse findVehicleInformationByTransmission(VehicleSearchByTransmissionRequest request) {
		VehicleListSearchResponse response = new VehicleListSearchResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> list = vehicleDaoImpl.findVehicleInformationByTransmission(request.getTransmission());
		response.setVehicle(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_VEHICLE_LIST_BY_TRANSMISSION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_VEHICLE_LIST_BY_TRANSMISSION_MSG);
		
		return response;
	}
	
	public VehicleAddResponse addVehicleInformation(VehicleAddRequest request) {
		VehicleAddResponse response = new VehicleAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle vehicle = new com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle();
		int recordsAdded = vehicleDaoImpl.addCarInformation(request);
		
		vehicle.setMake(request.getMake());
		vehicle.setModel(request.getModel());
		vehicle.setYear(request.getYear());
		vehicle.setCapacity(request.getCapacity());
		vehicle.setTransmission(request.getTransmission());
		
		response.setVehicle(vehicle);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_VEHICLE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_VEHICLE_INFORMATION_MSG);
		
		return response;
	}
	
	public VehicleUpdateResponse updateVehicleInfomration(VehicleUpdateRequest request) {
		VehicleUpdateResponse response = new VehicleUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle vehicle = new com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle();
		int recordsUpdated = vehicleDaoImpl.updateCarInformation(request.getVehicleId(), request);
		
		response.setVehicle(vehicle);
		response.setUpdatedCount(recordsUpdated);
		response.setDescription(AppConstants.UPDATE_VEHICLE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_VEHICLE_INFORMATION_MSG);
		
		return response;
	}
	
	public VehicleDeleteByIdResponse deleteVehicleInformation(VehicleDeleteByIdRequest request) {
		VehicleDeleteByIdResponse response = new VehicleDeleteByIdResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle vehicle = new com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle();
		int recordsDeleted = vehicleDaoImpl.deleteCarInformation(request.getVehicleId());
		
		response.setVehicle(vehicle);
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_VEHICLE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_VEHICLE_INFORMATION_MSG);
		
		return response;
	}
	
	public VehicleDeleteAllResponse deleteAllVehicleInformation() {
		VehicleDeleteAllResponse response = new VehicleDeleteAllResponse();
		int deletedRecords = vehicleDaoImpl.deleteAllVehicleInformation();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_VEHICLE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_VEHICLE_INFORMATION_MSG);
		
		return response;
	}
	
	public int getCountOfVehicles() {
		return vehicleDaoImpl.getCountofCars();
	}
}
