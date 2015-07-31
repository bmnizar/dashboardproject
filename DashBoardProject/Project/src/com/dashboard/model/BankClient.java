package com.dashboard.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BankClient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfCreation;
	private BankClientRank bankAccountRank;
	private String job;
	private String location;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<BankLoan> bankLoans;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

}
