package com.ks.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ks.entities.Customer;
import com.ks.entities.FoodItem;
import com.ks.entities.PurchaseOrder;
import com.ks.repository.CustomerRepository;
import com.ks.repository.FoodItemRepository;
import com.ks.repository.PurchaseOrderRepository;
import com.ks.util.Helper;

@Service
public class PurchaseOrderService {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

	@Autowired
	PurchaseOrderRepository repository;

	@Autowired
	CustomerRepository custRepository;

	public List<PurchaseOrder> findAllPurchaseOrders() {
		return repository.findAll();
	}

	public String createPurchaseOrder(PurchaseOrder order) {

		String orderId = Helper.generateRandomString();
		String orderBy = order.getOrderBy();
		Optional<Customer> customer = custRepository.findById(orderBy);
		

		try {

			if (null == order.getOrderid() && customer.isPresent()) 
			{
				order.setOrderid(orderId);
				order.setCustomer(customer.orElse(null));
				order.setOrderDate(java.sql.Date.valueOf(LocalDate.now()));
				repository.save(order);
				return orderId;
			} 
			else
			{
				return "EXCEPTION";
			}
		} 
		catch (Exception e) {
			System.err.println(e);
			return "EXCEPTION";
		}

	}
	
	public String updateOrderPaymntStatus(PurchaseOrder order) 
	{
		Optional<PurchaseOrder> po = repository.findById(order.getOrderid());
		
		if(po.isPresent())
		{
			PurchaseOrder dbo = po.get();
			if(null == dbo.getPaymentStatus())
			{
				dbo.setPaymentStatus("COMPLETE");
				repository.saveAndFlush(dbo);
				return "SUCCESS";
			}
			else
			{
				return "EXCEPTION";
			}
		}
		else
		{
			return "EXCEPTION";
		}
	}

}
