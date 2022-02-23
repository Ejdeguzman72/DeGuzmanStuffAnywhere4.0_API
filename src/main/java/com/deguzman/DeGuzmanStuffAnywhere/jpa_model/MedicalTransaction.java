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
@Table(name = "MEDICAL_TRANSACTIONS")
@CrossOrigin
public class MedicalTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 938725339019416975L;
	public Long medical_transaction_id;
	public String medical_transaction_date;
	public double amount;
	
	public MedicalOffice facility;
	
	public TransactionType transactionType;

	public User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_transaction_id")
	public Long getMedicalTransaction_Id() {
		return medical_transaction_id;
	}
	public void setMedicalTransaction_Id(Long medical_transaction_id) {
		this.medical_transaction_id = medical_transaction_id;
	}
	@Column(name = "medical_transaction_date")
	public String getMedicalTransactionDate() {
		return medical_transaction_date;
	}
	public void setMedicalTransactionDate(String medical_transaction_date) {
		this.medical_transaction_date = medical_transaction_date;
	}
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_office_id")
	public MedicalOffice getFacility() {
		return facility;
	}
	public void setFacility(MedicalOffice facility) {
		this.facility = facility;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((facility == null) ? 0 : facility.hashCode());
		result = prime * result + ((medical_transaction_id == null) ? 0 : medical_transaction_id.hashCode());
		result = prime * result + ((medical_transaction_date == null) ? 0 : medical_transaction_date.hashCode());
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
		MedicalTransaction other = (MedicalTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (facility == null) {
			if (other.facility != null)
				return false;
		} else if (!facility.equals(other.facility))
			return false;
		if (medical_transaction_id == null) {
			if (other.medical_transaction_id != null)
				return false;
		} else if (!medical_transaction_id.equals(other.medical_transaction_id))
			return false;
		if (medical_transaction_date == null) {
			if (other.medical_transaction_date != null)
				return false;
		} else if (!medical_transaction_date.equals(other.medical_transaction_date))
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
		return "MedicalTransaction [medical_transaction_id=" + medical_transaction_id + ", medical_transaction_date="
				+ medical_transaction_date + ", amount=" + amount + ", facility=" + facility + ", transactionType="
				+ transactionType + ", user=" + user + "]";
	}
	public MedicalTransaction(Long medical_transaction_id, String medical_transaction_date, double amount,
			MedicalOffice facility, TransactionType transactionType, User user) {
		super();
		this.medical_transaction_id = medical_transaction_id;
		this.medical_transaction_date = medical_transaction_date;
		this.amount = amount;
		this.facility = facility;
		this.transactionType = transactionType;
		this.user = user;
	}
	public MedicalTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
