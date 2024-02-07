package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.AlumnoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityManager;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public AlumnoEntity finbyDni(Long dni) {

        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        AlumnoEntity alumnoEntity = manager.find(AlumnoEntity.class, dni);

        manager.close();

        return alumnoEntity;
    }
}
