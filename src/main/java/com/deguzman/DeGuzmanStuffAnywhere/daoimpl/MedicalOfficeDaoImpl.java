package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.dao.MedicalOfficeDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;

@Repository
public class MedicalOfficeDaoImpl implements MedicalOfficeDao {

	String GET_ALL_MEDICAL_OFFICE_INFORMATION = "SELECT * FROM MEDICAL_OFFICE ORDER BY NAME";
	String GET_MEDICAL_OFFICE_INFORMATION_BY_ZIP = "SELECT * FROM MEDICAL_OFFICE WHERE ZIP = ?";
	String GET_ALL_MEDICAL_OFFICE_INFORMATION_BY_ID = "SELECT * FROM MEDICAL_OFFICE WHERE MEDICAL_OFFICE_ID = ?";
	String GET_MEDICAL_OFFICE_COUNT = "SELECT COUNT(*) FROM MEDICAL_OFFICE";
	String ADD_MEDICAL_OFFICE_INFORMATION = "INSERT INTO MEDICAL_OFFICE " + "(ADDRESS, CITY, NAME, STATE, ZIP) "
			+ "VALUES(?, ?, ?, ?, ?)";
	String UPDATE_MEDICAL_OFFICE_INFORMATION = "UPDATE MEDICAL_OFFICE "
			+ "SET NAME=?, "
			+ "ADDRESS=?, "
			+ "CITY=?, "
			+ "STATE=?, "
			+ "ZIP=? " 
			+ "WHERE MEDICAL_OFFICE_ID=?";
	String DELETE_MEDICAL_OFFICE_BY_ID = "DELETE FROM MEDICAL_OFFICE WHERE MEDICAL_OFFICE_ID = ?";
	String DELETE_ALL_MEDICAL_OFFICE_INFORMATION = "DELETE FROM MEDICAL_OFFICE";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalOfficeDaoImpl.class);

	@Override
	public List<MedicalOffice> findAllMedicalOfficeInformation() {
		List<MedicalOffice> list = jdbcTemplate.query(GET_ALL_MEDICAL_OFFICE_INFORMATION,
				BeanPropertyRowMapper.newInstance(MedicalOffice.class));

		LOGGER.info("Retriving All Medical Offices...");

		return list;
	}

	@Override
	public List<MedicalOffice> findMedicalOfficesByZip(String zip) {
		List<MedicalOffice> officeList = jdbcTemplate.query(GET_MEDICAL_OFFICE_INFORMATION_BY_ZIP,
				(rs, rowNum) -> new MedicalOffice(rs.getInt("MEDICAL_OFFICE_ID"), rs.getString("NAME"),
						rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP")),
				zip);

		LOGGER.info("Retriving Medical Office Information by Zip: " + zip);

		return officeList;
	}

	@Override
	public ResponseEntity<MedicalOffice> findMedicalOfficeInformationById(long medicalOfficeId) {
		MedicalOffice medicalOffice = jdbcTemplate.queryForObject(GET_ALL_MEDICAL_OFFICE_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(MedicalOffice.class), medicalOfficeId);

		LOGGER.info("Retrieved Medical Office Information: " + " " + medicalOffice.getName());

		return ResponseEntity.ok().body(medicalOffice);
	}

	@Override
	public int getMedicalOfficeCount() {
		int count = jdbcTemplate.queryForObject(GET_MEDICAL_OFFICE_COUNT, Integer.class);

		LOGGER.info("Getting Medical Office Count...");

		return count;
	}

	@Override
	public int addMedicalOfficeInformation(MedicalOffice medicalOffice) {

		String address = medicalOffice.getAddress();
		String city = medicalOffice.getCity();
		String medicalOfficeName = medicalOffice.getName();
		String state = medicalOffice.getState();
		String zip = medicalOffice.getZip();

		LOGGER.info("Added Medical Office information: " + medicalOfficeName);

		return jdbcTemplate.update(ADD_MEDICAL_OFFICE_INFORMATION,
				new Object[] { address, city, medicalOfficeName, state, zip });
	}

	@Override
	public int updateMedicalOfficeInformation(long medicalOfficeId, MedicalOffice officeDetails) {

		int result = 0; 
		
		MedicalOffice medicalOffice = jdbcTemplate.queryForObject(GET_ALL_MEDICAL_OFFICE_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(MedicalOffice.class), medicalOfficeId);
		
		if (medicalOffice != null) {
			medicalOffice.setName(officeDetails.getName());
			medicalOffice.setAddress(officeDetails.getAddress());
			medicalOffice.setCity(officeDetails.getCity());
			medicalOffice.setState(officeDetails.getState());
			medicalOffice.setZip(officeDetails.getZip());
			medicalOffice.setMedicalOfficeId(medicalOfficeId);
			
			result = jdbcTemplate.update(UPDATE_MEDICAL_OFFICE_INFORMATION, new Object [] {
				medicalOffice.getName(),
				medicalOffice.getAddress(),
				medicalOffice.getCity(),
				medicalOffice.getState(),
				medicalOffice.getZip(),
				medicalOffice.getMedicalOfficeId()
			});
			
			LOGGER.info("Updating medical office information with medical_office_id: " + medicalOfficeId);
		}
		
		return result;
	}

	@Override
	public int deleteMedicalOfficeById(long medicalOfficeId) {
		int count = jdbcTemplate.update(DELETE_MEDICAL_OFFICE_BY_ID, medicalOfficeId);

		LOGGER.info("Deleting Medical Office by medical_office_id: " + medicalOfficeId);

		return count;
	}

	@Override
	public int deleteAllMedicalOfficeInformation() {
		int count = jdbcTemplate.update(DELETE_ALL_MEDICAL_OFFICE_INFORMATION);

		LOGGER.info("Deleting All Medical Office Information...");

		return count;
	}

}
