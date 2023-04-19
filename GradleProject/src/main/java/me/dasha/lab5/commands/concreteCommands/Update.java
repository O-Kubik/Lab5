package me.dasha.lab5.commands.concreteCommands;



//Jбновление значение элемента коллекции, id которого равен заданному

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Update extends Command {
    private final CommandReceiver commandReceiver;

    public Update (CommandReceiver commandReceiver) {

        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            commandReceiver.update(args[1]);
        }
        else {
            System.out.println("Некорректное количество аргументов. Для справки напишите help."); }
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда update обновляет значение элемента коллекции, id которого равен заданному.");
    }
}