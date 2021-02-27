package seonjae.program.cosole.gui.listener;

import seonjae.program.cosole.gui.MainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandFieldKeyListener implements KeyListener {

    private MainFrame frame;

    public CommandFieldKeyListener(MainFrame frame) {
        this.frame = frame;
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !frame.getCommandField().getText().isEmpty() && frame.getCommandField().getText().length() > 0) {
            frame.log(frame.getCommandField().getText());
            frame.getCommandField().setText(null);
        }
    }
}
