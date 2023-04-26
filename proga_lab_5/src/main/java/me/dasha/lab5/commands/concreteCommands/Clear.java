package me.dasha.lab5.commands.concreteCommands;



//Очистка коллекции

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Clear extends Command {
    private final CommandReceiver commandReceiver;

    public Clear(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде clear.");
        }
        commandReceiver.clear();
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда clear очищает коллекцию.");
    }
}