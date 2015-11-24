package com.dashboard.view.physicalPerson;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.BankClientRank;
import com.dashboard.view.BankAccountBean;
import com.dashboard.view.GenericPersonBean;

@ManagedBean()
@SessionScoped
public class PhysicalPersonBean extends GenericPersonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void savePhysicalperson(ActionEvent actionEvent) {

		BankClientController.savePhysicalPerson(this);
		addMessage("Physical Person  saved with success");
	}

	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	private String job;

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {

		return id.toString();
	}
}
