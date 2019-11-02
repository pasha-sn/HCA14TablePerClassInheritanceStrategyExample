package com.infotech.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
@Entity
@Table(name="employee_table")
public class Employee extends Person
{
	//7 is the Integer part, and 2 is decimal part of the number
	//1234567.89 is a supported number
	@Column(name="salary", columnDefinition="DECIMAL(7,2)")
	private Double salary;
	
	@Column(name="date_of_joining")
	private Date doj;
	
	@Column(name="dep_name", length=30)
	private String depName;
	
	//Precision: Total number of significant digits
	//Scale: Number of digits to the right of decimal point
	@Column(name="bonus", precision=6, scale=3)
	private BigDecimal bonus;
	
	@Column(name="email", length=30, unique=true)
	private String email;
	
	//getters and setters
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//in this example I also added super class inherited toString method
	//(", toString()=" + super.toString())
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", doj=" + doj + ", depName=" + depName + ", bonus=" + bonus + ", email="
				+ email + ", toString()=" + super.toString() + "]";
	}	
}