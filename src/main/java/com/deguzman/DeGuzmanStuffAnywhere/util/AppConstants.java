package com.deguzman.DeGuzmanStuffAnywhere.util;

import org.springframework.http.HttpStatus;

public class AppConstants {

	public static final HttpStatus HTTP_STATUS_OK = HttpStatus.OK;
	
	// Automotive transaction descr and msgs
	
	public static final String GET_AUTO_TRX_LIST_DESCR = "GET AUTO TRX LIST";
	
	public static final String GET_AUTO_TRX_LIST_MSG = "Retrieving all automotive transactions from database";
	
	public static String FIND_AUTO_TRX_BY_ID_DESCR = "FIND AUTO_TRX BY ID";
	
	public static String FIND_AUTO_TRX_BY_ID_MSG = "Searching automotive transactions with ID";
	
	public static String GET_AUTO_TRX_LIST_BY_VEHICLE_DESCR = "GET AUTO_TRX LIST BY VEHICLE";
	
	public static String GET_AUTO_TRX_LIST_BY_VEHICLE_MSG = "Retrieving all vehicle information from database by vehicle";
	
	public static String GET_AUTO_TRX_LIST_BY_USER_DESCR = "GET AUTO_TRX LIST BY CAR USER";
	
	public static String GET_AUTO_TRX_LIST_BY_USER_MSG = "Retrieving all vehicle information from database by user";
	
	public static String GET_AUTO_TRX_LIST_BY_TYPE_DESCR = "GET AUTO_TRX LIST BY TRANSACTION TYPE";
	
	public static String GET_AUTO_TRX_LIST_BY_TYPE_MSG = "Retrieving all vehicle information from database by transaction type";
	
	public static String ADD_AUTO_TRX_INFORMATION_DESCR = "ADD AUTO_TRX";
	
	public static String ADD_AUTO_TRX_INFORMATION_MSG = "Inserting new automotive transaction information";
	
	public static String GET_AUTO_TRX_COUNT_DESCR = "GET AUTO_TRX COUNT";
	
	public static String GET_AUTO_TRX_COUNT_MSG = "Retrieving the record count of all auto transaction information";
	
	public static String UPDATE_AUTO_TRX_INFORMATION_DESCR = "UPDATE AUTO_TRX";
	
	public static String UPDATE_AUTO_TRX_INFORMATION_MSG = "Updating automotive transaction information";
	
	public static String DELETE_AUTO_TRX_INFORMATION_DESCR = "DELETE AUTO_TRX";
	
	public static String DELETE_AUTO_TRX_INFORMATION_MSG = "Deleteing automotive transaction information by transactionId";
	
	public static String DELETE_ALL_AUTO_TRX_INFORMATION_DESCR = "DELETE ALL AUTO_TRX";
	
	public static String DELETE_ALL_AUTO_TRX_INFORMATION_MSG = "Deleteing all automotive transactions";
	
	// Auto Repair Shop description and msgs
	
	public static String GET_AUTOSHOP_LIST_DESCR = "GET AUTOSHOP LIST";
		
	public static String GET_AUTOSHOP_LIST_MSG = "Retrieving all automotive repair shops from database";
		
	public static String GET_AUTO_SHOP_BY_ID_DESCR = "GET AUTOSHOP BY ID";
		
	public static String GET_AUTO_SHOP_BY_ID_MSG = "Retrieving Automotive Repair Shop by ID Number";
		
	public static String GET_AUTO_SHOP_BY_NAME_DESCR = "GET AUTOSHOP BY Name";
		
	public static String GET_AUTO_SHOP_BY_NAME_MSG = "Retrieving Automotive Repair Shop by Name";
		
	public static String GET_AUTO_SHOP_BY_ZIP_DESCR = "GET AUTOSHOP BY Zip";
		
	public static String GET_AUTO_SHOP_BY_ZIP_MSG = "Retrieving Automotive Repair Shop by Zip";
		
	public static String GET_AUTO_SHOP_COUNT_DESCR = "GET AUTOSHOP COUNT";
	
