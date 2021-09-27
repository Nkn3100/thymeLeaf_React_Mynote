package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Data;


public interface DataRepository extends CrudRepository<Data,String> {
	
	 //Data findByName (String name);
		
	
	
	
	
}
//List<Data> 
