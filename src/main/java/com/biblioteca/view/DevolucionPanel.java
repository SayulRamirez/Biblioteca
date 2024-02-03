package com.biblioteca.view;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DevolucionPanel extends javax.swing.JPanel {

    /**
     * Creates new form DevolucionPanel
     */
    public DevolucionPanel() {
        initComponents();
    }

    private void initComponents() {


        setMinimumSize(new Dimension(690, 460));
        setLayout(new AbsoluteLayout());

        JTextField textFolio = new JTextField();
        JLabel labelFolio = new JLabel();
        labelFolio.setText("Folio del prestamo:");
        add(labelFolio, new AbsoluteConstraints(6, 18, -1, -1));
        add(textFolio, new AbsoluteConstraints(120, 10, 50, 30));

        JPanel botonBuscar = new JPanel();
        botonBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });
        botonBuscar.setLayout(new AbsoluteLayout());

        JLabel labelBuscar = new JLabel();
        labelBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        labelBuscar.setText("Buscar");
        botonBuscar.add(labelBuscar, new AbsoluteConstraints(0, 0, 150, 30));

        add(botonBuscar, new AbsoluteConstraints(200, 10, 150, 30));

        JLabel labelDNI = new JLabel();
        JTextField textDNI = new JTextField();
        labelDNI.setText("DNI del alumno:");
        add(labelDNI, new AbsoluteConstraints(10, 70, -1, -1));
        add(textDNI, new AbsoluteConstraints(10, 100, 90, 30));

        JLabel labelID = new JLabel();
        JTextField textID = new JTextField();
        labelID.setText("ID del libro:");
        add(labelID, new AbsoluteConstraints(10, 170, -1, -1));
        add(textID, new AbsoluteConstraints(10, 190, 80, 30));

        JLabel labelTitulo = new JLabel();
        JTextField textTitulo = new JTextField();
        labelTitulo.setText("Titulo:");
        add(labelTitulo, new AbsoluteConstraints(10, 250, -1, -1));
        add(textTitulo, new AbsoluteConstraints(10, 270, 150, 30));

        JTextField textEntrega = new JTextField();
        JLabel labelEntrega = new JLabel();
        labelEntrega.setText("Fecha de entrega:");
        add(labelEntrega, new AbsoluteConstraints(10, 320, -1, -1));
        add(textEntrega, new AbsoluteConstraints(10, 350, 150, 30));

        JRadioButton radioMulta = new JRadioButton();
        radioMulta.setText("Acreedor a multa");
        add(radioMulta, new AbsoluteConstraints(360, 70, -1, -1));

        JComboBox<String> jComboBox1 = new JComboBox<>();
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "3 días de retraso", "Más de 3 días de retrazo", "Mal estado" }));
        add(jComboBox1, new AbsoluteConstraints(360, 120, -1, -1));

        JPanel botonDevolucion = new JPanel();
        botonDevolucion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                botonDecolucionMouseClicked(evt);
            }
        });
        botonDevolucion.setLayout(new AbsoluteLayout());

        JLabel labelDevolucion = new JLabel();
        labelDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        labelDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
        labelDevolucion.setText("Devolución");
        labelDevolucion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        botonDevolucion.add(labelDevolucion, new AbsoluteConstraints(0, 0, 200, 40));

        add(botonDevolucion, new AbsoluteConstraints(380, 340, 200, 40));
    }

    private void jLabel2MouseClicked(MouseEvent evt) {
    }

    private void botonDecolucionMouseClicked(MouseEvent evt) {
    }

    private void botonBuscarMouseClicked(MouseEvent evt) {
    }}
