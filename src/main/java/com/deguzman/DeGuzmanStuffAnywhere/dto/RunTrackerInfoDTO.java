package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class RunTrackerInfoDTO {

	public long run_id;
	public String run_date;
	public double run_distance;
	public String run_time;
	public String username;
	public long getRun_id() {
		return run_id;
	}
	public void setRun_id(long run_id) {
		this.run_id = run_id;
	}
	public String getRun_date() {
		return run_date;
	}
	public void setRun_date(String run_date) {
		this.run_date = run_date;
	}
	public double getRun_distance() {
		return run_distance;
	}
	public void setRun_distance(double run_distance) {
		this.run_distance = run_distance;
	}
	public String getRun_time() {
		return run_time;
	}
	public void setRun_time(String run_time) {
		this.run_time = run_time;
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
		result = prime * result + ((run_date == null) ? 0 : run_date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(run_distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (run_id ^ (run_id >>> 32));
		result = prime * result + ((run_time == null) ? 0 : run_time.hashCode());
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
		RunTrackerInfoDTO other = (RunTrackerInfoDTO) obj;
		if (run_date == null) {
			if (other.run_date != null)
				return false;
		} else if (!run_date.equals(other.run_date))
			return false;
		if (Double.doubleToLongBits(run_distance) != Double.doubleToLongBits(other.run_distance))
			return false;
		if (run_id != other.run_id)
			return false;
		if (run_time == null) {
			if (other.run_time != null)
				return false;
		} else if (!run_time.equals(other.run_time))
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
		return "RunTrackerInfoDTO [run_id=" + run_id + ", run_date=" + run_date + ", run_distance=" + run_distance
				+ ", run_time=" + run_time + ", username=" + username + "]";
	}
	public RunTrackerInfoDTO(long run_id, String run_date, double run_distance, String run_time, String username) {
		super();
		this.run_id = run_id;
		this.run_date = run_date;
		this.run_distance = run_distance;
		this.run_time = run_time;
		this.username = username;
	}
	public RunTrackerInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
