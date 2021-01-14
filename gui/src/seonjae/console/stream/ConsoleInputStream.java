package seonjae.console.stream;

import seonjae.console.listener.InputListener;

import java.io.InputStream;

public class ConsoleInputStream extends Thread {

    private InputListener listener;

    public ConsoleInputStream(InputListener listener) {
        this.listener = listener;
        start();
    }

    public void run() {
        System.setIn(new CustomInputStream());
        System.out.println("run");
    }

    public void destroy() {
        super.destroy();
        System.setIn(null);
    }

    private class CustomInputStream extends InputStream {
        public synchronized int read() {
            if (listener.getCharacters().isEmpty() || listener.getCharacters().size() < 1) return -1;
            int value = listener.getCharacters().get(0).charValue();
            listener.getCharacters().remove(0);
            return value;
        }
    }
}
