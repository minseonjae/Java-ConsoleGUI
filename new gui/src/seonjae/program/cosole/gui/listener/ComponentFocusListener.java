package seonjae.program.cosole.gui.listener;

import seonjae.program.cosole.gui.MainFrame;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ComponentFocusListener implements FocusListener {

    private MainFrame frame;

    public ComponentFocusListener(MainFrame frame) {
        this.frame = frame;
    }

    public void focusLost(FocusEvent e) {}
    public void focusGained(FocusEvent e) {
        frame.getCommandField().requestFocus();
    }
}
