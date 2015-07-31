package com.dashboard.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean()
@ApplicationScoped
public class SearchBankClientView {
	public List<BankClientBean> getlistOfBankClient() {
		List<BankClientBean> listOfBankClient= new ArrayList<>();
		return listOfBankClient;
	}
	public List<BankClientBean> getFilteredBankClient() {
		List<BankClientBean> listOfBankClient= new ArrayList<>();
		return listOfBankClient;
	}
	

}
