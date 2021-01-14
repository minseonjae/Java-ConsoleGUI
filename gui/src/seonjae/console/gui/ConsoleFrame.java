package seonjae.console.gui;

import lombok.Getter;

import javax.swing.*;

@Getter
public class ConsoleFrame extends JFrame {

    private ConsoleScrollPane scrollPane;
    private ConsoleTextArea textArea;
    private ConsoleTextField textField;
    private ConsoleButton button;

    public ConsoleFrame(String name) {
        super(name);
        setSize(620, 420);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        add(scrollPane = new ConsoleScrollPane());

        scrollPane.setViewportView(textArea = new ConsoleTextArea());

        add(textField = new ConsoleTextField());

        add(button = new ConsoleButton());
    }
}
