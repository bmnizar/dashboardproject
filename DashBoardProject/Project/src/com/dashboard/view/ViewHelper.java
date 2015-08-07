package com.dashboard.view;

import com.dashboard.model.BankAccount;
import com.dashboard.model.PhysicalPerson;

public class ViewHelper {

	public static PhysicalPersonBean seralizeToViewPhysicalPerson(PhysicalPerson physicalPerson) {
		PhysicalPersonBean physicalPersonBean = new PhysicalPersonBean();
		physicalPersonBean.setLocation(physicalPerson.getLocation());
		physicalPersonBean.setFirstName(physicalPerson.getFirstName());
		physicalPersonBean.setLastName(physicalPerson.getLastName());
		physicalPersonBean.setDateOfBirth(physicalPerson.getDateOfBirth());
		physicalPersonBean.setBankAccountRank(physicalPerson.getBankAccountRank());
		BankAccount bankAccount = physicalPerson.getBankAccount();
		if (bankAccount != null) {
			BankAccountBean bankAccountBean = seralizeToViewBankAccount(bankAccount);

			physicalPersonBean.setBankAccountBean(bankAccountBean);

		}
		return physicalPersonBean;
	}

	public static com.dashboard.view.BankAccountBean seralizeToViewBankAccount(
			BankAccount bankAccount) {
		BankAccountBean bankAccountBean = new BankAccountBean();
		bankAccountBean.setAmount(bankAccount.getAmount().toString());
		bankAccountBean
				.setBankAccountStatus(bankAccount.getBankAccountStatus());
		bankAccountBean.setMaxAllowedRedAmount(bankAccount    
				.getMaxAllowedRedAmount().toString());
		bankAccountBean.setDateOfCreation(bankAccount.getDateOfCreation());
		return bankAccountBean;
	}

}
