package com.project.PlaneLogin.SecurityConfigurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.project.PlaneLogin.user.CrmUser;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationSetup extends WebSecurityConfigurerAdapter {
	
	
	
	
	@Autowired
	private DataSource dataSource;

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	// Enable jdbc authentication
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			//.passwordEncoder(new BCryptPasswordEncoder());
			.passwordEncoder(passwordEncoder());	//to call with a bean
	}

	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}
	
	/*
	 //in memory authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("sai").password("sai123").roles("EMPLOYEE"))
			.withUser(users.username("teja").password("teja123").roles("MANAGER"))
			.withUser(users.username("ravi").password("ravi123").roles("ADMIN"));
	}
	
	*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/index").permitAll()
		.antMatchers("/pages/signuppage").permitAll()
		.antMatchers("/pages/getusers").hasAnyRole("EMPLOYEE", "MANAGER")
		.antMatchers("/login/securedHome").hasAnyRole("EMPLOYEE", "MANAGER")	//if we don't keep this we will be directed to the secured home page by typing the url without any authentication
		.and()
		.formLogin()
				.loginPage("/login/loginpage")
				.loginProcessingUrl("/authenticateTheUser")
				//.successForwardUrl("/pages/securedHome")	//don't use this as we are getting
				
				.defaultSuccessUrl("/login/securedHome", true) //: if we use this without authentication it is going
				.failureUrl("/pages/loginpage?error=true")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll();
			
	}
	
	
	
	
}
