package me.dasha.lab5.commands.concreteCommands;

//Вывод справки о доступных командах


import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Help extends Command {
    private final CommandReceiver commandReceiver;

    public Help (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }
    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде help.");
        }
        commandReceiver.help();
    }
    @Override
    public void writeInfo(){
        System.out.println("Команда help выводит справку о доступных командах");
    }
}
