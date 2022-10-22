package com.deguzman.DeGuzmanStuffAnywhere.util;

public class UriConstants {

	// Automotive Transactions URI endpoints
	public static final String URI_GET_AUTO_TRX_LIST = "/app/auto-transactions/all";
	public static final String URI_GET_AUTO_TRX_LIST_PAGINATION = "/app/auto-transactions/all-transactions";
	public static final String URI_GET_AUTO_TRX_BY_ID = "/app/auto-transactions/search/auto-transaction";
	public static final String URI_GET_AUTO_TRX_DTO_BY_ID = "/app/auto-transactions/searchsdfsdf/auto-transaction-dto";
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
