package me.dasha.lab5.commands.concreteCommands;


//Показ содержимого коллекции.

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Show extends Command {
    private final CommandReceiver commandReceiver;

    public Show (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде show.");
        }
        commandReceiver.show();
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда show – вывести все элементы коллекции в строковом представлении.");
    }
}