package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class UserInfoDTO {

	public long user_id;
	public String username;
	public String password;
	public String name;
	public String email;
	public String role_descr;
	public String user_status_descr;
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
	public String getRole_descr() {
		return role_descr;
	}
	public void setRole_descr(String role_descr) {
		this.role_descr = role_descr;
	}
	public String getUser_status_descr() {
		return user_status_descr;
	}
	public void setUser_status_descr(String user_status_descr) {
		this.user_status_descr = user_status_descr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role_descr == null) ? 0 : role_descr.hashCode());
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((user_status_descr == null) ? 0 : user_status_descr.hashCode());
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
		UserInfoDTO other = (UserInfoDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (role_descr == null) {
			if (other.role_descr != null)
				return false;
		} else if (!role_descr.equals(other.role_descr))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_status_descr == null) {
			if (other.user_status_descr != null)
				return false;
		} else if (!user_status_descr.equals(other.user_status_descr))
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
		return "UserInfoDTO [user_id=" + user_id + ", username=" + username + ", password=" + password + ", name="
				+ name + ", email=" + email + ", role_descr=" + role_descr + ", user_status_descr=" + user_status_descr
				+ "]";
	}
	public UserInfoDTO(long user_id, String username, String password, String name, String email, String role_descr,
			String user_status_descr) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.role_descr = role_descr;
		this.user_status_descr = user_status_descr;
	}
	public UserInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
