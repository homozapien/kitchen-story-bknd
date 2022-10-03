package com.ks.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ks.entities.Customer;
import com.ks.repository.CustomerRepository;



@Service
public class CustomerService 
{
	@Autowired
	CustomerRepository repository;
	
	public String createProfile(Customer customer) 
	{
		Optional<Customer> item = repository.findById(customer.getEmailid());
		if (item.isPresent()) 
		{
			return "Exception encounted; unable to create customer with id: " + customer.getEmailid();
		} 
		else
		{
			repository.save(customer);
			return "Customer with Id: "+ customer.getEmailid() +" stored successfully in the backend";
		}
    } 
	
	
	public Customer findCustomerProfileById(String emailid)
	{
		Optional<Customer> item = repository.findById(emailid);
		
		return item.orElse(null);
			
	}
	
	
	
}
