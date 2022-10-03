package com.ks.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ks.entities.FoodItem;
import com.ks.repository.FoodItemRepository;

@Service
public class FoodItemService {

	private static final Logger logger = LoggerFactory.getLogger(FoodItemService.class);

	@Autowired
	FoodItemRepository repository;

	public List<FoodItem> findAllFood()
     {
		return repository.findAll();
	}

	public String createFood(FoodItem food) {
		
			Optional<FoodItem> item = repository.findById(food.getId());
			if (item.isPresent()) 
			{
				return "Exception encounted; unable to create food with id: " + food.getId();
			} 
			else
			{
				repository.save(food);
				return "FoodItem with Id: "+ food.getId() +" stored successfully in the backend";
			}
		
	}

	public String deleteFood(String id) 
	{
		Optional<FoodItem> item = repository.findById(id);
		try
		{
		if (item.isPresent()) {
			FoodItem food = item.get();
			repository.delete(food);
			return "FoodItem with Id '" + id + "'  deleted successfully form the backend";
		} 
		else
		{

			return "Unable to delete FoodItem with id " + id + ", record does not exist";
		}
		}
		catch(Exception e)
		{
			return "Unable to delete FoodItem with id " + id + "Exception raised";
		}
	}

	public String updateFoodItemDetails(FoodItem food) {
		
			Optional<FoodItem> item = repository.findById(food.getId());
			try
			{
			if (item.isPresent()) 
			{
				FoodItem entity = item.get();
				entity.setName(food.getName());
				entity.setType(food.getType());
				entity.setPrice(food.getPrice());
				entity.setImagepath(food.getImagepath());
				entity.setPrice(food.getPrice());
				repository.saveAndFlush(entity);
				return "FoodItem with id " + food.getId() + " record updated successfully";

			} else {

				return "Unable to update FoodItem with id " + food.getId() + ", record does not exist";
			}
			}
			catch(Exception e)
			{
				return "Unable to update FoodItem with id " + food.getId() + "Exception raised";
			}
		
	}

}
