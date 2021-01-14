package seonjae.console.listener;

import lombok.Getter;

import java.util.ArrayList;

public class InputListener implements CommandListener {

    @Getter
    private ArrayList<Character> characters = new ArrayList<>();

    public void onCommand(String arg, String[] args) {
        char[] chars = arg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
    }
}
