package seonjae.console.gui;

import javax.swing.*;

public class ConsoleScrollPane extends JScrollPane {

    private static final int X = 0;
    private static final int Y = 0;
    private static final int WIDTH = 615;
    private static final int HEIGHT = 350;

    public ConsoleScrollPane() {
        super();
        setBounds(X, Y, WIDTH, HEIGHT);
    }
}
