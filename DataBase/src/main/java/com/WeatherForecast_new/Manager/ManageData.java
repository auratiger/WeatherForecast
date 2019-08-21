package com.WeatherForecast_new.Manager;

import com.WeatherForecast_new.Interfaces.Model;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManageData {
    private static EntityManager entityManager =
            Persistence.createEntityManagerFactory("user-unit").createEntityManager();
    private static EntityTransaction entityTransaction = entityManager.getTransaction();

    private static Logger logger = Logger.getLogger(ManageData.class);

    private static ManageData instance = new ManageData();

    private ManageData() {

    }

    public synchronized static void persist(Model model) {
        beginTransaction();
        entityManager.persist(model);
        commitTransaction();
    }

    public synchronized static void persistAll(Model[] models) {
        beginTransaction();
        for (Model model : models) {
            entityManager.persist(model);
        }
        commitTransaction();
    }

    private static void beginTransaction() {
        try {
            entityTransaction.begin();
            logger.info("Transaction has been opened.");
        } catch (IllegalStateException e) {
            rollBackTransaction();
        }
    }

    private static void commitTransaction() {
        try {
            entityTransaction.commit();
            logger.info("Transaction has been committed.");
        } catch (IllegalStateException e) {
            rollBackTransaction();
        }
    }

    private static void rollBackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            logger.error("Error while handling transaction" + e);
        }
    }
}
