package com.dashboard.view;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.BankClientRank;

@ManagedBean()
@SessionScoped
public class PhysicalPersonBean extends GenericPersonBean implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public void savePhysicalperson(ActionEvent actionEvent) {

		BankClientController.savePhysicalPerson(this);
		addMessage("Physical Person  saved with success");
	}

	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private BankClientRank bankAccountRank;
	private String job;
	private String location;
	private BankAccountBean bankAccountBean = new BankAccountBean();

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

	public BankAccountBean getBankAccountBean() {
		return bankAccountBean;
	}

	public void setBankAccountBean(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public String toString() {

		return id.toString();
	}
}