	public static String GET_AUTO_SHOP_COUNT_MSG = "Retrieving count of automotive repair shops listed in the application";
		
	public static String ADD_AUTOSHOP_INFORMATION_DESCR = "ADD AUTOSHOP INFORMATION";
		
	public static String ADD_AUTOSHOP_INFORMATION_MSG = "Inserting new autmotive repair shop information";
		
	public static String UPDATE_AUTOSHOP_INFORMATION_DESCR = "UPDATE AUTOSHOP INFORMATION";
		
	public static String UPDATE_AUTOSHOP_INFORMATION_MSG = "Updating automotive repair shop information based on ID";
		
	public static String DELETE_AUTOSHOP_INFORMATION_DESCR = "DELETE AUTOSHOP INFORMATION";
		
	public static String DELETE_AUTSHOP_INFORMATION_MSG = "Deleteing automotive repair shop information by autoShopId";
		
	public static String DELETE_ALL_AUTOSHOP_INFORMATION_DESCR = "DELETE ALL AUTOSHOP INFORMATION";
		
	public static String DELETE_ALL_AUTOSHOP_INFORMATION_MSG = "Deleteing automotive repair shop information by autoShopId";
	 
	
	// Books descr and msgs
	
	public static String GET_BOOKS_LIST_DESCR = "GET BOOKS LIST";
	
	public static String GET_BOOKS_LIST_MSG = "Retrieving all books from database";
	
	public static String FIND_BOOK_BY_ID_DESCR = "FIND BOOK BY ID";
	
	public static String FIND_BOOK_BY_ID_MSG = "Searching book information with ID";
	
	public static String GET_BOOK_LIST_BY_AUTHOR_DESCR = "GET BOOK LIST BY AUTHOR";
	
	public static String GET_BOOK_LIST_BY_AUTHOR_MSG = "Retrieving all book information from database by author";
	
	public static String FIND_BOOK_BY_TITLE_DESCR = "FIND BOOK BY TITLE";
	
	public static String FIND_BOOK_BY_TITLE_MSG = "Searching book information by title";
	
	public static String ADD_BOOK_INFORMATION_DESCR = "ADD BOOK INFORMATION";
	
	public static String ADD_BOOK_INFORMATION_MSG = "Inserting new book information";
	
	public static String UPDATE_BOOK_INFORMATION_DESCR = "UPDATE BOOK INFO";
	
	public static String UPDATE_BOOK_INFORMATION_MSG = "Updating automotive transaction information";
	
	public static String DELETE_BOOK_INFORMATION_DESCR = "DELETE BOOK BY BOOKID";
	
	public static String DELETE_BOOK_INFORMATION_MSG = "Deleteing book information by bookId";
	
	public static String DELETE_ALL_BOOK_INFORMATION_DESCR = "DELETE ALL BOOK INFORMATION";
	
	public static String DELETE_ALL_BOOK_INFORMATION_MSG = "Deleteing all book information";
	
	
	// Contact Information descr and msgs
	
	public static String GET_CONTACT_LIST_DESCR = "GET CONTACT LIST";
	
	public static String GET_CONTACT_LIST_MSG = "Retrieving all contacts from database";
	
	public static String FIND_CONTACT_BY_ID_DESCR = "FIND CONTACT BY ID";
	
	public static String FIND_CONTACT_BY_ID_MSG = "Searching contact with ID";
	
	public static String FIND_CONTACT_BY_LASTNAME_DESCR = "FIND CONTACT BY ID";
	
	public static String FIND_CONTACT_BY_LASTNAME_MSG = "Searching contact with ID";
	
	public static String GET_CONTACT_BY_EMAIL_DESCR = "FIND CONTACT BY EMAIL";
	
	public static String GET_CONTACT_BY_EMAIL_MSG = "Searching contact with email";
	
	public static String GET_CONTACT_BY_PHONE_DESCR = "FIND CONTACT BY PHONE";
	
	public static String GET_CONTACT_BY_PHONE_MSG = "Searching contact with phone";
	
