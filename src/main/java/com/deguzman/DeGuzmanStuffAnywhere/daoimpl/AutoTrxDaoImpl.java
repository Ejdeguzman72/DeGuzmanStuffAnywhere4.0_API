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

import com.deguzman.DeGuzmanStuffAnywhere.dao.AutoTrxDao;
import com.deguzman.DeGuzmanStuffAnywhere.dto.AutoTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidTransactionTypeException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidUserException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidVehicleException;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction;

@Repository
public class AutoTrxDaoImpl implements AutoTrxDao {

	String GET_ALL_AUTO_TRX_INFORMATION = "SELECT AT.AUTO_TRANSACTION_ID, AT.AUTO_TRANSACTION_DATE, AT.AMOUNT, V.MAKE, V.MODEL, V.YEAR, ASH.AUTO_SHOP_NAME, US.NAME, TT.TRANSACTION_TYPE_DESCR "
			+ "FROM AUTO_TRANSACTIONS AT, AUTO_SHOP ASH, VEHICLE V, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE AT.AUTO_SHOP_ID = ASH.AUTO_SHOP_ID " + "	AND AT.VEHICLE_ID = V.VEHICLE_ID "
			+ "	AND AT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID " + "	AND AT.USER_ID = US.USER_ID "
			+ "ORDER BY AT.AUTO_TRANSACTION_DATE";

	String GET_ALL_AUTO_TRX_INFO_BY_TYPE = "SELECT AT.AUTO_TRANSACTION_ID, AT.AUTO_TRANSACTION_DATE, AT.AMOUNT, V.MAKE, V.MODEL, V.YEAR, ASH.AUTO_SHOP_NAME, US.NAME, TT.TRANSACTION_TYPE_DESCR "
			+ "FROM AUTO_TRANSACTIONS AT, AUTO_SHOP ASH, VEHICLE V, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE AT.AUTO_SHOP_ID = ASH.AUTO_SHOP_ID " + "	AND AT.VEHICLE_ID = V.VEHICLE_ID "
			+ "	AND AT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID " + "	AND AT.USER_ID = US.USER_ID"
			+ "   AND AT.TRANSACTION_TYPE_ID = ?";

	String GET_ALL_AUTO_TRX_INFO_BY_VEHICLE = "SELECT AT.AUTO_TRANSACTION_ID, AT.AUTO_TRANSACTION_DATE, AT.AMOUNT, V.MAKE, V.MODEL, V.YEAR, ASH.AUTO_SHOP_NAME, US.NAME, TT.TRANSACTION_TYPE_DESCR "
			+ "FROM AUTO_TRANSACTIONS AT, AUTO_SHOP ASH, VEHICLE V, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE AT.AUTO_SHOP_ID = ASH.AUTO_SHOP_ID " + "	AND AT.VEHICLE_ID = V.VEHICLE_ID "
			+ "	AND AT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID " + "	AND AT.USER_ID = US.USER_ID"
			+ "   AND AT.VEHICLE_ID = ?";

	String GET_ALL_AUTO_TRX_BY_USER = "SELECT AT.AUTO_TRANSACTION_ID, AT.AUTO_TRANSACTION_DATE, AT.AMOUNT, V.MAKE, V.MODEL, V.YEAR, ASH.AUTO_SHOP_NAME, US.NAME, TT.TRANSACTION_TYPE_DESCR "
			+ "FROM AUTO_TRANSACTIONS AT, AUTO_SHOP ASH, VEHICLE V, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE AT.AUTO_SHOP_ID = ASH.AUTO_SHOP_ID " + "	AND AT.VEHICLE_ID = V.VEHICLE_ID "
			+ "	AND AT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID " + "	AND AT.USER_ID = US.USER_ID"
			+ "   AND AT.USER_ID = ?";

	String GET_AUTO_TRX_INFO_BY_ID = "SELECT AT.AUTO_TRANSACTION_ID, AT.AUTO_TRANSACTION_DATE, AT.AMOUNT, V.MAKE, V.MODEL, V.YEAR, ASH.AUTO_SHOP_NAME, US.NAME, TT.TRANSACTION_TYPE_DESCR "
			+ "FROM AUTO_TRANSACTIONS AT, AUTO_SHOP ASH, VEHICLE V, TRANSACTION_TYPE TT, USERS US "
			+ "WHERE AT.AUTO_SHOP_ID = ASH.AUTO_SHOP_ID " + "	AND AT.VEHICLE_ID = V.VEHICLE_ID "
			+ "	AND AT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID " + "	AND AT.USER_ID = US.USER_ID"
			+ "   AND AT.AUTO_TRANSACTION_ID = ?";

	String GET_AUTO_TRX_COUNT = "SELECT COUNT(*) FROM AUTO_TRANSACTIONS";

	String ADD_AUTO_TRX_INFO = "INSERT INTO AUTO_TRANSACTIONS "
			+ "(AMOUNT, AUTO_TRANSACTION_DATE, AUTO_SHOP_ID, VEHICLE_ID, TRANSACTION_TYPE_ID, USER_ID) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";

	String DELETE_AUTO_TRX_BY_ID = "DELETE FROM AUTO_TRANSACTIONS WHERE AUTO_TRANSACTION_ID = ?";

