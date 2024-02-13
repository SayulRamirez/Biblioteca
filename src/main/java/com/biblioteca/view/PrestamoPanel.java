package com.biblioteca.view;

import com.biblioteca.controller.AlumnoController;
import com.biblioteca.controller.LibroController;
import com.biblioteca.controller.PrestamoController;
import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.validation_view.ValidacionField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("all")
public class PrestamoPanel extends JPanel {
    private JTextField textAlumnoDNI;
    private JTextField textLibroID;
    private JTextField textAlumnoNombre;
    private JTextField textAlumnoApellido;
    private JTextField textGrado;
    private JTextField textGrupo;
    private JTextField textTitulo;
    private JTextField textAutorNombre;
    private JTextField textAutorApellido;
    private JPanel botonRellenar;
    private Libro libro;
    private Alumno alumno;


    /**
     * Creates new form PrestamoPanel
     */
    public PrestamoPanel() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new AbsoluteLayout());

        JLabel lalbelDNI = new JLabel();
        lalbelDNI.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        lalbelDNI.setText("DNI del alumno:");
        add(lalbelDNI, new AbsoluteConstraints(6, 20, 140, 30));

        textAlumnoDNI = new JTextField();
        textAlumnoDNI.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textAlumnoDNI, new AbsoluteConstraints(160, 20, 50, 30));
        textAlumnoDNI.addKeyListener(ValidacionField.ingresarNumeros());

        JLabel labelID = new JLabel();
        labelID.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelID.setText("ID del libro:");
        add(labelID, new AbsoluteConstraints(270, 20, 90, -1));

        textLibroID = new JTextField();
        textLibroID.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textLibroID, new AbsoluteConstraints(380, 20, 50, 30));
        textLibroID.addKeyListener(ValidacionField.ingresarNumeros());

        botonRellenar = new JPanel();
        botonRellenar.setLayout(new AbsoluteLayout());
        botonRellenar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonRellenar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel labelRellenar = new JLabel();
        labelRellenar.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelRellenar.setHorizontalAlignment(SwingConstants.CENTER);
        labelRellenar.setText("Rellenar");
        botonRellenar.add(labelRellenar, new AbsoluteConstraints(0, 0, 150, 30));

        add(botonRellenar, new AbsoluteConstraints(500, 20, 150, 30));
        botonRellenar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rellenarCampos();
            }
        });

        JPanel botonLimpiar = new JPanel();
        botonLimpiar.setLayout(new AbsoluteLayout());
        botonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLimpiar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel labelLimpiar = new JLabel();
        labelLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        labelLimpiar.setText("Limpiar");
        botonLimpiar.add(labelLimpiar, new AbsoluteConstraints(0, 0, 150, 30));

        add(botonLimpiar, new AbsoluteConstraints(500, 70, 150, 30));
        botonLimpiar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                limpiarCampos();
            }
        });

        JLabel labelNombre = new JLabel();
        labelNombre.setText("Nombre:");
        add(labelNombre, new AbsoluteConstraints(10, 90, -1, -1));

        textAlumnoNombre = new JTextField();
        add(textAlumnoNombre, new AbsoluteConstraints(10, 120, 115, 30));
        textAlumnoNombre.addKeyListener(ValidacionField.ingresarLetras());
        textAlumnoNombre.setEditable(false);

        JLabel labelApellido = new JLabel();
        labelApellido.setText("Apellido:");
        add(labelApellido, new AbsoluteConstraints(10, 170, -1, -1));

        textAlumnoApellido = new JTextField();
        add(textAlumnoApellido, new AbsoluteConstraints(10, 200, 115, 30));
        textAlumnoApellido.addKeyListener(ValidacionField.ingresarLetras());
        textAlumnoApellido.setEditable(false);

        JLabel labelGrado = new JLabel();
        labelGrado.setText("Grado:");
        add(labelGrado, new AbsoluteConstraints(10, 250, -1, -1));

        textGrado = new JTextField();
        add(textGrado, new AbsoluteConstraints(10, 270, 115, 30));
        textGrado.addKeyListener(ValidacionField.ingresarLetras());
        textGrado.setEditable(false);

        JLabel labelGrupo = new JLabel();

        labelGrupo.setText("Grupo:");
        add(labelGrupo, new AbsoluteConstraints(10, 320, -1, -1));

        textGrupo = new JTextField();
        add(textGrupo, new AbsoluteConstraints(10, 350, 50, 30));
        textGrupo.addKeyListener(ValidacionField.ingresarLetras());
        textGrupo.setEditable(false);

        JLabel labelTitulo = new JLabel();

        labelTitulo.setText("Titulo del libro:");
        add(labelTitulo, new AbsoluteConstraints(230, 90, -1, -1));

        textTitulo = new JTextField();
        add(textTitulo, new AbsoluteConstraints(230, 120, 230, 30));
        textTitulo.addKeyListener(ValidacionField.ingresarLetras());
        textTitulo.setEditable(false);

        JLabel labelNombreA = new JLabel();

        labelNombreA.setText("Nombre del autor:");
        add(labelNombreA, new AbsoluteConstraints(230, 170, -1, -1));

        textAutorNombre = new JTextField();
        add(textAutorNombre, new AbsoluteConstraints(230, 200, 230, 30));
        textAutorNombre.addKeyListener(ValidacionField.ingresarLetras());
        textAutorNombre.setEditable(false);

        JLabel labelAutorApellido = new JLabel();
        labelAutorApellido.setText("Apellido del autor:");
        add(labelAutorApellido, new AbsoluteConstraints(230, 250, -1, -1));

        textAutorApellido = new JTextField();
        add(textAutorApellido, new AbsoluteConstraints(230, 270, 230, 30));
        textAutorApellido.addKeyListener(ValidacionField.ingresarLetras());
        textAutorApellido.setEditable(false);

        JPanel botonPrestar = new JPanel();
        botonPrestar.setLayout(new AbsoluteLayout());
        botonPrestar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonPrestar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel labelPrestar = new JLabel();
        labelPrestar.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelPrestar.setHorizontalAlignment(SwingConstants.CENTER);
        labelPrestar.setText("Prestar");
        botonPrestar.add(labelPrestar, new AbsoluteConstraints(0, 0, 110, 30));

        add(botonPrestar, new AbsoluteConstraints(530, 390, 110, 30));

        botonPrestar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                realizarPrestamo();
            }
        });
    }

    private void rellenarCampos() {

        datosIngresadosValidos();

        String dni = textAlumnoDNI.getText();
        String id = textLibroID.getText();

        AlumnoController alumnoController = new AlumnoController();
        LibroController libroController = new LibroController();

        alumno = alumnoController.buscarAlumno(dni);
        libro = libroController.buscarLibroPorID(id);

        if (alumno == null || libro == null) {
            String mensaje = (alumno == null) ? "El alumno" : "El libro";
            JOptionPane.showMessageDialog(null, mensaje + " no existe.");
            throw new RuntimeException();
        }

        textAlumnoApellido.setText(alumno.getApellido());
        textAlumnoNombre.setText(alumno.getNombre());
        textGrado.setText(alumno.getPeriodo());
        textGrupo.setText(alumno.getGrupo());

        textTitulo.setText(libro.getTitulo());
        textAutorApellido.setText(libro.getAutor().getApellido());
        textAutorNombre.setText(libro.getAutor().getNombre());
    }

    private void  realizarPrestamo() {

        PrestamoController prestamoController = new PrestamoController();
        Long folio = prestamoController.realizarPrestamo(alumno, libro);

        if (folio == null) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error!");
            throw new RuntimeException();
        }

        JOptionPane.showMessageDialog(null, "El folio del prestamo es: " + folio);
    }

    private void limpiarCampos(){
        textAlumnoDNI.setEditable(true);
        textAlumnoDNI.setText("");
        textLibroID.setEditable(true);
        textLibroID.setText("");
        textAlumnoNombre.setText("");
        textAlumnoApellido.setText("");
        textGrado.setText("");
        textGrupo.setText("");
        textTitulo.setText("");
        textAutorNombre.setText("");
        textAutorApellido.setText("");
        botonRellenar.setEnabled(true);
    }

    private void datosIngresadosValidos(){

        String dni = textAlumnoDNI.getText();
        String id = textLibroID.getText();

        if (dni.isBlank() || id.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor llenar los compos DNI y ID correctamente.");
            throw new RuntimeException("DNI e ID llenados incorrectamente");
        }

        textAlumnoDNI.setEditable(false);
        textLibroID.setEditable(false);
        botonRellenar.setEnabled(false);
    }
}
