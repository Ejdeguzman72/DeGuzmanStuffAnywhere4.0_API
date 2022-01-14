package com.deguzman.DeGuzmanStuffAnywhere.model;

import java.io.Serializable;

public class Users implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9190614374131494245L;
	public long user_id;
	public String username;
	public String password;
	public String name;
	public String email;
	public int role_id;
	public int user_status_id;
	public long auto_transaction_id;
	public long transaction_id;
	public long medical_transaction_id;
	public int exercise_id;
	public long run_id;
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getUser_status_id() {
		return user_status_id;
	}
	public void setUser_status_id(int user_status_id) {
		this.user_status_id = user_status_id;
	}
	public long getAuto_transaction_id() {
		return auto_transaction_id;
	}
	public void setAuto_transaction_id(long auto_transaction_id) {
		this.auto_transaction_id = auto_transaction_id;
	}
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public long getMedical_transaction_id() {
		return medical_transaction_id;
	}
	public void setMedical_transaction_id(long medical_transaction_id) {
		this.medical_transaction_id = medical_transaction_id;
	}
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public long getRun_id() {
		return run_id;
	}
	public void setRun_id(long run_id) {
		this.run_id = run_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (auto_transaction_id ^ (auto_transaction_id >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + exercise_id;
		result = prime * result + (int) (medical_transaction_id ^ (medical_transaction_id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role_id;
		result = prime * result + (int) (run_id ^ (run_id >>> 32));
		result = prime * result + (int) (transaction_id ^ (transaction_id >>> 32));
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + user_status_id;
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
		Users other = (Users) obj;
		if (auto_transaction_id != other.auto_transaction_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (exercise_id != other.exercise_id)
			return false;
		if (medical_transaction_id != other.medical_transaction_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role_id != other.role_id)
			return false;
		if (run_id != other.run_id)
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_status_id != other.user_status_id)
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
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", role_id=" + role_id + ", user_status_id=" + user_status_id
				+ ", auto_transaction_id=" + auto_transaction_id + ", transaction_id=" + transaction_id
				+ ", medical_transaction_id=" + medical_transaction_id + ", exercise_id=" + exercise_id + ", run_id="
				+ run_id + "]";
	}
	public Users(long user_id, String username, String password, String name, String email, int role_id,
			int user_status_id, long auto_transaction_id, long transaction_id, long medical_transaction_id,
			int exercise_id, long run_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.role_id = role_id;
		this.user_status_id = user_status_id;
		this.auto_transaction_id = auto_transaction_id;
		this.transaction_id = transaction_id;
		this.medical_transaction_id = medical_transaction_id;
		this.exercise_id = exercise_id;
		this.run_id = run_id;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
