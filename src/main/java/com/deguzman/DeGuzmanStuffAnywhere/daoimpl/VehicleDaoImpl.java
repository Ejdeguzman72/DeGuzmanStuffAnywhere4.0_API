package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dao.VehicleDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	String GET_ALL_VEHICLE_INFORMATION = "SELECT * FROM VEHICLE ORDER BY YEAR DESC";

	String GET_VEHICLE_INFORMATION_BY_ID = "SELECT * FROM VEHICLE WHERE VEHICLE_ID = ?";

	String GET_VEHICLE_INFORMATION_BY_YEAR = "SELECT * FROM VEHICLE WHERE YEAR = ?";

	String GET_VEHICLE_INFORMATION_BY_MAKE = "SELECT * FROM VEHICLE WHERE MAKE = ?";

	String GET_VEHICLE_INFORMATION_BY_MODEL = "SELECT * FROM VEHICLE WHERE MODEL = ?";

	String GET_VEHICLE_INFORMATION_BY_TRANSMISSION = "SELECT * FROM VEHICLE WHERE TRANSMISSION = ?";

	String GET_VEHICLE_COUNT = "SELECT COUNT(*) FROM VEHICLE";

	String ADD_VEHICLE_INFORMATION = "INSERT INTO VEHICLE " + "(CAPACITY, MAKE, MODEL, TRANSMISSION, YEAR) "
			+ "VALUES(?, ?, ?, ?, ?)";

	String UPDATE_VEHICLE_INFORMATION = "UPDATE VEHICLE SET MAKE = ?, MODEL = ?, YEAR = ?, TRANSMISSION = ?, CAPACITY = ? WHERE VEHICLE_ID = ?";

	String DELETE_VEHICLE_INFORMATION_BY_ID = "DELETE FROM VEHICLE WHERE VEHICLE_ID = ?";

	String DELETE_ALL_VEHICLE_INFORMATION = "DELETE FROM VEHICLE";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleDaoImpl.class);

	@Override
	@Cacheable(value = "vehicleList")
	public List<Vehicle> findAllCarInformation() {
		return jdbcTemplate.query(GET_ALL_VEHICLE_INFORMATION, BeanPropertyRowMapper.newInstance(Vehicle.class));
	}

	@Override
	@Cacheable(value = "vehicleById", key = "#vehicleId")
	public Vehicle findVehicleInformationById(long vehicleId)
			throws InvalidVehicleException {
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(Vehicle.class), vehicleId);
		LOGGER.info(
				"Retrieved Vehicle Info: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		return vehicle;
	}

	@Override
	public List<Vehicle> findVehicleInformatioByMake(String make) {
		List<Vehicle> vehicleListMake = jdbcTemplate.query(GET_VEHICLE_INFORMATION_BY_MAKE,
				(rs, rowNum) -> new Vehicle(rs.getLong("VEHICLE_ID"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getInt("CAPACITY"), rs.getString("TRANSMISSION")),
				make);

		LOGGER.info("Retrieving Vehicle Information By Make: " + make);

		return vehicleListMake;
	}

	@Override
	public List<Vehicle> findVehicleInformationByModel(String model) {
		List<Vehicle> vehicleListMake = jdbcTemplate.query(GET_VEHICLE_INFORMATION_BY_MODEL,
				(rs, rowNum) -> new Vehicle(rs.getLong("VEHICLE_ID"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getInt("CAPACITY"), rs.getString("TRANSMISSION")),
				model);

		LOGGER.info("Retrieving Vehicle Information By Model: " + model);

		return vehicleListMake;
	}

	@Override
	public List<Vehicle> findVehicleInformationByYear(String year) {
		List<Vehicle> vehicleListMake = jdbcTemplate.query(GET_VEHICLE_INFORMATION_BY_YEAR,
				(rs, rowNum) -> new Vehicle(rs.getLong("VEHICLE_ID"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getInt("CAPACITY"), rs.getString("TRANSMISSION")),
				year);

		LOGGER.info("Retrieving Vehicle Information By Year: " + year);

		return vehicleListMake;
	}

	@Override
	public List<Vehicle> findVehicleInformationByTransmission(String transmission) {
		List<Vehicle> vehicleListMake = jdbcTemplate.query(GET_VEHICLE_INFORMATION_BY_TRANSMISSION,
				(rs, rowNum) -> new Vehicle(rs.getLong("VEHICLE_ID"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getInt("CAPACITY"), rs.getString("TRANSMISSION")),
				transmission);

		LOGGER.info("Retrieving Vehicle Information By Transmission: " + transmission);

		return vehicleListMake;
	}

	@Override
	@CachePut(value = "vehicleList")
	public int addCarInformation(@RequestBody Vehicle vehicle) {

		String make = vehicle.getMake();
		String model = vehicle.getModel();
		String year = vehicle.getYear();
		String transmission = vehicle.getTransmission();
		int capacity = vehicle.getCapacity();

		LOGGER.info("Adding Vehicle Information: " + make + " " + model + " " + year);

		return jdbcTemplate.update(ADD_VEHICLE_INFORMATION, new Object[] { capacity, make, model, transmission, year });
	}

	@Override
	@CachePut(value = "vehicleById", key = "#vehicleId")
	public int updateCarInformation(long vehicleId, Vehicle vehicleDetails) {

		int result = 0;
		
		Vehicle vehicle = jdbcTemplate.queryForObject(GET_VEHICLE_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(Vehicle.class), vehicleId);
		
		if (vehicle != null) {
			vehicle.setMake(vehicleDetails.getMake());
			vehicle.setModel(vehicleDetails.getModel());
			vehicle.setYear(vehicleDetails.getYear());
			vehicle.setTransmission(vehicleDetails.getTransmission());
			vehicle.setCapacity(vehicleDetails.getCapacity());
			vehicle.setVehicleId(vehicleDetails.getVehicleId());
			
			result = jdbcTemplate.update(UPDATE_VEHICLE_INFORMATION, new Object[] {
					vehicle.getMake(),
					vehicle.getModel(),
					vehicle.getYear(),
					vehicle.getTransmission(),
					vehicle.getCapacity(),
					vehicle.getVehicleId(),
			});
			
			LOGGER.info("Updating vehicle info for vehicle_id: " + vehicleId);
		}
		
		return result;
	}

	@Override
	@CachePut(value = "vehicleById", key = "#vehicleId")
	public int deleteCarInformation(long vehicleId) {
		int result = jdbcTemplate.update(DELETE_VEHICLE_INFORMATION_BY_ID, vehicleId);

		LOGGER.info("Deleting Vehicle Information by ID: " + vehicleId);

		return result;
	}

	@Override
	@CachePut(value = "vehicleList")
	public int deleteAllVehicleInformation() {
		int count = jdbcTemplate.update(DELETE_ALL_VEHICLE_INFORMATION);

		LOGGER.info("Deleting All Vehicles...");

		return count;
	}

	@Override
	public int getCountofCars() {
		int count = jdbcTemplate.queryForObject(GET_VEHICLE_COUNT, Integer.class);

		LOGGER.info("Getting count of vehicles...");

		return count;
	}

}
