package com.dashboard.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long number;

	private BigDecimal amount;
	
	private BigDecimal maxAllowedRedAmount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfCreation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfClosing;
	private BankAccountStatus bankAccountStatus=BankAccountStatus.Open;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	

	public BigDecimal getMaxAllowedRedAmount() {
		return maxAllowedRedAmount;
	}

	public void setMaxAllowedRedAmount(BigDecimal maxAllowedRedAmount) {
		this.maxAllowedRedAmount = maxAllowedRedAmount;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public BankAccountStatus getBankAccountStatus() {
		return bankAccountStatus;
	}

	public void setBankAccountStatus(BankAccountStatus bankAccountStatus) {
		this.bankAccountStatus = bankAccountStatus;
	}

	public Date getDateOfClosing() {
		return dateOfClosing;
	}

	public void setDateOfClosing(Date dateOfClosing) {
		this.dateOfClosing = dateOfClosing;
	}

}
