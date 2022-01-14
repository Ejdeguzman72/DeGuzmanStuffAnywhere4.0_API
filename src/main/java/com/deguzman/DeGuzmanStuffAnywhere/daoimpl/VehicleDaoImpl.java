package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.dao.VehicleDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {
	
	String GET_ALL_VEHICLE_INFORMATION = "SELECT * FROM VEHICLE";
	
	String GET_VEHICLE_INFORMATION_BY_ID = "SELECT * FROM VEHICLE WHERE VEHICLE_ID = ?";
	
	String GET_VEHICLE_INFORMATION_BY_YEAR = "SELECT * FROM VEHICLE WHERE YEAR = ?";
	
	String GET_VEHICLE_INFORMATION_BY_MAKE = "SELECT * FROM VEHICLE WHERE MAKE = ?";
	
	String GET_VEHICLE_INFORMATION_BY_MODEL = "SELECT * FROM VEHICLE WHERE MODEL = ?";
	
	String GET_VEHICLE_INFORMATION_BY_TRANSMISSION = "SELECT * FROM VEHICLE WHERE TRANSMISSION = ?";
	
	String GET_VEHICLE_COUNT = "SELECT COUNT(*) FROM VEHICLE";
	
	String ADD_VEHICLE_INFORMATION = "INSERT INTO VEHICLE " + 
			"(CAPACITY, MAKE, MODEL, TRANSMISSION, YEAR) " + 
			"VALUES(?, ?, ?, ?, ?)";

	String UPDATE_VEHICLE_INFORMATION = "UPDATE VEHICLE SET MAKE = ?, MODEL = ?, YEAR = ?, TRANSMISSION = ?, CAPACITY = ? WHERE VEHICLE_ID = ?";
	
	String DELETE_VEHICLE_INFORMATION_BY_ID = "DELETE FROM VEHICLE WHERE VEHICLE_ID = ?";
	
	String DELETE_ALL_VEHICLE_INFORMATION = "DELETE FROM VEHICLE";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleDaoImpl.class);
	
	@Override
	public List<Vehicle> findAllCarInformation() {
		return jdbcTemplate.query(GET_ALL_VEHICLE_INFORMATION, BeanPropertyRowMapper.newInstance(Vehicle.class));
	}

	@Override
	public ResponseEntity<Vehicle> findVehicleInformationById(long vehicleId) throws InvalidVehicleException {
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_ID, BeanPropertyRowMapper.newInstance(Vehicle.class), vehicleId);
		LOGGER.info("Retrieved Vehicle Info: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		return ResponseEntity.ok().body(vehicle);
	}

	@Override
	public ResponseEntity<Vehicle> findVehicleInformatioByMake(String make) {
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_YEAR, BeanPropertyRowMapper.newInstance(Vehicle.class), make);
		LOGGER.info("Retrieved Vehicle Information: " + vehicle.getMake() + " " + vehicle.getModel());
		
		return ResponseEntity.ok().body(vehicle);
	}

	@Override
	public ResponseEntity<Vehicle> findVehicleInformationByModel(String model) {
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_MAKE, BeanPropertyRowMapper.newInstance(Vehicle.class), model);
		LOGGER.info("Retrieved Vehicle Information: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		
		return ResponseEntity.ok().body(vehicle);
	}

	@Override
	public ResponseEntity<Vehicle> findVehicleInformationByYear(String year) {
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_YEAR, BeanPropertyRowMapper.newInstance(Vehicle.class), year);
		LOGGER.info("Retrieved Vehicle Information: " + vehicle.getMake() + " " + vehicle.getModel());
		
		return ResponseEntity.ok().body(vehicle);
	}
	
	@Override
	public ResponseEntity<Vehicle> findVehicleInformationByTransmission(String transmission) {
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_TRANSMISSION, BeanPropertyRowMapper.newInstance(Vehicle.class), transmission);
		LOGGER.info("Retrieved Vehicle Information: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		
		return ResponseEntity.ok().body(vehicle);
	}
	
	@Override
	public int addCarInformation(Vehicle vehicle) {
		return jdbcTemplate.update(ADD_VEHICLE_INFORMATION, new Object[] {
			vehicle.getCapacity(),vehicle.getMake(), vehicle.getModel(),vehicle.getTransmission(), vehicle.getYear()	
		});
	}

	@Override
	public int updateCarInformation(long vehicleId, Vehicle vehicleDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCarInformation(long vehicleId) {
		return jdbcTemplate.update(DELETE_VEHICLE_INFORMATION_BY_ID, vehicleId);
	}

	@Override
	public int deleteAllVehicleInformation() {
		return jdbcTemplate.update(DELETE_ALL_VEHICLE_INFORMATION);
	}
	
	@Override
	public int getCountofCars() {
		return jdbcTemplate.queryForObject(GET_VEHICLE_COUNT, Integer.class);
	}
	
}
