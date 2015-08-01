package com.dashboard.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.dashboard.controller.BankClientController;
import com.dashboard.model.BankClient;

@ManagedBean()
@ApplicationScoped
public class SearchBankClientView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<BankClientBean> filteredBankClient;

	public String returnToMainMenu(ActionEvent actionEvent) {
		return "index.html";
	}

	public List<BankClientBean> getlistOfBankClient() {
		List<BankClient> allBankClients = BankClientController
				.getAllBankClients();
		List<BankClientBean> listOfBankClient = new ArrayList<>();
		for (BankClient bankClient : allBankClients) {
			BankClientBean bankClientBean = ViewHelper
					.seralizeToViewBankClient(bankClient);
			listOfBankClient.add(bankClientBean);
		}
		return listOfBankClient;
	}

	public List<BankClientBean> getFilteredBankClient() {
		return filteredBankClient;
	}

	public void setFilteredBankClient(List<BankClientBean> filteredBankClient) {
		this.filteredBankClient = filteredBankClient;
	}

}
