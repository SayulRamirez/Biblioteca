package com.biblioteca.view;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ConsultaLibro extends javax.swing.JPanel {

    /**
     * Creates new form ConsultaLibro
     */
    public ConsultaLibro() {
        initComponents();
    }

    private void initComponents() {

        JLabel labelBusq = new JLabel();
        JComboBox<String> comboOpciones = new JComboBox<>();
        JLabel labelBusqA = new JLabel();
        JTextField textIngreBusq = new JTextField();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JPanel botonBuscar = new JPanel();
        JLabel labelBusqueda = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
        JTable jTable2 = new JTable();

        setLayout(new AbsoluteLayout());

        labelBusq.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusq.setText("Busqueda por:");
        add(labelBusq, new AbsoluteConstraints(6, 6, 120, 30));

        comboOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apellido", "Nombre", "Titulo" }));
        add(comboOpciones, new AbsoluteConstraints(10, 40, 150, 30));

        labelBusqA.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusqA.setText("Buscar a:");
        add(labelBusqA, new AbsoluteConstraints(240, 40, 90, 30));

        textIngreBusq.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textIngreBusq, new AbsoluteConstraints(340, 40, 160, 30));

        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });
        botonBuscar.setLayout(new AbsoluteLayout());

        labelBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
        labelBusqueda.setText("Buscar");
        botonBuscar.add(labelBusqueda, new AbsoluteConstraints(0, 0, 80, 30));

        add(botonBuscar, new AbsoluteConstraints(550, 40, 80, 30));

        jTable2.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "ID ", "Titulo", "Nombre", "Apellido", "Existencias"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class, String.class, String.class, String.class, Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new AbsoluteConstraints(10, 90, 670, 360));
    }
    private void botonBuscarMouseClicked(MouseEvent evt) {
    }
}