package com.biblioteca.validation_view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionField {

    public static KeyAdapter ingresarNumeros() {
        return new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {

                char keyChar = evt.getKeyChar();

                if (!Character.isDigit(keyChar)) evt.consume();

            }
        };
    }

    public static KeyAdapter ingresarLetras() {
        return new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {

                char keyChar = evt.getKeyChar();
                if (!Character.isLetter(keyChar) && keyChar != ' ') {
                    evt.consume();
                }
            }
        };
    }
}
