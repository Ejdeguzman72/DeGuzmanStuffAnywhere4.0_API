package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.VehicleDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;
import com.deguzman.DeGuzmanStuffAnywhere.service.VehiclePaginationService;

@RestController
@RequestMapping("/app/vehicles")
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleDaoImpl vehicleDaoImpl;

	@Autowired
	private VehiclePaginationService vehiclePageService;

	@GetMapping("/all")
	@CrossOrigin
	public List<Vehicle> getAllVehicleInformation() {
		return vehicleDaoImpl.findAllCarInformation();
	}

	@GetMapping("/all-vehicles")
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllVehiclesPagination(@RequestParam(required = false) String model,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return vehiclePageService.getAllVehiclesPagination(model, page, size);
	}

	@GetMapping("/vehicle/{vehicleId}")
	@CrossOrigin
	public ResponseEntity<Vehicle> getVehicleInformationById(@PathVariable int vehicleId)
			throws InvalidVehicleException {
		return vehicleDaoImpl.findVehicleInformationById(vehicleId);
	}

	@GetMapping("/vehicle/make/{make}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByMake(@PathVariable String make) {
		return vehicleDaoImpl.findVehicleInformatioByMake(make);
	}

	@GetMapping("/vehicle/model/{model}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByModel(@PathVariable String model) {
		return vehicleDaoImpl.findVehicleInformationByModel(model);
	}

	@GetMapping("/vehicle/year/{year}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByYear(@PathVariable String year) {
		return vehicleDaoImpl.findVehicleInformationByYear(year);
	}

	@GetMapping("/vehicle/transmission/{transmission}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByTransmission(@PathVariable String transmission) {
		return vehicleDaoImpl.findVehicleInformationByTransmission(transmission);
	}

	@GetMapping("/vehicle-count")
	@CrossOrigin
	public int getVehicleCount() {
		return vehicleDaoImpl.getCountofCars();
	}

	@PostMapping("/add-vehicle-information")
	@CrossOrigin
	public int addVehicleInformation(@RequestBody Vehicle vehicle) {
		return vehicleDaoImpl.addCarInformation(vehicle);
	}

	@DeleteMapping("/vehicle/{vehicleId}")
	@CrossOrigin
	public int deleteVehicleInformationbyId(@PathVariable int vehicleId) {
		return vehicleDaoImpl.deleteCarInformation(vehicleId);
	}

	@DeleteMapping("/delete-all-vehicles")
	@CrossOrigin
	public int deleteAllVehicleInformation() {
		return vehicleDaoImpl.deleteAllVehicleInformation();
	}

}
