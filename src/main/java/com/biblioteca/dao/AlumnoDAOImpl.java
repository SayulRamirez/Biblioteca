package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.AlumnoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.*;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public AlumnoEntity finbyDni(Long dni) {

        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();


        try {
            AlumnoEntity alumnoEntity = manager.find(AlumnoEntity.class, dni);

            Long dniEncontrado = alumnoEntity.getDni();

            StoredProcedureQuery query = manager.createStoredProcedureQuery("tieneMultaActiva");

            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);

            query.setParameter(1, dniEncontrado);

            boolean execute = query.execute();

            if (execute) {
                JOptionPane.showMessageDialog(null, "El alumno tiene multas, no puede realizar prestamos");
                throw new RuntimeException();
            }

            return alumnoEntity;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        } finally {

            manager.close();
        }
        return null;
    }
}
