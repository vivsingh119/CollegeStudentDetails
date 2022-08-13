package com.example.demo.modal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College implements Serializable {
	@Id
	@GeneratedValue
	private Integer cllgeId;
	private String cllgeName;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Student> totalStudents;

	public Integer getCllgeId() {
		return cllgeId;
	}

	public void setCllgeId(Integer cllgeId) {
		this.cllgeId = cllgeId;
	}

	public String getCllgeName() {
		return cllgeName;
	}

	public void setCllgeName(String cllgeName) {
		this.cllgeName = cllgeName;
	}

	public List<Student> getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(List<Student> totalStudents) {
		this.totalStudents = totalStudents;
	}

}
