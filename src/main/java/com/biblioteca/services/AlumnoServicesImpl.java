package com.biblioteca.services;

import com.biblioteca.dao.AlumnoDAOImpl;
import com.biblioteca.dao.interfaces.AlumnoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.model.Alumno;
import com.biblioteca.services.interfaces.AlumnoServices;

public class AlumnoServicesImpl implements AlumnoServices {

    private final AlumnoDAO alumnoDAO;

    public AlumnoServicesImpl() {
        alumnoDAO = new AlumnoDAOImpl();
    }
    @Override
    public Alumno buscarAlumno(Long id) {

        AlumnoEntity alumnoEntity = alumnoDAO.finbyDni(id);

        if (alumnoEntity == null) return null;

        return new Alumno(alumnoEntity.getDni(), alumnoEntity.getNombre(), alumnoEntity.getApellido(), alumnoEntity.getPeriodo(), alumnoEntity.getGrupo());
    }
}
