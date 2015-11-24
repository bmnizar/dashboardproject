package com.dashboard.view;

import com.dashboard.model.BankAccount;
import com.dashboard.model.MoralPerson;
import com.dashboard.model.PhysicalPerson;
import com.dashboard.view.moralPerson.MoralPersonBean;
import com.dashboard.view.physicalPerson.PhysicalPersonBean;

public class ViewHelper {

	public static PhysicalPersonBean seralizeToViewPhysicalPerson(PhysicalPerson physicalPerson) {
		PhysicalPersonBean physicalPersonBean = new PhysicalPersonBean();
		physicalPersonBean.setId(physicalPerson.getId());

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

	public static com.dashboard.view.BankAccountBean seralizeToViewBankAccount(BankAccount bankAccount) {
		BankAccountBean bankAccountBean = new BankAccountBean();
		bankAccountBean.setAmount(bankAccount.getAmount().toString());
		bankAccountBean.setBankAccountStatus(bankAccount.getBankAccountStatus());
		bankAccountBean.setMaxAllowedRedAmount(bankAccount.getMaxAllowedRedAmount().toString());
		bankAccountBean.setDateOfCreation(bankAccount.getDateOfCreation());
		return bankAccountBean;
	}

	/**
	 * @param moralPerson
	 * @return
	 */
	public static MoralPersonBean seralizeToViewMoralPerson(MoralPerson moralPerson) {
		MoralPersonBean moralPersonBean = new MoralPersonBean();
		moralPersonBean.setId(moralPerson.getId());
		moralPersonBean.setName(moralPerson.getName());
		moralPersonBean.setLocation(moralPerson.getLocation()); 
		moralPersonBean.setDateOfCreation(moralPerson.getDateOfCreation());
		moralPersonBean.setRegistrationId(moralPerson.getRegistrationId());
		moralPersonBean.setDateOfExpiry(moralPerson.getDateOfExpiry());
		moralPersonBean.setBankAccountRank(moralPerson.getBankAccountRank());
		BankAccount bankAccount = moralPerson.getBankAccount();
		if (bankAccount != null) {
			BankAccountBean bankAccountBean = seralizeToViewBankAccount(bankAccount);

			moralPersonBean.setBankAccountBean(bankAccountBean);

		}
		return moralPersonBean;
	}

}
