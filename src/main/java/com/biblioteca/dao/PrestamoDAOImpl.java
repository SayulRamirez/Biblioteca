package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.PrestamoDAO;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.entities.PrestamoEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String[]> buscarPrestamoPorID(String parametro) {

        String procedure = "buscarPrestamoPorIdLibro";
        return buscarPrestamoPorParametro(parametro, procedure);
    }

    @Override
    public List<String[]> buscarPrestamoPorTitulo(String parametro) {
        String procedure = "buscarPrestamoPorTitulo";
        return buscarPrestamoPorParametro(parametro, procedure);
    }

    private List<String[]> buscarPrestamoPorParametro(String parametro, String procedure) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();
        List<String[]> prestamos = new ArrayList<>();

        try {
            StoredProcedureQuery query = manager.createStoredProcedureQuery(procedure);

            query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);

            query.setParameter(1, parametro);

            query.execute();

            List<Object[]> resultados = query.getResultList();

            if (resultados.isEmpty()) return null;

            resultados.forEach(
                    array -> prestamos.add(
                            new String[]{
                                    String.valueOf(array[0]),
                                    array[1].toString(),
                                    array[2].toString(),
                                    String.valueOf(array[3]),}));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());

        } finally {
            manager.close();
        }
        return prestamos;
    }
}
