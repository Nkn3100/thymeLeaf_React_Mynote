package com.example.demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Data;
import com.example.demo.repository.DataRepository;
import com.example.demo.service.DataService;



@Controller
public class UserController {
	
	@Autowired DataRepository dataRepo;
	
	@Autowired
 	private DataService dataService;
	
	@GetMapping("/if-unless")
	public String users(Model model) {
		java.util.List<User> users =new ArrayList<>();
		users.add(new User("Nikhil","nikhil@skava.com","GUEST"));
		users.add(new User("Nidha","nidha@skava.com","ADMIN"));
		users.add(new User("Komal","komal@skava.com","ADMIN"));
		model.addAttribute("users", users);
		return "if-unless";
	}
	@GetMapping("/switch-case")	
	public String switchExample(Model model) {
		User user = new User("Nikhil","nikhil@skava.com","ADMIN");
		model.addAttribute("user",user);
		return "switch-case";
	}
	@RequestMapping("/")
	public String tableData(Model model) {
		model.addAttribute("notes", dataRepo.findAll());
		return "table-data";
	}
    @RequestMapping("/deleteNote/{number}")
    public String deleteData(@PathVariable Integer number) {
    	dataService.deleteData(number);
    	return "redirect:/";
    }
    @RequestMapping("/createNoteForm")
    public String createNoteForm(Model model) {
    	Data data =new Data();
    	model.addAttribute("mynote",data);
    	List<String> types = Arrays.asList("Private","Public","Confidential","Highly Confidential");
    	model.addAttribute("types", types);
    	List<String> fields = Arrays.asList("Home","Work","Personal","Knowledge",
    			"Philosophy","Others");
    	model.addAttribute("fields", fields);
    	return "new_note";
    	
    }
    @PostMapping("/saveNote")
	public String saveNote(@ModelAttribute("mynote") Data mynote){
    	
    	dataService.addNote(mynote);
    	return "redirect:/" ;
    }
    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute("mynote") Data mynote) {
    	dataService.updateNote(mynote);
    	return "redirect:/" ;
    }
    
    @RequestMapping("/updateNoteForm/{number}")
    public String updateNoteForm(@PathVariable Integer number, Model model) {
    	Data mynote = dataService.getNoteById(number);
    	model.addAttribute("mynote",mynote);
    	//System.out.println(mynote.getNumber());
    	List<String> types = Arrays.asList("Private","Public","Confidential","Highly Confidential");
    	model.addAttribute("types", types);
    	List<String> fields = Arrays.asList("Home","Work","Personal","Knowledge",
    			"Philosophy","Others");
    	model.addAttribute("fields", fields);
    	return "update_note";
    }
		
	
	
}
