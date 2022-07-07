package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class AutoTrxInfoDTO {

	public long auto_transaction_id;
	public double amount;
	public String auto_transaction_date;
	public String make;
	public String model;
	public String year;
	public String auto_shop_name;
	public String username;
	public String transaction_type_descr;
	public long getAuto_transaction_id() {
		return auto_transaction_id;
	}
	public void setAuto_transaction_id(long auto_transaction_id) {
		this.auto_transaction_id = auto_transaction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAuto_transaction_date() {
		return auto_transaction_date;
	}
	public void setAuto_transaction_date(String auto_transaction_date) {
		this.auto_transaction_date = auto_transaction_date;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAuto_shop_name() {
		return auto_shop_name;
	}
	public void setAuto_shop_name(String auto_shop_name) {
		this.auto_shop_name = auto_shop_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTransaction_type_descr() {
		return transaction_type_descr;
	}
	public void setTransaction_type_descr(String transaction_type_descr) {
		this.transaction_type_descr = transaction_type_descr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((auto_shop_name == null) ? 0 : auto_shop_name.hashCode());
		result = prime * result + ((auto_transaction_date == null) ? 0 : auto_transaction_date.hashCode());
		result = prime * result + (int) (auto_transaction_id ^ (auto_transaction_id >>> 32));
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((transaction_type_descr == null) ? 0 : transaction_type_descr.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		AutoTrxInfoDTO other = (AutoTrxInfoDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (auto_shop_name == null) {
			if (other.auto_shop_name != null)
				return false;
		} else if (!auto_shop_name.equals(other.auto_shop_name))
			return false;
		if (auto_transaction_date == null) {
			if (other.auto_transaction_date != null)
				return false;
		} else if (!auto_transaction_date.equals(other.auto_transaction_date))
			return false;
		if (auto_transaction_id != other.auto_transaction_id)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (transaction_type_descr == null) {
			if (other.transaction_type_descr != null)
				return false;
		} else if (!transaction_type_descr.equals(other.transaction_type_descr))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutoTrxInfoDTO [auto_transaction_id=" + auto_transaction_id + ", amount=" + amount
				+ ", auto_transaction_date=" + auto_transaction_date + ", make=" + make + ", model=" + model + ", year="
				+ year + ", auto_shop_name=" + auto_shop_name + ", username=" + username + ", transaction_type_descr="
				+ transaction_type_descr + "]";
	}
	public AutoTrxInfoDTO(long auto_transaction_id, double amount, String auto_transaction_date, String make,
			String model, String year, String auto_shop_name, String username, String transaction_type_descr) {
		super();
		this.auto_transaction_id = auto_transaction_id;
		this.amount = amount;
		this.auto_transaction_date = auto_transaction_date;
		this.make = make;
		this.model = model;
		this.year = year;
		this.auto_shop_name = auto_shop_name;
		this.username = username;
		this.transaction_type_descr = transaction_type_descr;
	}
	public AutoTrxInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
