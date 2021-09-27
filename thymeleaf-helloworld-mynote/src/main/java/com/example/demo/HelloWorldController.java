package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	@GetMapping("/hello")
	public String Hello(Model model) {
		model.addAttribute("message", "Hello World");
		return "helloworld";
		}
	@GetMapping("/style")
	public String Style() {
		return "add-css-js-demo";
		}
	@GetMapping("/bootstrap")
	public String Bootstrap() {
		return "add-bootstrap";
		}
}
