package seonjae.program.cosole.gui;

import lombok.Getter;
import seonjae.program.cosole.gui.listener.CommandFieldKeyListener;
import seonjae.program.cosole.gui.listener.ComponentFocusListener;
import seonjae.program.cosole.gui.listener.ConsoleCloseListener;
import seonjae.program.cosole.gui.thread.CommandLabelBlinkThread;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final int[] SIZE = {700, 472};
    private static final Color BACKGROUND = Color.BLACK;

    @Getter
    private ConsoleTextAreaScroll textAreaScroll;
    @Getter
    private ConsoleTextArea textArea;
    @Getter
    private InputCommandField commandField;
    @Getter
    private CommandLabel commandLabel;
    @Getter
    private CommandLabelBlinkThread commandLabelBlinkThread;

    public MainFrame(String title) {
        super(title);

        setSize(SIZE[0], SIZE[1]);
        getContentPane().setBackground(BACKGROUND);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        ComponentFocusListener focusListener = new ComponentFocusListener(this);

        addFocusListener(focusListener);
        addWindowListener(new ConsoleCloseListener(this));

        add(textAreaScroll = new ConsoleTextAreaScroll());
        textAreaScroll.setViewportView(textArea = new ConsoleTextArea());
        textArea.addFocusListener(focusListener);

        add(commandField = new InputCommandField());
        commandField.requestFocus(true);
        commandField.setFocusable(true);
        commandField.requestFocus();
        commandField.addKeyListener(new CommandFieldKeyListener(this));

        add(commandLabel = new CommandLabel());
        commandLabel.addFocusListener(focusListener);
    }

    public void newBlinkThread() {
        commandLabelBlinkThread = new CommandLabelBlinkThread(this);
    }

    public void log(Object message) {
        textArea.append(" " + message.toString());
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
