//package com.prodev.user.userservice.security;
//
//import javax.servlet.Filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.prodev.user.userservice.service.UserService;;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private Environment env;
//
//	@Autowired
//	private BCryptPasswordEncoder bcryptPasswordEncoder;
//
//	public WebSecurity() {
//		// TODO Auto-generated constructor stub
//	}
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	// TODO Auto-generated method stub
//	http.csrf().disable();
//	http.headers().frameOptions().disable();
//	System.out.println("atleast coming here...in websecurity");
////	http.addFilter(getAuthenticationFilter());
//	http.authorizeHttpRequests().antMatchers("/public/v1/ecom/user/**").permitAll().and().addFilter(getAuthenticationFilter());
//}
//private Filter getAuthenticationFilter() throws Exception {
//	// TODO Auto-generated method stub
//
//
//	AuthenticationFilter auth =new AuthenticationFilter(userService,env,authenticationManager());
//	auth.setFilterProcessesUrl("/public/v1/ecom/user/login");
////	auth.setAuthenticationManager(authenticationManager());
//	return auth;
//}
//
//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	// TODO Auto-generated method stub
//auth.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder);
//}
//}
