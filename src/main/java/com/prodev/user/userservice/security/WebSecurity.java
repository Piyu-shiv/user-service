package com.prodev.user.userservice.security;


import com.prodev.user.userservice.service.UserService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
;


@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public WebSecurity() {
        // TODO Auto-generated constructor stub
    }
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//		return authenticationConfiguration.getAuthenticationManager();
//	}

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//        System.out.println("atleast coming here...in websecurity");
////	http.addFilter(getAuthenticationFilter());
//        http.authorizeHttpRequests().antMatchers("/public/v1/ecom/user/**").permitAll().and().addFilter(getAuthenticationFilter());
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        AuthenticationManager authenticationManager = authenticationManagerBuilder.getOrBuild();
        AuthenticationFilter authFilter = new AuthenticationFilter(userService, env, authenticationManager);
        authFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
// ***************************
        http.csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/users/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()).addFilter(authFilter).authenticationManager(authenticationManager)
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
        DefaultSecurityFilterChain chain = http.getOrBuild();
        return chain;
    }
//    private Filter getAuthenticationFilter() throws Exception {
//        // TODO Auto-generated method stub
//        AuthenticationConfiguration config=new AuthenticationConfiguration();
//        config.
//        AuthenticationFilter auth = new AuthenticationFilter(userService, env, authenticationManager());
//        auth.setFilterProcessesUrl("/public/v1/ecom/user/login");
//	auth.setAuthenticationManager(authenticationManager());
//        return auth;
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // TODO Auto-generated method stub
//        auth.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder);
//    }
}
