package com.biblioteca.view;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutentiPanel extends JPanel {

    /**
     * Creates new form EstadoPanel
     */
    public AutentiPanel() {
        initComponents();
    }

   private void initComponents() {

        setPreferredSize(new Dimension(690, 460));
        setLayout(new AbsoluteLayout());

        JLabel labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // NOI18N
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Autenticación del alumno");
        add(labelTitulo, new AbsoluteConstraints(0, 30, 690, -1));

        JLabel lableDato = new JLabel();

        lableDato.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        lableDato.setText("DIN del alumno: ");
        add(lableDato, new AbsoluteConstraints(10, 70, -1, -1));

        JTextField textDNI = new JTextField();
        textDNI.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        textDNI.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                textDNIKeyTyped(evt);
            }
        });
        add(textDNI, new AbsoluteConstraints(10, 100, 130, -1));

        JLabel labelRespuesta = new JLabel();
        labelRespuesta.setFont(new Font("Segoe UI", Font.PLAIN, 17)); // NOI18N
        labelRespuesta.setForeground(new Color(255, 0, 0));
        add(labelRespuesta, new AbsoluteConstraints(10, 190, 390, 40));

        JPanel panelAutenti = new JPanel();
        panelAutenti.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelAutenti.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelAutentiMouseClicked(evt);
            }
        });
        panelAutenti.setLayout(new AbsoluteLayout());

        JLabel labelAutenti = new JLabel();
        labelAutenti.setFont(new Font("Segoe UI", 0, 17));
        labelAutenti.setHorizontalAlignment(SwingConstants.CENTER);
        labelAutenti.setText("Autenticar");
        labelAutenti.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelAutenti.add(labelAutenti, new AbsoluteConstraints(0, 0, 130, 30));

        add(panelAutenti, new AbsoluteConstraints(180, 100, 130, 30));
    }

    private void panelAutentiMouseClicked(MouseEvent evt) {
    }

    private void textDNIKeyTyped(KeyEvent evt) {
    }
}
