package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.PrestamoDAO;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.entities.PrestamoEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

public class PrestamoDAOImpl implements PrestamoDAO {

    @Override
    public Long realizarPrestamo(PrestamoEntity prestamoEntity) {

        Long folio;

        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {
            manager.getTransaction().begin();

            manager.persist(prestamoEntity);

            folio = prestamoEntity.getId();

            LibroEntity libro = prestamoEntity.getLibro();

            Integer numeroExistencias = libro.getNumeroExistencias();
            libro.setNumeroExistencias(numeroExistencias - 1);

            manager.merge(libro);

            manager.getTransaction().commit();
        } catch (IllegalStateException | EntityExistsException e) {

            manager.getTransaction().rollback();
            System.out.println("Ocurrio un error: " + e.getMessage());
            return null;
        } finally {
            manager.close();
        }

        return folio;
    }
}
