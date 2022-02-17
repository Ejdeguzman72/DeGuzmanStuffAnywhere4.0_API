package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.dao.MedicalTrxDao;
import com.deguzman.DeGuzmanStuffAnywhere.dto.MedicalTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction;

@Repository
public class MedicalTrxDaoImpl implements MedicalTrxDao {

	String GET_ALL_MEDICAL_TRANSACTION_INFO = "SELECT MT.MEDICAL_TRANSACTION_ID,MT.AMOUNT,MT.MEDICAL_TRANSACTION_DATE, MO.NAME AS FACILITYNAME,MO.ADDRESS,MO.CITY,MO.STATE,MO.ZIP,TT.TRANSACTION_TYPE_DESCR, US.NAME AS NAMEOFUSER "
			+ "FROM MEDICAL_TRANSACTIONS MT, MEDICAL_OFFICE MO, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE MT.MEDICAL_OFFICE_ID = MO.MEDICAL_OFFICE_ID AND MT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID  AND MT.USER_ID = US.USER_ID "
			+ "ORDER BY MT.MEDICAL_TRANSACTION_DATE DESC";

	String GET_ALL_MEDICAL_TRANSACTIONS_BY_FACILITY = "SELECT MT.MEDICAL_TRANSACTION_ID,MT.AMOUNT,MT.MEDICAL_TRANSACTION_DATE, MO.NAME AS FACILITYNAME,MO.ADDRESS,MO.CITY,MO.STATE,MO.ZIP,TT.TRANSACTION_TYPE_DESCR, US.NAME AS NAMEOFUSER "
			+ "FROM MEDICAL_TRANSACTIONS MT, MEDICAL_OFFICE MO, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE MT.MEDICAL_OFFICE_ID = MO.MEDICAL_OFFICE_ID AND MT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID  AND MT.USER_ID = US.USER_ID "
			+ "AND MT.MEDICAL_OFFICE_ID = ? " + "ORDER BY MT.MEDICAL_TRANSACTION_DATE DESC";

	String GET_ALL_MEDICAL_TRANSACTIONS_BY_TYPE = "SELECT MT.MEDICAL_TRANSACTION_ID,MT.AMOUNT,MT.MEDICAL_TRANSACTION_DATE, MO.NAME AS FACILITYNAME,MO.ADDRESS,MO.CITY,MO.STATE,MO.ZIP,TT.TRANSACTION_TYPE_DESCR, US.NAME AS NAMEOFUSER "
			+ "FROM MEDICAL_TRANSACTIONS MT, MEDICAL_OFFICE MO, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE MT.MEDICAL_OFFICE_ID = MO.MEDICAL_OFFICE_ID AND MT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID  AND MT.USER_ID = US.USER_ID "
			+ "AND MT.TRANSACTION_TYPE_ID = ? " + "ORDER BY MT.MEDICAL_TRANSACTION_DATE DESC";

	String GET_ALL_MEDICAL_TRANSACTIONS_BY_USER = "SELECT MT.MEDICAL_TRANSACTION_ID,MT.AMOUNT,MT.MEDICAL_TRANSACTION_DATE, MO.NAME AS FACILITYNAME,MO.ADDRESS,MO.CITY,MO.STATE,MO.ZIP,TT.TRANSACTION_TYPE_DESCR, US.NAME AS NAMEOFUSER "
			+ "FROM MEDICAL_TRANSACTIONS MT, MEDICAL_OFFICE MO, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE MT.MEDICAL_OFFICE_ID = MO.MEDICAL_OFFICE_ID AND MT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID  AND MT.USER_ID = US.USER_ID "
			+ "AND MT.USER_ID = ? " + "ORDER BY MT.MEDICAL_TRANSACTION_DATE DESC";

	String GET_MEDICAL_TRANSACTION_BY_ID = "SELECT MT.MEDICAL_TRANSACTION_ID,MT.AMOUNT,MT.MEDICAL_TRANSACTION_DATE, MO.NAME AS FACILITYNAME,MO.ADDRESS,MO.CITY,MO.STATE,MO.ZIP,TT.TRANSACTION_TYPE_DESCR, US.NAME AS NAMEOFUSER "
			+ "FROM MEDICAL_TRANSACTIONS MT, MEDICAL_OFFICE MO, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE MT.MEDICAL_OFFICE_ID = MO.MEDICAL_OFFICE_ID AND MT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID  AND MT.USER_ID = US.USER_ID "
			+ "AND MT.MEDICAL_TRANSACTION_ID = ?";
	
