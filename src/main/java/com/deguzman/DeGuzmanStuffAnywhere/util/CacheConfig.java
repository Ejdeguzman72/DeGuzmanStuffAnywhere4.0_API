package com.deguzman.DeGuzmanStuffAnywhere.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {
	
	@Autowired
	private CacheManager cacheManager;

	private String AUTO_SHOP_LIST = "autoShopList";
	private String AUTO_SHOP_PAGINATON_LIST = "autoShopPaginationList";
	private String AUTO_SHOP_BY_ID = "autoShopById";
	
	private String AUTO_TRANSACTION_LIST = "autoTransactionList";
	private String AUTO_TRANSACTION_PAGINATION_LIST = "autoTransactionPaginationList";
	private String AUTO_TRANSACTION_BY_ID = "autoTrasactionById";
	
	private String BOOK_LIST = "bookList";
	private String BOOK_PAGINATION_LIST = "bookPaginationList";
	private String BOOK_BY_ID = "bookById";
	private String BOOK_BY_NAME = "bookName";
	
	private String CONTACT_LIST = "contactList";
	private String CONTACT_PAGINATION_LIST = "contactPaginationList";
	private String CONTACT_BY_ID = "contactById";
	
	private String EXERCISE_LIST = "exerciseList";
	private String EXERCISE_PAGINATION_LIST = "exercisePaginationList";
	private String EXERCISE_BY_ID = "exerciseById";
	
	private String GENERAL_TRANSACTION_LIST = "transactionList";
	private String GENERAL_TRANSACTION_PAGINATION_LIST = "generalTransactionPaginationList";
	private String GENERAL_TRANSACTION_BY_ID = "generalTrasactionById";
	
	private String HOME_INFO_LIST = "homeInfoList";
	private String HOME_INFO_PAGINATION_LIST = "homeInfoPaginationList";
	
	private String MEDICAL_OFFICE_LIST = "medicalOfficeList";
	private String MEDICAL_OFFICE_PAGINATION_LIST = "medicalOfficePaginationList";
	private String MEDICAL_OFFICE_BY_ID = "medicalOfficeById";
	
	private String MEDICAL_TRANSACTION_LIST = "medicalTrasactionList";
	private String MEDICAL_TRANSACTION_PAGINATION_LIST = "medicalTransactionPaginationList";
	private String MEDICAL_TRANSACTION_BY_ID = "medicalTransactionById";
	
	private String POST_LIST = "postList";
	private String POST_PAGINATION_LIST = "postPaginationList";
	private String POST_BY_ID = "postById";
	
	private String RESTAURANT_LIST = "restaurantList";
	private String RESTAURANT_PAGINATION_LIST = "restaurantPaginationList";
	private String RESTAURANT_BY_ID = "restaurantByid";
	
	private String RUN_LIST = "runList";
	private String RUN_PAGINATION_LIST = "runPaginationList";
	private String RUN_TRACKER_BY_ID = "runById";
	
	private String SONG_LIST = "songList";
	private String SONG_PAGINATION_LIST = "songPaginationList";
	private String SONG_BY_ID = "songById";
	
	private String USER_LIST = "userList";
	private String USER_BY_ID = "userById";
	
	private String UTILITY_LIST = "utilityList";
	private String UTILITY_BY_ID = "utilityById";
	
	private String VEHICLE_LIST = "vehicleList";
	private String VEHICLE_PAGINATION_LIST = "vehiclePaginationList";
	private String VEHICLE_BY_ID = "vehicleById";

	@Bean
	public CacheManager dsaCacheManager() {
		SimpleCacheManager dsaCacheManager = new SimpleCacheManager();
		dsaCacheManager.setCaches(Arrays.asList(
				new ConcurrentMapCache(AUTO_SHOP_LIST),
				new ConcurrentMapCache(AUTO_SHOP_PAGINATON_LIST),
				new ConcurrentMapCache(AUTO_SHOP_BY_ID),
				
				new ConcurrentMapCache(AUTO_TRANSACTION_LIST),
				new ConcurrentMapCache(AUTO_TRANSACTION_PAGINATION_LIST),
				new ConcurrentMapCache(AUTO_TRANSACTION_BY_ID),
				
				new ConcurrentMapCache(BOOK_LIST),
				new ConcurrentMapCache(BOOK_PAGINATION_LIST),
				new ConcurrentMapCache(BOOK_BY_ID), 
				new ConcurrentMapCache(BOOK_BY_NAME),
				
				new ConcurrentMapCache(CONTACT_LIST),
				new ConcurrentMapCache(CONTACT_PAGINATION_LIST),
				new ConcurrentMapCache(CONTACT_BY_ID),
				
				new ConcurrentMapCache(EXERCISE_LIST),
				new ConcurrentMapCache(EXERCISE_PAGINATION_LIST),
				new ConcurrentMapCache(EXERCISE_BY_ID),
								
				new ConcurrentMapCache(GENERAL_TRANSACTION_LIST),
				new ConcurrentMapCache(GENERAL_TRANSACTION_PAGINATION_LIST),
				new ConcurrentMapCache(GENERAL_TRANSACTION_BY_ID), 
				
				new ConcurrentMapCache(HOME_INFO_LIST),
				new ConcurrentMapCache(HOME_INFO_PAGINATION_LIST),
				
				new ConcurrentMapCache(MEDICAL_OFFICE_LIST), 
				new ConcurrentMapCache(MEDICAL_OFFICE_PAGINATION_LIST),
				new ConcurrentMapCache(MEDICAL_OFFICE_BY_ID),
				
				
				new ConcurrentMapCache(MEDICAL_TRANSACTION_LIST),
				new ConcurrentMapCache(MEDICAL_TRANSACTION_PAGINATION_LIST),
				new ConcurrentMapCache(MEDICAL_TRANSACTION_BY_ID), 
				
				new ConcurrentMapCache(POST_LIST),
				new ConcurrentMapCache(POST_PAGINATION_LIST),
				new ConcurrentMapCache(POST_BY_ID),
				
				new ConcurrentMapCache(RESTAURANT_LIST),
				new ConcurrentMapCache(RESTAURANT_PAGINATION_LIST),
				new ConcurrentMapCache(RESTAURANT_BY_ID),
				
				new ConcurrentMapCache(RUN_LIST),
				new ConcurrentMapCache(RUN_PAGINATION_LIST),
				new ConcurrentMapCache(RUN_TRACKER_BY_ID), 
				
				new ConcurrentMapCache(SONG_LIST),
				new ConcurrentMapCache(SONG_PAGINATION_LIST),
				new ConcurrentMapCache(SONG_BY_ID),
				
				new ConcurrentMapCache(UTILITY_LIST),
				new ConcurrentMapCache(UTILITY_BY_ID), 
				
				new ConcurrentMapCache(USER_LIST), 
				new ConcurrentMapCache(USER_BY_ID),
				
				new ConcurrentMapCache(VEHICLE_LIST),
				new ConcurrentMapCache(VEHICLE_PAGINATION_LIST),
				new ConcurrentMapCache(VEHICLE_BY_ID)
				));

		return dsaCacheManager;
	}

	@Scheduled(fixedRate = 600)
	public void clearCacheSchedule() {
		for (String name:cacheManager.getCacheNames()) {
			cacheManager.getCache(name).clear();
		}
	}
}
