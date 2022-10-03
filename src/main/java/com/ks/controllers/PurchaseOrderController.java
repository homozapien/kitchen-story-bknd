package com.ks.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ks.entities.PurchaseOrder;
import com.ks.services.PurchaseOrderService;

@RestController
@RequestMapping(value = "kitchenstory")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);
	
	@Autowired
	PurchaseOrderService service;
	
	// http://localhost:9999/kitchenstory/findAllPOS
	@RequestMapping(value = "/findAllPOS", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<PurchaseOrder> fetchAllPurchaseOrders() 
	{
		return service.findAllPurchaseOrders();
	}

	// http://localhost:9999/kitchenstory/createpo
	@PostMapping(value = "/createpo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createpo(@RequestBody PurchaseOrder order) 
	{		
		return service.createPurchaseOrder(order);	
	}
	
	//http://localhost:9999/kitchenstory/updatepymntstatus/1001		
	@RequestMapping(value = "updatepymntstatus",
			method = RequestMethod.PUT)
	public String updatepaymentstatus(@RequestBody PurchaseOrder order) 
	{
		//return employeeService.deleteEmployee(id);
	System.out.println("Incoming Order id number " + order.getOrderid());
	
	   String result = service.updateOrderPaymntStatus(order);
	   System.out.println("Result of update is " + result);
		return result;
	}
	
	//http://localhost:9999/kitchenstory/updatepymntstatus/1001		
	/*@RequestMapping(value = "updatepymntstatus/{orderid}",
			method = RequestMethod.PUT)
	public String updatepaymentstatus(@PathVariable("orderid") String orderid) 
	{
		//return employeeService.deleteEmployee(id);
	System.out.println("Incoming Order id number " + orderid);
	
	   String result = service.updateOrderPaymntStatus(orderid);
	   System.out.println("Result of update is " + result);
		return result;
	}*/

	
}
