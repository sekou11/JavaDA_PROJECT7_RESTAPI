package com.nnk.springboot.domain;

import java.sql.Date;

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
@Table(name = "bidlist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BidList {
	// TODO: Map columns in data table BIDLIST with corresponding java fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
	private Integer bidListId;

	@NotBlank(message = "Account is mandatory")
	private String account;

	@NotBlank(message = "Type is mandatory")
	private String type;

	@NotNull
	private Double bidQuantity;

	private Double askQuantity;

	private Double bid;

	private Double ask;

	private String benchmark;

	private Date bidListDate;

	private String commentary;

	private String security;

	private String status;

	private String trader;

	private String book;

	private String creationName;
	private Date creationDate;
	private String revisionName;
	private Date revisionDate;
	private String dealName;
	private String sourceListId;
	private String side;

	public BidList(String account, String type, double bidQuantity) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

}
