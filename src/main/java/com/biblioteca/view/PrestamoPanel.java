package com.biblioteca.view;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrestamoPanel extends javax.swing.JPanel {

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

        JTextField textDNI = new JTextField();
        textDNI.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textDNI, new AbsoluteConstraints(160, 20, 50, 30));

        JLabel labelID = new JLabel();
        labelID.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelID.setText("ID del libro:");
        add(labelID, new AbsoluteConstraints(270, 20, 90, -1));

        JTextField textID = new JTextField();
        textID.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textID, new AbsoluteConstraints(380, 20, 50, 30));

        JPanel botonRellenar = new JPanel();
        botonRellenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRellenar.setLayout(new AbsoluteLayout());

        JLabel labelBoton = new JLabel();
        labelBoton.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBoton.setHorizontalAlignment(SwingConstants.CENTER);
        labelBoton.setText("Rellenar");
        labelBoton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                labelBotonMouseClicked(evt);
            }
        });
        botonRellenar.add(labelBoton, new AbsoluteConstraints(0, 0, 150, 30));

        add(botonRellenar, new AbsoluteConstraints(500, 20, 150, 30));

        JLabel labelNombre = new JLabel();
        labelNombre.setText("Nombre:");
        add(labelNombre, new AbsoluteConstraints(10, 90, -1, -1));

        JTextField textNombre = new JTextField();
        add(textNombre, new AbsoluteConstraints(10, 120, 100, 30));

        JLabel labelApellido = new JLabel();
        JTextField textApellido = new JTextField();
        labelApellido.setText("Apellido:");
        add(labelApellido, new AbsoluteConstraints(10, 170, -1, -1));
        add(textApellido, new AbsoluteConstraints(10, 200, 100, 30));

        JLabel labelGrado = new JLabel();
        labelGrado.setText("Grado:");
        add(labelGrado, new AbsoluteConstraints(10, 250, -1, -1));

        JTextField textGrado = new JTextField();
        add(textGrado, new AbsoluteConstraints(10, 270, 100, 30));

        JLabel labelGrupo = new JLabel();
        JTextField textGrupo = new JTextField();
        labelGrupo.setText("Grupo:");
        add(labelGrupo, new AbsoluteConstraints(10, 320, -1, -1));
        add(textGrupo, new AbsoluteConstraints(10, 350, 50, 30));

        JLabel labelTitulo = new JLabel();
        JTextField textTitulo = new JTextField();
        labelTitulo.setText("Titulo del libro:");
        add(labelTitulo, new AbsoluteConstraints(290, 90, -1, -1));
        add(textTitulo, new AbsoluteConstraints(290, 120, 200, 30));

        JLabel labelNombreA = new JLabel();
        JTextField textNombreA = new JTextField();
        labelNombreA.setText("Nombre del autor:");
        add(labelNombreA, new AbsoluteConstraints(290, 170, -1, -1));
        add(textNombreA, new AbsoluteConstraints(290, 200, 200, 30));

        JLabel labelApellidoA = new JLabel();
        labelApellidoA.setText("Apellido del autor:");
        add(labelApellidoA, new AbsoluteConstraints(290, 250, -1, -1));

        JTextField textApellidoA = new JTextField();
        add(textApellidoA, new AbsoluteConstraints(290, 270, 200, 30));

        JPanel botonPrestar = new JPanel();
        botonPrestar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                botonPrestarMouseClicked(evt);
            }
        });
        botonPrestar.setLayout(new AbsoluteLayout());

        JLabel labelPrestar = new JLabel();
        labelPrestar.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelPrestar.setHorizontalAlignment(SwingConstants.CENTER);
        labelPrestar.setText("Prestar");
        botonPrestar.add(labelPrestar, new AbsoluteConstraints(0, 0, 110, 30));

        add(botonPrestar, new AbsoluteConstraints(530, 390, 110, 30));
    }


    private void labelBotonMouseClicked(MouseEvent evt) {
    }

    private void botonPrestarMouseClicked(MouseEvent evt) {    }
}
