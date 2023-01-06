package kr.codingtree.console;

import lombok.SneakyThrows;

public class Example {
    @SneakyThrows
    public static void main(String[] args) {
        Console console = new Console("Console");

        console.show();

        System.out.println("asdf");
        System.out.println("asdf");
        System.out.println("asdf");
        System.out.println("asdf");
        console.setDebugging(true);
        console.debugLog("asdf");
    }
}
