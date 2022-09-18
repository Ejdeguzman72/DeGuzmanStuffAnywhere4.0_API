package com.deguzman.DeGuzmanStuffAnywhere.util;

public class UriConstants {
	
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
	public static final String URI_GET_VEHICLE_BY_YEAR = "/app/auto-repair-shops/repair-shop/search/name";
	public static final String URI_GET_VEHICLE_BY_MAKE = "/app/auto-repair-shops/repair-shop/search/zip";
	public static final String URI_GET_VEHICLE_BY_MODEL = "/app/auto-repair-shops/repair-shop/search/zip";
	public static final String URI_GET_VEHICLE_BY_TRANSMISSION = "/app/auto-repair-shops/repair-shop/search/zip";
	public static final String URI_GET_VEHICLE_COUNT = "/app/auto-repair-shops/repair-shop/count";
	public static final String URI_ADD_VEHICLE_INFORMATION = "/app/vehicles/add-vehicle-information";
	public static final String URI_UPDATE_VEHICLE_INFORMATION = "/app/vehicles/vehicle";
	public static final String URI_DELETE_ALL_VEHICLE_INFORMATION = "/app/vehicles/vehicle";
	public static final String URI_DELETE_VEHICLE_INFORMATION = "/app/vehicles/delete-all-vehicles";
}
