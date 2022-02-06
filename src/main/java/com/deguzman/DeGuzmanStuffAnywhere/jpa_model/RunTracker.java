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
@Table(name = "RUN_TRACKER")
@CrossOrigin
public class RunTracker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4812037100686878546L;
	public long run_id;
	public String runDate;
	public double runDistance;
	public String runTime;
	
	
	public User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "run_id")
	public long getRun_id() {
		return run_id;
	}

	public void setRun_id(long run_id) {
		this.run_id = run_id;
	}

	@Column(name = "run_date")
	public String getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}

	@Column(name = "run_distance")
	public double getRunDistance() {
		return runDistance;
	}

	public void setRunDistance(double runDistance) {
		this.runDistance = runDistance;
	}

	@Column(name = "run_time")
	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User userRunTracker) {
		this.user = userRunTracker;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((runDate == null) ? 0 : runDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(runDistance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((runTime == null) ? 0 : runTime.hashCode());
		result = prime * result + (int) (run_id ^ (run_id >>> 32));
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
		RunTracker other = (RunTracker) obj;
		if (runDate == null) {
			if (other.runDate != null)
				return false;
		} else if (!runDate.equals(other.runDate))
			return false;
		if (Double.doubleToLongBits(runDistance) != Double.doubleToLongBits(other.runDistance))
			return false;
		if (runTime == null) {
			if (other.runTime != null)
				return false;
		} else if (!runTime.equals(other.runTime))
			return false;
		if (run_id != other.run_id)
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
		return "RunTracker [run_id=" + run_id + ", runDate=" + runDate + ", runDistance=" + runDistance + ", runTime="
				+ runTime + ", user=" + user + "]";
	}

	public RunTracker(long run_id, String runDate, double runDistance, String runTime, User user) {
		super();
		this.run_id = run_id;
		this.runDate = runDate;
		this.runDistance = runDistance;
		this.runTime = runTime;
		this.user = user;
	}

	public RunTracker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
