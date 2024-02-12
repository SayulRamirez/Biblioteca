package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.MultaDAO;
import com.biblioteca.entities.MultaEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.time.LocalDate;

public class MultaDAOImpl implements MultaDAO {

    @Override
    public MultaEntity buscarMultaPorAlumno(long dni) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {

            TypedQuery<MultaEntity> query = manager.createQuery(
                    "from MultaEntity e where e.alumno.id =: id and e.estado = true", MultaEntity.class);

            query.setParameter("id", dni);

            return query.getSingleResult();

        } catch (IllegalArgumentException | NoResultException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void actualizarMultas(LocalDate ahora) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {
            Query query = manager.createQuery("update MultaEntity m set m.estado = true where m.finMulta <=: fecha");

            query.setParameter("fecha", ahora);

            manager.getTransaction().begin();

            int i = query.executeUpdate();

            manager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Se actualizarón " + i + " registros.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}
