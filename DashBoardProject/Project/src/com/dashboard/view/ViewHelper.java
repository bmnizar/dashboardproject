package com.dashboard.view;

import com.dashboard.model.BankAccount;
import com.dashboard.model.BankClient;

public class ViewHelper {

	public static BankClientBean seralizeToViewBankClient(BankClient bankClient) {
		BankClientBean bankClientBean = new BankClientBean();
		bankClientBean.setLocation(bankClient.getLocation());
		bankClientBean.setFirstName(bankClient.getFirstName());
		bankClientBean.setLastName(bankClient.getLastName());
		bankClientBean.setDateOfBirth(bankClient.getDateOfBirth());
		bankClientBean.setBankAccountRank(bankClient.getBankAccountRank());
		BankAccount bankAccount = bankClient.getBankAccount();
		if (bankAccount != null) {
			BankAccountBean bankAccountBean = seralizeToViewBankAccount(bankAccount);

			bankClientBean.setBankAccountBean(bankAccountBean);

		}
		return bankClientBean;
	}

	public static com.dashboard.view.BankAccountBean seralizeToViewBankAccount(
			BankAccount bankAccount) {
		BankAccountBean bankAccountBean = new BankAccountBean();
		bankAccountBean.setAmount(bankAccount.getAmount().toString());
		bankAccountBean
				.setBankAccountStatus(bankAccount.getBankAccountStatus());
		bankAccountBean.setMaxAllowedRedAmount(bankAccount
				.getMaxAllowedRedAmount().toString());
		return bankAccountBean;
	}

}
