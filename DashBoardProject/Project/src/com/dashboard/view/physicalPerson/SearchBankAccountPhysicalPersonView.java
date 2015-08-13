package com.dashboard.view.physicalPerson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.PhysicalPerson;
import com.dashboard.view.ViewHelper;

@ManagedBean()
@SessionScoped
public class SearchBankAccountPhysicalPersonView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<PhysicalPersonBean> filteredPhysicalPerson;
	private PhysicalPersonBean selectedPhysicalPerson;
	private LazyPhysicalPersonDataModel<PhysicalPersonBean> lazyModel;
	private Logger logger = LoggerFactory
			.getLogger(SearchBankAccountPhysicalPersonView.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostConstruct
	public void init() {
		List<PhysicalPerson> allPhysicalPersons = BankClientController
				.getAllPhysicalPersonByPaging(0, 10);
		List<PhysicalPersonBean> listOfPhysicalPerson = new ArrayList<>();
		for (PhysicalPerson physicalPerson : allPhysicalPersons) {
			PhysicalPersonBean bankClientBean = ViewHelper
					.seralizeToViewPhysicalPerson(physicalPerson);
			listOfPhysicalPerson.add(bankClientBean);
		}

		lazyModel = new LazyPhysicalPersonDataModel(listOfPhysicalPerson);
		logger.debug(lazyModel.toString());
	}

	public String returnToMainMenu(ActionEvent actionEvent) {
		return "index.html";
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

	public void setSelectedPhysicalPerson(
			PhysicalPersonBean selectedPhysicalPerson) {
		this.selectedPhysicalPerson = selectedPhysicalPerson;
	}

	public LazyPhysicalPersonDataModel<PhysicalPersonBean> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(
			LazyPhysicalPersonDataModel<PhysicalPersonBean> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