	public static String GET_CONTACT_COUNT_DESCR = "GET CONTACT COUNT";
	
	public static String GET_CONTACT_COUNT_MSG = "Retrieving the record count of all contact information";
	
	public static String ADD_CONTACT_INFORMATION_DESCR = "ADD CONTACT";
	
	public static String ADD_CONTACT_INFORMATION_MSG = "Inserting new contact information";
	
	public static String UPDATE_CONTACT_INFORMATION_DESCR = "UPDATE CONTACT";
	
	public static String UPDATE_CONTACT_INFORMATION_MSG = "Updating contact information";
	
	public static String DELETE_CONTACT_INFORMATION_DESCR = "DELETE CONTACT";
	
	public static String DELETE_CONTACT_INFORMATION_MSG = "Deleteing contact information by personId";
	
	public static String DELETE_ALL_CONTACT_INFORMATION_DESCR = "DELETE CONTACT";
	
	public static String DELETE_ALL_CONTACT_INFORMATION_MSG = "Deleteing contact information by personId";
	
	
	// Exercise Information description and messages
	
	public static String GET_EXERCISE_LIST_DESCR = "GET EXERCISE LIST";
	
	public static String GET_EXERCISE_LIST_MSG = "Retrieving all exercise information from database";
	
	public static String GET_EXERCISE_BY_ID_DESCR = "GET EXERCISE LIST";
	
	public static String GET_EXERCISE_BY_ID_MSG = "Retrieving all exercise information from database";
	
	public static String GET_EXERCISE_LIST_BY_USER_DESCR = "GET EXERCISE LIST BY USER";
	
	public static String GET_EXERCISE_LIST_BY_USER_MSG = "Retrieving all exercise information from database by user";
	
	public static String GET_EXERCISE_LIST_BY_TYPE_DESCR = "GET EXERCISE LIST BY TRANSACTION TYPE";
	
	public static String GET_EXERCISE_LIST_BY_TYPE_MSG = "Retrieving all exercise information from database by transaction type";
	
	public static String ADD_EXERCISE_INFORMATION_DESCR = "ADD EXERCISE INFORMATION";
	
	public static String ADD_EXERCISE_INFORMATION_MSG = "Inserting new exercise information";
	
	public static String UPDATE_EXERCISE_INFORMATION_DESCR = "UPDATE EXERCISE INFORMATION";
	
	public static String UPDATE_EXERCISE_INFORMATION_MSG = "Updating exercise information based on ID";
	
	public static String DELETE_EXERCISE_INFORMATION_DESCR = "DELETE EXERCISE INFORMATION";
	
	public static String DELETE_EXERCISE_INFORMATION_MSG = "Deleting exercise information based on ID";
	
	public static String DELETE_ALL_EXERCISE_INFORMATION_DESCR = "DELETE ALL EXERCISE INFORMATION";
	
	public static String DELETE_ALL_EXERCISE_INFORMATION_MSG = "Deleting all exercise information based on ID";
	
	// General Transactions descriptions and messages
	
	public static final String GET_GENERAL_TRX_LIST_DESCR = "GET GENERAL_TRX LIST";
	
	public static final String GET_GENERAL_TRX_LIST_MSG = "Retrieving all general transactions from database";
	
	public static String FIND_GENERAL_TRX_BY_ID_DESCR = "FIND GENERAL_TRX BY ID";
	
	public static String FIND_GENERAL_TRX_BY_ID_MSG = "Searching general transactions with ID";
	
	public static String GET_GENERAL_TRX_LIST_BY_USER_DESCR = "GET GENERAL_TRX LIST BY CAR USER";
	
	public static String GET_GENERAL_TRX_LIST_BY_USER_MSG = "Retrieving all general transaction information from database by user";
	
	public static String GET_GENERAL_TRX_LIST_BY_TYPE_DESCR = "GET GENERAL_TRX LIST BY TRANSACTION TYPE";
	
	public static String GET_GENERAL_TRX_LIST_BY_TYPE_MSG = "Retrieving all general transaction information from database by transaction type";
	
