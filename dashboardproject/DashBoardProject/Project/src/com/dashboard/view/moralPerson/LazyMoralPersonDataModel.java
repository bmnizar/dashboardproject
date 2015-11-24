package com.dashboard.view.moralPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.MoralPerson;
import com.dashboard.model.PhysicalPerson;
import com.dashboard.view.ViewHelper;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real
 * datasource like a database.
 */
public class LazyMoralPersonDataModel<T extends MoralPersonBean> extends
		LazyDataModel<MoralPersonBean> {

	private static final long serialVersionUID = 1L;
	private List<MoralPersonBean> datasource;

	public LazyMoralPersonDataModel(List<MoralPersonBean> datasource) {
		this.datasource = datasource;
	}

	
	@Override
	public MoralPersonBean getRowData(String rowKey) {
		// TODO Auto-generated method stub
		return super.getRowData(rowKey);
	}

	@Override
	public Object getRowKey(MoralPersonBean oralPersonBean) {
		String id = oralPersonBean.getId().toString();
		return id;
  
	}

	@Override
	public List<MoralPersonBean> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<MoralPerson> allMoralPersons = BankClientController
				.getAllMoralPersonByPaging(first, pageSize);
		List<MoralPersonBean> listOfMoralPerson = new ArrayList<>();
		for (MoralPerson moralPerson : allMoralPersons) {
			MoralPersonBean bankClientBean = ViewHelper
					.seralizeToViewMoralPerson(moralPerson);
			listOfMoralPerson.add(bankClientBean);
		}
		Integer totalNumberOfMoralPersons = BankClientController.getTotalNumberOfMoralPersons();
		this.setRowCount(totalNumberOfMoralPersons);
		return listOfMoralPerson;
	}

	public List<MoralPersonBean> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<MoralPersonBean> datasource) {
		this.datasource = datasource;
	}

}