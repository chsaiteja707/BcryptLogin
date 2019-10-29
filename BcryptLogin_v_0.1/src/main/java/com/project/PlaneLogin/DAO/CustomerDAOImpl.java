package com.project.PlaneLogin.DAO;



import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

//here we have to use org.springframework.transactional

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.project.PlaneLogin.Entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session session=entityManager.unwrap(Session.class);
		Customer customer=session.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		Query query=entityManager.createQuery("from Customer");
		List<Customer> customers=query.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query=session.createQuery("delete from Customer where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public void AddCustomerList(List<Customer> customers) {
		
		for(Customer customer:customers) {
			logger.warning(customer.getFname()+"--"+customer.getLname());;
		}
		Session session=entityManager.unwrap(Session.class);
		for(Customer customer:customers)
			session.saveOrUpdate(customer);
		
	}


	//instead of keeping @Transactional we can simply write this as like this
	/*
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();
	
	try {
			//use session object to save data
			System.out.println("Create new user object");
			
			//create the student object
			User temp=new User("sai","teja","saiteja@gmail.com");
					
			//start a transaction
			session.beginTransaction();
			
			System.out.println("saving the student");
			//save the student object
			session.save(temp);
				
			//commit transaction			
			session.getTransaction().commit();
			
			System.out.println("done");
		}
		finally {
			session.close();
		}
*/
	
	
	
	
	

}