	public static String ADD_GENERAL_TRX_INFORMATION_DESCR = "ADD GENERAL_TRX";
	
	public static String ADD_GENERAL_TRX_INFORMATION_MSG = "Inserting new general transaction information";
	
	public static String GET_GENERAL_TRX_COUNT_DESCR = "GET GENERAL_TRX COUNT";
	
	public static String GET_GENERAL_TRX_COUNT_MSG = "Retrieving the record count of all general transaction information";
	
	public static String UPDATE_GENERAL_TRX_INFORMATION_DESCR = "UPDATE GENERAL_TRX";
	
	public static String UPDATE_GENERAL_TRX_INFORMATION_MSG = "Updating general transaction information";
	
	public static String DELETE_GENERAL_TRX_INFORMATION_DESCR = "DELETE GENERAL_TRX";
	
	public static String DELETE_GENERAL_TRX_INFORMATION_MSG = "Deleteing general transaction information by transactionId";
	
	public static String DELETE_ALL_GENERAL_TRX_INFORMATION_DESCR = "DELETE ALL GENERAL_TRX";
	
	public static String DELETE_ALL_GENERAL_TRX_INFORMATION_MSG = "Deleteing all general transactions";
	
	// Medical Office description and msgs
	
	public static String GET_MEDICAL_OFFICE_LIST_DESCR = "GET MEDICAL OFFICE LIST";
			
	public static String GET_MEDICAL_OFFICE_LIST_MSG = "Retrieving all medical offices from database";
			
	public static String GET_MEDICAL_OFFICE_BY_ID_DESCR = "GET AUTOSHOP BY ID";
			
	public static String GET_MEDICAL_OFFICE_BY_ID_MSG = "Retrieving Automotive Repair Shop by ID Number";
			
	public static String GET_MEDICAL_OFFICE_BY_NAME_DESCR = "GET AUTOSHOP BY Name";
			
	public static String GET_MEDICAL_OFFICE_BY_NAME_MSG = "Retrieving Automotive Repair Shop by Name";
			
	public static String GET_MEDICAL_OFFICE_BY_ZIP_DESCR = "GET AUTOSHOP BY Zip";
			
	public static String GET_MEDICAL_OFFICE_BY_ZIP_MSG = "Retrieving Automotive Repair Shop by Zip";
			
	public static String GET_MEDICAL_OFFICE_COUNT_DESCR = "GET AUTOSHOP COUNT";
		
	public static String GET_MEDICAL_OFFICE_COUNT_MSG = "Retrieving count of automotive repair shops listed in the application";
			
	public static String ADD_MEDICAL_OFFICE_INFORMATION_DESCR = "ADD AUTOSHOP INFORMATION";
			
	public static String ADD_MEDICAL_OFFICE_INFORMATION_MSG = "Inserting new autmotive repair shop information";
			
	public static String UPDATE_MEDICAL_OFFICE_INFORMATION_DESCR = "UPDATE AUTOSHOP INFORMATION";
			
	public static String UPDATE_MEDICAL_OFFICE_INFORMATION_MSG = "Updating automotive repair shop information based on ID";
			
	public static String DELETE_MEDICAL_OFFICE_INFORMATION_DESCR = "DELETE AUTOSHOP INFORMATION";
			
	public static String DELETE_MEDICAL_OFFICE_INFORMATION_MSG = "Deleteing automotive repair shop information by autoShopId";
			
	public static String DELETE_ALL_MEDICAL_OFFICE_INFORMATION_DESCR = "DELETE ALL AUTOSHOP INFORMATION";
			
	public static String DELETE_ALL_MEDICAL_OFFICE_INFORMATION_MSG = "Deleteing automotive repair shop information by autoShopId";
	
	
	// Medical Trx Descriptions and Messages
	public static final String GET_MEDICAL_TRX_LIST_DESCR = "GET MEDICAL_TRX LIST";
	
	public static final String GET_MEDICAL_TRX_LIST_MSG = "Retrieving all medical transactions from database";
	
