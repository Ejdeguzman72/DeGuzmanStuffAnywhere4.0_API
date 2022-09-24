package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.VehicleDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;
import com.deguzman.DeGuzmanStuffAnywhere.service.VehicleService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.AutoShopListResponse;
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

@RestController
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleListResponse>> getAllVehicleInformation() {
		VehicleListResponse response = vehicleService.findAllVehicleInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICEL_LIST_PAGINATION)
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllVehiclesPagination(@RequestParam(required = false) String model,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return vehicleService.getAllVehiclesPagination(model, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleSearchResponse>> getVehicleInformationById(@RequestBody VehicleSearchByIdRequest request)
			throws InvalidVehicleException {
		VehicleSearchResponse response = vehicleService.findVehicleInformationById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_BY_MAKE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleListSearchResponse>> getVehicleInformationByMake(@RequestBody VehicleSearchByMakeRequest request) {
		VehicleListSearchResponse response = vehicleService.findVehicleInformationByMake(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_BY_MODEL)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleListSearchResponse>> getVehicleInformationByModel(@RequestBody VehicleSearchByModelRequest request) {
		VehicleListSearchResponse response = vehicleService.findVehicleInformationbyModel(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_BY_YEAR)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleListSearchResponse>> getVehicleInformationByYear(@RequestBody VehicleSearchByYearRequest request) {
		VehicleListSearchResponse response = vehicleService.findVehicleInformationByYear(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_BY_TRANSMISSION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleListSearchResponse>> getVehicleInformationByTransmission(@RequestBody VehicleSearchByTransmissionRequest request) {
		VehicleListSearchResponse response = vehicleService.findVehicleInformationByTransmission(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_VEHICLE_COUNT)
	@CrossOrigin
	public int getVehicleCount() {
		return vehicleService.getCountOfVehicles();
	}

	@PostMapping(value = UriConstants.URI_ADD_VEHICLE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleAddResponse>> addVehicleInformation(@RequestBody VehicleAddRequest request) {
		VehicleAddResponse response = vehicleService.addVehicleInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_VEHICLE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleUpdateResponse>> updateVehicleInformation(@RequestBody VehicleUpdateRequest request) {
		VehicleUpdateResponse response = vehicleService.updateVehicleInfomration(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_VEHICLE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleDeleteByIdResponse>> deleteVehicleInformationbyId(@RequestBody VehicleDeleteByIdRequest request) {
		VehicleDeleteByIdResponse response = vehicleService.deleteVehicleInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_VEHICLE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<VehicleDeleteAllResponse>> deleteAllVehicleInformation() {
		VehicleDeleteAllResponse response = vehicleService.deleteAllVehicleInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

}
