package com.infotech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
@Entity
@Table(name="person_table")
//table per class strategy for inheritance in hibernate
//Hibernate will create 3 temporary global HT_XXX table in oracle database
//Hibernate uses theses table for bulk operations
//https://in.relation.to/2005/07/20/multitable-bulk-operations/
//cons:this strategy provides a poor support for polymorphic relationships.
//we have duplicated column name in every table
//https://stackoverflow.com/questions/29408829/inheritance-mapping-in-jpa?rq=1
//https://stackoverflow.com/questions/1373294/inheritance-in-hibernate-annotations
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name", length=100)
	private String name;
	
	@Column(name="gender", length=10)
	private String gender;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}		
}