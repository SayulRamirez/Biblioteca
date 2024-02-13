package com.biblioteca.view;

import com.biblioteca.util.PersistenceHib;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("all")
public class VentanaPrincipal extends JFrame {

    private JPanel panelContenido;
    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        JLabel labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26)); // NOI18N
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Servicio  de prestamos bibliotecarios");
        getContentPane().add(labelTitulo, new AbsoluteConstraints(0, 0, 890, 40));

        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new AbsoluteLayout());

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(231, 244, 237));
        panelMenu.setLayout(new AbsoluteLayout());

        JPanel panelAutenti = new JPanel();
        panelAutenti.setBackground(new Color(231, 244, 237));
        panelAutenti.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelAutenti.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelAutentiMouseClicked();
            }
        });
        panelAutenti.setLayout(new AbsoluteLayout());

        JLabel labelAutenti = new JLabel();
        labelAutenti.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelAutenti.setHorizontalAlignment(SwingConstants.CENTER);
        labelAutenti.setText("Autenticación de alumno");
        panelAutenti.add(labelAutenti, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelAutenti, new AbsoluteConstraints(0, 140, 200, 30));

        JPanel panelEstado = new JPanel();
        panelEstado.setBackground(new Color(231, 244, 237));
        panelEstado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelEstado.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelEstadoMouseClicked();
            }
        });
        panelEstado.setLayout(new AbsoluteLayout());

        JLabel labelEstado = new JLabel();
        labelEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelEstado.setHorizontalAlignment(SwingConstants.CENTER);
        labelEstado.setText("Estado");
        panelEstado.add(labelEstado, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelEstado, new AbsoluteConstraints(0, 170, 200, 30));

        JPanel panelConLibro = new JPanel();
        panelConLibro.setBackground(new Color(231, 244, 237));
        panelConLibro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelConLibro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelConLibroMouseClicked();
            }
        });
        panelConLibro.setLayout(new AbsoluteLayout());

        JLabel labelConLibro = new JLabel();
        labelConLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelConLibro.setHorizontalAlignment(SwingConstants.CENTER);
        labelConLibro.setText("Consulta de libros");
        panelConLibro.add(labelConLibro, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelConLibro, new AbsoluteConstraints(0, 200, 200, 30));

        JPanel panelConPrest = new JPanel();
        panelConPrest.setBackground(new Color(231, 244, 237));
        panelConPrest.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelConPrest.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelConPrestMouseClicked();
            }
        });
        panelConPrest.setLayout(new AbsoluteLayout());

        JLabel labelConPrest = new JLabel();
        labelConPrest.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelConPrest.setHorizontalAlignment(SwingConstants.CENTER);
        labelConPrest.setText("Consulta de prestamos");
        panelConPrest.add(labelConPrest, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelConPrest, new AbsoluteConstraints(0, 230, 200, 30));

        JPanel panelPrestamo = new JPanel();
        panelPrestamo.setBackground(new Color(231, 244, 237));
        panelPrestamo.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelPrestamo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelPrestamoMouseClicked();
            }
        });
        panelPrestamo.setLayout(new AbsoluteLayout());

        JLabel labelPrestano = new JLabel();
        labelPrestano.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelPrestano.setHorizontalAlignment(SwingConstants.CENTER);
        labelPrestano.setText("Prestamos");
        panelPrestamo.add(labelPrestano, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelPrestamo, new AbsoluteConstraints(0, 260, 200, 30));

        JPanel panelDevolucion = new JPanel();
        panelDevolucion.setBackground(new Color(231, 244, 237));
        panelDevolucion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelDevolucion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelDevolucionMouseClicked();
            }
        });
        panelDevolucion.setLayout(new AbsoluteLayout());

        JLabel labelDevolucion = new JLabel();
        labelDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
        labelDevolucion.setText("Devoluciones");
        panelDevolucion.add(labelDevolucion, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelDevolucion, new AbsoluteConstraints(0, 290, 200, 30));

        panelContenedor.add(panelMenu, new AbsoluteConstraints(0, 0, 200, 460));

        panelContenido = new JPanel();
        GroupLayout panelContenidoLayout = new GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
                panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 690, Short.MAX_VALUE)
        );
        panelContenidoLayout.setVerticalGroup(
                panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 460, Short.MAX_VALUE)
        );

        panelContenedor.add(panelContenido, new AbsoluteConstraints(200, 0, 690, 460));

        getContentPane().add(panelContenedor, new AbsoluteConstraints(0, 40, 890, 460));

        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                PersistenceHib.shutdown();
                super.windowClosing(e);
            }
        });
    }

    private void panelAutentiMouseClicked() {

        cambiarDePanel(new AutentiPanel());
    }

    private void panelEstadoMouseClicked() {
        cambiarDePanel(new EstadoPanel());
    }

    private void panelConLibroMouseClicked() {

        cambiarDePanel(new ConsultaLibro());
    }

    private void panelConPrestMouseClicked() {

        cambiarDePanel(new ConsultaPrestamo());
    }
    private void panelPrestamoMouseClicked() {

        cambiarDePanel(new PrestamoPanel());
    }

    private void panelDevolucionMouseClicked() {

        cambiarDePanel(new DevolucionPanel());
    }


    private void cambiarDePanel(JPanel panel) {
        panelContenido.removeAll();
        panel.setSize(690, 460);
        panelContenido.add(panel);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
