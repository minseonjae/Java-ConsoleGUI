package seonjae.console.listener;

import seonjae.console.Console;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Console.command();
    }
}
