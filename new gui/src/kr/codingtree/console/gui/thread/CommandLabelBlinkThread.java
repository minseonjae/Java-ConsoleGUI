package kr.codingtree.console.gui.thread;

import lombok.Setter;
import lombok.SneakyThrows;
import kr.codingtree.console.gui.MainFrame;

public class CommandLabelBlinkThread extends Thread {

    @Setter
    private boolean stopped = false;

    private MainFrame frame;

    public CommandLabelBlinkThread(MainFrame frame) {
        this.frame = frame;
    }

    @SneakyThrows
    public void run() {
        while (!stopped) {
            sleep(400);
            frame.getCommandLabel().setVisible(!frame.getCommandLabel().isVisible());
        }
    }
}
