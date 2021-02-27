package seonjae.program.cosole.stream;

import seonjae.program.cosole.gui.MainFrame;

import java.io.OutputStream;
import java.io.PrintStream;

public class ConsolePrintStream extends PrintStream {
    public ConsolePrintStream(MainFrame frame) {
        super(new ConsoleOutputStream() {
            public void write(String text) {
                frame.log(text);
            }
        });
    }
}
