package com.project.PlaneLogin.Service;


//here we have to use org.springframework.transactional
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.PlaneLogin.DAO.CustomerDAO;
import com.project.PlaneLogin.Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO=customerDAO;
	}
		
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public void addCustomerFile(MultipartFile file) {
		
		try {
		InputStream is=file.getInputStream();
		logger.warning("input file is read");
		String line="";
		String splitBy=",";
		List<Customer> customers=new ArrayList<Customer>();
		logger.warning("input file is saved to inputstream");
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		logger.warning("input file is accepted by buffer");
			while((line=br.readLine())!=null) {
				logger.warning("input file is getting processed");
				String details[]=line.split(splitBy);
				customers.add(new Customer(details[0],details[1],details[2]));
			}	
			customerDAO.AddCustomerList(customers);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public Object getContentTypeFromService(MultipartFile file) {
		return file.getContentType();
	}

	
}
