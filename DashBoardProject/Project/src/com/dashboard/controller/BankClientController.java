package com.dashboard.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.internal.SessionImpl;

import com.dashboard.model.BankAccount;
import com.dashboard.model.MoralPerson;
import com.dashboard.model.PhysicalPerson;
import com.dashboard.model.helper.EntityManagerHelper;
import com.dashboard.view.BankAccountBean;
import com.dashboard.view.moralPerson.MoralPersonBean;
import com.dashboard.view.physicalPerson.PhysicalPersonBean;

public class BankClientController {

	public static void savePhysicalPerson(PhysicalPersonBean physicalPersonBean) {
		Calendar instance = Calendar.getInstance();
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		PhysicalPerson physicalPerson = new PhysicalPerson();
		physicalPerson.setFirstName(physicalPersonBean.getFirstName());
		physicalPerson.setLastName(physicalPersonBean.getLastName());
		physicalPerson.setJob(physicalPersonBean.getJob());
		physicalPerson.setDateOfBirth(physicalPersonBean.getDateOfBirth());
		physicalPerson.setDateOfCreation(instance.getTime());
		BankAccountBean bankAccountBean = physicalPersonBean
				.getBankAccountBean();
		BankAccount bankAccount = new BankAccount();
		bankAccount.setMaxAllowedRedAmount(new BigDecimal(bankAccountBean
				.getMaxAllowedRedAmount()));
		Date dateOfCreation = Calendar.getInstance().getTime();
		bankAccount.setDateOfCreation(dateOfCreation);
		bankAccount.setAmount(new BigDecimal(bankAccountBean.getAmount()));
		physicalPerson.setBankAccount(bankAccount);
		EntityManagerHelper.beginTransaction();
		entityManager.persist(physicalPerson);
		EntityManagerHelper.commit();

	}

	public static void saveMoralPerson(MoralPersonBean moralPersonBean) {
		Calendar instance = Calendar.getInstance();
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		MoralPerson moralPerson = new MoralPerson();
		moralPerson.setName(moralPersonBean.getName());

		moralPerson.setDateOfCreation(instance.getTime());
		BankAccountBean bankAccountBean = moralPersonBean.getBankAccountBean();
		BankAccount bankAccount = new BankAccount();
		bankAccount.setMaxAllowedRedAmount(new BigDecimal(bankAccountBean
				.getMaxAllowedRedAmount()));
		Date dateOfCreation = Calendar.getInstance().getTime();
		bankAccount.setDateOfCreation(dateOfCreation);
		bankAccount.setAmount(new BigDecimal(bankAccountBean.getAmount()));
		moralPerson.setBankAccount(bankAccount);
		EntityManagerHelper.beginTransaction();
		entityManager.persist(moralPerson);
		EntityManagerHelper.commit();

	}

	@SuppressWarnings("unchecked")
	public static List<PhysicalPerson> getAllPhysicalPerson() {
		SessionImpl sessionImpl = (SessionImpl) EntityManagerHelper
				.getEntityManager().getDelegate();
		List<PhysicalPerson> list = sessionImpl.createCriteria(
				PhysicalPerson.class).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public static List<PhysicalPerson> getAllMoralPerson() {
		SessionImpl sessionImpl = (SessionImpl) EntityManagerHelper
				.getEntityManager().getDelegate();
		List<PhysicalPerson> list = sessionImpl.createCriteria(
				PhysicalPerson.class).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public static List<PhysicalPerson> getAllPhysicalPersonByPaging(int first,
			int pageSize) {
		SessionImpl sessionImpl = (SessionImpl) EntityManagerHelper
				.getEntityManager().getDelegate();
		Criteria createCriteria = sessionImpl
				.createCriteria(PhysicalPerson.class);

		createCriteria.setFirstResult(first);
		createCriteria.setMaxResults(pageSize);
		List<PhysicalPerson> list = createCriteria.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public static List<MoralPerson> getAllMoralPersonByPaging(int first,
			int pageSize) {
		SessionImpl sessionImpl = (SessionImpl) EntityManagerHelper
				.getEntityManager().getDelegate();
		Criteria createCriteria = sessionImpl
				.createCriteria(MoralPerson.class);

		createCriteria.setFirstResult(first);
		createCriteria.setMaxResults(pageSize);
		List<MoralPerson> list = createCriteria.list();
		return list;
	}
}
