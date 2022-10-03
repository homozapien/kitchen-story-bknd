package com.ks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ks.entities.FoodItem;
import com.ks.services.FoodItemService;

@RestController
@RequestMapping(value = "kitchenstory")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(FoodItemController.class);
	
	@Autowired
	FoodItemService service;

	// http://localhost:9191/kitchenstory/findAll
	@RequestMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<FoodItem> fetchAllFoods() 
	{	  
			return service.findAllFood();
	
	}  
	
	/*@RequestMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<FoodItem> fetchAllFoods() 
	{
		
		    logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");
	        
		List<FoodItem> response = new ArrayList<>();
		try
		{
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			
			response = service.findAllFood();
			response.forEach(element -> {
				
				try {
					System.out.println(ow.writeValueAsString(element));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		       	}
					);
		}
		catch(Exception e)
		{
		  System.err.println(e);
		} 
		
		return response;
	}*/

	// http://localhost:9191/kitchenstory/storefood
	@PostMapping(value = "/storefood", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createFood(@RequestBody FoodItem food) {
		return service.createFood(food);
	}

	// http://localhost:9999/kitchenstory/updatefood
	@RequestMapping(value = "/updatefood", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public String updateFoodDetails(@RequestBody FoodItem food) {
		return service.updateFoodItemDetails(food);
	}

	// http://localhost:9191/kitchenstory/deletefood/{e.g. 100}
	@DeleteMapping(value = "/deletefood/{id}")
	public String deleteFood(@PathVariable("id") String id) {
		return service.deleteFood(id);
	}
}
