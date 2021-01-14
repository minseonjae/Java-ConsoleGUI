package seonjae.console.gui;

import javax.swing.*;
import java.awt.*;

public class ConsoleButton extends JButton {

    private static final String NAME = "COMMAND";
    private static final int X = 500;
    private static final int Y = 358;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 25;
    private static final Font FONT = new Font("나눔고딕", Font.PLAIN, 12);
    private static final Color BACKGROUND = new Color(200, 200, 200);

    public ConsoleButton() {
        super(NAME);
        setBounds(X, Y, WIDTH, HEIGHT);
        setFont(FONT);
        setBackground(BACKGROUND);
    }
}