	public static String FIND_MEDICAL_TRX_BY_ID_DESCR = "FIND MEDICAL_TRX BY ID";
	
	public static String FIND_MEDICAL_TRX_BY_ID_MSG = "Searching medical transactions with ID";
	
	public static String GET_MEDICAL_TRX_LIST_BY_USER_DESCR = "GET MEDICAL_TRX LIST BY CAR USER";
	
	public static String GET_MEDICAL_TRX_LIST_BY_USER_MSG = "Retrieving all medical transaction information from database by user";
	
	public static String GET_MEDICAL_TRX_LIST_BY_TYPE_DESCR = "GET MEDICAL_TRX LIST BY TRANSACTION TYPE";
	
	public static String GET_MEDICAL_TRX_LIST_BY_TYPE_MSG = "Retrieving all medical transaction information from database by transaction type";
	
	public static String ADD_MEDICAL_TRX_INFORMATION_DESCR = "ADD MEDICAL_TRX";
	
	public static String ADD_MEDICAL_TRX_INFORMATION_MSG = "Inserting new medical transaction information";
	
	public static String GET_MEDICAL_TRX_COUNT_DESCR = "GET MEDICAL_TRX COUNT";
	
	public static String GET_MEDICAL_TRX_COUNT_MSG = "Retrieving the record count of all medical transaction information";
	
	public static String UPDATE_MEDICAL_TRX_INFORMATION_DESCR = "UPDATE MEDICAL_TRX";
	
	public static String UPDATE_MEDICAL_TRX_INFORMATION_MSG = "Updating medical transaction information";
	
	public static String DELETE_MEDICAL_TRX_INFORMATION_DESCR = "DELETE MEDICAL_TRX";
	
	public static String DELETE_MEDICAL_TRX_INFORMATION_MSG = "Deleteing medical transaction information by transactionId";
	
	public static String DELETE_ALL_MEDICAL_TRX_INFORMATION_DESCR = "DELETE ALL MEDICAL_TRX";
	
	public static String DELETE_ALL_MEDICAL_TRX_INFORMATION_MSG = "Deleteing all medical transactions";
	
	
	// Vehicle description and msgs
	
	public static String GET_VEHICLE_LIST_DESCR = "GET VEHICLE LIST";
	
	public static String GET_VEHICLE_LIST_MSG = "Retrieving all vehicle information from database";
	
	public static String GET_VEHICLE_BY_ID_DESCR = "GET VEHICLE LIST";
	
	public static String GET_VEHICLE_BY_ID_MSG = "Retrieving all vehicle information from database";
	
	public static String GET_VEHICLE_LIST_BY_MAKE_DESCR = "GET VEHICLE LIST BY MANUFACTURER";
	
	public static String GET_VEHICLE_LIST_BY_MAKE_MSG = "Retrieving all vehicle information from database by manufacturer";
	
	public static String GET_VEHICLE_LIST_BY_MODEL_DESCR = "GET VEHICLE LIST BY CAR MODEL";
	
	public static String GET_VEHICLE_LIST_BY_MODEL_MSG = "Retrieving all vehicle information from database by car model";
	
	public static String GET_VEHICLE_LIST_BY_YEAR_DESCR = "GET VEHICLE LIST BY CAR YEAR";
	
	public static String GET_VEHICLE_LIST_BY_YEAR_MSG = "Retrieving all vehicle information from database by car year";
	
	public static String GET_VEHICLE_LIST_BY_TRANSMISSION_DESCR = "GET VEHICLE LIST BY CAR TRANSMISSION";
	
	public static String GET_VEHICLE_LIST_BY_TRANSMISSION_MSG = "Retrieving all vehicle information from database by car transmission";
	
	public static String ADD_VEHICLE_INFORMATION_DESCR = "ADD VEHICLE INFORMATION";
	
	public static String ADD_VEHICLE_INFORMATION_MSG = "Inserting new vehicle information";
	
	public static String UPDATE_VEHICLE_INFORMATION_DESCR = "UPDATE VEHICLE INFORMATION";
	
