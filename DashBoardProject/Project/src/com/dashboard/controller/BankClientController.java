package com.dashboard.controller;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.dashboard.model.BankAccount;
import com.dashboard.model.BankClient;
import com.dashboard.model.helper.EntityManagerHelper;
import com.dashboard.view.BankAccountBean;
import com.dashboard.view.BankClientBean;

public class BankClientController {

	public static void saveClient(BankClientBean bankClientBean) {
		Calendar instance = Calendar.getInstance();
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		BankClient bankClient = new BankClient();
		bankClient.setFirstName(bankClientBean.getFirstName());
		bankClient.setLastName(bankClientBean.getLastName());
		bankClient.setJob(bankClientBean.getJob());
		bankClient.setDateOfBirth(bankClientBean.getDateOfBirth());
		bankClient.setDateOfCreation(instance.getTime());
		BankAccountBean bankAccountBean = bankClientBean.getBankAccountBean();
		BankAccount bankAccount=new BankAccount();
		bankAccount.setMaxAllowedRedAmount(bankAccountBean.getMaxAllowedRedAmount());
		bankAccount.setAmount(bankAccountBean.getAmount());
		bankClient.setBankAccount(bankAccount);
		EntityManagerHelper.beginTransaction();
		entityManager.persist(bankClient);
		EntityManagerHelper.commit();

	}

}