	String GET_MEDICAL_TRANSACTION_INFO = "SELECT * FROM MEDICAL_TRANSACTIONS WHERE MEDICAL_TRANSACTION_ID = ?";

	String GET_MEDICAL_TRX_COUNT = "SELECT COUNT(*) FROM MEDICAL_TRANSACTIONS";

	String ADD_MEDICAL_TRANSACTION = "INSERT INTO MEDICAL_TRANSACTIONS "
			+ "(AMOUNT, MEDICAL_TRANSACTION_DATE, MEDICAL_OFFICE_ID, TRANSACTION_TYPE_ID, USER_ID) "
			+ "VALUES(?, ?, ?, ?, ?)";

	String UPDATE_MEDICAL_TRANSACTION = "UPDATE MEDICAL_TRANSACTIONS "
			+ "SET AMOUNT = ?, "
			+ "MEDICAL_TRANSACTION_DATE = ?, "
			+ "MEDICAL_OFFICE_ID = ?, "
			+ "TRANSACTION_TYPE_ID = ?, "
			+ "USER_ID = ? "
			+ "WHERE MEDICAL_TRANSACTION_ID = ?";

	String DELETE_MEDICAL_TRANSACTION_BY_ID = "DELETE FROM MEDICAL_TRANSACTIONS WHERE MEDICAL_TRANSACTION_ID = ?";

