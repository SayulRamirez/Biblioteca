package com.biblioteca.view;

import com.biblioteca.validation_view.ValidacionField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        JPanel botonRellenar = new JPanel();
        botonRellenar.setLayout(new AbsoluteLayout());
        botonRellenar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonRellenar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel labelBoton = new JLabel();
        labelBoton.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBoton.setHorizontalAlignment(SwingConstants.CENTER);
        labelBoton.setText("Rellenar");
        botonRellenar.add(labelBoton, new AbsoluteConstraints(0, 0, 150, 30));

        add(botonRellenar, new AbsoluteConstraints(500, 20, 150, 30));
        botonRellenar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rellenarCampos();
            }
        });

        JLabel labelNombre = new JLabel();
        labelNombre.setText("Nombre:");
        add(labelNombre, new AbsoluteConstraints(10, 90, -1, -1));

        textAlumnoNombre = new JTextField();
        add(textAlumnoNombre, new AbsoluteConstraints(10, 120, 100, 30));
        textAlumnoNombre.addKeyListener(ValidacionField.ingresarLetras());

        JLabel labelApellido = new JLabel();
        labelApellido.setText("Apellido:");
        add(labelApellido, new AbsoluteConstraints(10, 170, -1, -1));

        textAlumnoApellido = new JTextField();
        add(textAlumnoApellido, new AbsoluteConstraints(10, 200, 100, 30));
        textAlumnoApellido.addKeyListener(ValidacionField.ingresarLetras());


        JLabel labelGrado = new JLabel();
        labelGrado.setText("Grado:");
        add(labelGrado, new AbsoluteConstraints(10, 250, -1, -1));

        textGrado = new JTextField();
        add(textGrado, new AbsoluteConstraints(10, 270, 100, 30));
        textGrado.addKeyListener(ValidacionField.ingresarLetras());


        JLabel labelGrupo = new JLabel();

        labelGrupo.setText("Grupo:");
        add(labelGrupo, new AbsoluteConstraints(10, 320, -1, -1));

        textGrupo = new JTextField();
        add(textGrupo, new AbsoluteConstraints(10, 350, 50, 30));
        textGrupo.addKeyListener(ValidacionField.ingresarLetras());


        JLabel labelTitulo = new JLabel();

        labelTitulo.setText("Titulo del libro:");
        add(labelTitulo, new AbsoluteConstraints(290, 90, -1, -1));

        textTitulo = new JTextField();
        add(textTitulo, new AbsoluteConstraints(290, 120, 200, 30));
        textTitulo.addKeyListener(ValidacionField.ingresarLetras());

        JLabel labelNombreA = new JLabel();


        labelNombreA.setText("Nombre del autor:");
        add(labelNombreA, new AbsoluteConstraints(290, 170, -1, -1));

        textAutorNombre = new JTextField();
        add(textAutorNombre, new AbsoluteConstraints(290, 200, 200, 30));
        textAutorNombre.addKeyListener(ValidacionField.ingresarLetras());

        JLabel labelApellidoA = new JLabel();
        labelApellidoA.setText("Apellido del autor:");
        add(labelApellidoA, new AbsoluteConstraints(290, 250, -1, -1));

        textAutorApellido = new JTextField();
        add(textAutorApellido, new AbsoluteConstraints(290, 270, 200, 30));
        textAutorApellido.addKeyListener(ValidacionField.ingresarLetras());

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

    }

    private void  realizarPrestamo() {

    }
}
