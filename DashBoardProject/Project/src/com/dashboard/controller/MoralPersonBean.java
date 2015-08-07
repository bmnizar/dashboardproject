package com.dashboard.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.dashboard.view.BankAccountBean;
import com.dashboard.view.GenericPersonBean;

@ManagedBean()
@SessionScoped
public class MoralPersonBean extends GenericPersonBean {
	public void saveBankClient(ActionEvent actionEvent) {

		BankClientController.saveMoralPerson(this);
		addMessage("Moral Person  saved with success");
	}

	private BankAccountBean bankAccountBean = new BankAccountBean();
	private String name;
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
	
	
	
}
