package me.dasha.lab5.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Вызыватель команд: хранит зарегистрированные команды и запускает их

public class CommandInvoker {
    private HashMap<String, Command> commands = new HashMap<>();
    private List<String> history = new ArrayList<String>();


    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void executeCommand(String[] commandName) {
        System.out.println("Введите команду. Для справки введите \"help\"");
        try {
            if (commandName.length > 0) {
                history.add(commandName[0]);
                Command command = commands.get(commandName[0]);
                command.execute(commandName);
            } else { System.out.println("Вы не ввели команду."); }
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("Не существует команды " + commandName[0] + ". Для справки используйте – help");
        }
    }

    public List<String> getHistory() {
        return history;
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
