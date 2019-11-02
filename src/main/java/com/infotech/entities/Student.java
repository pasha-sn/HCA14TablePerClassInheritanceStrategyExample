package com.infotech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
@Entity
@Table(name="student_table")
public class Student extends Person
{
	@Column(name="school_name", length=50)
	private String schooolName;
	
	@Column(name="fee")
	private float fee;
	
	@Column(name="section_name", length=50)
	private String sectionName;
	
	//getters and setters
	public String getSchooolName() {
		return schooolName;
	}
	public void setSchooolName(String schooolName) {
		this.schooolName = schooolName;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	//in this example I added super class inherited toString method
	//(", toString()=" + super.toString())
	@Override
	public String toString() {
		return "Student [schooolName=" + schooolName + ", fee=" + fee + ", sectionName=" + sectionName + ", toString()="
				+ super.toString() + "]";
	}	
}
