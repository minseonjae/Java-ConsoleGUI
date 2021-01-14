package seonjae.console;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import seonjae.console.gui.ConsoleFrame;
import seonjae.console.listener.ButtonActionListener;
import seonjae.console.listener.CommandListener;
import seonjae.console.listener.InputListener;
import seonjae.console.listener.TextFieldKeyPressedListener;
import seonjae.console.stream.ConsoleInputStream;
import seonjae.console.stream.ConsoleOutputStream;

import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@UtilityClass
public class Console {

    @Setter
    private static String title = "console";

    private static ConsoleFrame frame = null;

    private static ConsoleInputStream inputThread = null;

    @Getter
    private static boolean hide = true;

    public boolean show() {
        if (!hide) return false;
        frame = new ConsoleFrame(title);
        frame.setVisible(true);

        frame.getTextField().addKeyListener(new TextFieldKeyPressedListener());
        frame.getButton().addActionListener(new ButtonActionListener());

        PrintStream printStream = new PrintStream(new ConsoleOutputStream() {
            public void onWrite(String text) {
                nlog(" " + text);
            }
        });
        System.setOut(printStream);
        System.setErr(printStream);

        InputListener listener = new InputListener();
        inputThread = new ConsoleInputStream(listener);
        registerCommandListener(listener);

        hide = false;

        try {
            int i = Integer.parseInt("a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean hide() {
        if (hide) return false;
        frame.setVisible(false);
        frame = null;
        System.setOut(null);
        System.setErr(null);
        inputThread.destroy();
        hide = true;
        return true;
    }

    @Getter
    private static HashSet<CommandListener> commandListeners = new HashSet<>();

    public void registerCommandListener(CommandListener listener) {
        commandListeners.add(listener);
    }
    public void resetCommandListener() {
        commandListeners.clear();
    }
    public void command() {
        if (frame == null) return;
        if (frame.getTextField().getText().isEmpty()) {
            log(LogType.WARNING, "메세지를 입력하여 주세요!");
        } else {
            String command = frame.getTextField().getText();
            for (CommandListener listener : commandListeners) {
                listener.onCommand(command, command.split(" "));
            }
            frame.getTextField().setText(null);
        }
    }

    public void nlog(Object message) {
        if (frame == null) return;
        frame.getTextArea().append(message.toString());
        frame.getTextArea().setCaretPosition(frame.getTextArea().getDocument().getLength());
    }
    public void log(Object message) {
        log(null, message);
    }
    public void log(LogType type, Object message) {
        nlog(" [" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + (type == null ? "" : " " + type.getName()) + "] " + message.toString() + "\n");
    }
}
