package com.biblioteca.view;

import com.biblioteca.controller.PrestamoController;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

@SuppressWarnings("all")
public class ConsultaPrestamo extends JPanel {

    private JComboBox<String> comboOpciones;
    private JTextField textDatoBusqueda;
    private DefaultTableModel modeloPrestamos;

    /**
     * Creates new form ConsultaLibro
     */
    public ConsultaPrestamo() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new AbsoluteLayout());

        JLabel labelBusquedaPor = new JLabel();
        labelBusquedaPor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelBusquedaPor.setText("Busqueda por:");
        add(labelBusquedaPor, new AbsoluteConstraints(6, 6, 120, 30));

        comboOpciones = new JComboBox<>();
        comboOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        comboOpciones.setModel(new DefaultComboBoxModel<>(new String[] { "Id del libro", "Titulo" }));
        add(comboOpciones, new AbsoluteConstraints(10, 40, 150, 30));

        JLabel labelBuscarA = new JLabel();
        labelBuscarA.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelBuscarA.setText("Buscar a:");
        add(labelBuscarA, new AbsoluteConstraints(240, 40, 90, 30));

        textDatoBusqueda = new JTextField();
        textDatoBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        add(textDatoBusqueda, new AbsoluteConstraints(340, 40, 160, 30));

        JPanel botonBuscar = new JPanel();
        botonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonBuscar.setLayout(new AbsoluteLayout());

        JLabel labelBusqueda = new JLabel();
        labelBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
        labelBusqueda.setText("Buscar");
        botonBuscar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        botonBuscar.add(labelBusqueda, new AbsoluteConstraints(0, 0, 80, 30));

        add(botonBuscar, new AbsoluteConstraints(550, 40, 80, 30));
        botonBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarPrestamo();
            }
        });

        JTable tablaPrestamos = new JTable();
        tablaPrestamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPrestamos.setFont(new Font("Roboto", Font.PLAIN, 18));
        modeloPrestamos = (DefaultTableModel) tablaPrestamos.getModel();
        modeloPrestamos.addColumn("Folio");
        modeloPrestamos.addColumn("Fecha del prestamo");
        modeloPrestamos.addColumn("Fecha de entrega");
        modeloPrestamos.addColumn("Titulo del libro");

        tablaPrestamos.setModel(modeloPrestamos);

        JScrollPane scrollPrestamos = new JScrollPane(tablaPrestamos);
        scrollPrestamos.setViewportView(tablaPrestamos);
        add(scrollPrestamos, new AbsoluteConstraints(10, 90, 670, 360));
    }
    private void buscarPrestamo() {

        modeloPrestamos.getDataVector().clear();

        int opcion = comboOpciones.getSelectedIndex();
        String parametro = textDatoBusqueda.getText();

        PrestamoController prestamoController = new PrestamoController();
        List<String[]> prestamos = prestamoController.buscarPrestamo(opcion, parametro);

        if (prestamos == null) {
            JOptionPane.showMessageDialog(null, "No se encontrarón coincidencias");
            throw new RuntimeException();
        }

        prestamos.forEach(datos -> modeloPrestamos.addRow(datos));
    }
}