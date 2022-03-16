package com.deguzman.DeGuzmanStuffAnywhere.jpa_model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.User;

@Entity
@Table(name = "AUTO_TRANSACTIONS")
@CrossOrigin
public class AutoTransaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676869382585836353L;
	public Long auto_transaction_id;
	public String autoTransactionDate;
	public double amount;
	
	public AutoRepairShop autoShop;
	
	public User user;
	
	public TransactionType transactionType;
	
	public Vehicle vehicle;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auto_transaction_id")
	public Long getAutoTransaction_id() {
		return auto_transaction_id;
	}
	public void setAutoTransaction_id(Long auto_transaction_id) {
		this.auto_transaction_id = auto_transaction_id;
	}
	@Column(name = "auto_transaction_date")
	public String getAutoTransactionDate() {
		return autoTransactionDate;
	}
	public void setAutoTransactionDate(String autoTransactionDate) {
		this.autoTransactionDate = autoTransactionDate;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto_shop_id")
	public AutoRepairShop getAutoShop() {
		return autoShop;
	}
	public void setAutoShop(AutoRepairShop autoShop) {
		this.autoShop = autoShop;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_type_id")
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	public Vehicle getCar() {
		return vehicle;
	}
	public void setCar(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((autoTransactionDate == null) ? 0 : autoTransactionDate.hashCode());
		result = prime * result + ((auto_transaction_id == null) ? 0 : auto_transaction_id.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		result = prime * result + ((autoShop == null) ? 0 : autoShop.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (auto_transaction_id == null) {
			if (other.auto_transaction_id != null)
				return false;
		} else if (!auto_transaction_id.equals(other.auto_transaction_id))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		if (autoShop == null) {
			if (other.autoShop != null)
				return false;
		} else if (!autoShop.equals(other.autoShop))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutoTransaction [auto_transaction_id=" + auto_transaction_id + ", autoTransactionDate="
				+ autoTransactionDate + ", autoShop=" + autoShop + ", amount=" + amount + ", user=" + user
				+ ", transactionType=" + transactionType + ", vehicle=" + vehicle + "]";
	}
	public AutoTransaction(Long auto_transaction_id, String autoTransactionDate, AutoRepairShop autoShop, double amount,
			User user, TransactionType transactionType, Vehicle vehicle) {
		super();
		this.auto_transaction_id = auto_transaction_id;
		this.autoTransactionDate = autoTransactionDate;
		this.autoShop = autoShop;
		this.amount = amount;
		this.user = user; 
		this.transactionType = transactionType;
		this.vehicle = vehicle;
	}
	
	public AutoTransaction(String autoTransactionDate, AutoRepairShop autoShop, double amount,
			User user, TransactionType transactionType, Vehicle vehicle) {
		super();
		this.autoTransactionDate = autoTransactionDate;
		this.autoShop = autoShop;
		this.amount = amount;
		this.user = user; 
		this.transactionType = transactionType;
		this.vehicle = vehicle;
	}
	
	public AutoTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
