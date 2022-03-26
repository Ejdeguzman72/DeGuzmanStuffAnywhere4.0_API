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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.VehicleDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;
import com.deguzman.DeGuzmanStuffAnywhere.service.VehicleService;

@RestController
@RequestMapping("/app/vehicles")
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/all")
	@CrossOrigin
	public List<Vehicle> getAllVehicleInformation() {
		return vehicleService.findAllVehicleInformation();
	}

	@GetMapping("/all-vehicles")
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllVehiclesPagination(@RequestParam(required = false) String model,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return vehicleService.getAllVehiclesPagination(model, page, size);
	}

	@GetMapping("/vehicle/{vehicleId}")
	@CrossOrigin
	public ResponseEntity<Vehicle> getVehicleInformationById(@PathVariable int vehicleId)
			throws InvalidVehicleException {
		return vehicleService.findVehicleInformationById(vehicleId);
	}

	@GetMapping("/vehicle/make/{make}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByMake(@PathVariable String make) {
		return vehicleService.findVehicleInformationByMake(make);
	}

	@GetMapping("/vehicle/model/{model}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByModel(@PathVariable String model) {
		return vehicleService.findVehicleInformationbyModel(model);
	}

	@GetMapping("/vehicle/year/{year}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByYear(@PathVariable String year) {
		return vehicleService.findVehicleInformationByYear(year);
	}

	@GetMapping("/vehicle/transmission/{transmission}")
	@CrossOrigin
	public List<Vehicle> getVehicleInformationByTransmission(@PathVariable String transmission) {
		return vehicleService.findVehicleInformationByTransmission(transmission);
	}

	@GetMapping("/vehicle-count")
	@CrossOrigin
	public int getVehicleCount() {
		return vehicleService.getCountOfVehicles();
	}

	@PostMapping("/add-vehicle-information")
	@CrossOrigin
	public int addVehicleInformation(@RequestBody Vehicle vehicle) {
		return vehicleService.addVehicleInformation(vehicle);
	}
	
	@PutMapping("/vehicle/{vehicleId}")
	@CrossOrigin
	public int updateVehicleInformation(@PathVariable int vehicleId, @RequestBody Vehicle vehicleDetails) {
		return vehicleService.updateVehicleInfomration(vehicleId, vehicleDetails);
	}

	@DeleteMapping("/vehicle/{vehicleId}")
	@CrossOrigin
	public int deleteVehicleInformationbyId(@PathVariable int vehicleId) {
		return vehicleService.deleteVehicleInformation(vehicleId);
	}

	@DeleteMapping("/delete-all-vehicles")
	@CrossOrigin
	public int deleteAllVehicleInformation() {
		return vehicleService.deleteAllVehicleInformation();
	}

}
