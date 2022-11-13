package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

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

import com.deguzman.DeGuzmanStuffAnywhere.dao.GeneralTrxDao;
import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;

@Repository
public class GeneralTrxDaoImpl implements GeneralTrxDao {

	String GET_ALL_GENERAL_TRX_INFORMATION = "SELECT GT.TRANSACTION_ID, GT.AMOUNT, GT.ENTITY, GT.PAYMENT_DATE, TT.TRANSACTION_TYPE_DESCR, U.USERNAME "
			+ "FROM GENERAL_TRANSACTION GT, TRANSACTION_TYPE TT, USERS U "
			+ "WHERE GT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID AND GT.USER_ID = U.USER_ID "
			+ "ORDER BY GT.PAYMENT_DATE DESC";

	String GET_ALL_GENERAL_TRANSACTION_INFO_BY_TYPE = "SELECT GT.TRANSACTION_ID, GT.AMOUNT, GT.ENTITY, GT.PAYMENT_DATE, TT.TRANSACTION_TYPE_DESCR, US.USERNAME "
			+ "FROM GENERAL_TRANSACTION GT, TRANSACTION_TYPE TT, USERS U "
			+ "WHERE GT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID AND GT.USER_ID = U.USER_ID "
			+ "AND GT.TRANSACTION_TYPE_ID = ?";

	String GET_ALL_GENERAL_TRANSACTION_INFO_BY_USER = "SELECT GT.TRANSACTION_ID, GT.AMOUNT, GT.ENTITY, GT.PAYMENT_DATE, TT.TRANSACTION_TYPE_DESCR, US.USERNAME "
			+ "FROM GENERAL_TRANSACTION GT, TRANSACTION_TYPE TT, USERS U "
			+ "WHERE GT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID AND GT.USER_ID = U.USER_ID "
			+ "AND GT.USER_ID = ?";

	String GET_TRANSACTION_INFO_BY_ID = "SELECT GT.TRANSACTION_ID, GT.AMOUNT, GT.ENTITY, GT.PAYMENT_DATE, TT.TRANSACTION_TYPE_DESCR, US.USERNAME "
			+ "FROM GENERAL_TRANSACTION GT, TRANSACTION_TYPE TT, USERS U "
			+ "WHERE GT.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID AND GT.USER_ID = U.USER_ID "
			+ "AND GT.TRANSACTION_ID = ?";
	
	String GET_TRANSASCTION_INFO = "SELECT * FROM GENERAL_TRANSACTION WHERE TRANSACTION_ID = ?";

	String GET_TRANSCTION_COUNT = "SELECT COUNT(*) FROM GENERAL_TRANSACTIONS";

	String ADD_TRANSACTION_INFO = "INSERT INTO GENERAL_TRANSACTION "
			+ "(AMOUNT, ENTITY, PAYMENT_DATE, TRANSACTION_TYPE_ID, USER_ID) " + "VALUES(?, ?, ?, ?, ?)";
	
	String UPDATE_TRANSACTION_INFO = "UPDATE GENERAL_TRANSACTION SET AMOUNT = ?, ENTITY = ?, PAYMENT_DATE = ?, TRANSACTION_TYPE_ID = ?, USER_ID = ? WHERE TRANSACTION_ID = ?";

	String DELETE_TRANSACTION_BY_ID = "DELETE FROM GENERAL_TRANSACTION WHERE TRANSACTION_ID = ?";

	String DELETE_ALL_TRANSACTIONS = "DELETE FROM GENERAL_TRANSACTION";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(GeneralTrxDaoImpl.class);

	@Override
	@Cacheable(value = "transactionList")
	public List<GeneralTrxInfoDTO> findAllTransactionInformation() {
		List<GeneralTrxInfoDTO> generalTrxList = jdbcTemplate.query(GET_ALL_GENERAL_TRX_INFORMATION,
				BeanPropertyRowMapper.newInstance(GeneralTrxInfoDTO.class));

		LOGGER.info("Retrieving all general transaction info...");

		return generalTrxList;
	}

