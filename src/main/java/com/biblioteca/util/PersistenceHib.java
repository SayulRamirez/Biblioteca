package com.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("all")
public class PersistenceHib {

    private static EntityManagerFactory emf;
    private static EntityManager manager;

    private PersistenceHib() {}

    private static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {

            emf = Persistence.createEntityManagerFactory("Persistencia");
        }

        return emf;
    }

    public static EntityManager getEntityManager() {

        if (manager == null) {
            return manager = getEntityManagerFactory().createEntityManager();
        }

        return manager;
    }

    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