	public static String UPDATE_VEHICLE_INFORMATION_MSG = "Updating vehicle information based on ID";
	
	public static String DELETE_VEHICLE_INFORMATION_DESCR = "DELETE VEHICLE INFORMATION";
	
	public static String DELETE_VEHICLE_INFORMATION_MSG = "Deleting vehicle information based on ID";
	
	public static String DELETE_ALL_VEHICLE_INFORMATION_DESCR = "DELETE ALL VEHICLE INFORMATION";
	
	public static String DELETE_ALL_VEHICLE_INFORMATION_MSG = "Deleting all vehicle information based on ID";
	
	// Restaurant descriptions and msgs
	
	public static String GET_RESTAURANT_LIST_DESCR = "GET RESTAURANT LIST";
	
	public static String GET_RESTAURANT_LIST_MSG = "Retrieving all restaurant information from database";
	
	public static String GET_RESTAURANT_BY_ID_DESCR = "GET RESTAURANT BY ID";
	
	public static String GET_RESTAURANT_BY_ID_MSG = "Retrieving all restaurant information from database based off restaurantId";
	
	public static String GET_RESTAURANT_LIST_BY_NAME_DESCR = "GET RESTAURANT BY NAME";
	
	public static String GET_RESTAURANT_LIST_BY_NAME_MSG = "Retrieving restaurant information from database by name";
	
	public static String GET_RESTAURANT_LIST_BY_ZIP_DESCR = "GET RESTAURANT LIST BY ZIP";
	
	public static String GET_RESTAURANT_LIST_BY_ZIP_MSG = "Retrieving restaurant information from database by zip";
	
	public static String GET_RESTAURANT_LIST_BY_TYPE_DESCR = "GET RESTAURANT LIST BY TYPE";
	
	public static String GET_RESTAURANT_LIST_BY_TYPE_MSG = "Retrieving restaurant information from database by type";
	
	public static String ADD_RESTAURANT_INFORMATION_DESCR = "ADD RESTAURANT INFORMATION";
	
	public static String ADD_RESTAURANT_INFORMATION_MSG = "Inserting new restaurant information";
	
	public static String UPDATE_UPDATE_INFORMATION_DESCR = "UPDATE RESTAURANT INFORMATION";
	
	public static String UPDATE_UPDATE_INFORMATION_MSG = "Updating restaurant information based on ID";
	
	public static String DELETE_RESTAURANT_INFORMATION_DESCR = "DELETE RESTAURANT INFORMATION";
	
	public static String DELETE_RESTAURANT_INFORMATION_MSG = "Deleting restaurant information based on ID";
	
	public static String DELETE_ALL_RESTAURANT_INFORMATION_DESCR = "DELETE ALL RESTAURANT INFORMATION";
	
	public static String DELETE_ALL_RESTAURANT_INFORMATION_MSG = "Deleting all restaurant information based on ID";
	
	// Social Media descr and msgs
	
	public static String GET_SOCIAL_MEDIA_LIST_DESCR = "GET SOCIAL_MEDIA LIST";
		
	public static String GET_SOCIAL_MEDIA_LIST_MSG = "Retrieving all social media posts from database";
		
	public static String FIND_SOCIAL_MEDIA_BY_ID_DESCR = "FIND SOCIAL_MEDIA BY USER";
		
	public static String FIND_SOCIAL_MEDIA_BY_ID_MSG = "Searching social media information with user ID";
		
	public static String ADD_SOCIAL_MEDIA_INFORMATION_DESCR = "ADD SOCIAL_MEDIA INFORMATION";
		
	public static String ADD_SOCIAL_MEDIA_INFORMATION_MSG = "Inserting new social media information";
		
	public static String DELETE_SOCIAL_MEDIA_INFORMATION_DESCR = "DELETE SOCIAL_MEDIA BY BOOKID";
		
	public static String DELETE_SOCIAL_MEDIA_INFORMATION_MSG = "Deleteing social media information by bookId";
	
	// Music Information Library messages and description 
	
	public static String GET_MUSIC_LIST_DESCR = "GET MUSIC LIST";
	
