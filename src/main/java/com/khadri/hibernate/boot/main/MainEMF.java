package com.khadri.hibernate.boot.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.khadri.hibernate.boot.entities.Customer;
import com.khadri.hibernate.boot.entities.Order;
import com.khadri.hibernate.boot.registry.util.JpaBootStrapEntityManagerUtil;

public class MainEMF {

	public static void main(String[] args) {

		EntityManagerFactory emf = JpaBootStrapEntityManagerUtil
				.getEntityMagerFactory();

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Customer customer = new Customer();
		customer.setName("JHON");

		Order order = new Order();
		order.setName("DOSA");

		em.persist(customer);
		em.persist(order);

		em.getTransaction().commit();
		

	}
}
