package com.ks.repository;



import org.springframework.stereotype.Repository;

import com.ks.entities.PurchaseOrder;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String> 
{

	

}
