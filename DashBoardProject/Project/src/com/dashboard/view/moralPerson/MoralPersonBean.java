package com.dashboard.view.moralPerson;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;
import com.dashboard.view.BankAccountBean;
import com.dashboard.view.GenericPersonBean;

@ManagedBean()
@SessionScoped
public class MoralPersonBean extends GenericPersonBean {

	private static final long serialVersionUID = 1L;

	private BankAccountBean bankAccountBean = new BankAccountBean();

	private String name;
	private String registrationId;
	private Date dateOfExpiry;
	private Date dateOfCreation;

	public void saveMoralPerson(ActionEvent actionEvent) {

		BankClientController.saveMoralPerson(this);
		addMessage("Moral Person  saved with success");
	}

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

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public BankAccountBean getBankAccountBean() {
		return bankAccountBean;
	}

	public void setBankAccountBean(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
