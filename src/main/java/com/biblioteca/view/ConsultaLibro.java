package com.biblioteca.view;

import com.biblioteca.controller.ControllerLibro;
import com.biblioteca.model.Libro;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ConsultaLibro extends javax.swing.JPanel {

    private JTextField textParametroBusqueda;
    private JComboBox<String> comboOpciones;
    private DefaultTableModel modeloLibros;

    /**
     * Creates new form ConsultaLibro
     */
    public ConsultaLibro() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new AbsoluteLayout());

        JLabel labelBuscarPor = new JLabel();
        labelBuscarPor.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBuscarPor.setText("Busqueda por:");
        add(labelBuscarPor, new AbsoluteConstraints(6, 6, 120, 30));

        comboOpciones = new JComboBox<>();
        comboOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apellido", "Nombre", "Titulo" }));
        add(comboOpciones, new AbsoluteConstraints(10, 40, 150, 30));

        JLabel labelBuascarA = new JLabel();
        labelBuascarA.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelBuascarA.setText("Buscar a:");
        add(labelBuascarA, new AbsoluteConstraints(240, 40, 90, 30));

        textParametroBusqueda = new JTextField();
        textParametroBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        add(textParametroBusqueda, new AbsoluteConstraints(340, 40, 160, 30));

        textParametroBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (!Character.isLetter(keyChar)) {
                    e.consume();
                }
            }
        });

        JPanel botonBuscar = new JPanel();
        botonBuscar.setLayout(new AbsoluteLayout());

        JLabel lableBuscar = new JLabel();
        lableBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        lableBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lableBuscar.setText("Buscar");
        botonBuscar.add(lableBuscar, new AbsoluteConstraints(0, 0, 80, 30));

        add(botonBuscar, new AbsoluteConstraints(550, 40, 80, 30));

        botonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarLibro();
            }
        });

        JTable tablaLibros = new JTable();
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaLibros.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloLibros = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; //Ninguna celda es editable
            }
        };
        modeloLibros = (DefaultTableModel) tablaLibros.getModel();
        modeloLibros.addColumn("ID");
        modeloLibros.addColumn("Título");
        modeloLibros.addColumn("Nombre");
        modeloLibros.addColumn("Apellido");
        modeloLibros.addColumn("Existencias");
        tablaLibros.setModel(modeloLibros);
        JScrollPane scroll_tablaLibros = new JScrollPane(tablaLibros);

        scroll_tablaLibros.setViewportView(tablaLibros);
        add(scroll_tablaLibros, new AbsoluteConstraints(10, 90, 670, 360));

    }
    private void buscarLibro() {

        modeloLibros.getDataVector().clear();

        int itemSeleccionado = comboOpciones.getSelectedIndex();

        String parametroEntrada = textParametroBusqueda.getText();

        ControllerLibro controllerLibro = new ControllerLibro();

        List<Libro> libros = controllerLibro.buscarLibro(itemSeleccionado, parametroEntrada);

        libros.forEach(libro -> modeloLibros.addRow(

                new Object[] {
                        libro.getId(),
                        libro.getTitulo(),
                        libro.getAutor().getNombre(),
                        libro.getAutor().getApellido(),
                        libro.getNumeroExistencias()
                }));
    }
}