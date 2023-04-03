package com.khadri.hibernate.boot.registry.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;

import com.khadri.hibernate.boot.entities.Customer;
import com.khadri.hibernate.boot.entities.Order;

public class BootServiceRegistryUtil {
	static SessionFactory factory;
	static Session session;

	private static SessionFactory createSessionFactory() {
		
		//Builder design pattern
		BootstrapServiceRegistry serviceRegistry = new BootstrapServiceRegistryBuilder()
				.build();

		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildMetadata();

		factory = metadata.buildSessionFactory();

		return factory;
	}

	public static Session getSession() {
		session = createSessionFactory().openSession();
		return session;
	}

	public static void closeObjects() {
		session.close();
		factory.close();
	}
}
