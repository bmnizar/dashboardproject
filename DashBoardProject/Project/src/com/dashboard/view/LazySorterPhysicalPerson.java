package com.dashboard.view;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.dashboard.model.PhysicalPerson;
 
public class LazySorterPhysicalPerson implements Comparator<PhysicalPerson> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorterPhysicalPerson(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

	@Override
	public int compare(PhysicalPerson o1, PhysicalPerson o2) {
		int compareTo = o1.getId().compareTo(o2.getId());
		return compareTo;
	}
 
   
}