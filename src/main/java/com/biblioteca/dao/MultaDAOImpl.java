package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.MultaDAO;
import com.biblioteca.entities.MultaEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MultaDAOImpl implements MultaDAO {

    @Override
    public MultaEntity buscarMultaPorAlumno(long dni) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {

            TypedQuery<MultaEntity> query = manager.createQuery(
                    "select e.id, e.finMulta, e.estado from MultaEntity e where e.alumno.id =: id and e.estado = true", MultaEntity.class);

            return query.getSingleResult();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
