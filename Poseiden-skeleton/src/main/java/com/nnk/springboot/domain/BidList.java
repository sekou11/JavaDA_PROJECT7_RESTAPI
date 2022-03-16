package com.nnk.springboot.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bidlist")

public class BidList {
	// TODO: Map columns in data table BIDLIST with corresponding java fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer BidListId ;
	private String account;
	private String type;
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

	public BidList() {

	}

	public BidList(String account, String type, double bidQuantity) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

	public Integer getBidListId() {
		return BidListId;
	}

	public void setBidListId(Integer bidListId) {
		BidListId = bidListId;
	}

	public Double getBidQuantity() {
		return bidQuantity;
	}

	public void setBidQuantity(Double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}

	
	
	
	

	




}
