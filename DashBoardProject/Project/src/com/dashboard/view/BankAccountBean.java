package com.dashboard.view;

import java.math.BigDecimal;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.dashboard.model.BankAccountStatus;

@ManagedBean()
@SessionScoped
public class BankAccountBean {



	private BigDecimal amount;

	private BigDecimal maxAllowedRedAmount;
	private Date dateOfCreation;
	private BankAccountStatus bankAccountStatus;

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

}
