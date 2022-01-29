package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class PostRestaurantDTO {

	public int restaurant_id;
	public String name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public int restaurant_type_id;

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getRestaurant_type_id() {
		return restaurant_type_id;
	}

	public void setRestaurant_type_id(int restaurant_type_id) {
		this.restaurant_type_id = restaurant_type_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + restaurant_id;
		result = prime * result + restaurant_type_id;
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
		PostRestaurantDTO other = (PostRestaurantDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (restaurant_id != other.restaurant_id)
			return false;
		if (restaurant_type_id != other.restaurant_type_id)
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
		return "PostRestaurantDTO [restaurant_id=" + restaurant_id + ", name=" + name + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", restaurant_type_id=" + restaurant_type_id
				+ "]";
	}

	public PostRestaurantDTO(int restaurant_id, String name, String address, String city, String state, String zip,
			int restaurant_type_id) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.restaurant_type_id = restaurant_type_id;
	}

	public PostRestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
