package com.biblioteca.view;

import com.biblioteca.controller.AlumnoController;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutentiPanel extends JPanel {

    private JTextField textIngresoDNI;
    private JLabel labelRespuesta;

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
        labelTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Autenticación del alumno");
        add(labelTitulo, new AbsoluteConstraints(0, 30, 690, -1));

        JLabel labelIngresoDNI = new JLabel();
        labelIngresoDNI.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelIngresoDNI.setText("DIN del alumno: ");
        add(labelIngresoDNI, new AbsoluteConstraints(10, 70, -1, -1));

        textIngresoDNI = new JTextField();
        textIngresoDNI.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        textIngresoDNI.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {

                char keyChar = evt.getKeyChar();

                if (Character.isLetter(keyChar)) {
                    evt.consume();
                }
            }
        });
        add(textIngresoDNI, new AbsoluteConstraints(10, 100, 130, -1));

        labelRespuesta = new JLabel();
        labelRespuesta.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelRespuesta.setForeground(new Color(255, 0, 0));
        add(labelRespuesta, new AbsoluteConstraints(10, 190, 390, 40));

        JPanel panelAutenticar = new JPanel();
        panelAutenticar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelAutenticar.setLayout(new AbsoluteLayout());

        JLabel labelAutenticar = new JLabel();
        labelAutenticar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        labelAutenticar.setHorizontalAlignment(SwingConstants.CENTER);
        labelAutenticar.setText("Autenticar");
        labelAutenticar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelAutenticar.add(labelAutenticar, new AbsoluteConstraints(0, 0, 130, 30));

        add(panelAutenticar, new AbsoluteConstraints(180, 100, 130, 30));

        panelAutenticar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {

                String textDNI = textIngresoDNI.getText();

                AlumnoController controller = new AlumnoController();
                String respuesta = controller.estaVerificado(textDNI);

                labelRespuesta.setText(respuesta);
            }
        });
    }
}
