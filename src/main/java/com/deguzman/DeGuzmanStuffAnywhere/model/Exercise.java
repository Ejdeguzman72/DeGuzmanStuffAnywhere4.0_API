package com.deguzman.DeGuzmanStuffAnywhere.model;

import java.io.Serializable;

public class Exercise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1101615341293557860L;
	public int exercise_id;
	public String exercise_name;
	public int sets;
	public int reps;
	public double weight;
	public String date;
	public int exercise_type_id;
	public long user_id;
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public String getExercise_name() {
		return exercise_name;
	}
	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExercise_type_id() {
		return exercise_type_id;
	}
	public void setExercise_type_id(int exercise_type_id) {
		this.exercise_type_id = exercise_type_id;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + exercise_id;
		result = prime * result + ((exercise_name == null) ? 0 : exercise_name.hashCode());
		result = prime * result + exercise_type_id;
		result = prime * result + reps;
		result = prime * result + sets;
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Exercise other = (Exercise) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (exercise_id != other.exercise_id)
			return false;
		if (exercise_name == null) {
			if (other.exercise_name != null)
				return false;
		} else if (!exercise_name.equals(other.exercise_name))
			return false;
		if (exercise_type_id != other.exercise_type_id)
			return false;
		if (reps != other.reps)
			return false;
		if (sets != other.sets)
			return false;
		if (user_id != other.user_id)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Exercise [exercise_id=" + exercise_id + ", exercise_name=" + exercise_name + ", sets=" + sets
				+ ", reps=" + reps + ", weight=" + weight + ", date=" + date + ", exercise_type_id=" + exercise_type_id
				+ ", user_id=" + user_id + "]";
	}
	public Exercise(int exercise_id, String exercise_name, int sets, int reps, double weight, String date,
			int exercise_type_id, long user_id) {
		super();
		this.exercise_id = exercise_id;
		this.exercise_name = exercise_name;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
		this.date = date;
		this.exercise_type_id = exercise_type_id;
		this.user_id = user_id;
	}
	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
