package com.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankUser {

	@Id
	private Integer cin;
	private String login;
	private String password;

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getUsername() {
		return login;
	}

	public void setUsername(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
