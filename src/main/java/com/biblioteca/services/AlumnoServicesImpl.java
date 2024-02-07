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
    public String buscarAlumno(Long id) {

        AlumnoEntity alumnoEntity = alumnoDAO.finbyDni(id);

        if (alumnoEntity == null) return "El alumno no esta en el sistema";
        else return "El alumno se encuentra en el sistema";
    }
}
