package me.dasha.lab5.commands.concreteCommands;

//Добавление нового элемента в коллекцию


import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Add extends Command {
    private final CommandReceiver commandReceiver;

    public Add (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }


    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде add.");
        }
        commandReceiver.add();
    }
    @Override
    public void writeInfo(){
        System.out.println("Команда add добавляет новый элемент в коллекцию");
    }
}

