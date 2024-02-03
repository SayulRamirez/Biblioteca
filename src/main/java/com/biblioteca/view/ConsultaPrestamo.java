package com.biblioteca.view;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class ConsultaPrestamo extends JPanel {

    /**
     * Creates new form ConsultaLibro
     */
    public ConsultaPrestamo() {
        initComponents();
    }

    private void initComponents() {


        setMinimumSize(new Dimension(690, 460));
        setPreferredSize(new Dimension(690, 460));
        setLayout(new AbsoluteLayout());

        JLabel labelBusq = new JLabel();
        labelBusq.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusq.setText("Busqueda por:");
        add(labelBusq, new AbsoluteConstraints(6, 6, 120, 30));

        JComboBox<String> comboOpciones = new JComboBox<>();
        comboOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        comboOpciones.setModel(new DefaultComboBoxModel<>(new String[] { "Id del libro", "Titulo" }));
        add(comboOpciones, new AbsoluteConstraints(10, 40, 150, 30));

        JLabel labelBusqA = new JLabel();
        labelBusqA.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusqA.setText("Buscar a:");
        add(labelBusqA, new AbsoluteConstraints(240, 40, 90, 30));

        JTextField textIngreBusq = new JTextField();
        textIngreBusq.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textIngreBusq, new AbsoluteConstraints(340, 40, 160, 30));

        JPanel botonBuscar = new JPanel();
        botonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });
        botonBuscar.setLayout(new AbsoluteLayout());

        JLabel labelBusqueda = new JLabel();

        labelBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
        labelBusqueda.setText("Buscar");
        botonBuscar.add(labelBusqueda, new AbsoluteConstraints(0, 0, 80, 30));

        add(botonBuscar, new AbsoluteConstraints(550, 40, 80, 30));

        JTable tablaPrestamos = new JTable();
        tablaPrestamos.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Folio", "Fecha de solicitud", "Fecha de entrega"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(tablaPrestamos);

        add(jScrollPane2, new AbsoluteConstraints(10, 90, 670, 360));
    }
    private void botonBuscarMouseClicked(MouseEvent evt) {

    }
}