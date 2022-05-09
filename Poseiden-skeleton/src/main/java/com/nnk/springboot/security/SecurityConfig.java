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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomOAuth2UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		BCryptPasswordEncoder passwordEncoder = passwordEncoder();
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/" ,"/webjars/**","/user/**").permitAll()  
		//.antMatchers("/admin/**").hasAuthority("ADMIN")
		//.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER", "ROLE_USER")
		.anyRequest().authenticated() // All request have to be authenticate														// authenticated
				.and().formLogin() // UserName_Password session Access
				.defaultSuccessUrl("/bidList/list").and().logout() // logout
				.logoutUrl("/app-logout").logoutSuccessUrl("/")
				.and().oauth2Login() // Token Access
				.defaultSuccessUrl("/trade/list").userInfoEndpoint().userService(userService);

		http.exceptionHandling().accessDeniedPage("/app/error");// page for deny access

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
