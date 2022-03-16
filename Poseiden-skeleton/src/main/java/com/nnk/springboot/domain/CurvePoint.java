package com.nnk.springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	// TODO: Map columns in data table CURVEPOINT with corresponding java fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer curveId;
	private Date asOfDate;
	private Double term;
	private Double value;
	private Date creationDate;

	public CurvePoint() {

	}

	public CurvePoint(Integer id, Integer curveId, Date asOfDate, Double term, Double value, Date creationDate) {
		super();
		this.id = id;
		this.curveId = curveId;
		this.asOfDate = asOfDate;
		this.term = term;
		this.value = value;
		this.creationDate = creationDate;
	}

	public CurvePoint(int curveId, double term, double value) {
		this.curveId = curveId;
		this.term =term;
		this.value =value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCurveId() {
		return curveId;
	}

	public void setCurveId(Integer curveId) {
		this.curveId = curveId;
	}

	public Date getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}

	public Double getTerm() {
		return term;
	}

	public void setTerm(Double term) {
		this.term = term;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	

}