	@Override
	public List<GeneralTrxInfoDTO> findTransactionsByUser(long user_id) {
		List<GeneralTrxInfoDTO> generalTrxListUser = jdbcTemplate.query(GET_ALL_GENERAL_TRANSACTION_INFO_BY_USER,
				(rs, rowNum) -> new GeneralTrxInfoDTO(rs.getLong("TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("ENTITY"), rs.getString("PAYMENT_DATE"), rs.getString("TRANSACTION_TYPE_DESCR"),
						rs.getString("USERNAME")),
				user_id);

		LOGGER.info("Retrieving list of transactions with user_id: " + user_id);

		return generalTrxListUser;
	}

	@Override
	public List<GeneralTrxInfoDTO> findTransactionsByType(long transaction_type_id) {
		List<GeneralTrxInfoDTO> generalTrxListType = jdbcTemplate.query(GET_ALL_GENERAL_TRANSACTION_INFO_BY_TYPE,
				(rs, rowNum) -> new GeneralTrxInfoDTO(rs.getLong("TRANSACTION_ID"), rs.getDouble("AMOUNT"),
						rs.getString("ENTITY"), rs.getString("PAYMENT_DATE"), rs.getString("TRANSACTION_TYPE_DESCR"),
						rs.getString("USERNAME")),
				transaction_type_id);

		LOGGER.info("Retriving list of transactions with transaction_type_id: " + transaction_type_id);

		return generalTrxListType;
	}

	@Override
	@Cacheable(value = "generalTransactionById", key = "#transaction_id")
	public GeneralTrxInfoDTO findTransactionInformationDTOById(long transaction_id)
			throws ResourceNotFoundException {
		GeneralTrxInfoDTO generalTrx = jdbcTemplate.queryForObject(GET_TRANSACTION_INFO_BY_ID,
				BeanPropertyRowMapper.newInstance(GeneralTrxInfoDTO.class), transaction_id);

		LOGGER.info("Retrieving transaction with ID: " + transaction_id);

		return generalTrx;
	}
	
	@Override
	public GeneralTransaction findTransactionInformationById(long transaction_id)
			throws ResourceNotFoundException {
		GeneralTransaction transaction = jdbcTemplate.queryForObject(GET_TRANSASCTION_INFO,
				BeanPropertyRowMapper.newInstance(GeneralTransaction.class), transaction_id);
		
		LOGGER.info("Retrieving transaction with ID: " + transaction_id);
		
		return transaction;
		
	}

	@Override
	public long findCountOfGeneralTransaction() {
		long count = jdbcTemplate.queryForObject(GET_TRANSCTION_COUNT, Integer.class);

		LOGGER.info("Getting General Transaction Count...");

		return count;
	}

	@Override
	@CachePut(value = "transactionList")
	public int addTransactionInformation(GeneralTransaction transaction) throws ResourceNotFoundException {

		double amount = transaction.getAmount();
		String entity = transaction.getEntity();
		String paymentDate = transaction.getPayment_date();
		long transactionTypeId = transaction.getTransaction_type_id();
		long userId = transaction.getUser_id();

		LOGGER.info("Adding general tranasction: " + entity + " " + amount + " by" + " " + "user with ID: " + userId);

		return jdbcTemplate.update(ADD_TRANSACTION_INFO,
				new Object[] { amount, entity, paymentDate, transactionTypeId, userId });
	}

	@Override
	@CachePut(value = "generalTrasactionById", key = "#transaction_id")
	public int updateTransactionInformation(Long transaction_id, @RequestBody GeneralTransaction transactionDetails) {

		int result = 0;
		
		GeneralTransaction transaction = jdbcTemplate.queryForObject(GET_TRANSASCTION_INFO,
				BeanPropertyRowMapper.newInstance(GeneralTransaction.class), transaction_id);
		
		if (transaction != null) {
			transaction.setAmount(transactionDetails.getAmount());
			transaction.setEntity(transactionDetails.getEntity());
			transaction.setPayment_date(transactionDetails.getPayment_date());
			transaction.setTransaction_type_id(transactionDetails.getTransaction_type_id());
			transaction.setUser_id(transactionDetails.getUser_id());
			transaction.setTransaction_id(transaction_id);
			
			result = jdbcTemplate.update(UPDATE_TRANSACTION_INFO, new Object[] {
				transaction.getAmount(),
				transaction.getEntity(),
				transaction.getPayment_date(),
				transaction.getTransaction_type_id(),
				transaction.getUser_id(),
				transaction.getTransaction_id()
			});
			
			LOGGER.info("Updating general transaction information for transaction_id: " + transaction_id);
		}
		
		return result;
	}

	@Override
	@CachePut(value = "generalTrasactionById", key = "#transaction_id")
	public int deleteTransactionInformation(long transaction_id) {
		int result = jdbcTemplate.update(DELETE_TRANSACTION_BY_ID, transaction_id);

		LOGGER.info("Deleting transaction with ID: " + transaction_id);

		return result;
	}

	@Override
	@CachePut(value = "transactionList")
	public int deleteAllTransactions() {
		int result = jdbcTemplate.update(DELETE_ALL_TRANSACTIONS);

		LOGGER.info("Deleting All Transactions...");

		return result;
	}

}
