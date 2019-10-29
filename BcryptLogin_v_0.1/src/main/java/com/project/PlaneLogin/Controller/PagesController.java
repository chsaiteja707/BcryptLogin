package com.project.PlaneLogin.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.PlaneLogin.Entity.Customer;
import com.project.PlaneLogin.Service.CustomerService;

@Controller
@RequestMapping("/pages")
public class PagesController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/loginpage")
	public String showMyLoginPage() {
		return "login";
	}
	
	@GetMapping("/securedHome")
	public String securedHomePage() {
		return "securedHome";
	}
		
	@GetMapping("/getusers")
	public String getUsers(Model model) {
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "userlist";
	}
	
	@GetMapping("/addcustomer")
	public String showAddCustomer(Model model) {
		model.addAttribute("customer",new Customer());
		return "addcustomer";
	}
	
	@PostMapping("/postadd")
	public String postAdd(@ModelAttribute("customer") Customer customer) {
		
		customerService.addCustomer(customer);
		return "redirect:/pages/getusers";
		
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer=customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "addcustomer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/pages/getusers";
	}
	
	@PostMapping("/upload")
	public String addToDbFromFile(@RequestParam("file") MultipartFile file, Model model) {
		customerService.addCustomerFile(file);
		model.addAttribute("filetype",customerService.getContentTypeFromService(file));
		return "securedHome";
	}
	
}
