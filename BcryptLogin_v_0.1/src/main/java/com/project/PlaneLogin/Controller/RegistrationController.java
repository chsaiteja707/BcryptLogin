
package com.project.PlaneLogin.Controller;

import java.util.List;
import java.util.logging.Logger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.PlaneLogin.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	
	@Autowired
	private JdbcUserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@GetMapping("/signuppage")
	public String signupPage(Model model) {
		model.addAttribute("crmUser", new CrmUser());
		return "signup";
	}
	
	@PostMapping("/postsignup")
	public String postSignup(@ModelAttribute("crmUser") CrmUser crmUser,Model model) {
		logger.warning("in post signup");
		String username=crmUser.getUsername();
		if(userDetailsManager.userExists(username)) {
			logger.warning("existing user name");
			model.addAttribute("user",new CrmUser());
			model.addAttribute("headermsg","Error");
			model.addAttribute("message","user name with "+username+" already exist");
			return "signup";
		}
		
		
		logger.warning("getting to insert");
		//password encryption
		String encodedPassword=passwordEncoder.encode(crmUser.getPassword());
		
		// give user default role of "employee"
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
        String userName=username;
        // create user object (from Spring Security framework)
        User tempUser = new User(userName, encodedPassword, authorities);
        
        // save user in the database
        
        userDetailsManager.createUser(tempUser);	
        logger.warning("inserted");
		return "index";
	}
	
	
	/*
	 //if you need validations also to be performed by a spring
	  * also include the commented part in the CrmUser
	 
	@GetMapping("/signuppage")
	public String signupPage(Model model) {
		model.addAttribute("crmUser", new CrmUser());
		return "signup";
	}
	
	@PostMapping("/postsignup")
	public String postSignup(
				@Valid @ModelAttribute("crmUser") CrmUser crmUser,
				BindingResult bindingResult,
				Model model) {
		logger.warning("in post signup");
		String username=crmUser.getUsername();
		if(bindingResult.hasErrors()) {
			logger.warning("has errors");
			model.addAttribute("user",new CrmUser());
			model.addAttribute("headermsg","Error");
			model.addAttribute("message","user name or password cannot be empty");
			return "signup";
		}
		
		
		else if(userDetailsManager.userExists(username)) {
			logger.warning("existing user name");
			model.addAttribute("user",new CrmUser());
			model.addAttribute("headermsg","Error");
			model.addAttribute("message","user name with "+username+" already exist");
			return "signup";
		}
		
		logger.warning("getting to insert");
		//password encryption
		String encodedPassword=passwordEncoder.encode(crmUser.getPassword());
		//encodedPassword="{bcrypt}"+encodedPassword;
		// give user default role of "employee"
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
        String userName=username;
        // create user object (from Spring Security framework)
        User tempUser = new User(userName, encodedPassword, authorities);
        
        // save user in the database
        
        userDetailsManager.createUser(tempUser);	
        logger.warning("inserted");
		return "index";
	}
	*/
	
}


	

