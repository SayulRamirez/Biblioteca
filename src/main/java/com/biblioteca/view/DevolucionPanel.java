package com.biblioteca.view;

import com.biblioteca.controller.PrestamoController;
import com.biblioteca.validation_view.ValidacionField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

public class DevolucionPanel extends javax.swing.JPanel {

    private JTextField textFolio;
    private JTextField textDNI;
    private JTextField textID;
    private JTextField textTitulo;
    private JTextField textEntrega;
    private JRadioButton radioMulta;
    private JComboBox<String> tipoMulta;
    private String folio;
    /**
     * Creates new form DevolucionPanel
     */
    public DevolucionPanel() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new AbsoluteLayout());

        textFolio = new JTextField();
        JLabel labelFolio = new JLabel();
        labelFolio.setText("Folio del prestamo:");
        add(labelFolio, new AbsoluteConstraints(6, 18, -1, -1));
        textFolio.addKeyListener(ValidacionField.ingresarNumeros());
        add(textFolio, new AbsoluteConstraints(120, 10, 50, 30));

        JPanel botonBuscar = new JPanel();
        botonBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarDatosPrestamo();
            }
        });
        botonBuscar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        botonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonBuscar.setLayout(new AbsoluteLayout());

        JLabel labelBuscar = new JLabel();
        labelBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        labelBuscar.setText("Buscar");
        botonBuscar.add(labelBuscar, new AbsoluteConstraints(0, 0, 150, 30));
        add(botonBuscar, new AbsoluteConstraints(200, 10, 150,30));

        JPanel botonLimpiar = new JPanel();
        botonLimpiar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                limpiarCampos();
            }
        });
        botonLimpiar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        botonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLimpiar.setLayout(new AbsoluteLayout());

        JLabel labelLimpiar = new JLabel();
        labelLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        labelLimpiar.setText("Limpiar");
        botonLimpiar.add(labelLimpiar, new AbsoluteConstraints(0, 0, 150, 30));
        add(botonLimpiar, new AbsoluteConstraints(400, 10, 150,30));

        JLabel labelDNI = new JLabel();
        textDNI = new JTextField();
        labelDNI.setText("DNI del alumno:");
        add(labelDNI, new AbsoluteConstraints(10, 70, -1, -1));
        textDNI.setEditable(false);
        add(textDNI, new AbsoluteConstraints(10, 100, 90, 30));

        JLabel labelID = new JLabel();
        textID = new JTextField();
        labelID.setText("ID del libro:");
        add(labelID, new AbsoluteConstraints(10, 170, -1, -1));
        textID.setEditable(false);
        add(textID, new AbsoluteConstraints(10, 190, 80, 30));

        JLabel labelTitulo = new JLabel();
        textTitulo = new JTextField();
        labelTitulo.setText("Titulo:");
        add(labelTitulo, new AbsoluteConstraints(10, 250, -1, -1));
        textTitulo.setEditable(false);
        add(textTitulo, new AbsoluteConstraints(10, 270, 220, 30));

        textEntrega = new JTextField();
        JLabel labelEntrega = new JLabel();
        labelEntrega.setText("Fecha de entrega:");
        add(labelEntrega, new AbsoluteConstraints(10, 320, -1, -1));
        textEntrega.setEditable(false);
        add(textEntrega, new AbsoluteConstraints(10, 350, 150, 30));

        radioMulta = new JRadioButton();
        radioMulta.setText("Acreedor a multa");
        add(radioMulta, new AbsoluteConstraints(360, 70, -1, -1));

        tipoMulta = new JComboBox<>();
        tipoMulta.setModel(new DefaultComboBoxModel<>(new String[] { "3 días de retraso", "Más de 3 días de retrazo", "Mal estado" }));
        add(tipoMulta, new AbsoluteConstraints(360, 120, -1, -1));

        JPanel botonDevolucion = new JPanel();
        botonDevolucion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                realizarDevolucion();
            }
        });
        botonDevolucion.setLayout(new AbsoluteLayout());

        JLabel labelDevolucion = new JLabel();
        labelDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        labelDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
        labelDevolucion.setText("Devolución");

        botonDevolucion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        botonDevolucion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonDevolucion.add(labelDevolucion, new AbsoluteConstraints(0, 0, 200, 40));

        add(botonDevolucion, new AbsoluteConstraints(380, 340, 200, 40));
    }

    private void realizarDevolucion() {
        String motivo = Objects.requireNonNull(tipoMulta.getSelectedItem()).toString();
        int posicionMotivo = tipoMulta.getItemCount();
        boolean seleccionado = radioMulta.isSelected();
        LocalDate fechaEntrega = recuperarFechaEntrega();

        PrestamoController devolucionController = new PrestamoController();
        int actualizado = devolucionController.actualizarPrestamo(folio, seleccionado, motivo, posicionMotivo, fechaEntrega);

        if (actualizado == 0) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error.");
            throw new RuntimeException();
        }

        JOptionPane.showMessageDialog(null, "Se actualizó correctamente " + actualizado + " prestamo.");
    }

    private void buscarDatosPrestamo() {

        folio = textFolio.getText();

        PrestamoController prestamoController = new PrestamoController();

        String[] prestamo = prestamoController.buscarPrestamoPorFolio(folio);

        if (prestamo == null){
            JOptionPane.showMessageDialog(null, "No se encontro el folio.");
            throw new RuntimeException();
        }

        textDNI.setText(prestamo[1]);
        textID.setText(prestamo[2]);
        textTitulo.setText(prestamo[3]);
        textEntrega.setText(prestamo[4]);
    }

    private void limpiarCampos() {
        textEntrega.setText("");
        textTitulo.setText("");
        textID.setText("");
        textFolio.setText("");
        textFolio.setEditable(true);
        textDNI.setText("");
    }

    private LocalDate recuperarFechaEntrega() {

        String fecha = textEntrega.getText();

        String[] partes = fecha.split("-");

        int ano = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);

        return LocalDate.of(ano, mes, dia);
    }
}
