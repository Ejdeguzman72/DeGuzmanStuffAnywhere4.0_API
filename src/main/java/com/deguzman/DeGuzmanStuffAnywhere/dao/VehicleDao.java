package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

public interface VehicleDao {

	public List<Vehicle> findAllCarInformation();

	public ResponseEntity<Vehicle> findVehicleInformationById(@PathVariable long vehicleId)
			throws InvalidVehicleException;

	public List<Vehicle> findVehicleInformatioByMake(@PathVariable String make);

	public List<Vehicle> findVehicleInformationByModel(@PathVariable String model);

	public List<Vehicle> findVehicleInformationByYear(@PathVariable String year);

	public List<Vehicle> findVehicleInformationByTransmission(@PathVariable String transmission);

	public int getCountofCars();

	public int addCarInformation(@RequestBody Vehicle vehicle);

	public int updateCarInformation(@PathVariable long vehicleId, @RequestBody Vehicle vehicleDetails);

	public int deleteCarInformation(@PathVariable long vehicleId);

	public int deleteAllVehicleInformation();
}
