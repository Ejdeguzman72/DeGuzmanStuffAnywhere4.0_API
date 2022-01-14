package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.VehicleDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

@RestController
@RequestMapping("/app/vehicles")
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleDaoImpl vehicleDaoImpl;
	
	@GetMapping("/all")
	public List<Vehicle> getAllVehicleInformation() {
		return vehicleDaoImpl.findAllCarInformation();
	}
	
	@GetMapping("/vehicle/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleInformationById(@PathVariable int vehicleId) throws InvalidVehicleException {
		return vehicleDaoImpl.findVehicleInformationById(vehicleId);
	}
	
	@GetMapping("/vehicle/make/{make}")
	public ResponseEntity<Vehicle> getVehicleInformationByMake(@PathVariable String make) {
		return vehicleDaoImpl.findVehicleInformatioByMake(make);
	}
	
	@GetMapping("/vehicle/model/{model}")
	public ResponseEntity<Vehicle> getVehicleInformationByModel(@PathVariable String model) {
		return vehicleDaoImpl.findVehicleInformationByModel(model);
	}
	
	@GetMapping("/vehicle/year/{year}")
	public ResponseEntity<Vehicle> getVehicleInformationByYear(@PathVariable String year) {
		return vehicleDaoImpl.findVehicleInformationByYear(year);
	}
	
	@GetMapping("/vehicle/transmission/{transmission}")
	public ResponseEntity<Vehicle> getVehicleInformationByTransmission(@PathVariable String transmission) {
		return vehicleDaoImpl.findVehicleInformationByTransmission(transmission);
	}
	
	@GetMapping("/vehicle-count")
	public int getVehicleCount() {
		return vehicleDaoImpl.getCountofCars();
	}
	
	@PostMapping("/add-vehicle-information")
	public int addVehicleInformation(@RequestBody Vehicle vehicle) {
		return vehicleDaoImpl.addCarInformation(vehicle);
	}
	
	@DeleteMapping("/vehicle/{vehicleId}")
	public int deleteVehicleInformationbyId(@PathVariable int vehicleId) {
		return vehicleDaoImpl.deleteCarInformation(vehicleId);
	}
	
	@DeleteMapping("/delete-all-vehicles")
	public int deleteAllVehicleInformation() {
		return vehicleDaoImpl.deleteAllVehicleInformation();
	}
	
}
