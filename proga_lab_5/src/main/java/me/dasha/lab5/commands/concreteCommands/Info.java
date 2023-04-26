package me.dasha.lab5.commands.concreteCommands;



//Вывод информации о коллекции

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Info extends Command {
    private final CommandReceiver commandReceiver;

    public Info (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда info – вывести в стандартный поток вывода информацию о коллекции.");

    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде info.");
        }
        commandReceiver.info();
    }


}