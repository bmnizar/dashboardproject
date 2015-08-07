package com.dashboard.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String location;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<BankLoan> bankLoans;

	@OneToOne(cascade = CascadeType.PERSIST, optional = false)
	private BankAccount bankAccount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfCreation;
	private BankClientRank bankAccountRank = BankClientRank.Normal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<BankLoan> getBankLoans() {
		return bankLoans;
	}

	public void setBankLoans(Set<BankLoan> bankLoans) {
		this.bankLoans = bankLoans;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public BankClientRank getBankAccountRank() {
		return bankAccountRank;
	}

	public void setBankAccountRank(BankClientRank bankAccountRank) {
		this.bankAccountRank = bankAccountRank;
	}

}
