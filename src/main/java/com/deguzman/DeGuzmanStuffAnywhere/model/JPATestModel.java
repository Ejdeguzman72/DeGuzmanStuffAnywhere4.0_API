package com.deguzman.DeGuzmanStuffAnywhere.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "jpatest")
@CrossOrigin
public class JPATestModel {

	public int id;
	public String test;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((test == null) ? 0 : test.hashCode());
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
		JPATestModel other = (JPATestModel) obj;
		if (id != other.id)
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JPATestModel [id=" + id + ", test=" + test + "]";
	}

	public JPATestModel(int id, String test) {
		super();
		this.id = id;
		this.test = test;
	}

	public JPATestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
