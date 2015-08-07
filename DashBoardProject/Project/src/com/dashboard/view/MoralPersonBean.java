package com.dashboard.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;

@ManagedBean()
@SessionScoped
public class MoralPersonBean extends GenericPersonBean {
	public void saveMoralPerson(ActionEvent actionEvent) {

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
