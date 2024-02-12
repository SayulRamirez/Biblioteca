package com.biblioteca.view;

import com.biblioteca.controller.MultaController;
import com.biblioteca.controller.PrestamoController;
import com.biblioteca.model.Multa;
import com.biblioteca.model.Prestamo;
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
    private JTextField textLibroTitulo;
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
        botonEstado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
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
        botonLimpiar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
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

        JPanel botonActualizar = new JPanel();
        botonActualizar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        botonActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        botonActualizar.setLayout(new AbsoluteLayout());

        JLabel labelActualizar = new JLabel();
        labelActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelActualizar.setHorizontalAlignment(SwingConstants.CENTER);
        labelActualizar.setText("Actualizar");

        botonActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actualizarMultas();
            }
        });

        botonActualizar.add(labelActualizar, new AbsoluteConstraints(0, 0, 120, 30));

        add(botonActualizar, new AbsoluteConstraints(500, 70, 120, 30));

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

        JLabel labelTituloLibro = new JLabel();
        labelTituloLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelTituloLibro.setText("Titulo del libro:");
        add(labelTituloLibro, new AbsoluteConstraints(200, 190, 150, 25));

        textLibroTitulo = new JTextField();
        textLibroTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textLibroTitulo.setEditable(false);
        add(textLibroTitulo, new AbsoluteConstraints(200, 220, 200, 30));

        JLabel labelEstMulta = new JLabel();
        labelEstMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelEstMulta.setForeground(new Color(255, 0, 0));
        labelEstMulta.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelEstMulta, new AbsoluteConstraints(370, 130, 250, 30));

        JLabel lableIDMulta = new JLabel();
        lableIDMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lableIDMulta.setText("Folio de la multa:");
        add(lableIDMulta, new AbsoluteConstraints(420, 190, 140, 25));

        textIdMulta = new JTextField();
        textIdMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textIdMulta.setEditable(false);
        add(textIdMulta, new AbsoluteConstraints(420, 220, 100, 30));

        JLabel labelFinMulta = new JLabel();
        labelFinMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelFinMulta.setText("Termino de la multa:");
        add(labelFinMulta, new AbsoluteConstraints(420, 270, 170, 25));

        textFinMulta = new JTextField();
        textFinMulta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textFinMulta.setEditable(false);
        add(textFinMulta, new AbsoluteConstraints(420, 300, 150, 30));

        JLabel labelMotivo = new JLabel();
        labelMotivo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelMotivo.setText("Motivo:");
        add(labelMotivo, new AbsoluteConstraints(420, 350, 70, 25));

        textMotivo = new JTextField();
        textMotivo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textMotivo.setEditable(false);
        add(textMotivo, new AbsoluteConstraints(420, 380, 200, 30));
    }

    private void buscarDatos(){

        String dni = textDIN.getText();

        PrestamoController prestamoController = new PrestamoController();
        Prestamo prestamo = prestamoController.buscarPrestamoPorAlumno(dni);

        if (prestamo == null) {
            JOptionPane.showMessageDialog(null, "El alumno no tiene prestamos activos.");
        } else {
            textIDPrestamo.setText(prestamo.getId().toString());
            textFechaPrestamo.setText(prestamo.getFechaSolicitud().toString());
            textFechaEntrega.setText(prestamo.getFechaEntrega().toString());
            textLibroTitulo.setText(prestamo.getLibro().getTitulo());
        }

        MultaController multaController = new MultaController();
        Multa multa = multaController.buscarMulta(dni);

        if (multa == null) {
            JOptionPane.showMessageDialog(null, "El alumno no tiene multas.");
        } else {
            textMotivo.setText(multa.getMotivo());
            textFinMulta.setText(multa.getFinMulta().toString());
            textIdMulta.setText(multa.getId().toString());
        }

    }

    private void limpiarCampos() {
        textDIN.setText("");
        textLibroTitulo.setText("");
        textIdMulta.setText("");
        textFechaEntrega.setText("");
        textFechaPrestamo.setText("");
        textFinMulta.setText("");
        textIDPrestamo.setText("");
        textMotivo.setText("");
    }

    private void actualizarMultas(){

    }
}