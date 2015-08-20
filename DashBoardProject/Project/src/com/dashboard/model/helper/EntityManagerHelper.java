package com.dashboard.model.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.internal.SessionImpl;

public class EntityManagerHelper {

	private static EntityManagerFactory emf;
	private static ThreadLocal<EntityManager> threadLocal;
	private static EntityManager em;

	public EntityManagerHelper() {
		emf = Persistence
				.createEntityManagerFactory("dashboardPersistenceUnit");
		threadLocal = new ThreadLocal<EntityManager>();
	}
	public static SessionImpl getSession() {
		if (em== null) {
			getEntityManager();
		}
		SessionImpl sessionImpl = (org.hibernate.internal.SessionImpl) em
				.getDelegate();
		return sessionImpl;

	}

	public static EntityManager getEntityManager() {
		EntityManager em = threadLocal.get();

		if (em == null) {
			em = emf.createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}
	

	public static void closeEntityManager() {
		EntityManager em = threadLocal.get();
		if (em != null) {
			em.close();
			threadLocal.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		emf.close();
	}

	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public static void rollback() {
		getEntityManager().getTransaction().rollback();
	}

	public static void commit() {
		getEntityManager().getTransaction().commit();
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static ThreadLocal<EntityManager> getThreadlocal() {
		return threadLocal;
	}

}