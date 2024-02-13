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
        getContentPane().setBackground(new Color(179, 8, 56));

        JLabel labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));// NOI18N
        labelTitulo.setForeground(new Color(250, 250, 250));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Servicio  de prestamos bibliotecarios");
        getContentPane().add(labelTitulo, new AbsoluteConstraints(0, 0, 890, 40));

        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new AbsoluteLayout());

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(224, 62, 82));
        panelMenu.setLayout(new AbsoluteLayout());

        JPanel panelAutenti = new JPanel();
        JLabel labelAutenti = new JLabel();
        panelAutenti.setBackground(new Color(113, 197, 232));
        panelAutenti.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelAutenti.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelAutentiMouseClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelAutenti.setBackground(new Color(0, 165, 181));
                labelAutenti.setFont(new Font("Segoe UI", Font.PLAIN, 19));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelAutenti.setBackground(new Color(113, 197, 232));
                labelAutenti.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }
        });
        panelAutenti.setLayout(new AbsoluteLayout());

        labelAutenti.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelAutenti.setHorizontalAlignment(SwingConstants.CENTER);
        labelAutenti.setForeground(new Color(179, 8, 56));
        labelAutenti.setText("Autenticar alumno");
        panelAutenti.add(labelAutenti, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelAutenti, new AbsoluteConstraints(0, 140, 200, 30));

        JPanel panelEstado = new JPanel();
        JLabel labelEstado = new JLabel();
        panelEstado.setBackground(new Color(113, 197, 232));
        panelEstado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelEstado.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelEstadoMouseClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelEstado.setBackground(new Color(0, 165, 181));
                labelEstado.setFont(new Font("Segoe UI", Font.PLAIN, 19));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelEstado.setBackground(new Color(113, 197, 232));
                labelEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }
        });
        panelEstado.setLayout(new AbsoluteLayout());

        labelEstado.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelEstado.setHorizontalAlignment(SwingConstants.CENTER);
        labelEstado.setForeground(new Color(179, 8, 56));
        labelEstado.setText("Estado");
        panelEstado.add(labelEstado, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelEstado, new AbsoluteConstraints(0, 170, 200, 30));

        JPanel panelConLibro = new JPanel();
        JLabel labelConLibro = new JLabel();
        panelConLibro.setBackground(new Color(113, 197, 232));
        panelConLibro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelConLibro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelConLibroMouseClicked();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                panelConLibro.setBackground(new Color(0, 165, 181));
                labelConLibro.setFont(new Font("Segoe UI", Font.PLAIN, 19));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelConLibro.setBackground(new Color(113, 197, 232));
                labelConLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }
        });
        panelConLibro.setLayout(new AbsoluteLayout());

        labelConLibro.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelConLibro.setHorizontalAlignment(SwingConstants.CENTER);
        labelConLibro.setForeground(new Color(179, 8, 56));
        labelConLibro.setText("Consulta libro");
        panelConLibro.add(labelConLibro, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelConLibro, new AbsoluteConstraints(0, 200, 200, 30));

        JPanel panelConPrest = new JPanel();
        JLabel labelConPrest = new JLabel();
        panelConPrest.setBackground(new Color(113, 197, 232));
        panelConPrest.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelConPrest.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelConPrestMouseClicked();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                panelConPrest.setBackground(new Color(0, 165, 181));
                labelConPrest.setFont(new Font("Segoe UI", Font.PLAIN, 19));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelConPrest.setBackground(new Color(113, 197, 232));
                labelConPrest.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }
        });
        panelConPrest.setLayout(new AbsoluteLayout());

        labelConPrest.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelConPrest.setHorizontalAlignment(SwingConstants.CENTER);
        labelConPrest.setForeground(new Color(179, 8, 56));
        labelConPrest.setText("Consulta prestamo");
        panelConPrest.add(labelConPrest, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelConPrest, new AbsoluteConstraints(0, 230, 200, 30));

        JPanel panelPrestamo = new JPanel();
        JLabel labelPrestano = new JLabel();
        panelPrestamo.setBackground(new Color(113, 197, 232));
        panelPrestamo.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelPrestamo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelPrestamoMouseClicked();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                panelPrestamo.setBackground(new Color(0, 165, 181));
                labelPrestano.setFont(new Font("Segoe UI", Font.PLAIN, 19));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelPrestamo.setBackground(new Color(113, 197, 232));
                labelPrestano.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }
        });
        panelPrestamo.setLayout(new AbsoluteLayout());

        labelPrestano.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelPrestano.setHorizontalAlignment(SwingConstants.CENTER);
        labelPrestano.setForeground(new Color(179, 8, 56));
        labelPrestano.setText("Prestamos");
        panelPrestamo.add(labelPrestano, new AbsoluteConstraints(0, 0, 200, 30));

        panelMenu.add(panelPrestamo, new AbsoluteConstraints(0, 260, 200, 30));

        JPanel panelDevolucion = new JPanel();
        JLabel labelDevolucion = new JLabel();
        panelDevolucion.setBackground(new Color(113, 197, 232));
        panelDevolucion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        panelDevolucion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelDevolucionMouseClicked();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                panelDevolucion.setBackground(new Color(0, 165, 181));
                labelDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 19));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelDevolucion.setBackground(new Color(113, 197, 232));
                labelDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }
        });
        panelDevolucion.setLayout(new AbsoluteLayout());

        labelDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
        labelDevolucion.setForeground(new Color(179, 8, 56));
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
