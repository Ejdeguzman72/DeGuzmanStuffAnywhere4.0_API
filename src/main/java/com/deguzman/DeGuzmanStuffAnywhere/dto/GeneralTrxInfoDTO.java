package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class GeneralTrxInfoDTO {

	public long transaction_id;
	public double amount;
	public String payment_date;
	public String entity;
	public String transaction_type_descr;
	public String username;
	
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getTransaction_type_descr() {
		return transaction_type_descr;
	}
	public void setTransaction_type_descr(String transaction_type_descr) {
		this.transaction_type_descr = transaction_type_descr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((payment_date == null) ? 0 : payment_date.hashCode());
		result = prime * result + (int) (transaction_id ^ (transaction_id >>> 32));
		result = prime * result + ((transaction_type_descr == null) ? 0 : transaction_type_descr.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		GeneralTrxInfoDTO other = (GeneralTrxInfoDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (payment_date == null) {
			if (other.payment_date != null)
				return false;
		} else if (!payment_date.equals(other.payment_date))
			return false;
		if (transaction_id != other.transaction_id)
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
		return true;
	}
	@Override
	public String toString() {
		return "GeneralTrxInfoDTO [transaction_id=" + transaction_id + ", amount=" + amount + ", payment_date="
				+ payment_date + ", entity=" + entity + ", transaction_type_descr=" + transaction_type_descr
				+ ", username=" + username + "]";
	}
	public GeneralTrxInfoDTO(long transaction_id, double amount, String payment_date, String entity,
			String transaction_type_descr, String username) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.entity = entity;
		this.transaction_type_descr = transaction_type_descr;
		this.username = username;
	}
	public GeneralTrxInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
