package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class UtilityInfoDTO {

	public long utility_id;
	public String name;
	public String phone;
	public String url;
	public String dueDate;
	public String utility_type_descr;

	public long getUtility_id() {
		return utility_id;
	}

	public void setUtility_id(long utility_id) {
		this.utility_id = utility_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getUtility_type_descr() {
		return utility_type_descr;
	}

	public void setUtility_type_descr(String utility_type_descr) {
		this.utility_type_descr = utility_type_descr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + (int) (utility_id ^ (utility_id >>> 32));
		result = prime * result + ((utility_type_descr == null) ? 0 : utility_type_descr.hashCode());
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
		UtilityInfoDTO other = (UtilityInfoDTO) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (utility_id != other.utility_id)
			return false;
		if (utility_type_descr == null) {
			if (other.utility_type_descr != null)
				return false;
		} else if (!utility_type_descr.equals(other.utility_type_descr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UtilityInfoDTO [utility_id=" + utility_id + ", name=" + name + ", phone=" + phone + ", url=" + url
				+ ", dueDate=" + dueDate + ", utility_type_descr=" + utility_type_descr + "]";
	}

	public UtilityInfoDTO(long utility_id, String name, String phone, String url, String dueDate,
			String utility_type_descr) {
		super();
		this.utility_id = utility_id;
		this.name = name;
		this.phone = phone;
		this.url = url;
		this.dueDate = dueDate;
		this.utility_type_descr = utility_type_descr;
	}

	public UtilityInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
