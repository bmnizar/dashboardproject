package com.dashboard.view.moralPerson;

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
import com.dashboard.model.MoralPerson;
import com.dashboard.model.PhysicalPerson;
import com.dashboard.view.ViewHelper;

@ManagedBean()
@SessionScoped
public class SearchBankAccountMoralPersonView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<MoralPersonBean> filteredMoralPerson;
	private MoralPersonBean selectedMoralPerson;
	private LazyMoralPersonDataModel<MoralPersonBean> lazyModel;
	private Logger logger = LoggerFactory.getLogger(SearchBankAccountMoralPersonView.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostConstruct
	public void init() {
		List<MoralPerson> allMoralPersons = BankClientController.getAllMoralPersonByPaging(0, 10);
		List<MoralPersonBean> listOfMoralPerson = new ArrayList<>();
		for (MoralPerson moralPerson : allMoralPersons) {
			MoralPersonBean bankClientBean = ViewHelper.seralizeToViewMoralPerson(moralPerson);
			listOfMoralPerson.add(bankClientBean);
		}

		lazyModel = new LazyMoralPersonDataModel(listOfMoralPerson);
		logger.debug(lazyModel.toString());
	}

	public List<MoralPersonBean> getFilteredMoralPerson() {
		return filteredMoralPerson;
	}

	public void setFilteredMoralPerson(List<MoralPersonBean> filteredMoralPerson) {
		this.filteredMoralPerson = filteredMoralPerson;
	}

	public MoralPersonBean getSelectedMoralPerson() {
		return selectedMoralPerson;
	}

	public void setSelectedMoralPerson(MoralPersonBean selectedMoralPerson) {
		this.selectedMoralPerson = selectedMoralPerson;
	}

	public LazyMoralPersonDataModel<MoralPersonBean> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyMoralPersonDataModel<MoralPersonBean> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
