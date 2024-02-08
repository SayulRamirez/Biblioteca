package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.LibroDAO;
import com.biblioteca.entities.AutorEntity;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.util.PersistenceHib;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    private List<LibroEntity> libros;


    @Override
    public List<LibroEntity> buscarLibrosPorApellido(String apellido) {
        String procedure = "buscarLibroPorApellido";

        return buscarLibroPorParametro(apellido, procedure);
    }

    @Override
    public List<LibroEntity> buscarLibrosPorNombre(String nombre) {
        String procedure = "buscarLibroPorNombre";

        return buscarLibroPorParametro(nombre, procedure);
    }

    @Override
    public List<LibroEntity> buscarLibrosPorTitulo(String titulo) {
        String procedure = "buscarLibroPorTitulo";

        return buscarLibroPorParametro(titulo, procedure);
    }

    /**
     * Busca el libro por el tipo de procedimiento en la base de datos y lo filtra con el parametro establecido
     * @param parametro {@link String} filtro
     * @param procedure {@link String} procedimeinto almacenado en la base de datos
     * @return Lista de {@link LibroEntity}
     */
    private List<LibroEntity> buscarLibroPorParametro(String parametro, String procedure) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {
            StoredProcedureQuery query = manager.createStoredProcedureQuery(procedure);

            query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);

            query.setParameter(1, parametro);

            query.execute();

            List<Object[]> resultados = query.getResultList();


            if (resultados.isEmpty()) {
                return null;
            }

            libros = new ArrayList<>();

            resultados.forEach(resultado
                    -> libros.add(new LibroEntity(Long.valueOf((Integer) resultado[0]), (String) resultado[1], (Integer) resultado[2],
                    new AutorEntity((String) resultado[3], (String) resultado[4]))));

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            manager.close();
        }
        return libros;
    }

}
