package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.AlumnoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.*;

@SuppressWarnings("all")
public class AlumnoDAOImpl implements AlumnoDAO {

    private EntityManager manager;

    public AlumnoDAOImpl() {
        manager = PersistenceHib.getEntityManager();
    }

    @Override
    public AlumnoEntity finbyDni(Long dni) {

        try {
            AlumnoEntity alumnoEntity = manager.find(AlumnoEntity.class, dni);

            if (alumnoEntity == null) return null;

            Long dniEncontrado = alumnoEntity.getDni();

            StoredProcedureQuery query = manager.createStoredProcedureQuery("tieneMultaActiva");

            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);

            query.setParameter(1, dniEncontrado);

            boolean execute = query.execute();

            if (!execute) {
                JOptionPane.showMessageDialog(null, "El alumno tiene multas, no puede realizar prestamos");
                throw new RuntimeException();
            }

            return alumnoEntity;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
        return null;
    }
}
