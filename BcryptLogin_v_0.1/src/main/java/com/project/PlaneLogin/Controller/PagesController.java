package com.project.PlaneLogin.Controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import com.project.PlaneLogin.user.CrmUser;

@Controller
@RequestMapping("/pages")
public class PagesController {
	
	
	@Autowired
	private CustomerService customerService;
	
	/*
	@GetMapping("/loginpage")
	public String showMyLoginPage(Model model) {
		model.addAttribute("crmUser",new CrmUser());
		return "login";
	}
	
	@GetMapping("/securedHome")
	public String securedHomePage(Model model) {
		User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		return "securedHome";
	}
		*/
	@GetMapping("/getusers")
	public String getUsers(Model model) {
		User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "userlist";
	}
	
	@GetMapping("/addcustomer")
	public String showAddCustomer(Model model) {
User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		
		model.addAttribute("customer",new Customer());
		return "addcustomer";
	}
	
	@PostMapping("/postadd")
	public String postAdd(@ModelAttribute("customer") Customer customer, Model model) {
User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		
		customerService.addCustomer(customer);
		return "redirect:/pages/getusers";
		
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		
		Customer customer=customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "addcustomer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		
		customerService.deleteCustomer(id);
		return "redirect:/pages/getusers";
	}
	
	@PostMapping("/upload")
	public String addToDbFromFile(@RequestParam("file") MultipartFile file, Model model) {
User crmUser1=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=crmUser1.getUsername();
		System.out.println(username);
		model.addAttribute("username",username);
		
		customerService.addCustomerFile(file);
		model.addAttribute("filetype",customerService.getContentTypeFromService(file));
		return "securedHome";
	}
	
}
