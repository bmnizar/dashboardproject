package com.dashboard.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long number;

	private BigDecimal amount;
	@OneToOne
	private BankClient bankClient;
	private BigDecimal maxAllowedRedAmount;
	private Date dateOfCreation;
	private BankAccountStatus bankAccountStatus;

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

	public BankClient getBankClient() {
		return bankClient;
	}

	public void setBankClient(BankClient bankClient) {
		this.bankClient = bankClient;
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

}