	public static String GET_MUSIC_LIST_MSG = "Retrieving all music information from database";
	
	public static String GET_MUSIC_BY_ID_DESCR = "GET MUSIC BY ID";
	
	public static String GET_MUSIC_BY_ID_MSG = "Retrieving all music information from database based off restaurantId";
	
	public static String GET_MUSIC_BY_GENRE_DESCR = "GET MUSIC BY GENRE";
	
	public static String GET_MUSIC_BY_GENRE_MSG = "Retrieving all music information from database based off genre";
	
	public static String GET_MUSIC_LIST_BY_TITLE_DESCR = "GET MUSIC BY TITLE";
	
	public static String GET_MUSIC_LIST_BY_TITLE_MSG = "Retrieving music information from database by title";
	
	public static String GET_MUSIC_LIST_BY_ARTIST_DESCR = "GET MUSIC LIST BY ARTIST";
	
	public static String GET_MUSIC_LIST_BY_ARTIST_MSG = "Retrieving music information from database by artist";
	
	public static String ADD_MUSIC_INFORMATION_DESCR = "ADD MUSIC INFORMATION";
	
	public static String ADD_MUSIC_INFORMATION_MSG = "Inserting new music information";
	
	public static String UPDATE_MUSIC_INFORMATION_DESCR = "UPDATE MUSIC INFORMATION";
	
	public static String UPDATE_MUSIC_INFORMATION_MSG = "Updating music information based on ID";
	
	public static String DELETE_MUSIC_INFORMATION_DESCR = "DELETE MUSIC INFORMATION";
	
	public static String DELETE_MUSIC_INFORMATION_MSG = "Deleting music information based on ID";
	
	public static String DELETE_ALL_MUSIC_INFORMATION_DESCR = "DELETE ALL MUSIC INFORMATION";
	
	public static String DELETE_ALL_MUSIC_INFORMATION_MSG = "Deleting all music information based on ID";
	
	// Utility Information MSG and Descr
	
	public static String GET_UTILITY_LIST_DESCR = "GET UTILITY LIST";
	
	public static String GET_UTILITY_LIST_MSG = "Retrieving all utility information from database";
	
	public static String GET_UTILITY_BY_ID_DESCR = "GET UTILITY BY ID";
	
	public static String GET_UTILITY_BY_ID_MSG = "Retrieving all utility information from database based off restaurantId";
	
	public static String GET_UTILITY_BY_DUE_DATE_DESCR = "GET UTILITY BY DUE DATE";
	
	public static String GET_UTILITY_BY_DUE_DATE_MSG = "Retrieving all UTILITY information from database based off due date";
	
	public static String GET_UTILITY_LIST_BY_TYPE_DESCR = "GET UTILITY BY TYPE";
	
	public static String GET_UTILITY_LIST_BY_TYPE_MSG = "Retrieving utility information from database by type";
	
	public static String GET_UTILITY_LIST_BY_NAME_DESCR = "GET MUSIC LIST BY ARTIST";
	
	public static String GET_UTILITY_LIST_BY_NAME_MSG = "Retrieving music information from database by artist";
	
	public static String ADD_UTILITY_INFORMATION_DESCR = "ADD UTILITY INFORMATION";
	
	public static String ADD_UTILITY_INFORMATION_MSG = "Inserting new utility information";
	
	public static String UPDATE_UTILITY_INFORMATION_DESCR = "UPDATE UTILITY INFORMATION";
	
	public static String UPDATE_UTILITY_INFORMATION_MSG = "Updating utility information based on ID";
	
	public static String DELETE_UTILITY_INFORMATION_DESCR = "DELETE UTILITY INFORMATION";
	
	public static String DELETE_UTILITY_INFORMATION_MSG = "Deleting utility information based on ID";
	
	public static String DELETE_ALL_UTILITY_INFORMATION_DESCR = "DELETE ALL UTILITY INFORMATION";
	
	public static String DELETE_ALL_UTILITY_INFORMATION_MSG = "Deleting all utility information based on ID";
}
