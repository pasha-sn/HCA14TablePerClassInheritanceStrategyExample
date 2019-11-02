package com.infotech.client;

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
public class FetchDataClientTest {
	

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			//super class entity
			Person person = session.get(Person.class, 1);			
			if(person != null && !(person instanceof Student) && !(person instanceof Employee))
			{
				System.out.println("Data is person type");
				System.out.println(person);
			}else if(person instanceof Employee)
			{
				Employee employee = (Employee) person;
				System.out.println("Data is employee type");
				System.out.println(employee);
			}else if(person instanceof Student)
			{
				Student student = (Student) person;
				System.out.println("Data is student type");
				System.out.println(student);
				
			}else {
				System.out.println("Person Not Found In Database!!!");
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
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
    select
        person0_.id as id1_1_0_,
        person0_.gender as gender2_1_0_,
        person0_.name as name3_1_0_,
        person0_.bonus as bonus1_0_0_,
        person0_.dep_name as dep_name2_0_0_,
        person0_.date_of_joining as date_of_joining3_0_0_,
        person0_.email as email4_0_0_,
        person0_.salary as salary5_0_0_,
        person0_.fee as fee1_2_0_,
        person0_.school_name as school_name2_2_0_,
        person0_.section_name as section_name3_2_0_,
        person0_.clazz_ as clazz_0_ 
    from
        ( select
            id,
            gender,
            name,
            null as bonus,
            null as dep_name,
            null as date_of_joining,
            null as email,
            null as salary,
            null as fee,
            null as school_name,
            null as section_name,
            0 as clazz_ 
        from
            person_table 
        union
        all select
            id,
            gender,
            name,
            bonus,
            dep_name,
            date_of_joining,
            email,
            salary,
            null as fee,
            null as school_name,
            null as section_name,
            1 as clazz_ 
        from
            employee_table 
        union
        all select
            id,
            gender,
            name,
            null as bonus,
            null as dep_name,
            null as date_of_joining,
            null as email,
            null as salary,
            fee,
            school_name,
            section_name,
            2 as clazz_ 
        from
            student_table 
    ) person0_ 
where
    person0_.id=?
Data is employee type
Employee [salary=3500.29, doj=1922-02-22 00:00:00.0, depName=IT, bonus=123.456, email=pasha.sn@gmail.com, toString()=Person [id=2, name=Pasha Sadi, gender=Male]]
*/