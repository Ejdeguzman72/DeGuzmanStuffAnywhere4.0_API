package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class MedicalTrxInfoDTO {

	public long medical_transaction_id;
	public double amount;
	public String medical_transaction_date;
	public String facilityName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String transaction_type_descr;
	public String name;

	public long getMedical_transaction_id() {
		return medical_transaction_id;
	}

	public void setMedical_transaction_id(long medical_transaction_id) {
		this.medical_transaction_id = medical_transaction_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMedical_transaction_date() {
		return medical_transaction_date;
	}

	public void setMedical_transaction_date(String medical_transaction_date) {
		this.medical_transaction_date = medical_transaction_date;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
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

	public String getTransaction_type_descr() {
		return transaction_type_descr;
	}

	public void setTransaction_type_descr(String transaction_type_descr) {
		this.transaction_type_descr = transaction_type_descr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((medical_transaction_date == null) ? 0 : medical_transaction_date.hashCode());
		result = prime * result + (int) (medical_transaction_id ^ (medical_transaction_id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((transaction_type_descr == null) ? 0 : transaction_type_descr.hashCode());
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
		MedicalTrxInfoDTO other = (MedicalTrxInfoDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (medical_transaction_date == null) {
			if (other.medical_transaction_date != null)
				return false;
		} else if (!medical_transaction_date.equals(other.medical_transaction_date))
			return false;
		if (medical_transaction_id != other.medical_transaction_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (transaction_type_descr == null) {
			if (other.transaction_type_descr != null)
				return false;
		} else if (!transaction_type_descr.equals(other.transaction_type_descr))
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
		return "MedicalTrxInfoDTO [medical_transaction_id=" + medical_transaction_id + ", amount=" + amount
				+ ", medical_transaction_date=" + medical_transaction_date + ", facilityName=" + facilityName
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", transaction_type_descr=" + transaction_type_descr + ", name=" + name + "]";
	}

	public MedicalTrxInfoDTO(long medical_transaction_id, double amount, String medical_transaction_date,
			String facilityName, String address, String city, String state, String zip, String transaction_type_descr,
			String name) {
		super();
		this.medical_transaction_id = medical_transaction_id;
		this.amount = amount;
		this.medical_transaction_date = medical_transaction_date;
		this.facilityName = facilityName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.transaction_type_descr = transaction_type_descr;
		this.name = name;
	}

	public MedicalTrxInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
