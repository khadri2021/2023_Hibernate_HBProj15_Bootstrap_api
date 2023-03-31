package com.khadri.hibernate.boot.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.boot.entities.Customer;
import com.khadri.hibernate.boot.entities.Order;
import com.khadri.hibernate.boot.registry.BootRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Session session = BootRegistryUtil.getSession();

		Transaction txn = session.beginTransaction();

		Customer customer = new Customer();
		customer.setName("JHON");

		session.save(customer);

		Order order = new Order();
		order.setName("DOSA");

		session.save(order);

		txn.commit();

		BootRegistryUtil.closeObjects();

	}
}
