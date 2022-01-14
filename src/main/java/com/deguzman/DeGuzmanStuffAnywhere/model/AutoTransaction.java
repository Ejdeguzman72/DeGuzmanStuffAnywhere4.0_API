package com.deguzman.DeGuzmanStuffAnywhere.model;

import java.io.Serializable;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class AutoTransaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676869382585836353L;
	public long autoTransaction_id;
	public String autoTransactionDate;
	public double amount;
	public int auto_shop_id;
	public long transaction_type_id;
	public long vehicle_id;
	public long user_id;
	
	public long getAutoTransaction_id() {
		return autoTransaction_id;
	}
	public void setAutoTransaction_id(long autoTransaction_id) {
		this.autoTransaction_id = autoTransaction_id;
	}
	public String getAutoTransactionDate() {
		return autoTransactionDate;
	}
	public void setAutoTransactionDate(String autoTransactionDate) {
		this.autoTransactionDate = autoTransactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAuto_shop_id() {
		return auto_shop_id;
	}
	public void setAuto_shop_id(int auto_shop_id) {
		this.auto_shop_id = auto_shop_id;
	}
	public long getTransaction_type_id() {
		return transaction_type_id;
	}
	public void setTransaction_type_id(long transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	public long getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((autoTransactionDate == null) ? 0 : autoTransactionDate.hashCode());
		result = prime * result + (int) (autoTransaction_id ^ (autoTransaction_id >>> 32));
		result = prime * result + auto_shop_id;
		result = prime * result + (int) (transaction_type_id ^ (transaction_type_id >>> 32));
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + (int) (vehicle_id ^ (vehicle_id >>> 32));
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
		AutoTransaction other = (AutoTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (autoTransactionDate == null) {
			if (other.autoTransactionDate != null)
				return false;
		} else if (!autoTransactionDate.equals(other.autoTransactionDate))
			return false;
		if (autoTransaction_id != other.autoTransaction_id)
			return false;
		if (auto_shop_id != other.auto_shop_id)
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (vehicle_id != other.vehicle_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutoTransaction [autoTransaction_id=" + autoTransaction_id + ", autoTransactionDate="
				+ autoTransactionDate + ", amount=" + amount + ", auto_shop_id=" + auto_shop_id
				+ ", transaction_type_id=" + transaction_type_id + ", vehicle_id=" + vehicle_id + ", user_id=" + user_id
				+ "]";
	}
	public AutoTransaction(long autoTransaction_id, String autoTransactionDate, double amount, int auto_shop_id,
			long transaction_type_id, long vehicle_id, long user_id) {
		super();
		this.autoTransaction_id = autoTransaction_id;
		this.autoTransactionDate = autoTransactionDate;
		this.amount = amount;
		this.auto_shop_id = auto_shop_id;
		this.transaction_type_id = transaction_type_id;
		this.vehicle_id = vehicle_id;
		this.user_id = user_id;
	}
	public AutoTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
