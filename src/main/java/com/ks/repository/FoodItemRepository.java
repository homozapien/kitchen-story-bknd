package com.ks.repository;



import org.springframework.stereotype.Repository;

import com.ks.entities.FoodItem;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, String> 
{

	

}
