package com.deguzman.DeGuzmanStuffAnywhere.util;

public class UriConstants {

	// Automotive Transactions URI endpoints
	public static final String URI_GET_AUTO_TRX_LIST = "/app/auto-transactions/all";
	public static final String URI_GET_AUTO_TRX_LIST_PAGINATION = "/app/auto-transactions/all-transactions";
	public static final String URI_GET_AUTO_TRX_BY_ID = "/app/auto-transactions/search/auto-transaction";
	public static final String URI_GET_AUTO_TRX_DTO_BY_ID = "/app/auto-transactions/search/auto-transaction-dto";
	public static final String URI_GET_AUTO_TRX_BY_VEHICLE = "/app/auto-transactions/auto-transaction/search/vehicle";
	public static final String URI_GET_AUTO_TRX_BY_USER = "/app/auto-transactions/auto-transaction/search/user";
	public static final String URI_GET_AUTO_TRX_BY_TYPE = "/app/auto-transactions/auto-transaction/search/type";
	public static final String URI_GET_AUTO_TRX_COUNT = "/app/auto-transactions/auto-transaction/count";
	public static final String URI_ADD_AUTO_TRX_INFORMATION = "/app/auto-transactions/add-auto-transaction-information";
	public static final String URI_UPDATE_AUTO_TRX_INFORMATION = "/app/auto-transactions/auto-transaction";
	public static final String URI_DELETE_AUTO_TRX_INFORMATION = "/app/auto-transactions/auto-transaction";
	public static final String URI_DELETE_ALL_AUTO_TRX_INFORMATION = "/app/auto-transactions/delete-all";

	// Auto Repair Shop URI Endpoints
	public static final String URI_GET_AUTOSHOP_LIST = "/app/auto-repair-shops/all";
	public static final String URI_GET_AUTOSHOP_LIST_PAGINATION = "/app/auto-repair-shops/all-shops";
	public static final String URI_GET_AUTOSHOP_BY_ID = "/app/auto-repair-shops/search/repair-shop";
	public static final String URI_GET_AUTOSHOP_BY_NAME = "/app/auto-repair-shops/repair-shop/search/name";
	public static final String URI_GET_AUTOSHOP_BY_ZIP = "/app/auto-repair-shops/repair-shop/search/zip";
	public static final String URI_GET_AUTOSHOP_COUNT = "/app/auto-repair-shops/repair-shop/count";
	public static final String URI_ADD_AUTOSHOP_INFORMATION = "/app/auto-repair-shops/add-auto-shop";
	public static final String URI_UPDATE_AUTOSHOP_INFORMATION = "/app/auto-repair-shops/repair-shop";
	public static final String URI_DELETE_ALL_AUTOSHOP_INFORMATION = "/app/auto-repair-shops/repair-shop";
	public static final String URI_DELETE_AUTOSHOP_INFORMATION = "/app/auto-repair-shops/delete-all";
	
	// Books Information URI endpoints 
	public static final String URI_GET_BOOKS_LIST = "/app/books/all";
	public static final String URI_GET_BOOKS_LIST_PAGINATION = "/app/books/all-books";
	public static final String URI_GET_BOOKS_BY_ID = "/app/books/book";
	public static final String URI_GET_BOOKS_BY_TITLE = "/app/books/book/search/title";
	public static final String URI_GET_BOOKS_BY_AUTHOR = "/app/books/book/search/author";
	public static final String URI_ADD_BOOKS_INFORMATION = "/app/books/add-book-information";
	public static final String URI_UPDATE_BOOKS_INFORMATION = "/app/books/book";
	public static final String URI_DELETE_BOOKS_INFORMATION = "/app/books/book";
	public static final String URI_DELETE_ALL_BOOKS_INFORMATION = "/app/books/delete-all";

