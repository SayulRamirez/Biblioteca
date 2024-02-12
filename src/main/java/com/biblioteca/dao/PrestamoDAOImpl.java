package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.PrestamoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.entities.MultaEntity;
import com.biblioteca.entities.PrestamoEntity;
import com.biblioteca.util.PersistenceHib;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAOImpl implements PrestamoDAO {

    @Override
    public Long realizarPrestamo(PrestamoEntity prestamoEntity) {
        Long dni = prestamoEntity.getAlumno().getDni();

        puedeRealizarPrestamos(dni);

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
    public List<String[]> buscarPrestamoPorID(Long parametro) {

        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();
        List<String[]> prestamos = new ArrayList<>();

        try {
            StoredProcedureQuery query = manager.createStoredProcedureQuery("buscarPrestamoPorIdLibro");

            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);

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

    @Override
    public List<String[]> buscarPrestamoPorTitulo(String parametro) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();
        List<String[]> prestamos = new ArrayList<>();

        try {
            StoredProcedureQuery query = manager.createStoredProcedureQuery("buscarPrestamoPorTitulo");

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

    @Override
    public String[] buscarPrestamoPorFolio(long folioPrestamo) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {
            StoredProcedureQuery query = manager.createStoredProcedureQuery("buscarPrestamoPorFolio");

            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);

            query.setParameter(1, folioPrestamo);

            query.execute();

            List<Object[]> respuesta = query.getResultList();

            List<String[]> prestamos = new ArrayList<>();

            respuesta.forEach(
                    array -> prestamos.add(
                            new String[]{
                                    String.valueOf(array[0]),
                                    String.valueOf(array[1]),
                                    String.valueOf(array[2]),
                                    (String) array[3],
                                    String.valueOf(array[4])}));


            if (prestamos.size() == 0) return null;

            return prestamos.get(0);

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());

        } finally {
            manager.close();
        }
        return null;

    }

    @Override
    public int actualizarPrestamo(long folioLong) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {
            PrestamoEntity prestamoEntity = manager.find(PrestamoEntity.class, folioLong);

            prestamoEntity.setEstado(false);

            LibroEntity libro = prestamoEntity.getLibro();
            Integer existencias = libro.getNumeroExistencias();
            libro.setNumeroExistencias(existencias + 1);

            manager.getTransaction().begin();

            manager.merge(libro);
            manager.merge(prestamoEntity);

            manager.getTransaction().commit();
            return 1;
        } catch (IllegalArgumentException | TransactionRequiredException e) {

            manager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el prestamo.");
            e.getStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close();
        }
    }

    @Override
    public int actualizarPrestamoMulta(long folio, String motivo, LocalDate fechaInicial, LocalDate fehcaFinal) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {

            PrestamoEntity prestamoEntity = manager.find(PrestamoEntity.class, folio);
            prestamoEntity.setEstado(false);

            AlumnoEntity alumno = prestamoEntity.getAlumno();
            LibroEntity libro = prestamoEntity.getLibro();

            Integer existencias = libro.getNumeroExistencias();
            libro.setNumeroExistencias(existencias + 1);

            MultaEntity multaEntity = new MultaEntity(null, motivo, fechaInicial, fehcaFinal, alumno);

            manager.getTransaction().begin();

            manager.merge(libro);
            manager.merge(prestamoEntity);
            manager.persist(multaEntity);

            manager.getTransaction().commit();
            return 1;
        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException | RollbackException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            manager.getTransaction().rollback();
            return 0;
        } finally {
            manager.close();
        }
    }

    @Override
    public PrestamoEntity buscarPrestamoPorDni(Long dni) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {

            TypedQuery<PrestamoEntity> query = manager.createQuery(
                    "from PrestamoEntity p where p.alumno.dni =: dni and p.estado = true", PrestamoEntity.class);

            query.setParameter("dni", dni);

            return query.getSingleResult();

        } catch (IllegalArgumentException | NoResultException e) {
            System.out.println(e.getMessage());
        } finally {
            manager.close();
        }
        return null;
    }

    private void puedeRealizarPrestamos(Long dni) {
        EntityManager manager = PersistenceHib.getEntityManagerFactory().createEntityManager();

        try {
            TypedQuery<PrestamoDAOImpl> query = manager.createQuery("select p.id from PrestamoEntity p where p.alumno.dni =: dni and p.estado = true", PrestamoDAOImpl.class);
            query.setParameter("dni", dni);

            PrestamoDAOImpl resultado = query.getSingleResult();

            if (resultado != null) {
                JOptionPane.showMessageDialog(null, "El alumno tiene un prestamo pendiente");
                throw new RuntimeException("Tiene prestamo.");
            }

            TypedQuery<MultaEntity> queryMulta = manager.createQuery("select m.id from MultaEntity m where m.alumno.dni =: dni and m.estado = true", MultaEntity.class);

            queryMulta.setParameter("dni", dni);

            MultaEntity multaEntity = queryMulta.getSingleResult();

            if (multaEntity != null) {
                JOptionPane.showMessageDialog(null, "El alumno tiene una multa pendiente");
                throw new RuntimeException("Tiene una multa.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            manager.close();
        }
    }
}
