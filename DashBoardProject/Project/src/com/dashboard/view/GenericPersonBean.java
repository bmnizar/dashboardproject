package com.dashboard.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.dashboard.model.BankClientRank;

public class GenericPersonBean implements Serializable{

	private static final long serialVersionUID = 1L;
	protected Long id;
	protected String location;
	protected BankClientRank bankAccountRank = BankClientRank.Normal;
	protected BankAccountBean bankAccountBean = new BankAccountBean();
	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected",
						format.format(event.getObject())));
	}

	public String returnToMainMenu(ActionEvent actionEvent) {
		return "index.html";
	}
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

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

	public BankClientRank getBankAccountRank() {
		return bankAccountRank;
	}

	public void setBankAccountRank(BankClientRank bankAccountRank) {
		this.bankAccountRank = bankAccountRank;
	}

	public BankAccountBean getBankAccountBean() {
		return bankAccountBean;
	}

	public void setBankAccountBean(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}
	
	
}
