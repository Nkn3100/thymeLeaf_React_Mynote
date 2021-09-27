package com.example.demo;

import java.util.ArrayList;

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
    @RequestMapping("/deleteNote/{title}")
    public String deleteData(@PathVariable String title) {
    	String a=dataService.deleteData(title);
    	return "redirect:/";
    }
    @RequestMapping("/createNoteForm")
    public String createNoteForm(Model model) {
    	Data data =new Data();
    	model.addAttribute("mynote",data);
    	return "new_note";
    	
    }
    @PostMapping("/saveNote")
	public String saveNote(@ModelAttribute("mynote") Data mynote){
    	
    	dataService.addNote(mynote);
    	return "redirect:/" ;
    }
    @RequestMapping("/updateNoteForm/{title}")
    public String updateNoteForm(@PathVariable String title, Model model) {
    	Data mynote = dataService.getNoteById(title);
    	model.addAttribute("mynote",mynote);
    	return "update_note";
    }
		
	
	
}
