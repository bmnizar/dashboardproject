package com.dashboard.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.PhysicalPerson;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real
 * datasource like a database.
 */
public class LazyPhysicalPersonDataModel<T extends PhysicalPersonBean> extends
		LazyDataModel<PhysicalPersonBean> {

	private static final long serialVersionUID = 1L;
	private List<PhysicalPersonBean> datasource;

	public LazyPhysicalPersonDataModel(List<PhysicalPersonBean> datasource) {
		this.datasource = datasource;
	}

	@Override
	public PhysicalPersonBean getRowData(String rowKey) {
		System.out.println();
		return null;
	}

	@Override
	public Object getRowKey(PhysicalPersonBean physicalPersonBean) {
		return physicalPersonBean.getFirstName() + " "
				+ physicalPersonBean.getLastName();

	}

	@Override
	public List<PhysicalPersonBean> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<PhysicalPerson> allPhysicalPersons = BankClientController
				.getAllPhysicalPersonByPaging(first, pageSize);
		List<PhysicalPersonBean> listOfPhysicalPerson = new ArrayList<>();
		for (PhysicalPerson physicalPerson : allPhysicalPersons) {
			PhysicalPersonBean bankClientBean = ViewHelper
					.seralizeToViewPhysicalPerson(physicalPerson);
			listOfPhysicalPerson.add(bankClientBean);
		}
		this.setRowCount(listOfPhysicalPerson.size());
		return listOfPhysicalPerson;
	}

	public List<PhysicalPersonBean> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<PhysicalPersonBean> datasource) {
		this.datasource = datasource;
	}

}