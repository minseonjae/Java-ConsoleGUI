package seonjae.console.gui;

import javax.swing.*;
import java.awt.*;

public class ConsoleTextField extends JTextField {

    private static final int X = 12;
    private static final int Y = 358;
    private static final int WIDTH = 492;
    private static final int HEIGHT = 26;
    private static final Font FONT = new Font("나눔고딕", Font.PLAIN, 12);

    public ConsoleTextField() {
        super();
        setBounds(X, Y, WIDTH, HEIGHT);
        setFont(FONT);
    }
}
