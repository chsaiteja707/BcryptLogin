package com.project.PlaneLogin.DAO;

import java.util.List;

import com.project.PlaneLogin.Entity.Customer;

public interface CustomerDAO {
	public void addCustomer(Customer user);

	public Customer getCustomer(int id);

	
	public List<Customer> getAllCustomers();

	public void deleteCustomer(int id);

	public void AddCustomerList(List<Customer> customers);

}
