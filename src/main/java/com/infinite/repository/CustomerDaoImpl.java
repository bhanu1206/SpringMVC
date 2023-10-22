package com.infinite.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import com.infinite.model.Customer;

@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
public class CustomerDaoImpl implements ICustomerDao {
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Autowired
	private SessionFactory sesfactory;
	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session ss = this.sesfactory.getCurrentSession();
		List<Customer> ls = ss.createQuery("from Customer").list();
		return ls;
	}

	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		session.save(customer);
		return customer;
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

		Session session = this.sesfactory.getCurrentSession();
		Hibernate.initialize(customer);
		session.update(customer);
		
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
		

	

}