	String DELETE_ALL_AUTO_TRX = "DELETE FROM AUTO_TRANSACTIONS";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(AutoTrxDaoImpl.class);

	@Override
	public List<AutoTrxInfoDTO> findAllAutoTransactionInformation() {
		List<AutoTrxInfoDTO> autoTrxList = jdbcTemplate.query(GET_ALL_AUTO_TRX_INFORMATION,
				BeanPropertyRowMapper.newInstance(AutoTrxInfoDTO.class));

		LOGGER.info("Retrieving all Auto Transactions...");

		return autoTrxList;
	}

	@Override
	public List<AutoTrxInfoDTO> findAutoTransactionsByVehicle(long vehicle_id) {
		List<AutoTrxInfoDTO> autoTrxListVehicle = jdbcTemplate.query(GET_ALL_AUTO_TRX_INFO_BY_VEHICLE,
				(rs, rowNum) -> new AutoTrxInfoDTO(rs.getLong("AUTO_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("AUTO_TRANSACTION_DATE"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getString("AUTO_SHOP_NAME"), rs.getString("NAME"),
						rs.getString("TRANSACTION_TYPE_DESCR")),
				vehicle_id);

		LOGGER.info("Retriving all Auto Transactions by vehicle_id: " + vehicle_id);

		return autoTrxListVehicle;
	}

	@Override
	public List<AutoTrxInfoDTO> findAutoTransactionsByUser(long user_id) {
		List<AutoTrxInfoDTO> autoTrxListUser = jdbcTemplate.query(GET_ALL_AUTO_TRX_BY_USER,
				(rs, rowNum) -> new AutoTrxInfoDTO(rs.getLong("AUTO_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("AUTO_TRANSACTION_DATE"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getString("AUTO_SHOP_NAME"), rs.getString("NAME"),
						rs.getString("TRANSACTION_TYPE_DESCR")),
				user_id);

		LOGGER.info("Retrieving all Auto Transactions by user_id: " + user_id);

		return autoTrxListUser;
	}

	@Override
	public List<AutoTrxInfoDTO> findAutoTransactionsByType(long transaction_type_id) {
		List<AutoTrxInfoDTO> autoTrxListType = jdbcTemplate.query(GET_ALL_AUTO_TRX_INFO_BY_TYPE,
				(rs, rowNum) -> new AutoTrxInfoDTO(rs.getLong("AUTO_TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("AUTO_TRANSACTION_DATE"), rs.getString("MAKE"), rs.getString("MODEL"),
						rs.getString("YEAR"), rs.getString("AUTO_SHOP_NAME"), rs.getString("NAME"),
						rs.getString("TRANSACTION_TYPE_DESCR")),
				transaction_type_id);

		LOGGER.info("Retrieving all Auto Transactions by transaction_type_id: " + transaction_type_id);

		return autoTrxListType;
	}

	@Override
	public ResponseEntity<AutoTrxInfoDTO> findAutoTranasctionInformationById(@PathVariable long auto_transaction_id)
			throws InvalidTransactionException {

		AutoTrxInfoDTO autoTrxInfo = jdbcTemplate.queryForObject(GET_AUTO_TRX_INFO_BY_ID,
				BeanPropertyRowMapper.newInstance(AutoTrxInfoDTO.class), auto_transaction_id);

		LOGGER.info("Retrieving transaction based on ID: " + " " + auto_transaction_id);

		return ResponseEntity.ok().body(autoTrxInfo);
	}

	@Override
	public long getCountOfAutoTransactions() {
		long count = jdbcTemplate.queryForObject(GET_AUTO_TRX_COUNT, Integer.class);

		LOGGER.info("Retrieving count of Auto Transactions...");

		return count;
	}

	@Override
	public int addAutoTransactionInformation(AutoTransaction autoTransaction) throws InvalidAutoShopException,
			InvalidUserException, InvalidTransactionTypeException, InvalidVehicleException {
		double amount = autoTransaction.getAmount();
		String auto_transaction_date = autoTransaction.getAuto_transaction_date();
		int autoShop = autoTransaction.getAuto_shop_id();
		long transactionType = autoTransaction.getTransaction_type_id();
		long vehicle = autoTransaction.getVehicle_id();
		long user = autoTransaction.getUser_id();

		LOGGER.info("Adding Auto Transaction: " + " " + amount);

		return jdbcTemplate.update(ADD_AUTO_TRX_INFO,
				new Object[] { amount, auto_transaction_date, autoShop, transactionType, vehicle, user });

	}

	@Override
	public int updateTransactionInformation(long auto_transaction_id, AutoTransaction autoTransactionDetails)
			throws InvalidAutoShopException, InvalidVehicleException, InvalidTransactionTypeException,
			InvalidUserException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAutoTransactionInformation(long auto_transaction_id) {
		int count = jdbcTemplate.update(DELETE_AUTO_TRX_BY_ID, auto_transaction_id);

		LOGGER.info("Deleting Auto Transaction with ID: " + auto_transaction_id);

		return count;
	}

	@Override
	public int deleteAllAutoTransactions() {
		int count = jdbcTemplate.update(DELETE_ALL_AUTO_TRX);

		LOGGER.info("Deleting All Auto Transactions");

		return count;
	}

}
