package com.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHib {

    private static EntityManagerFactory emf;

    private PersistenceHib() {}

    public static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {

            emf = Persistence.createEntityManagerFactory("Persistencia");
        }

        return emf;
    }

    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
