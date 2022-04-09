package com.nnk.springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "trade")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Trade {

	// TODO: Map columns in data table TRADE with corresponding java fields
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@NotNull
	private Integer tradeId;
	
	@NotBlank(message ="account is mandatory" )
	private String  account;
	
	@NotBlank(message ="type is mandatory" )
	private String type;
	
	@NotNull
	private Double buyQuantity;
	private Double sellQuantity;
	private Double buyPrice;
	private Double sellPrice;
	private Date tradeDate;
	
	private String security;
	private String  status;
	private String trader;
	private String benchmark;
	private String   book;
	private String creationName;
	private Date creationDate;
	private String revisionName;
	private Date revisionDate;
	
	private String dealName;
	private String dealType; 
	private String sourceListId; 
	private String side;
	
	public Trade(String account, String type) {
		super();
		this.account = account;
		this.type = type;
	}
	

	


	public Trade(@NotBlank(message = "account is mandatory") String account,
			@NotBlank(message = "type is mandatory") String type,
			@NotNull Double buyQuantity) {
		super();
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
	}
	
	
	
	
	

	

	
	
	
	
	
}
	
	
	
	  
	  
	
	

	 
	
	  
