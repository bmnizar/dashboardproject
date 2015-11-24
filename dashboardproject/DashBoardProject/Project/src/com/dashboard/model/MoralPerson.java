package com.dashboard.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class MoralPerson extends Person {
	private String name;
	private String registrationId;
	private Date dateOfExpiry;

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
