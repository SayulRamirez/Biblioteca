package com.biblioteca.view;

import com.biblioteca.validation_view.ValidacionField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EstadoPanel extends JPanel {

    private JTextField textDIN;
    private JTextField textIDPrestamo;
    private JTextField textFechaPrestamo;
    private JTextField textFechaEntrega;
    private JTextField textIDLibro;
    private JTextField textIdMulta;
    private JTextField textFinMulta;
    private JTextField textMotivo;

    public EstadoPanel() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new AbsoluteLayout());

        JLabel labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Estado del alumno");
        add(labelTitulo, new AbsoluteConstraints(0, 20, 690, -1));

        JLabel labelDIN = new JLabel();
        labelDIN.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelDIN.setText("DIN:");
        add(labelDIN, new AbsoluteConstraints(10, 70, 40, 30));

        textDIN = new JTextField();
        textDIN.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textDIN.addKeyListener(ValidacionField.ingresarNumeros());
        add(textDIN, new AbsoluteConstraints(60, 70, 100, 30));

        JPanel botonEstado = new JPanel();
        botonEstado.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonEstado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        botonEstado.setLayout(new AbsoluteLayout());

        JLabel labelEstado = new JLabel();
        labelEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelEstado.setHorizontalAlignment(SwingConstants.CENTER);
        labelEstado.setText("Mostrar estado");

        botonEstado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarDatos();
            }
        });

        botonEstado.add(labelEstado, new AbsoluteConstraints(0, 0, 120, 30));

        add(botonEstado, new AbsoluteConstraints(190, 70, 120, 30));

        JPanel botonLimpiar = new JPanel();
        botonLimpiar.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        botonLimpiar.setLayout(new AbsoluteLayout());

        JLabel labelLimpiar = new JLabel();
        labelLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        labelLimpiar.setText("Limpiar");

        botonLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }
        });

        botonLimpiar.add(labelLimpiar, new AbsoluteConstraints(0, 0, 120, 30));

        add(botonLimpiar, new AbsoluteConstraints(350, 70, 120, 30));

        JLabel labelEstPresta = new JLabel();
        labelEstPresta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelEstPresta.setForeground(new Color(255, 0, 0));
        labelEstPresta.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelEstPresta, new AbsoluteConstraints(10, 130, 250, 30));

        textIDPrestamo = new JTextField();
        textIDPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textIDPrestamo.setHorizontalAlignment(JTextField.CENTER);
        textIDPrestamo.setEditable(false);
        add(textIDPrestamo, new AbsoluteConstraints(10, 220, 100, 30));

        JLabel labelFolPrestamo = new JLabel();
        labelFolPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelFolPrestamo.setText("Folio del prestamo:");
        add(labelFolPrestamo, new AbsoluteConstraints(10, 190, 150, 25));

        JLabel labelFechaPres = new JLabel();
        labelFechaPres.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelFechaPres.setText("Fecha del prestamo:");
        add(labelFechaPres, new AbsoluteConstraints(10, 270, 160, 25));

        textFechaPrestamo = new JTextField();
        textFechaPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textFechaPrestamo.setHorizontalAlignment(JTextField.CENTER);
        textFechaPrestamo.setEditable(false);
        add(textFechaPrestamo, new AbsoluteConstraints(10, 300, 150, 30));

        JLabel labelFechaEntre = new JLabel();
        labelFechaEntre.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelFechaEntre.setText("Fecha de entrega:");
        add(labelFechaEntre, new AbsoluteConstraints(10, 350, 150, 25));

        textFechaEntrega = new JTextField();
        textFechaEntrega.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textFechaEntrega.setHorizontalAlignment(JTextField.CENTER);
        textFechaEntrega.setEditable(false);
        add(textFechaEntrega, new AbsoluteConstraints(10, 390, 150, 30));

        JLabel labelIDLibro = new JLabel();
        labelIDLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelIDLibro.setText("ID del libro:");
        add(labelIDLibro, new AbsoluteConstraints(200, 190, 90, 25));

        textIDLibro = new JTextField();
        textIDLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textIDLibro.setEditable(false);
        add(textIDLibro, new AbsoluteConstraints(200, 220, 70, 30));

        JLabel labelEstMulta = new JLabel();
        labelEstMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelEstMulta.setForeground(new Color(255, 0, 0));
        labelEstMulta.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelEstMulta, new AbsoluteConstraints(370, 130, 250, 30));

        JLabel lableIDMulta = new JLabel();
        lableIDMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lableIDMulta.setText("Folio de la multa:");
        add(lableIDMulta, new AbsoluteConstraints(370, 190, 140, 25));

        textIdMulta = new JTextField();
        textIdMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textIdMulta.setEditable(false);
        add(textIdMulta, new AbsoluteConstraints(370, 220, 100, 30));

        JLabel labelFinMulta = new JLabel();
        labelFinMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelFinMulta.setText("Termino de la multa:");
        add(labelFinMulta, new AbsoluteConstraints(370, 270, 170, 25));

        textFinMulta = new JTextField();
        textFinMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textFinMulta.setEditable(false);
        add(textFinMulta, new AbsoluteConstraints(370, 300, 150, 30));

        JLabel labelMotivo = new JLabel();
        labelMotivo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelMotivo.setText("Motivo:");
        add(labelMotivo, new AbsoluteConstraints(370, 350, 70, 25));

        textMotivo = new JTextField();
        textMotivo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textMotivo.setEditable(false);
        add(textMotivo, new AbsoluteConstraints(370, 380, 200, 30));
    }

    private void buscarDatos(){

    }

    private void limpiarCampos() {
        textFechaEntrega.setText("");
        textMotivo.setText("");
        textFinMulta.setText("");
        textIdMulta.setText("");
        textFechaPrestamo.setText("");
        textIDLibro.setText("");
        textIDPrestamo.setText("");
        textDIN.setText("");
    }
}