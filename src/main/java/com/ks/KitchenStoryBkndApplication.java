package com.ks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ks.entities.Customer;
import com.ks.repository.CustomerRepository;



@SpringBootApplication(scanBasePackages = "com.ks")
@EntityScan(basePackages = "com.ks.entities")
@EnableJpaRepositories(basePackages = "com.ks.repository")
public class KitchenStoryBkndApplication {

	private static final Logger log = LoggerFactory.getLogger(KitchenStoryBkndApplication.class);
	
	public static void main(String[] args) 
	{
		SpringApplication.run(KitchenStoryBkndApplication.class, args);
		System.out.println("Spring Boot KitchenStoryBkndApplication successfully started");
	}
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Bean
	public CommandLineRunner quickTest(CustomerRepository repository) {
		return (args) -> 
		{
			
			
			  log.info(">>> Creating some user profiles:");
			  
			  Optional<Customer> customer = repository.findById("admin@kitchenstory.com");
			  
			  if(!customer.isPresent())
			  {
				  //public Customer(String emailid, String password, String userType, String firstname, String lastname,String creditCard)
					
				  Customer customer1 = new  Customer("admin@kitchenstory.com",     "123", "Admin",    "Admin", "Strator", "123456");
				  Customer customer2 = new  Customer("customer1@kitchenstory.com", "123", "Customer", "Test", "UserOne", "123456");
				  Customer customer3 = new  Customer("customer2@kitchenstory.com", "123", "Customer", "Test", "UserTwo", "123456");
				      
				  List<Customer> custList = new ArrayList<>();
				  custList.add(customer1);
				  custList.add(customer2);
				  custList.add(customer3);
				
				  
				  repository.saveAllAndFlush(custList);
				  
				  
				  
				  log.info(">>> 3 User profiles creatd");
			  }
			 /* else
			  {
				  log.info(">>> User profiles exists <<<<<");  
				  System.out.println(customer);
				  log.info("### User profiles exists");  
			  } */
			  
			  
			  
		};
	}

}
