package seonjae.program.console.gui.listener;

import seonjae.program.console.gui.MainFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConsoleCloseListener implements WindowListener {

    private MainFrame frame;

    public ConsoleCloseListener(MainFrame frame) {
        this.frame = frame;
    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        frame.getCommandLabelBlinkThread().setStopped(true);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
