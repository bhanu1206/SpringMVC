package com.infinite.service;

import java.util.List;
import com.infinite.model.Customer;
public interface ICustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(int id);
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int id);
}
