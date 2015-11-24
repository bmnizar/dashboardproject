package com.dashboard.test;

import javax.persistence.EntityManager;

import com.dashboard.model.helper.EntityManagerHelper;

public class TestModel {

	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.close();

	}

}
