package com.nnk.springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "trade")
public class Trade {
    // TODO: Map columns in data table TRADE with corresponding java fields
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TradeId;
	private String  account;
	private String type;
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
	
	public Trade() {
	
	}

	public Trade(Integer tradeId, String account, String type, Double buyQuantity, Double sellQuantity, Double buyPrice,
			Double sellPrice, Date tradeDate, String security, String status, String trader, String benchmark,
			String book, String creationName, Date creationDate, String revisionName, Date revisionDate,
			String dealName, String dealType, String sourceListId, String side) {
		super();
		TradeId = tradeId;
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
		this.sellQuantity = sellQuantity;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.tradeDate = tradeDate;
		this.security = security;
		this.status = status;
		this.trader = trader;
		this.benchmark = benchmark;
		this.book = book;
		this.creationName = creationName;
		this.creationDate = creationDate;
		this.revisionName = revisionName;
		this.revisionDate = revisionDate;
		this.dealName = dealName;
		this.dealType = dealType;
		this.sourceListId = sourceListId;
		this.side = side;
	}

	public Trade(String account, String type) {
		this.account = account;
		this.type = type;
	}

	public Integer getTradeId() {
		return TradeId;
	}

	public void setTradeId(Integer tradeId) {
		TradeId = tradeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	
	
}
	
	
	
	  
	  
	
	

	 
	
	  
