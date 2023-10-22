package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.Customer;
import com.infinite.repository.CustomerDaoImpl;
import com.infinite.repository.ICustomerDao;
@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerDao cdaoimpl;
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return cdaoimpl.getAllCustomers();
	}
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return cdaoimpl.getCustomer(id);
	}
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cdaoimpl.addCustomer(customer);
	}
	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cdaoimpl.updateCustomer(customer);;

	}
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		cdaoimpl.deleteCustomer(id);
		
	}

}
