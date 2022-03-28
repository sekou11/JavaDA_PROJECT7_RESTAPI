package com.nnk.springboot.security.OAuth;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User {
	 
	Logger logger = LoggerFactory.getLogger(CustomOAuth2User.class);
	
    private OAuth2User oauth2User;
     
    public CustomOAuth2User(OAuth2User oauth2User) {
    	logger.debug("Constructor CustomOAuth2User");
    	
    	this.oauth2User = oauth2User;
        
    }
 
    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }
 
    @Override
    public String getName() {
        return oauth2User.getAttribute("login");
    }
 
}