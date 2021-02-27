package seonjae.program.cosole;

import lombok.Getter;
import lombok.Setter;
import seonjae.program.cosole.gui.MainFrame;
import seonjae.program.cosole.stream.ConsolePrintStream;

public class Console {

    @Setter
    private static String title = "console";

    @Getter
    private static MainFrame frame;

    @Getter
    private boolean hide = true;

    public Console(String title) {
        frame = new MainFrame(this.title = title);

        ConsolePrintStream printStream = new ConsolePrintStream(frame);

        System.setOut(printStream);
        System.setErr(printStream);
    }

    public boolean show() {
        if (hide) {
            frame.setVisible(true);
            frame.newBlinkThread();
            frame.getCommandLabelBlinkThread().start();
            return true;
        }

        return false;
    }
    public boolean hide() {
        if (hide) return false;
        frame.setVisible(false);
        frame.getCommandLabelBlinkThread().setStopped(true);
        return true;
    }
}
