package com.dashboard.view.moralPerson;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.dashboard.model.PhysicalPerson;

public class LazySorterMoralPerson implements Comparator<PhysicalPerson> {

	private String sortField;

	private SortOrder sortOrder;

	public LazySorterMoralPerson(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(PhysicalPerson o1, PhysicalPerson o2) {
		int compareTo = o1.getId().compareTo(o2.getId());
		return compareTo;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

}