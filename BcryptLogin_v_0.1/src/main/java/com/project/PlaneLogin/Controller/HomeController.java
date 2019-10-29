package com.project.PlaneLogin.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController {	
	
	@RequestMapping("/index")
	public String home() {
		return "home";
	}
	
	

}
