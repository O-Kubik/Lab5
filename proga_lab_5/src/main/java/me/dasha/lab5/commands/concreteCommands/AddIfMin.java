package me.dasha.lab5.commands.concreteCommands;



//Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции


import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class AddIfMin extends Command {
    private final CommandReceiver commandReceiver;

    public AddIfMin(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде add_if_min.");
        }
        commandReceiver.addIfMin();
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции.");
    }
}