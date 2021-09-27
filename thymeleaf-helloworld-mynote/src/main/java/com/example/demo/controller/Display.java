package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Data;
import com.example.demo.service.DataService;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class Display {
	
	@Autowired
 	private DataService dataService;

	 	
	    @GetMapping("/getNotes")
	    public List<Data> getNotes(){
	    	 //Iterable<Data> allList = dataService.getdata();
	    	 return (List<Data>) dataService.getNotes();
	 		//return new ResponseEntity<>(allList, HttpStatus.OK);

	    }
	    @PostMapping("/addNote")
	    public String addData1(@RequestBody Data data){
	    	String name=dataService.addNote(data);
	    	return "note with title "+name+" added successfully";
	    }

	    @PutMapping("/editNote")
	    public String editNote(@RequestBody Data data) {
	    	String name=dataService.editNote(data);
	    	return "note with title "+name+" updated";
	    }
	    @DeleteMapping("/deleteNote/{title}")
	    public String deleteData(@PathVariable String title) {
	    	String a=dataService.deleteData(title);
	    	return "The note with title "+a+" deleted";
	    }

	    @DeleteMapping("/deleteNote")
	    public String deleteData1(@RequestBody String title) {
	    	String a=dataService.deleteData1(title);
	    	return "The note with title "+a+" deleted";
	    }
	    @GetMapping("/getNoteById/{title}")
	    public Data getNoteById(@PathVariable String title){
	    	
	    	 return dataService.getNoteById(title);
	 		

	    }
	    
	    }


