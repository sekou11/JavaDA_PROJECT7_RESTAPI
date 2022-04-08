package com.nnk.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nnk.springboot.auth.CustomOAuth2UserService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class webSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private  CustomUserDetailsService customUserDetailsService;
	  
	@Autowired
	private CustomOAuth2UserService userService;
	
	@Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = passwordEncoder();
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/admin/**").hasAnyAuthority("ADMIN") 
    	.antMatchers("/user/**").hasAnyAuthority("ADMIN" ,"USER","ROLE_USER") 
    	.antMatchers("/js/**","/css/**", "/img/**", "/favicon.ico" ,"/webjars/**").permitAll() 
    	.antMatchers("/", "/user/**", "/app/login").permitAll() 
    	.anyRequest().authenticated()
   	.and()
    	.formLogin()
    	.defaultSuccessUrl("/bidList/list")
    	.and()
    	.logout().logoutUrl("/app-logout").logoutSuccessUrl("/")
    	.and()
    	.oauth2Login()
    	.defaultSuccessUrl("/bidList/list")	
		.userInfoEndpoint().userService(userService);
			http.exceptionHandling().accessDeniedPage("/app/error");
    }
}
