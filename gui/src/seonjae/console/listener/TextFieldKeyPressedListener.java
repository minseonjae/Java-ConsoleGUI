package seonjae.console.listener;

import seonjae.console.Console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextFieldKeyPressedListener extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == '\n') {
            Console.command();
        }
    }
}
