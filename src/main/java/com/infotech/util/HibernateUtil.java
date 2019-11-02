package com.infotech.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	// Static block is executed when class loads
	// sessionFactory is very expensive object
	// static block is common for all clients
	// Runs every time when the instance of the class is created
	static 
	{
		try {
			if (sessionFactory == null) {
				// create standardServiceRegistry
				standardServiceRegistry = new StandardServiceRegistryBuilder()
						.configure()
						.build();
				// create MetadataSources
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

				// create Metadata
				Metadata metadata = metadataSources.getMetadataBuilder().build();

				// create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		} catch (Exception e) {
			if (standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
	}

	// A static method belongs to the class rather than the object of a class.
	// A static method can be invoked without the need for creating an instance of a class.
	// A static method can access static data member and can change the value of it.	
	// https://stackoverflow.com/questions/11993077/difference-between-static-methods-and-instance-methods/11993118
	// https://stackoverflow.com/questions/2671496/java-when-to-use-static-methods
	// Create static Utility Factory method to return sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// Create static Utility Helper method using helper SimpleDateFormat.class to format date
	public static Date getDoj(String doj) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(doj);
	}
}