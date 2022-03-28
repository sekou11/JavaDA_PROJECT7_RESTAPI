package com.nnk.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nnk.springboot.security.OAuth.CustomOAuth2UserService;



@Configuration
@EnableWebSecurity

public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	

    @Autowired
    private UserDetailsService userDetailsService;
    
    
    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/js/**","/css/**", "/img/**","/favicon.ico").permitAll() 
    	.antMatchers("/", "/user/**", "/app/login").permitAll() 
    	.antMatchers("/bidList/**", "/curvePoint/**", "/rating/**", "/ruleName/**", "/trade/**", "/app/secure/**").authenticated()
    	.antMatchers("/admin/**").hasAnyAuthority("ADMIN") 
    	.anyRequest().denyAll()
    	.and()
    	.formLogin().permitAll().defaultSuccessUrl("/bidList/list")
    	.and()
    	.oauth2Login() 
			.userInfoEndpoint().userService(customOAuth2UserService)
			.and()
			.defaultSuccessUrl("/bidList/list")				
		.and()
    	.logout().logoutUrl("/app-logout").logoutSuccessUrl("/").permitAll()
         ;
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