	// URI Contact endpoints
	public static final String URI_GET_CONTACT_LIST = "/app/person-info/all";
	public static final String URI_GET_CONTACT_LIST_PAGINATION = "app/person-info/all-contacts";
	public static final String URI_GET_CONTACT_BY_ID = "/app/person-info/person";
	public static final String URI_GET_CONTACT_BY_LASTNAME = "/app/person-info/person/lastname";
	public static final String URI_GET_CONTACT_BY_PHONE = "/app/person-info/person/phone";
	public static final String URI_GET_CONTACT_BY_EMAIL = "/app/person-info/person/email";
	public static final String URI_GET_CONTACT_COUNT = "/app/person-info/count";
	public static final String URI_ADD_CONTACT_INFORMATION = "/app/person-info/add-person-information";
	public static final String URI_UPDATE_CONTACT_INFORMATION = "/app/person-info/person";
	public static final String URI_DELETE_ALL_CONTACT_INFORMATION = "/app/person-info/delete-all";
	public static final String URI_DELETE_CONTACT_INFORMATION = "/app/person-info/person";
	
	// URI Exercise endpoints
	public static final String URI_GET_EXERCISE_LIST = "/app/gym-tracker/all";
	public static final String URI_GET_EXERCISE_LIST_PAGINATION = "/app/gym-tracker/all-exercises";
	public static final String URI_GET_EXERCISE_BY_ID = "/app/gym-tracker/search/exercise";
	public static final String URI_GET_EXERCISE_DTO_BY_ID = "/app/gym-tracker/search/exercise-dto";
	public static final String URI_GET_EXERCISE_BY_USER = "/app/gym-tracker/exercise/search/user";
	public static final String URI_GET_EXERCISE_BY_TYPE = "/app/gym-tracker/exercise/search/type";
	public static final String URI_GET_EXERCISE_COUNT = "/app/gym-tracker/exercise/count";
	public static final String URI_ADD_EXERCISE_INFORMATION = "/app/gym-tracker/add-exercise-information";
	public static final String URI_UPDATE_EXERCISE_INFORMATION = "/app/gym-tracker/search/exercise";
	public static final String URI_DELETE_EXERCISE_INFORMATION = "/app/gym-tracker/search/exercise";
	public static final String URI_DELETE_ALL_EXERCISE_INFORMATION = "/app/gym-tracker/exercise/delete-all";
	
	// General Transactions URI endpoints
	public static final String URI_GET_GENERAL_TRX_LIST = "/app/general-transactions/all";
	public static final String URI_GET_GENERAL_TRX_LIST_PAGINATION = "/app/general-transactions/all-transactions";
	public static final String URI_GET_GENERAL_TRX_BY_ID = "/app/general-transactions/search/general-transaction";
	public static final String URI_GET_GENERAL_TRX_DTO_BY_ID = "/app/general-transactions/search/general-transaction-dto";
	public static final String URI_GET_GENERAL_TRX_BY_USER = "/app/general-transactions/general-transaction/search/user";
	public static final String URI_GET_GENERAL_TRX_BY_TYPE = "/app/general-transactions/general-transaction/search/type";
	public static final String URI_GET_GENERAL_TRX_COUNT = "/app/general-transactions/general-transaction/count";
	public static final String URI_ADD_GENERAL_TRX_INFORMATION = "/app/general-transactions/add-general-transaction-information";
	public static final String URI_UPDATE_GENERAL_TRX_INFORMATION = "/app/general-transactions/general-transaction";
	public static final String URI_DELETE_GENERAL_TRX_INFORMATION = "/app/general-transactions/general-transaction";
	public static final String URI_DELETE_ALL_GENERAL_TRX_INFORMATION = "/app/general-transactions/delete-all";

