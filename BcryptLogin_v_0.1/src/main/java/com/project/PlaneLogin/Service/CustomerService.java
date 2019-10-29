package com.project.PlaneLogin.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.PlaneLogin.Entity.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer );
	
	public Customer getCustomer(int id);

	public List<Customer> getAllCustomers();

	
	public void deleteCustomer(int id);

	public void addCustomerFile(MultipartFile file);

	public Object getContentTypeFromService(MultipartFile file);

	

}
