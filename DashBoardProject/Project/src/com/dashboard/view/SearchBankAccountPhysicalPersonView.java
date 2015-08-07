package com.dashboard.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.BankClient;
import com.dashboard.model.PhysicalPerson;

@ManagedBean()
@ApplicationScoped
public class SearchBankAccountPhysicalPersonView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<PhysicalPersonBean> filteredBankClient;

	public String returnToMainMenu(ActionEvent actionEvent) {
		return "index.html";
	}

	public List<PhysicalPersonBean> getlistOfPhysicalPersonBean() {
		List<PhysicalPerson> allPhysicalPersons = BankClientController
				.getAllPhysicalPerson();
		List<PhysicalPersonBean> listOfPhysicalPerson = new ArrayList<>();
		for (PhysicalPerson physicalPerson : allPhysicalPersons) {
			PhysicalPersonBean bankClientBean = ViewHelper
					.seralizeToViewPhysicalPerson(physicalPerson);
			listOfPhysicalPerson.add(bankClientBean);
		}
		return listOfPhysicalPerson;
	}

	public List<BankClientBean> getFilteredBankClient() {
		return filteredBankClient;
	}

	public void setFilteredBankClient(List<BankClientBean> filteredBankClient) {
		this.filteredBankClient = filteredBankClient;
	}

}
