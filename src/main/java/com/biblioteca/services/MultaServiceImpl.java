package com.biblioteca.services;

import com.biblioteca.dao.MultaDAOImpl;
import com.biblioteca.dao.interfaces.MultaDAO;
import com.biblioteca.entities.MultaEntity;
import com.biblioteca.model.Multa;
import com.biblioteca.services.interfaces.MultaService;

public class MultaServiceImpl implements MultaService {

    private final MultaDAO multaDAO;

    public MultaServiceImpl(){
        multaDAO = new MultaDAOImpl();
    }

    @Override
    public Multa buscarMultaPorAlumno(long dni) {

        MultaEntity multaEntity = multaDAO.buscarMultaPorAlumno(dni);

        if (multaEntity == null) return null;

        return new Multa(
                multaEntity.getId(),
                multaEntity.getMotivo(),
                null,
                multaEntity.getInicioMulta(),
                null,
                null
        );
    }
}
