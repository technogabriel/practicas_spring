package ar.com.spring.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}
	
	@GetMapping("/redirectGoogle")
	public String redirectHome() {
		
		return "redirect:https://www.google.com";
		
	}

}
