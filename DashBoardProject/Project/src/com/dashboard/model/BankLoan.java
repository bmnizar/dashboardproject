package com.dashboard.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankLoan {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal amountOfLoan;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmountOfLoan() {
		return amountOfLoan;
	}
	public void setAmountOfLoan(BigDecimal amountOfLoan) {
		this.amountOfLoan = amountOfLoan;
	}

}
