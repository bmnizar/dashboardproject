package com.dashboard.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.PhysicalPerson;

@ManagedBean()
@ApplicationScoped
public class SearchBankAccountPhysicalPersonView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<PhysicalPersonBean> filteredPhysicalPerson;
	private PhysicalPersonBean selectedPhysicalPerson;

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

	public List<PhysicalPersonBean> getFilteredPhysicalPerson() {
		return filteredPhysicalPerson;
	}

	public void setFilteredPhysicalPerson(
			List<PhysicalPersonBean> filteredPhysicalPerson) {
		this.filteredPhysicalPerson = filteredPhysicalPerson;
	}

	public PhysicalPersonBean getSelectedPhysicalPerson() {
		return selectedPhysicalPerson;
	}

	public void setSelectedPhysicalPerson(PhysicalPersonBean selectedPhysicalPerson) {
		this.selectedPhysicalPerson = selectedPhysicalPerson;
	}

}
