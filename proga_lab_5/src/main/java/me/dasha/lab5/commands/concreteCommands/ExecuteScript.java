package me.dasha.lab5.commands.concreteCommands;


import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

//Считывание и исполнение скрипта из указанного файла.

public class ExecuteScript extends Command {
    private final CommandReceiver commandReceiver;
    private static String path;

    public ExecuteScript(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) throws StackOverflowError {
        try {
            if (args.length == 2) { path = args[1]; commandReceiver.executeScript(args[1]); }
            else { System.out.println("Некорректное количество аргументов. Для справки напишите help."); }
        } catch (StackOverflowError ex) {
            System.out.println("Ошибка! Обнаружен выход за пределы стека.");
        }
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда execute_script file_name считывает и исполняет скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    public static String getPath() {
        return path;
    }
}