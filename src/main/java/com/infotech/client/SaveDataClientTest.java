package com.infotech.client;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.entities.Person;
import com.infotech.entities.Student;
import com.infotech.util.HibernateUtil;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class SaveDataClientTest 
{
	
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			Person person = new Person();
			person.setName("Neda Salehi");
			person.setGender("Female");
			
			Employee employee = new Employee();
			employee.setBonus(new BigDecimal(123.456));
			//employee.setBonus(BigDecimal.valueOf(123.456));
			employee.setDepName("IT");
			employee.setDoj(HibernateUtil.getDoj("22/02/1922"));
			employee.setEmail("pasha.sn@gmail.com");
			employee.setSalary(3500.2872);
			employee.setName("Pasha Sadi");
			employee.setGender("Male");
			
			Student student = new Student();
			student.setName("Saba");
			student.setGender("Female");
			student.setFee(2000.00f);
			student.setSchooolName("Ershad");
			student.setSectionName("Java");
			
			session.beginTransaction();
			
			session.save(person);
			session.save(employee);
			session.save(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
<property name="hibernate.hbm2ddl.auto">create</property>
Hibernate: 
    create global temporary table HT_student_table (id number(10,0) not null) 
        on commit delete rows
Hibernate: 
    create global temporary table HT_employee_table (id number(10,0) not null) 
        on commit delete rows
Hibernate: 
    create global temporary table HT_person_table (id number(10,0) not null) 
        on commit delete rows
Hibernate: 
    
    drop table employee_table cascade constraints
Hibernate: 
    
    drop table person_table cascade constraints
Hibernate: 
    
    drop table student_table cascade constraints
Hibernate: 
    
    drop sequence hibernate_sequence
Hibernate: create sequence hibernate_sequence start with 1 increment by  1
Hibernate: 
    
    create table employee_table (
       id number(10,0) not null,
        gender varchar2(10 char),
        name varchar2(100 char),
        bonus number(6,3),
        dep_name varchar2(30 char),
        date_of_joining timestamp,
        email varchar2(30 char),
        salary DECIMAL(7,2),
        primary key (id)
    )
Hibernate: 
    
    create table person_table (
       id number(10,0) not null,
        gender varchar2(10 char),
        name varchar2(100 char),
        primary key (id)
    )
Hibernate: 
    
    create table student_table (
       id number(10,0) not null,
        gender varchar2(10 char),
        name varchar2(100 char),
        fee float,
        school_name varchar2(50 char),
        section_name varchar2(50 char),
        primary key (id)
    )
Hibernate: 
    
    alter table employee_table 
       add constraint UK_2casspobvavvi9s23312f9mhm unique (email)
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    insert 
    into
        person_table
        (gender, name, id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        employee_table
        (gender, name, bonus, dep_name, date_of_joining, email, salary, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        student_table
        (gender, name, fee, school_name, section_name, id) 
    values
        (?, ?, ?, ?, ?, ?)
*/