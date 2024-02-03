package com.biblioteca.view;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EstadoPanel extends javax.swing.JPanel {

    /**
     * Creates new form EstadoPanel
     */
    public EstadoPanel() {
        initComponents();
    }

    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(690, 460));
        setLayout(new AbsoluteLayout());

        JLabel labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // NOI18N
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Estado del alumno");
        add(labelTitulo, new AbsoluteConstraints(0, 20, 690, -1));

        JLabel labelDIN = new JLabel();
        labelDIN.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelDIN.setText("DIN:");
        add(labelDIN, new AbsoluteConstraints(10, 70, 40, 30));

        JTextField textDIN = new JTextField();
        textDIN.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        textDIN.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                textDINKeyTyped(evt);
            }
        });
        add(textDIN, new AbsoluteConstraints(60, 70, 100, 30));

        JPanel botonEstado = new JPanel();
        botonEstado.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonEstado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        botonEstado.setLayout(new AbsoluteLayout());

        JLabel labelEstado = new JLabel();
        labelEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelEstado.setHorizontalAlignment(SwingConstants.CENTER);
        labelEstado.setText("Mostrar estado");
        labelEstado.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                labelEstadoMouseClicked(evt);
            }
        });
        botonEstado.add(labelEstado, new AbsoluteConstraints(0, 0, 120, 30));

        add(botonEstado, new AbsoluteConstraints(190, 70, 120, 30));

        JLabel labelEstPresta = new JLabel();
        labelEstPresta.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelEstPresta.setForeground(new Color(255, 0, 0));
        labelEstPresta.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelEstPresta, new AbsoluteConstraints(10, 130, 250, 30));

        JTextField textIDPrestamo = new JTextField();
        textIDPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        textIDPrestamo.setHorizontalAlignment(JTextField.CENTER);
        textIDPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textIDPrestamoActionPerformed(evt);
            }
        });
        add(textIDPrestamo, new AbsoluteConstraints(10, 220, 100, 30));

        JLabel labelFolPrestamo = new JLabel();
        labelFolPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelFolPrestamo.setText("Folio del prestamo:");
        add(labelFolPrestamo, new AbsoluteConstraints(10, 190, 150, 25));

        JLabel labelFechaPres = new JLabel();
        labelFechaPres.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelFechaPres.setText("Fecha del prestamo:");
        add(labelFechaPres, new AbsoluteConstraints(10, 270, 160, 25));

        JTextField panelFechaPrest = new JTextField();
        panelFechaPrest.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        panelFechaPrest.setHorizontalAlignment(JTextField.CENTER);
        add(panelFechaPrest, new AbsoluteConstraints(10, 300, 150, 30));

        JLabel labelFechaEntre = new JLabel();
        labelFechaEntre.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelFechaEntre.setText("Fecha de entrega:");
        add(labelFechaEntre, new AbsoluteConstraints(10, 350, 150, 25));

        JTextField textFechaEntrega = new JTextField();
        textFechaEntrega.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        textFechaEntrega.setHorizontalAlignment(JTextField.CENTER);
        add(textFechaEntrega, new AbsoluteConstraints(10, 390, 150, 30));

        JLabel labelIDLibro = new JLabel();
        labelIDLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelIDLibro.setText("ID del libro:");
        add(labelIDLibro, new AbsoluteConstraints(200, 190, 90, 25));

        JTextField textIDLibro = new JTextField();
        textIDLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textIDLibro, new AbsoluteConstraints(200, 220, 70, 30));

        JLabel labelEstMulta = new JLabel();
        labelEstMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelEstMulta.setForeground(new Color(255, 0, 0));
        labelEstMulta.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelEstMulta, new AbsoluteConstraints(370, 130, 250, 30));

        JLabel lableIDMulta = new JLabel();
        lableIDMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        lableIDMulta.setText("Folio de la multa:");
        add(lableIDMulta, new AbsoluteConstraints(370, 190, 140, 25));

        JTextField textFolio = new JTextField();
        textFolio.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textFolio, new AbsoluteConstraints(370, 220, 100, 30));

        JLabel labelFinMulta = new JLabel();
        labelFinMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelFinMulta.setText("Termino de la multa:");
        add(labelFinMulta, new AbsoluteConstraints(370, 270, 170, 25));

        JTextField textFinMulta = new JTextField();
        textFinMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textFinMulta, new AbsoluteConstraints(370, 300, 150, 30));

        JLabel labelMotivo = new JLabel();
        labelMotivo.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelMotivo.setText("Motivo:");
        add(labelMotivo, new AbsoluteConstraints(370, 350, 70, 25));

        JTextField textMotivo = new JTextField();
        textMotivo.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textMotivo, new AbsoluteConstraints(370, 380, 200, 30));
    }

    private void textIDPrestamoActionPerformed(ActionEvent evt) {
    }
    private void labelEstadoMouseClicked(MouseEvent evt) {

    }
    private void textDINKeyTyped(KeyEvent evt) {
    }
}