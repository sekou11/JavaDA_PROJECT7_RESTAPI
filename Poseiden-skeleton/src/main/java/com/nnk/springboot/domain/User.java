package com.nnk.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.nnk.springboot.domain.Validation.ValidPassword;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "Username is mandatory")
	@Column(name = "user_name", unique = true)
	private String username;

	@ValidPassword
	private String password;

	@NotBlank(message = "FullName is mandatory")
	private String fullname;
	
	private String roles;
	
	@Enumerated(EnumType.STRING)
	private Provider provider;



	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(Integer id, @NotBlank(message = "Username is mandatory") String username, String password,
		@NotBlank(message = "FullName is mandatory") String fullname, String roles) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.fullname = fullname;
	this.roles = roles;
}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
	}



	public Provider getProvider() {
		return provider;
	}



	public void setProvider(Provider provider) {
		this.provider = provider;
	}



	
}
