package com.khadri.hibernate.boot.main;

import javax.persistence.EntityManager;

import com.khadri.hibernate.boot.entities.Customer;
import com.khadri.hibernate.boot.entities.Order;
import com.khadri.hibernate.boot.registry.util.JpaBootStrapEntityManagerUtil;

public class MainEntityManager {

	public static void main(String[] args) {

		EntityManager entityManager = JpaBootStrapEntityManagerUtil
				.getEntityMager();
 

		entityManager.getTransaction().begin();

		Customer customer = new Customer();
		customer.setName("JHON");

		Order order = new Order();
		order.setName("DOSA");

		entityManager.persist(customer);
		entityManager.persist(order);

		entityManager.getTransaction().commit();
		

	}
}
