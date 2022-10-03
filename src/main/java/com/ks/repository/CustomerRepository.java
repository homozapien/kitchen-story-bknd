package com.ks.repository;



import org.springframework.stereotype.Repository;

import com.ks.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> 
{	

}
