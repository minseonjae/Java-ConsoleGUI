package kr.codingtree.console.command;

import lombok.Getter;

import java.util.HashSet;

public class ConsoleCommand {

    @Getter
    private HashSet<CommandExecutor> executors = new HashSet<>();

    public void register(CommandExecutor executor) {
        executors.add(executor);
    }

    public boolean execute(String command) {
        String[] commands = command.trim().split(" ");

        for (CommandExecutor executor : executors) {
            if (executor.onCommand(commands)) {
                return true;
            }
        }

        return false;
    }
}
