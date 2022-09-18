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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.VehicleDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.VehicleJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Vehicle;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain.VehicleListResponse;

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
	
	public ResponseEntity<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> findVehicleInformationById(@PathVariable long vehicleId) throws InvalidVehicleException {
		return vehicleDaoImpl.findVehicleInformationById(vehicleId);
	}
	
	public List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> findVehicleInformationByMake(@PathVariable String make) {
		return vehicleDaoImpl.findVehicleInformatioByMake(make);
	}
	
	public List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> findVehicleInformationbyModel(@PathVariable String model) {
		return vehicleDaoImpl.findVehicleInformationByModel(model);
	}
	
	public List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> findVehicleInformationByYear(@PathVariable String year) {
		return vehicleDaoImpl.findVehicleInformationByYear(year);
	}
	 
	public List<com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle> findVehicleInformationByTransmission(@PathVariable String transmission) {
		return vehicleDaoImpl.findVehicleInformationByTransmission(transmission);
	}
	
	public int addVehicleInformation(@RequestBody com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle vehicle) {
		return vehicleDaoImpl.addCarInformation(vehicle);
	}
	
	public int updateVehicleInfomration(long vehicleId, com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle vehicleDetails) {
		return vehicleDaoImpl.updateCarInformation(vehicleId, vehicleDetails);
	}
	
	public int deleteVehicleInformation(@PathVariable long vehicleId) {
		return vehicleDaoImpl.deleteCarInformation(vehicleId);
	}
	
	public int deleteAllVehicleInformation() {
		return vehicleDaoImpl.deleteAllVehicleInformation();
	}
	
	public int getCountOfVehicles() {
		return vehicleDaoImpl.getCountofCars();
	}
}
