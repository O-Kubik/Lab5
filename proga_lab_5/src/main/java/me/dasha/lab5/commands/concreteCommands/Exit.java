package me.dasha.lab5.commands.concreteCommands;


//Выход из программы

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Exit extends Command {
    private final CommandReceiver commandReceiver;

    public Exit (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде exit.");
        }
        commandReceiver.exit();
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда exit – завершить программу (без сохранения в файл).");
    }
}