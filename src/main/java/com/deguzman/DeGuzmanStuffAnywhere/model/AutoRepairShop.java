package com.deguzman.DeGuzmanStuffAnywhere.model;

import java.io.Serializable;


public class AutoRepairShop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7246009274943519322L;
	public int autoshopId;
	public String autoShopName;
	public String address;
	public String city;
	public String zip;
	public String state;
	
	public int getAutoshopId() {
		return autoshopId;
	}
	public void setAutoshopId(int autoshopId) {
		this.autoshopId = autoshopId;
	}
	
	public String getAutoShopName() {
		return autoShopName;
	}
	public void setAutoShopName(String autoShopName) {
		this.autoShopName = autoShopName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((autoShopName == null) ? 0 : autoShopName.hashCode());
		result = prime * result + autoshopId;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoRepairShop other = (AutoRepairShop) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (autoShopName == null) {
			if (other.autoShopName != null)
				return false;
		} else if (!autoShopName.equals(other.autoShopName))
			return false;
		if (autoshopId != other.autoshopId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutoRepairShop [autoshopId=" + autoshopId + ", autoShopName=" + autoShopName + ", address=" + address
				+ ", city=" + city + ", zip=" + zip + ", state=" + state + "]";
	}
	public AutoRepairShop(int autoshopId, String autoShopName, String address, String city, String zip, String state) {
		super();
		this.autoshopId = autoshopId;
		this.autoShopName = autoShopName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
	}
	public AutoRepairShop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
