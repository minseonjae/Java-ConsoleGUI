package seonjae.console.gui;

import javax.swing.*;
import java.awt.*;

public class ConsoleTextArea extends JTextArea {

    private static final boolean EDITABLE = false;
    private static final Font FONT = new Font("나눔고딕", Font.PLAIN, 13);
    private static final Color FOREGROUND = new Color(230, 230, 230);
    private static final Color BACKGROUND = new Color(0, 0, 0);

    public ConsoleTextArea() {
        super();
        setEditable(EDITABLE);
        setFont(FONT);
        setForeground(FOREGROUND);
        setBackground(BACKGROUND);
    }
}
