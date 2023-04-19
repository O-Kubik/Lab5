package me.dasha.lab5.commands.concreteCommands;


//Удалить элемент по ID

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class RemoveByID extends Command {
    private final CommandReceiver commandReceiver;

    public RemoveByID (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            commandReceiver.removeById(args[1]);
        }
        else {
            System.out.println("Некорректное количество аргументов. Для справки напишите help."); }
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда remove_by_id удаляет элемент из коллекции по его id.");
    }
}