	// URI Vehicle Endpoints
	public static final String URI_GET_VEHICLE_LIST = "/app/vehicles/all";
	public static final String URI_GET_VEHICEL_LIST_PAGINATION = "/app/vehicles/all-vehicles";
	public static final String URI_GET_VEHICLE_BY_ID = "/app/vehicles/search/vehicle";
	public static final String URI_GET_VEHICLE_BY_YEAR = "/app/vehicles/vehicle/search/year";
	public static final String URI_GET_VEHICLE_BY_MAKE = "/app/vehicles/vehicle/search/make";
	public static final String URI_GET_VEHICLE_BY_MODEL = "/app/vehicles/vehicle/search/model";
	public static final String URI_GET_VEHICLE_BY_TRANSMISSION = "/app/vehicles/vehicle/search/transmission";
	public static final String URI_GET_VEHICLE_COUNT = "/app/vehicles/vehicle/count";
	public static final String URI_ADD_VEHICLE_INFORMATION = "/app/vehicles/add-vehicle-information";
	public static final String URI_UPDATE_VEHICLE_INFORMATION = "/app/vehicles/vehicle";
	public static final String URI_DELETE_ALL_VEHICLE_INFORMATION = "/app/vehicles/vehicle";
	public static final String URI_DELETE_VEHICLE_INFORMATION = "/app/vehicles/delete-all-vehicles";
	
	// Medical Office URI Endpoints
	public static final String URI_GET_MEDICAL_OFFICE_LIST = "/app/medical-offices/all";
	public static final String URI_GET_MEDICAL_OFFICE_LIST_PAGINATION = "/app/medical-offices/all-medical-offices";
	public static final String URI_GET_MEDICAL_OFFICE_BY_ID = "/app/medical-offices/search/medical-office";
	public static final String URI_GET_MEDICAL_OFFICE_BY_NAME = "/app/medical-offices/medical-office/search/name";
	public static final String URI_GET_MEDICAL_OFFICE_BY_ZIP = "/app/medical-offices/medical-office/search/zip";
	public static final String URI_GET_MEDICAL_OFFICE_COUNT = "/app/medical-offices/medical-office/count";
	public static final String URI_ADD_MEDICAL_OFFICE_INFORMATION = "/app/medical-offices/add-medical-office";
	public static final String URI_UPDATE_MEDICAL_OFFICE_INFORMATION = "/app/medical-offices/medical-office";
	public static final String URI_DELETE_ALL_MEDICAL_OFFICE_INFORMATION = "/app/medical-offices/medical-office";
	public static final String URI_DELETE_MEDICAL_OFFICE_INFORMATION = "/app/medical-offices/delete-all";

	// URI Restaurant Endpoints
	public static final String URI_GET_RESTAURANT_LIST = "/app/restaurants/all";
	public static final String URI_GET_RESTAURANT_LIST_PAGINATION = "/app/restaurants/all-restaurants";
	public static final String URI_GET_RESTAURANT_BY_ID = "/app/restaurants/restaurant";
	public static final String URI_GET_RESTAURANT_INFO_DTO_BY_ID = "/app/restaurants/restaurant-dto";
	public static final String URI_GET_RESTAURANT_BY_ZIP = "/app/restaurants/restaurant/search/zip";
	public static final String URI_GET_RESTAURANT_BY_NAME = "/app/restaurants/restaurant/search/name";
	public static final String URI_GET_RESTAURANT_BY_DESCR = "/app/restaurants/restaurant/descr";
	public static final String URI_GET_VEHICLE_BY_TYPE = "/app/restaurants/restaurant/search/type";
	public static final String URI_GET_RESTAURANT_COUNT = "/app/restaurants/restaurant/count";
	public static final String URI_ADD_RESTAURANT_INFORMATION = "/app/restaurants/add-restaurant-information";
	public static final String URI_UPDATE_RESTAURANT_INFORMATION = "/app/restaurants/restaurant";
	public static final String URI_DELETE_ALL_RESTAURANT_INFORMATION = "/app/restaurants/restaurant";
	public static final String URI_DELETE_RESTAURANT_INFORMATION = "/app/restaurants/delete-all-restaurants";
}