	String DELETE_ALL_MEDICAL_TRANSACTIONS = "DELETE FROM MEDICAL_TRANSACTIONS";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalTrxDaoImpl.class);

	@Override
	public List<MedicalTrxInfoDTO> findAllMedicalTransactionInformation() {
		List<MedicalTrxInfoDTO> medicalTrxList = jdbcTemplate.query(GET_ALL_MEDICAL_TRANSACTION_INFO,
				(rs, rowNum) -> new MedicalTrxInfoDTO(rs.getLong("MEDICAL_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("MEDICAL_TRANSACTION_DATE"), rs.getString("FACILITYNAME"), rs.getString("ADDRESS"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("TRANSACTION_TYPE_DESCR"), rs.getString("NAMEOFUSER")));

		LOGGER.info("Retrieving all medical transactions...");

		return medicalTrxList;
	}

	@Override
	public List<MedicalTrxInfoDTO> findMedicalTransactionsByFacility(@PathVariable int facility_id) {
		List<MedicalTrxInfoDTO> medicalTrxListFacility = jdbcTemplate.query(GET_ALL_MEDICAL_TRANSACTIONS_BY_FACILITY,
				(rs, rowNum) -> new MedicalTrxInfoDTO(rs.getLong("MEDICAL_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("MEDICAL_TRANSACTION_DATE"), rs.getString("FACILITYNAME"), rs.getString("ADDRESS"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("TRANSACTION_TYPE_DESCR"), rs.getString("NAMEOFUSER")),
				facility_id);

		LOGGER.info("Retrieving All Medical Transactions by facility_id: " + facility_id);

		return medicalTrxListFacility;

	}

	@Override
	public List<MedicalTrxInfoDTO> findMedicalTransactionsByType(@PathVariable long transaction_type_id) {
		List<MedicalTrxInfoDTO> medicalTrxListType = jdbcTemplate.query(GET_ALL_MEDICAL_TRANSACTIONS_BY_TYPE,
				(rs, rowNum) -> new MedicalTrxInfoDTO(rs.getLong("MEDICAL_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("MEDICAL_TRANSACTION_DATE"), rs.getString("FACILITYNAME"), rs.getString("ADDRESS"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("TRANSACTION_TYPE_DESCR"), rs.getString("NAMEOFUSER")),
				transaction_type_id);

		LOGGER.info("Retrieving All Medical Transactions by transaction_type_id: " + transaction_type_id);

		return medicalTrxListType;
	}

	@Override
	public List<MedicalTrxInfoDTO> findAllMedicalTransactionbyUser(@PathVariable long user_id) {
		List<MedicalTrxInfoDTO> medicalTrxListUser = jdbcTemplate.query(GET_ALL_MEDICAL_TRANSACTIONS_BY_USER,
				(rs, rowNum) -> new MedicalTrxInfoDTO(rs.getLong("MEDICAL_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("MEDICAL_TRANSACTION_DATE"), rs.getString("FACILITYNAME"), rs.getString("ADDRESS"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("TRANSACTION_TYPE_DESCR"), rs.getString("NAMEOFUSER")),
				user_id);

		LOGGER.info("Retrieving All Medical Transactions by user_id: " + user_id);

		return medicalTrxListUser;
	}

	@Override
	public ResponseEntity<MedicalTrxInfoDTO> findMedicalTransactionInformationById(
			@PathVariable long medical_transaction_id) throws ResourceNotFoundException {
		MedicalTrxInfoDTO medicalTrx = jdbcTemplate.queryForObject(GET_MEDICAL_TRANSACTION_BY_ID,
				BeanPropertyRowMapper.newInstance(MedicalTrxInfoDTO.class), medical_transaction_id);

		LOGGER.info("Retrieving Medical Transaction by ID: " + medical_transaction_id);

		return ResponseEntity.ok().body(medicalTrx);
	}

	@Override
	public long getCountOfMedicalTransactions() {
		long count = jdbcTemplate.queryForObject(GET_MEDICAL_TRX_COUNT, Integer.class);

		LOGGER.info("Getting the medical transaction count...");

		return count;
	}

	@Override
	public int addMedicalTransactionInformation(MedicalTransaction medicalTransaction)
			throws ResourceNotFoundException {

		double amount = medicalTransaction.getAmount();
		String medicalTrxDate = medicalTransaction.getMedical_transaction_date();
		int medicalOffice = medicalTransaction.getMedical_office_id();
		long transactionType = medicalTransaction.getTransaction_type_id();
		long user = medicalTransaction.getUser_id();

		LOGGER.info("Adding medical transaction..." + " " + amount + " " + medicalTrxDate);

		int result = jdbcTemplate.update(ADD_MEDICAL_TRANSACTION,
				new Object[] { amount, medicalTrxDate, medicalOffice, transactionType, user });

		return result;
	}

	@Override
	public int updateMedicalTransaction(long medical_transaction_id, MedicalTransaction medicalTransactionDetails) {

		int result = 0;
		
		MedicalTransaction transaction = jdbcTemplate.queryForObject(GET_MEDICAL_TRANSACTION_INFO,
				BeanPropertyRowMapper.newInstance(MedicalTransaction.class), medical_transaction_id);
		
		if (transaction != null) {
			transaction.setAmount(medicalTransactionDetails.getAmount());
			transaction.setMedical_transaction_date(medicalTransactionDetails.getMedical_transaction_date());
			transaction.setMedical_office_id(medicalTransactionDetails.getMedical_office_id());
			transaction.setTransaction_type_id(medicalTransactionDetails.getTransaction_type_id());
			transaction.setUser_id(medicalTransactionDetails.getUser_id());
			transaction.setMedical_transaction_id(medical_transaction_id);
			
			result = jdbcTemplate.update(UPDATE_MEDICAL_TRANSACTION, new Object[] {
				transaction.getAmount(),
				transaction.getMedical_transaction_date(),
				transaction.getMedical_office_id(),
				transaction.getTransaction_type_id(),
				transaction.getUser_id(),
				transaction.getMedical_transaction_id()
			});
			
			LOGGER.info("Updating medical transaction info for medical_transaction_id: " + medical_transaction_id);
		}
		
		return result;
	}

	@Override
	public int deleteMedicalTraansactionInformation(long medical_transaction_id) {
		int result = jdbcTemplate.update(DELETE_MEDICAL_TRANSACTION_BY_ID, medical_transaction_id);

		LOGGER.info("Deleting Medical Transaction based on medical_transaction_id: " + medical_transaction_id);

		return result;
	}

	@Override
	public int deleteAllMedicalTransactions() {
		int result = jdbcTemplate.update(DELETE_ALL_MEDICAL_TRANSACTIONS);

		LOGGER.info("Deleting All Medical Transactions...");

		return result;
	}

}
